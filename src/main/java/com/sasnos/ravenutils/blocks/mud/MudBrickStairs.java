package com.sasnos.ravenutils.blocks.mud;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.StairsBlock;

public class MudBrickStairs extends StairsBlock {

  public MudBrickStairs() {
    super(() -> ModBlocks.MUD_BRICKS.get().getDefaultState(),
        Properties.from(ModBlocks.MUD_BRICKS.get()));
  }
}