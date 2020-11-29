package com.sasnos.ravenutils.blocks.mud;

import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MudBrickWall extends WallBlock {

  public MudBrickWall() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(2.5F)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}