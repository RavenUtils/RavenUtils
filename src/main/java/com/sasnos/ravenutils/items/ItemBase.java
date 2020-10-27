package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;

public class ItemBase extends Item {

  public ItemBase() {
    super(new Item.Properties().group(RavenUtils.TAB));
  }
}
