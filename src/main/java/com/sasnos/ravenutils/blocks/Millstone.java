package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Millstone extends Block {

  public Millstone() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3F)
        .sound(SoundType.STONE));
  }
}
