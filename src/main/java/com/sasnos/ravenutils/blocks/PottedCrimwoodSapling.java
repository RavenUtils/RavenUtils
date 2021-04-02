package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.material.Material;

import net.minecraft.block.AbstractBlock.Properties;

public class PottedCrimwoodSapling extends FlowerPotBlock {

  public PottedCrimwoodSapling() {
    super(null, ModBlocks.CRIMWOOD_SAPLING, Properties.create(Material.MISCELLANEOUS)
        .zeroHardnessAndResistance()
        .notSolid());
  }
}