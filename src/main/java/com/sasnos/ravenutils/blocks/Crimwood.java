package com.sasnos.ravenutils.blocks;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Crimwood extends RotatedPillarBlock {

  public Crimwood() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F)
        .sound(SoundType.WOOD));
  }
}