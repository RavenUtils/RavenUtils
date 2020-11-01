package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Limestone extends OreBlock {

  public Limestone() {
    super(AbstractBlock.Properties.create(Material.ROCK)
        .hardnessAndResistance(2f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
