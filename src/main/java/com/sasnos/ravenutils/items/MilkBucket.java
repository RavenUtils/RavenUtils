package com.sasnos.ravenutils.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IRegistryDelegate;

/**
 * Clay bucket holding milk
 */
public class MilkBucket extends BaseBucketItem {
  private static final ItemStack MILK_STACK = new ItemStack(Items.MILK_BUCKET);
  public MilkBucket(Item containerItemIn, int maxDamage) {
    super(new Properties()
            .maxStackSize(1)
            .containerItem(containerItemIn)
            .maxDamage(maxDamage)
            .setNoRepair());
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand hand) {
    player.setActiveHand(hand);
    return new ActionResult<>(ActionResultType.SUCCESS, player.getHeldItem(hand));
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.DRINK;
  }

  @Override
  public int getUseDuration(ItemStack stack) {
    return 32;
  }

  @Override
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
    if (!worldIn.isRemote()) {
      // TODO: this is a hack until I find a better way to make it cure the same as milk
      entity.curePotionEffects(MILK_STACK);
    }
    // update stats
    if (entity instanceof ServerPlayerEntity) {
      ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity;
      CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
      serverplayerentity.addStat(Stats.ITEM_USED.get(this));
    }
    // if a player, empty a bucket
    if (entity instanceof PlayerEntity) {
      PlayerEntity player = (PlayerEntity)entity;
      return updateBucket(stack, player, stack.getContainerItem());
    }
    return stack;
  }

  /* Fluids */

  @Override
  protected boolean hasFluid(ItemStack container) {
    return true;
  }

  /** Cached milk type */
  private static IRegistryDelegate<Fluid> milk = null;

  @Override
  public Fluid getFluid(ItemStack stack) {
    // TODO: store this value in config, instead of a static variable
    if (milk != null) {
      return milk.get();
    }
    // if the tag is empty, return empty, otherwise get a random element
    Fluid newMilk = Fluids.EMPTY;//CeramicsTags.Fluids.MILK.getAllElements().isEmpty() ? Fluids.EMPTY : CeramicsTags.Fluids.MILK.getRandomElement(random);
    milk = newMilk.delegate;
    return newMilk;
  }

  @Override
  public void fillItemGroup(ItemGroup tab, NonNullList<ItemStack> subItems) {
    if (/*Config.bucketEnabled && */this.isInGroup(tab)) {
      subItems.add(new ItemStack(this));
    }
  }
}
