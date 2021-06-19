package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class SulfurOre extends OreBlock {

  public SulfurOre() {
    super(Properties.of(Material.STONE)
        .strength(3f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
