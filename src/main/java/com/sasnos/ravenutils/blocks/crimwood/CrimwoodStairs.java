package com.sasnos.ravenutils.blocks.crimwood;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.StairsBlock;

public class CrimwoodStairs extends StairsBlock {

  public CrimwoodStairs() {
    super(() -> ModBlocks.CRIMWOOD_PLANKS.get().getDefaultState(),
        Properties.from(ModBlocks.CRIMWOOD_PLANKS.get()));
  }
}