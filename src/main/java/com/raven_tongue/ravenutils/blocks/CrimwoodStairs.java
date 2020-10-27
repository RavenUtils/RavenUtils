package com.raven_tongue.ravenutils.blocks;

import com.raven_tongue.ravenutils.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.StairsBlock;

public class CrimwoodStairs extends StairsBlock {

  public CrimwoodStairs() {
    super(ModBlocks.CRIMWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(ModBlocks.CRIMWOOD_PLANKS.get()));
  }
}