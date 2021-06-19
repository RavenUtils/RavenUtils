package com.sasnos.ravenutils.blocks.mud;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MudBlock extends Block {

  public MudBlock() {
    super(AbstractBlock.Properties.of(Material.DIRT)
        .strength(2F)
        .sound(SoundType.GRAVEL)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
