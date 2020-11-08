package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CrimwoodPlanks extends Block {

  public CrimwoodPlanks() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F, 3.0F)
        .sound(SoundType.WOOD)
    );
  }
}