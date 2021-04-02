package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodFenceGate extends FenceGateBlock {

  public CrimwoodFenceGate() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F, 3.0F)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD));
  }
}