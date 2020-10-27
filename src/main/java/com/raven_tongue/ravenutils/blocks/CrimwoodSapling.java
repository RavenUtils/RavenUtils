package com.raven_tongue.ravenutils.blocks;

import com.raven_tongue.ravenutils.blocks.trees.CrimwoodTree;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CrimwoodSapling extends SaplingBlock {

  public CrimwoodSapling() {
    super(new CrimwoodTree(), AbstractBlock.Properties.create(Material.PLANTS)
        .doesNotBlockMovement()
        .tickRandomly()
        .zeroHardnessAndResistance()
        .sound(SoundType.PLANT));
  }
}