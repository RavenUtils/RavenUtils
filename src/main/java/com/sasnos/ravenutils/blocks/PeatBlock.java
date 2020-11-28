package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PeatBlock extends Block {

  public PeatBlock() {
    super(AbstractBlock.Properties.create(Material.EARTH)
        .hardnessAndResistance(2.5F)
        .sound(SoundType.GROUND)
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
