package com.sasnos.ravenutils.items;

import net.minecraft.item.Rarity;

import net.minecraft.item.Item.Properties;

public class Knife extends BaseItemDamageable {
  public Knife(int maxDamage, Rarity rarity) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .rarity(rarity)
        .setNoRepair());
  }

}
