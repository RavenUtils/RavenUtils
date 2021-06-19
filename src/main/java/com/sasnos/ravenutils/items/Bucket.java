package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.ForgeI18n;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static net.minecraft.util.math.RayTraceContext.FluidMode;
import static net.minecraft.util.math.RayTraceResult.Type;

import net.minecraft.item.Item.Properties;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult.Type;

public class Bucket extends BaseBucketItem {

  public Bucket(Item containerItemIn, int maxDamage, Supplier<Item> milkBucket) {
    super(new Properties()
        .craftRemainder(containerItemIn)
        .durability(maxDamage)
        .setNoRepair(), milkBucket);
  }
  /* Bucket behavior */

  @Override
  public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
    ItemStack stack = player.getItemInHand(hand);
    Fluid fluid = this.getFluid(stack);
    BlockRayTraceResult trace = getPlayerPOVHitResult(world, player, fluid == Fluids.EMPTY ? FluidMode.SOURCE_ONLY : FluidMode.NONE);

    // fire Forge event for bucket use
    ActionResult<ItemStack> ret = ForgeEventFactory.onBucketUse(player, world, stack, trace);
    if (ret != null) {
      return ret;
    }

    // if we missed, do nothing
    if (trace.getType() != Type.BLOCK) {
      return ActionResult.pass(stack);
    }

    // normal fluid logic
    BlockPos pos = trace.getBlockPos();
    Direction direction = trace.getDirection();
    BlockPos offset = pos.relative(direction);

    // ensure we can place a fluid there
    if (world.mayInteract(player, pos) && player.mayUseItemAt(offset, direction, stack)) {
      BlockState state = world.getBlockState(pos);
      Block block = state.getBlock();
      if (block == Blocks.CAULDRON && !player.isCrouching()) {
        ActionResult<ItemStack> result = interactWithCauldron(world, pos, state, player, stack, fluid);
        if (result.getResult() != ActionResultType.PASS) {
          return result;
        }
      }

      if (fluid == Fluids.EMPTY) {
        if (block instanceof IBucketPickupHandler) {
          Fluid newFluid = ((IBucketPickupHandler) block).takeLiquid(world, pos, state);
          if (newFluid != Fluids.EMPTY) {
            player.awardStat(Stats.ITEM_USED.get(this));

            if (newFluid == Fluids.LAVA && bucketBurns(stack)) {
              stack.shrink(1);
              Direction facing = player.getDirection();
              BlockPos position = player.blockPosition();
              world.setBlockAndUpdate(position.relative(facing), Fluids.LAVA.defaultFluidState().createLegacyBlock());
              player.playSound(SoundEvents.LAVA_EXTINGUISH, 1f, 1f);
              return ActionResult.fail(stack);
            }

            // play sound effect
            SoundEvent sound = newFluid.getAttributes().getFillSound();
            if (sound == null) {
              sound = newFluid.is(FluidTags.LAVA) ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL;
            }
            player.playSound(sound, 1.0F, 1.0F);
            ItemStack newStack = updateBucket(stack, player, withFluid(stack, newFluid));
            if (!world.isClientSide()) {
              CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, newStack.copy());
            }

            return ActionResult.success(newStack);
          }
        }
      } else {
        BlockPos fluidPos = state.getBlock() instanceof ILiquidContainer && fluid == Fluids.WATER ? pos : offset;
        if (this.tryPlaceContainedLiquid(player, world, fluidPos, stack, trace)) {
          onLiquidPlaced(fluid, world, stack, fluidPos);
          if (player instanceof ServerPlayerEntity) {
            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, fluidPos, stack);
          }

          player.awardStat(Stats.ITEM_USED.get(this));
          return ActionResult.success(emptyBucket(stack, player));
        }
      }
    }
    return ActionResult.fail(stack);
  }


  private boolean bucketBurns(ItemStack stack) {
    Item bucket = stack.getItem();
    return bucket.is(EssentialsTags.Items.buckets_burnable);
  }

  /**
   * Called when a liquid is placed in world
   *
   * @param fluid Fluid to place
   * @param world World instance
   * @param stack Stack instance
   * @param pos   Position to place the world
   */
  private static void onLiquidPlaced(Fluid fluid, World world, ItemStack stack, BlockPos pos) {
    // TODO: is this bad?
    Item item = fluid.getBucket();
    if (item instanceof BucketItem) {
      ((BucketItem) item).checkExtraContent(world, stack, pos);
    }
  }

  // TODO: possibly migrate to the Forge method
  @SuppressWarnings("deprecation")
  private boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World world, BlockPos pos, ItemStack stack, @Nullable BlockRayTraceResult trace) {
    Fluid fluidStack = this.getFluid(stack);
    Fluid fluid = fluidStack.getFluid();
    if (!(fluid instanceof FlowingFluid)) {
      return false;
    }

    BlockState state = world.getBlockState(pos);
    Block block = state.getBlock();
    boolean replaceable = state.canBeReplaced(fluid);
    if (state.isAir(world, pos) || replaceable || block instanceof ILiquidContainer && ((ILiquidContainer) block).canPlaceLiquid(world, pos, state, fluid)) {
      if (world.dimensionType().ultraWarm() && fluid.is(FluidTags.WATER)) {
        world.playSound(player, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);

        for (int l = 0; l < 8; ++l) {
          world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + Math.random(), pos.getY() + Math.random(), pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
        }
      } else if (block instanceof ILiquidContainer && fluid == Fluids.WATER) {
        if (((ILiquidContainer) block).placeLiquid(world, pos, state, ((FlowingFluid) fluid).getSource(false))) {
          this.playEmptySound(fluid, player, world, pos);
        }
      } else {
        if (!world.isClientSide() && replaceable && !state.getMaterial().isLiquid()) {
          world.destroyBlock(pos, true);
        }

        this.playEmptySound(fluid, player, world, pos);
        world.setBlock(pos, fluid.defaultFluidState().createLegacyBlock(), 11);
      }

      return true;
    }
    if (trace == null) {
      return false;
    }
    return this.tryPlaceContainedLiquid(player, world, trace.getBlockPos().relative(trace.getDirection()), stack, null);
  }

  /**
   * Plays the sound on emptying the bucket
   *
   * @param fluid  Fluid placed
   * @param player Player accessing the bucket
   * @param world  World instance
   * @param pos    Position of sound
   */
  private void playEmptySound(Fluid fluid, @Nullable PlayerEntity player, IWorld world, BlockPos pos) {
    SoundEvent sound = fluid.getAttributes().getEmptySound();
    if (sound == null) {
      sound = fluid.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
    }
    world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
  }

  /**
   * Interacts with a cauldron block
   *
   * @param world  World instance
   * @param pos    Position of the cauldron
   * @param state  Cauldron state
   * @param player Interacting player
   * @param stack  Bucket stack
   * @param fluid  Contained fluid
   * @return Action result from interaction, pass means failed to interact with a cauldron
   */
  private ActionResult<ItemStack> interactWithCauldron(World world, BlockPos pos, BlockState state, @Nullable PlayerEntity player, ItemStack stack, Fluid fluid) {
    // if the bucket is empty, try filling from the cauldron
    int level = state.getValue(CauldronBlock.LEVEL);
    if (fluid == Fluids.EMPTY) {
      // if empty, try emptying
      if (level == 3) {
        // empty cauldron logic
        if (player != null) {
          player.awardStat(Stats.USE_CAULDRON);
        }
        if (!world.isClientSide()) {
          ((CauldronBlock) Blocks.CAULDRON).setWaterLevel(world, pos, state, 0);
        }
        world.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        return ActionResult.success(withFluid(stack, Fluids.WATER));
      }
    } else if (fluid == Fluids.WATER) {
      // fill cauldron if not full
      if (level < 3) {
        if (player != null) {
          player.awardStat(Stats.FILL_CAULDRON);
        }
        if (!world.isClientSide) {
          ((CauldronBlock) Blocks.CAULDRON).setWaterLevel(world, pos, state, 3);
        }
        world.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

        // return empty bucket
        return ActionResult.success(stack.getContainerItem());
      }
    } else {
      // pass if not empty or water
      return ActionResult.pass(stack);
    }
    // consume so we do not accidentally place water next to the cauldron, consistency with vanilla
    return ActionResult.success(stack);
  }

  @Override
  public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
    // only work if the bucket is empty and right clicking a cow
    if (!player.isCreative() && !hasFluid(stack) && target instanceof CowEntity && !target.isBaby()) {
      // sound
      player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
      if (!player.getCommandSenderWorld().isClientSide()) {
        addItem(player, withMilk());
        stack.shrink(1);
      }
      return ActionResultType.SUCCESS;
    }
    return ActionResultType.PASS;
  }


  /* Item stack properties */

  // TODO: perhaps separate filled and empty?
  @Override
  public int getItemStackLimit(ItemStack stack) {
    // empty stacks to 16
    return hasFluid(stack) ? 1 : 16;
  }

  @Override
  public int getBurnTime(ItemStack stack) {
    return getFluid(stack) == Fluids.LAVA ? 20000 : 0;
  }

  @Override
  public ITextComponent getName(ItemStack stack) {
    Fluid fluid = getFluid(stack);
    ITextComponent component;
    if (fluid == Fluids.EMPTY) {
      component = super.getName(stack);
    } else {
      // if the specific fluid is translatable, use that
      String key = this.getDescriptionId(stack);
      ResourceLocation location = fluid.getRegistryName();
      assert location != null;
      String fluidKey = String.format("%s.%s.%s", key, location.getNamespace(), location.getPath());
      if (ForgeI18n.getPattern(fluidKey).equals(fluidKey)) {
        component = new TranslationTextComponent(key + ".filled", new FluidStack(fluid, FluidAttributes.BUCKET_VOLUME).getDisplayName());
      } else {
        component = new TranslationTextComponent(fluidKey);
      }
    }
    return component;
  }

  @Override
  public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> subItems) {
    if (this.allowdedIn(tab)) {
      subItems.add(new ItemStack(this));
      // add all fluids that the bucket can be filled with
      for (Fluid fluid : ForgeRegistries.FLUIDS.getValues()) {
        // skip flowing fluids (we have still) and milks
        // include cracked if cracked, non-cracked if not cracked
        if (isVisible(fluid)) {
          subItems.add(setFluid(new ItemStack(this), fluid));
        }
      }
    }
  }

  /**
   * Checks if the given fluid is visible in creative
   *
   * @param fluid Fluid to check
   * @return True if its visible
   */
  private static boolean isVisible(Fluid fluid) {
    // hide empty and milk (milk shows in its own bucket
    if (fluid == Fluids.EMPTY || isMilk(fluid)) {
      return false;
    }
    return fluid.defaultFluidState().isSource();
  }
}