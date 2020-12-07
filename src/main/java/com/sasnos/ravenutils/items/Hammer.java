package com.sasnos.ravenutils.items;


import net.minecraft.item.Rarity;

public class Hammer extends BaseItemDamageable {
  public Hammer(int maxDamage, Rarity rarity) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .rarity(rarity)
        .setNoRepair());
  }

}
