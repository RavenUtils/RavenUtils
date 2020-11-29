package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrimwoodDoor extends DoorBlock {

  public CrimwoodDoor() {
    super(Properties.create(Material.WOOD)
        .sound(SoundType.WOOD)
        .hardnessAndResistance(3.0F)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
        .notSolid()
    );
  }
}