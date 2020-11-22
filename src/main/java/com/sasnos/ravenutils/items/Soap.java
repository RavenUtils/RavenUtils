package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Soap extends Item {
  public Soap(int maxDamage) {
    super(new Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
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
}
