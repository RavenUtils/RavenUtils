package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class SewingNeedle extends BaseItemDamageable {
  public SewingNeedle(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }

}
