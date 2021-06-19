package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class Chisel extends BaseItemDamageable {
  public Chisel(int maxDamage) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }

}
