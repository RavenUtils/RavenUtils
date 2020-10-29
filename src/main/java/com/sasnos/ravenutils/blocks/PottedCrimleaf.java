package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.material.Material;

public class PottedCrimleaf extends FlowerPotBlock {

  public PottedCrimleaf() {
    super(ModBlocks.CRIMLEAF.get(), Properties.create(Material.MISCELLANEOUS)
        .zeroHardnessAndResistance()
        .notSolid());
  }
}