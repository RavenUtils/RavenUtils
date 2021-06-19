package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class GelatinBlock extends Block {

  public GelatinBlock() {
    super(Properties.of(Material.SPONGE)
        .strength(2f, 3f)
        .sound(SoundType.SLIME_BLOCK)
        .speedFactor(0.01F)
        .harvestTool(ToolType.SHOVEL)
        .noOcclusion()
    );
  }
}
