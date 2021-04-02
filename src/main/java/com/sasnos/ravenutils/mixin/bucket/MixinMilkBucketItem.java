package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.item.Item.Properties;

@Mixin(MilkBucketItem.class)
public abstract class MixinMilkBucketItem extends Item {

  public MixinMilkBucketItem(Properties properties) {
    super(properties);
  }

  /**
   * @reason add the ability to damge the bucket
   * @author Unbekannt
   */
  @Overwrite
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
    if (!worldIn.isRemote)
      entityLiving.curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air

    int damage = stack.getDamage();
    ItemStack emptyBucket;
    if (damage + 1 < stack.getMaxDamage()) {
      emptyBucket = new ItemStack(Items.BUCKET);
      emptyBucket.setDamage(damage + 1);
    } else {
      emptyBucket = ItemStack.EMPTY;
    }


    if (entityLiving instanceof ServerPlayerEntity) {
      ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
      CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
      serverplayerentity.addStat(Stats.ITEM_USED.get(this));
    }

    if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
      stack.shrink(1);
    }


    return stack.isEmpty() ? emptyBucket : stack;
  }
}
