package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class SaltOre extends OreBlock {

  public SaltOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
