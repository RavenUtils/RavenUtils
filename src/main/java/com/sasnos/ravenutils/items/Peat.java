package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class Peat extends Item {

  public Peat() {
    super(new Properties().group(RavenUtils.TAB));
  }

  @Override
  public int getBurnTime(ItemStack itemstack) {
    return 800;
  }
}
