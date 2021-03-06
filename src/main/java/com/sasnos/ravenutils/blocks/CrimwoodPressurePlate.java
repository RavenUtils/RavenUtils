package com.sasnos.ravenutils.blocks;

import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CrimwoodPressurePlate extends PressurePlateBlock {

  public CrimwoodPressurePlate() {
    super(Sensitivity.EVERYTHING, Properties.create(Material.WOOD)
        .doesNotBlockMovement()
        .hardnessAndResistance(0.5F)
        .sound(SoundType.WOOD));
  }
}