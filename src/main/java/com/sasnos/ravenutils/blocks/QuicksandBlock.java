package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class QuicksandBlock extends SandBlock {

  public QuicksandBlock() {
    super(14406560, AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND)
        .strength(0.5F)
        .sound(SoundType.SAND)
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
