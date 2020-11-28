package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SaltBlock extends Block {

  public SaltBlock() {
    super(Properties.create(Material.SAND)
        .hardnessAndResistance(0.5F)
        .sound(SoundType.SAND)
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
