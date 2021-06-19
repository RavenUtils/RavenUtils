package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class SewingNeedle extends BaseItemDamageable {
  public SewingNeedle(int maxDamage) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }

}
