package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MytherineOre extends OreBlock {

  public MytherineOre() {
    super(AbstractBlock.Properties.create(Material.ROCK)
        .hardnessAndResistance(40f, 1200f)
        .sound(SoundType.STONE)
        .harvestLevel(3)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
