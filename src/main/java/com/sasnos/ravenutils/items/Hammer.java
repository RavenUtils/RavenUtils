package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Hammer extends Item {
  public Hammer() {
    super(new Item.Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .setNoRepair());
  }

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return true;
  }
}
