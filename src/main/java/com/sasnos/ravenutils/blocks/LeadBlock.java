package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class LeadBlock extends Block {

  public LeadBlock() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(7f, 12f)
        .sound(SoundType.METAL)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
