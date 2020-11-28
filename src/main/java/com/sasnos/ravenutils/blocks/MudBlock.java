package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MudBlock extends Block {

  public MudBlock() {
    super(AbstractBlock.Properties.create(Material.EARTH)
        .hardnessAndResistance(2F)
        .sound(SoundType.GROUND)
        .setRequiresTool()
        .harvestTool(ToolType.SHOVEL)
    );
  }
}
