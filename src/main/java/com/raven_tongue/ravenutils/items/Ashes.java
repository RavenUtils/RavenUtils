package com.raven_tongue.ravenutils.items;

import com.raven_tongue.ravenutils.RavenUtils;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;

public class Ashes extends BoneMealItem {
  public Ashes() {
    super(new Item.Properties()
        .group(RavenUtils.TAB));
  }
}
