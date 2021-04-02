package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class SilverOre extends OreBlock {

  public SilverOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
