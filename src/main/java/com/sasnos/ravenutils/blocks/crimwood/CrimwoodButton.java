package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.SoundType;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodButton extends WoodButtonBlock {

  public CrimwoodButton() {
    super(Properties.of(Material.DECORATION)
        .noCollission()
        .strength(0.5F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
  }
}