package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BronzeBlock extends Block {

  public BronzeBlock() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(5f, 6f)
        .sound(SoundType.METAL)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
