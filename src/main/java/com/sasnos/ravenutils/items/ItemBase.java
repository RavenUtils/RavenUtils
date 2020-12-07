package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBase extends Item {
  private int burnTime;

  public ItemBase() {
    super(new Properties().group(RavenUtils.TAB));
    this.burnTime = 0;
  }

  public ItemBase(Properties properties) {
    super(properties.group(RavenUtils.TAB));
    this.burnTime = 0;
  }

  public ItemBase setBurnTime(int burnTime) {
    this.burnTime = burnTime;
    return this;
  }

  public int getBurnTime(ItemStack itemStack) {
    return this.burnTime;
  }

  public boolean isRepairable(@Nonnull ItemStack stack) {
    return false;
  }
}
