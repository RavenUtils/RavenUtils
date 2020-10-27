package com.raven_tongue.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RavenEyeOre extends Block {

  public RavenEyeOre() {
    super(Properties.create(Material.IRON)
        .hardnessAndResistance(4f, 300f)
        .sound(SoundType.STONE)
        .setRequiresTool()
        .harvestTool(ToolType.PICKAXE)
    );
  }
}
