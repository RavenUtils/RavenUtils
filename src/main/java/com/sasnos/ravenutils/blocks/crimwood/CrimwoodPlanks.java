package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodPlanks extends Block {

  public CrimwoodPlanks() {
    super(Properties.of(Material.WOOD)
        .strength(2.0F, 3.0F)
        .sound(SoundType.WOOD)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.AXE)
    );
  }
}