package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;

public class Mortar extends BaseItemDamageable {
  public Mortar(int maxDamage) {
    super(new Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }


}
