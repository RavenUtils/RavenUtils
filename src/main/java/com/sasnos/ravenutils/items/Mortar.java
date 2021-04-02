package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class Mortar extends BaseItemDamageable {
  public Mortar(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }
}
