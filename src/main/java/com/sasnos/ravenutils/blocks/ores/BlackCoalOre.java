package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlackCoalOre extends OreBlock {

  public BlackCoalOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(20f, 600f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
