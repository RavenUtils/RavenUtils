package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CrimwoodLeaves extends LeavesBlock {

  public CrimwoodLeaves() {
    super(Properties.create(Material.LEAVES)
        .hardnessAndResistance(0.2F)
        .tickRandomly()
        .sound(SoundType.PLANT)
        .notSolid());
  }
}