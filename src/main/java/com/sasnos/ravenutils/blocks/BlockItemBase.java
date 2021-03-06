package com.sasnos.ravenutils.blocks;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class BlockItemBase extends BlockItem {
  private int burnTime;

  public BlockItemBase(Block block) {
    super(block, new Properties().group(RavenUtils.TAB));
    this.burnTime = -1;
  }

  public BlockItemBase setBurnTime(int burnTime) {
    this.burnTime = burnTime;
    return this;
  }

  public int getBurnTime(ItemStack itemStack) {
    return this.burnTime;
  }
}
