package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlackCoalBlock extends Block {

  public BlackCoalBlock() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(4f, 600f)
        .sound(SoundType.STONE)
    );
  }
}
