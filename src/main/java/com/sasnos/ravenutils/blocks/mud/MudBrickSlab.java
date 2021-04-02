package com.sasnos.ravenutils.blocks.mud;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class MudBrickSlab extends SlabBlock {

  public MudBrickSlab() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(2.5F)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}