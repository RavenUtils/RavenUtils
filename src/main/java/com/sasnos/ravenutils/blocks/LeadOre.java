package com.sasnos.ravenutils.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class LeadOre extends OreBlock {

  public LeadOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(5f, 10f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
