package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;

public class RavenineShield extends ShieldItem {
  public RavenineShield() {
    super(new Item.Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .maxDamage(9999));
  }
}
