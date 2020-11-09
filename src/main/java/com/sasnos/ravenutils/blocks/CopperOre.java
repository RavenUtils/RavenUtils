package com.sasnos.ravenutils.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperOre extends OreBlock {

  public CopperOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
