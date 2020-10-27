package com.raven_tongue.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RavenEyeBlock extends Block {

  public RavenEyeBlock() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(4f, 300f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
