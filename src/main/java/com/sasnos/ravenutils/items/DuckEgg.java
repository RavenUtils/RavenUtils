package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.EggItem;

import net.minecraft.item.Item.Properties;

public class DuckEgg extends EggItem {
  public DuckEgg() {
    super(new Properties()
        .stacksTo(16)
        .tab(RavenUtils.TAB));
  }
}
