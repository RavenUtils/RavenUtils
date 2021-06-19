package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class Mortar extends BaseItemDamageable {
  public Mortar(int maxDamage) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }
}
