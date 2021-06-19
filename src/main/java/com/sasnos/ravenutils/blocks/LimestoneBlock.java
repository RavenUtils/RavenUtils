package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class LimestoneBlock extends OreBlock {

  public LimestoneBlock() {
    super(AbstractBlock.Properties.of(Material.STONE)
        .strength(2f, 3f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
