package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CrimwoodDoor extends DoorBlock {

  public CrimwoodDoor() {
    super(AbstractBlock.Properties.create(Material.WOOD)
        .sound(SoundType.WOOD)
        .hardnessAndResistance(3.0F)
        .notSolid()
    );
  }
}