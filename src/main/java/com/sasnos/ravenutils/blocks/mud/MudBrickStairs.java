package com.sasnos.ravenutils.blocks.mud;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.StairsBlock;

import net.minecraft.block.AbstractBlock.Properties;

public class MudBrickStairs extends StairsBlock {

  public MudBrickStairs() {
    super(() -> ModBlocks.MUD_BRICKS.get().defaultBlockState(),
        Properties.copy(ModBlocks.MUD_BRICKS.get()));
  }
}