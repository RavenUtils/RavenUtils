package com.sasnos.ravenutils.items;

import net.minecraft.item.Rarity;

public class Knife extends BaseItemDamageable {
  public Knife(int maxDamage, Rarity rarity) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .rarity(rarity)
        .setNoRepair());
  }

}
