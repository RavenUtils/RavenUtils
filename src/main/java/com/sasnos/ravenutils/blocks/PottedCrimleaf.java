package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.material.Material;

import net.minecraft.block.AbstractBlock.Properties;

public class PottedCrimleaf extends FlowerPotBlock {

  public PottedCrimleaf() {
    super(null, ModBlocks.CRIMLEAF, Properties.of(Material.DECORATION)
        .instabreak()
        .noOcclusion());
  }
}