package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.material.Material;

public class PottedCrimwoodSapling extends FlowerPotBlock {

  public PottedCrimwoodSapling() {
    super(ModBlocks.CRIMWOOD_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
        .zeroHardnessAndResistance()
        .notSolid());
  }
}