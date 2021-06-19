package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PeatBlock extends Block {

  public PeatBlock() {
    super(AbstractBlock.Properties.of(Material.DIRT)
        .strength(2.5F)
        .sound(SoundType.GRAVEL)
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
