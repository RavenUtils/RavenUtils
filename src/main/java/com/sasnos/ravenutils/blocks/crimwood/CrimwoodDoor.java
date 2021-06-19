package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodDoor extends DoorBlock {

  public CrimwoodDoor() {
    super(Properties.of(Material.WOOD)
        .sound(SoundType.WOOD)
        .strength(3.0F)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.AXE)
        .noOcclusion()
    );
  }
}