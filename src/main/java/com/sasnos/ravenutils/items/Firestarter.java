package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class Firestarter extends FlintAndSteelItem {
  public Firestarter(int maxDamage) {
    super(new Properties()
        .tab(RavenUtils.TAB)
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return true;
  }

  @Override
  public ItemStack getContainerItem(ItemStack itemstack) {
    ItemStack stack = itemstack.copy();
    if (stack.getMaxDamage() - stack.getDamageValue() <= 1) {
      stack.shrink(1);
    } else {
      stack.hurt(1, random, null);
    }
    return stack;
  }
}
