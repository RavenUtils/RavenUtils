package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MytherineBlock extends Block {

  public MytherineBlock() {
    super(AbstractBlock.Properties.create(Material.IRON)
        .hardnessAndResistance(4f, 1200f)
        .sound(SoundType.METAL)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
