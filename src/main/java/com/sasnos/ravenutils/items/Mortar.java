package com.sasnos.ravenutils.items;

public class Mortar extends BaseItemDamageable {
  public Mortar(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }
}
