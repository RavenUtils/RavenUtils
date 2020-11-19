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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class Bucket extends BucketItem {
  
  public Bucket(Supplier<Fluid> supplier, Item containerItemIn, int maxDamage) {
    super(supplier, new Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .containerItem(containerItemIn)
        .maxDamage(maxDamage)
        .setNoRepair());
  }

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return true;
  }

  @Override
  public ItemStack getContainerItem(ItemStack itemstack) {
    ItemStack containerItem = super.getContainerItem(itemstack);
    ItemStack stack = itemstack.copy();

    containerItem.setDamage(stack.getDamage());
    if (containerItem.getMaxDamage() - containerItem.getDamage() <= 1) {
      containerItem.shrink(1);
    } else {
      containerItem.attemptDamageItem(1, random, null);
    }
    return containerItem;
  }

  @Override
  public ICapabilityProvider initCapabilities(ItemStack stack, @org.jetbrains.annotations.Nullable CompoundNBT nbt) {
    return super.initCapabilities(stack, nbt);
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    ItemStack itemstack = playerIn.getHeldItem(handIn);
    RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.getFluid() == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
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
        if (this.getFluid() == Fluids.EMPTY) {
          BlockState blockstate1 = worldIn.getBlockState(blockpos);
          if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
            Fluid fluid = ((IBucketPickupHandler) blockstate1.getBlock()).pickupFluid(worldIn, blockpos, blockstate1);
            if (fluid != Fluids.EMPTY) {
              playerIn.addStat(Stats.ITEM_USED.get(this));

              SoundEvent soundevent = this.getFluid().getAttributes().getFillSound();
              boolean bucketBurnable = false;

              if (fluid.isIn(FluidTags.LAVA)) {
                Item bucket = playerIn.getActiveItemStack().getItem();
                if (bucket == ModToolItems.BUCKET_WOOD.get()
                    || bucket == ModToolItems.BUCKET_CLAY.get()
                //    || bucket.isIn()
                ) {
                  bucketBurnable = true;
                }
              }

              if (bucketBurnable) {
                soundevent = SoundEvents.BLOCK_LAVA_EXTINGUISH;
                playerIn.playSound(soundevent, 1.0F, 1.0F);
                playerIn.getActiveItemStack().shrink(1);

                return ActionResult.resultFail(itemstack);
              } else {
                Item bucket = playerIn.getActiveItemStack().getItem();

                if (soundevent == null) {
                  soundevent = SoundEvents.ITEM_BUCKET_FILL;
                }
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
  protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
    return getContainerItem(stack);
  }

  @Override
  protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
    SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
    if (soundevent == null)
      soundevent = this.getFluid().isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA : SoundEvents.ITEM_BUCKET_EMPTY;
    worldIn.playSound(player, pos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
  }

  @Override
  public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn, @Nullable BlockRayTraceResult rayTrace) {
    return super.tryPlaceContainedLiquid(player, worldIn, posIn, rayTrace);
  }

  private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate) {
    return blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer) blockstate.getBlock()).canContainFluid(worldIn, posIn, blockstate, this.getFluid());
  }
}