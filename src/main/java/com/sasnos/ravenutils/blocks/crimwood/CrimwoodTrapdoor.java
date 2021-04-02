package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodTrapdoor extends TrapDoorBlock {

  public CrimwoodTrapdoor() {
    super(Properties.create(Material.WOOD)
        .sound(SoundType.WOOD)
        .hardnessAndResistance(3.0F)
        .sound(SoundType.WOOD)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
        .notSolid()
    );
  }
}