package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlackCoal extends Item {

  public BlackCoal() {
    super(new Properties().group(RavenUtils.TAB));
  }

  @Override
  public int getBurnTime(ItemStack itemstack) {
    return 2400;
  }
}
