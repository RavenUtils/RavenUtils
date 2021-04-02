package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class SilverBlock extends Block {

  public SilverBlock() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(5f, 6f)
        .sound(SoundType.METAL)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
