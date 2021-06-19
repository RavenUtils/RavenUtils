package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

import net.minecraft.item.Item.Properties;

public class Tongs extends Item {
  public Tongs(int maxDamage, Rarity rarity) {
    super(new Properties()
        .tab(RavenUtils.TAB)
        .stacksTo(1)
        .durability(maxDamage)
        .rarity(rarity)
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
