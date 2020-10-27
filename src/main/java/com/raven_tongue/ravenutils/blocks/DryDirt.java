package com.raven_tongue.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DryDirt extends Block {

  public DryDirt() {
    super(AbstractBlock.Properties.create(Material.EARTH)
        .hardnessAndResistance(0.3f, 0.3f)
        .sound(SoundType.GROUND)
        .harvestLevel(0)
    );
  }
}
