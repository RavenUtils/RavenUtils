package com.sasnos.ravenutils.blocks.fuels;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class BlackCoalBlockItem extends BlockItem {

  public BlackCoalBlockItem(Block blockIn, Properties builder) {
    super(blockIn, builder);
  }

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return 24000;
  }
}
