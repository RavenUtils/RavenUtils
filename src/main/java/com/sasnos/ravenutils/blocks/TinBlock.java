package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TinBlock extends Block {

  public TinBlock() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(5f, 6f)
        .sound(SoundType.METAL)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
