package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class FossilDirt extends OreBlock {

  public FossilDirt() {
    super(Properties.create(Material.EARTH)
        .hardnessAndResistance(2f, 5f)
        .sound(SoundType.GROUND)
        .harvestLevel(2)
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
