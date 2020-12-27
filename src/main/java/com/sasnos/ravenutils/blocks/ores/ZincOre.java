package com.sasnos.ravenutils.blocks.ores;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ZincOre extends OreBlock {

  public ZincOre() {
    super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
        // todo make harvestabke by axe (stone+) and pickaxe (iron+) only
        // .harvestTool(ToolType.PICKAXE)
    );
  }
}
