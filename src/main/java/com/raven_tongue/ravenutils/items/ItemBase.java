package com.raven_tongue.ravenutils.items;

import com.raven_tongue.ravenutils.RavenUtils;
import net.minecraft.item.Item;

public class ItemBase extends Item {

  public ItemBase() {
    super(new Item.Properties().group(RavenUtils.TAB));
  }
}
