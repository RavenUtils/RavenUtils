package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class ResinBlock extends Block {

  public ResinBlock() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(5f, 50f)
        .sound(SoundType.SLIME)
        .speedFactor(0.1F)
        .harvestTool(ToolType.PICKAXE)
        .notSolid()
    );
  }
}
