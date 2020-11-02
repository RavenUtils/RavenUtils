package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class Bucket extends BucketItem {

  private final Fluid containedBlock;

  public Bucket(Supplier<Fluid> supplier, Item containerItemIn, int maxDamage) {
    super(supplier, new Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .containerItem(containerItemIn)
        .maxDamage(maxDamage)
        .setNoRepair());

    this.containedBlock = null;
    this.fluidSupplier = supplier;
  }

  public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
    return false;
  }

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return true;
  }

  @Override
  public ItemStack getContainerItem(ItemStack itemstack) {
    ItemStack stack = itemstack.copy();

    if (stack.getMaxDamage() - stack.getDamage() <= 1) {
      stack.shrink(1);
    } else {
      stack.attemptDamageItem(1, random, null);
    }
    return stack;
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    ItemStack itemstack = playerIn.getHeldItem(handIn);
    RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
    ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
    if (ret != null) return ret;
    if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
      return ActionResult.resultPass(itemstack);
    } else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
      return ActionResult.resultPass(itemstack);
    } else {
      BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
      BlockPos blockpos = blockraytraceresult.getPos();
      Direction direction = blockraytraceresult.getFace();
      BlockPos blockpos1 = blockpos.offset(direction);
      if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
        if (this.containedBlock == Fluids.EMPTY) {
          BlockState blockstate1 = worldIn.getBlockState(blockpos);
          if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
            Fluid fluid = ((IBucketPickupHandler) blockstate1.getBlock()).pickupFluid(worldIn, blockpos, blockstate1);
            if (fluid != Fluids.EMPTY) {
              playerIn.addStat(Stats.ITEM_USED.get(this));

              SoundEvent soundevent = this.containedBlock.getAttributes().getFillSound();

              if (playerIn.getActiveItemStack().getItem() == ModToolItems.WOOD_BUCKET.get()
                  || playerIn.getActiveItemStack().getItem() == ModToolItems.CLAY_BUCKET.get()
                  && fluid.isIn(FluidTags.LAVA)) {
                if (soundevent == null)
                  soundevent = SoundEvents.BLOCK_LAVA_EXTINGUISH;
                playerIn.playSound(soundevent, 1.0F, 1.0F);
                playerIn.getActiveItemStack().shrink(1);

                return ActionResult.resultFail(itemstack);
              } else {
                if (soundevent == null)
                  soundevent = SoundEvents.ITEM_BUCKET_FILL;
                playerIn.playSound(soundevent, 1.0F, 1.0F);
                ItemStack itemstack1 = DrinkHelper.fill(itemstack, playerIn, new ItemStack(fluid.getFilledBucket()));

                if (!worldIn.isRemote) {
                  CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) playerIn, new ItemStack(fluid.getFilledBucket()));
                }

                return ActionResult.func_233538_a_(itemstack1, worldIn.isRemote());
              }
            }
          }

          return ActionResult.resultFail(itemstack);
        } else {
          BlockState blockstate = worldIn.getBlockState(blockpos);
          BlockPos blockpos2 = canBlockContainFluid(worldIn, blockpos, blockstate) ? blockpos : blockpos1;
          if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos2, blockraytraceresult)) {
            this.onLiquidPlaced(worldIn, itemstack, blockpos2);
            if (playerIn instanceof ServerPlayerEntity) {
              CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerIn, blockpos2, itemstack);
            }

            playerIn.addStat(Stats.ITEM_USED.get(this));
            return ActionResult.func_233538_a_(this.emptyBucket(itemstack, playerIn), worldIn.isRemote());
          } else {
            return ActionResult.resultFail(itemstack);
          }
        }
      } else {
        return ActionResult.resultFail(itemstack);
      }
    }
  }

  @Override
  protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
    SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
    if (soundevent == null)
      soundevent = this.containedBlock.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA : SoundEvents.ITEM_BUCKET_EMPTY;
    worldIn.playSound(player, pos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
  }

  private final java.util.function.Supplier<? extends Fluid> fluidSupplier;

  private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate) {
    return blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer) blockstate.getBlock()).canContainFluid(worldIn, posIn, blockstate, this.containedBlock);
  }
}