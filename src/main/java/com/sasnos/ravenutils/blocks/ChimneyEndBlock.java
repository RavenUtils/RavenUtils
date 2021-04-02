package com.sasnos.ravenutils.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;

import net.minecraft.block.AbstractBlock.Properties;

public class ChimneyEndBlock extends Block implements IChimney {

  public ChimneyEndBlock(Properties properties) {
    super(properties);
  }

  @Override
  public void updateBlock(IWorld worldIn, BlockState facingState) {

  }
}
