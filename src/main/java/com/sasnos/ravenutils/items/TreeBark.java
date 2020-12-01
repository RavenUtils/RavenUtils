package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TreeBark extends Item {

  public TreeBark() {
    super(new Item.Properties().group(RavenUtils.TAB));
  }

  @Override
  public int getBurnTime(ItemStack itemstack) {
    return 100;
  }
}
