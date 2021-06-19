package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;

import net.minecraft.item.Item.Properties;

public class ItemBase extends Item {
  private int burnTime;

  public ItemBase() {
    super(new Properties().tab(RavenUtils.TAB));
  }

  public ItemBase(Properties properties) {
    super(properties.tab(RavenUtils.TAB));
  }
}
