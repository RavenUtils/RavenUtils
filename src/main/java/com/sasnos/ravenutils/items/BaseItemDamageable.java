package com.sasnos.ravenutils.items;

import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class BaseItemDamageable extends ItemBase {

  public BaseItemDamageable() {
    super(new Properties());
  }

  public BaseItemDamageable(Properties properties) {
    super(properties);
  }

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return true;
  }

  @Override
  public ItemStack getContainerItem(ItemStack itemstack) {
    ItemStack stack = itemstack.copy();
    if (stack.getMaxDamage() - stack.getDamage() <= 0) {
      stack.shrink(1);
    } else {
      if (stack.attemptDamageItem(1, random, null)) {
        stack.shrink(1);
      }
    }
    return stack;
  }
}
