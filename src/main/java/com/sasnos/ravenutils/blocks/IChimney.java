package com.sasnos.ravenutils.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;

public interface IChimney {
  boolean bottom = false;

  void updateBlock(IWorld worldIn, BlockState facingState);

  default boolean isBottom() {
    return bottom;
  }
}
