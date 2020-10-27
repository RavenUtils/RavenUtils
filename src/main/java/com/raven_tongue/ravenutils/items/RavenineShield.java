package com.raven_tongue.ravenutils.items;

import com.raven_tongue.ravenutils.RavenUtils;
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
