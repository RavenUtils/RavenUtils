package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;

public class ItemBase extends Item {
  private int burnTime;

  public ItemBase() {
    super(new Properties().group(RavenUtils.TAB));
  }

  public ItemBase(Properties properties) {
    super(properties.group(RavenUtils.TAB));
  }
}
