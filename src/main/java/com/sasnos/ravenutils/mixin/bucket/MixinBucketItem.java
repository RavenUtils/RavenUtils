package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BucketItem.class)
public abstract class MixinBucketItem extends Item {

  @Final
  @Shadow
  private Fluid containedBlock;

  public MixinBucketItem(Properties properties) {
    super(properties);
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return false;
  }

  /**
   * @reason add way to add damage to the bucket when emptied and destroy it when exceed max Damage
   * @author Unbekannt
   */
  @Overwrite
  protected ItemStack emptyBucket(ItemStack itemstack, PlayerEntity playerIn) {
    if (playerIn.abilities.isCreativeMode) {
      return itemstack;
    }

    if (itemstack.getDamage() + 1 > itemstack.getMaxDamage()) {
      return ItemStack.EMPTY;
    }
    int damage = itemstack.getDamage() + 1;
    ItemStack newBucket = new ItemStack(Items.BUCKET);
    newBucket.setDamage(damage);
    return newBucket;
  }
}
