package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FossilRock extends OreBlock {

  public FossilRock() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(2.5f, 8f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}