package com.sasnos.ravenutils.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class RavenEyeOre extends OreBlock {

  public RavenEyeOre() {
    super(Properties.of(Material.METAL)
        .strength(4f, 300f)
        .sound(SoundType.STONE)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
