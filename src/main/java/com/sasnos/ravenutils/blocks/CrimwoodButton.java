package com.sasnos.ravenutils.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrimwoodButton extends WoodButtonBlock {

  public CrimwoodButton() {
    super(Properties.create(Material.MISCELLANEOUS)
        .doesNotBlockMovement()
        .hardnessAndResistance(0.5F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
  }
}