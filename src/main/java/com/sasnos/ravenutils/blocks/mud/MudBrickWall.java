package com.sasnos.ravenutils.blocks.mud;

import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class MudBrickWall extends WallBlock {

  public MudBrickWall() {
    super(Properties.of(Material.STONE)
        .strength(2.5F)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}