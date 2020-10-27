package com.raven_tongue.ravenutils.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;

public class CrimwoodTrapdoor extends TrapDoorBlock {

  public CrimwoodTrapdoor() {
    super(Properties.create(Material.WOOD)
        .sound(SoundType.WOOD)
        .hardnessAndResistance(3.0F)
        .sound(SoundType.WOOD)
        .notSolid()
    );
  }
}