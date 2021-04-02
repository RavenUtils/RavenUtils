package com.sasnos.ravenutils.blocks.crimwood;

import com.sasnos.ravenutils.blocks.trees.CrimwoodTree;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodSapling extends SaplingBlock {

  public CrimwoodSapling() {
    super(new CrimwoodTree(), Properties.create(Material.PLANTS)
        .doesNotBlockMovement()
        .tickRandomly()
        .zeroHardnessAndResistance()
        .sound(SoundType.PLANT));
  }
}