package com.sasnos.ravenutils.items;

public class Soap extends BaseItemDamageable {
  public Soap(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }

}
