package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.FenceBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodFence extends FenceBlock {

  public CrimwoodFence() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F, 3.0F)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD));
  }
}