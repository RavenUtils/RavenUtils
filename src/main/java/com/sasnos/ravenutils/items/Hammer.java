package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ToolItem;

import java.util.HashSet;

public class Hammer extends ToolItem {
  public Hammer(int maxDamage, Rarity rarity, float attackDamage, float attackSpeed, IItemTier hammerTier) {
    super(attackDamage, attackSpeed, hammerTier, new HashSet<>(), new Properties()
            .maxStackSize(1)
            .maxDamage(maxDamage)
            .rarity(rarity)
            .setNoRepair()
            .group(RavenUtils.TAB));
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
    return false;
  }
}
