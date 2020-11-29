package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrimwoodPlanks extends Block {

  public CrimwoodPlanks() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F, 3.0F)
        .sound(SoundType.WOOD)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
    );
  }
}