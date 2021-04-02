package com.sasnos.ravenutils.items;

import net.minecraft.item.Rarity;

import net.minecraft.item.Item.Properties;

public class Knife extends BaseItemDamageable {
  public Knife(int maxDamage, Rarity rarity) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .rarity(rarity)
        .setNoRepair());
  }

}
