package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class RavenEyeBlock extends Block {

  public RavenEyeBlock() {
    super(Properties.of(Material.METAL)
        .strength(4f, 300f)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
