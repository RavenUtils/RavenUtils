package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.EggItem;

public class DuckEgg extends EggItem {
  public DuckEgg() {
    super(new Properties()
        .maxStackSize(16)
        .group(RavenUtils.TAB));
  }
}
