package com.sasnos.ravenutils.items;

import net.minecraft.item.Item.Properties;

public class Soap extends BaseItemDamageable {
  public Soap(int maxDamage) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }

}
