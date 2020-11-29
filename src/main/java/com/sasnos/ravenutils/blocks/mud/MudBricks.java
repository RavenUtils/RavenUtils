package com.sasnos.ravenutils.blocks.mud;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MudBricks extends Block {

  public MudBricks() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(2.5F)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}