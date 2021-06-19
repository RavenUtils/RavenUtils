package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class BlackCoalOre extends OreBlock {

  public BlackCoalOre() {
    super(Properties.of(Material.STONE)
        .strength(20f, 600f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
