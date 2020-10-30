package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SaltBlock extends Block {

  public SaltBlock() {
    super(Properties.create(Material.SAND)
        .hardnessAndResistance(0.5F)
        .sound(SoundType.SAND)
    );
  }
}
