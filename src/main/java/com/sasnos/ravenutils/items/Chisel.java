package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class Chisel extends BaseItemDamageable {
  public Chisel(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }

}
