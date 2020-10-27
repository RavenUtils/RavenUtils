package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DryDirt extends Block {

  public DryDirt() {
    super(AbstractBlock.Properties.create(Material.EARTH)
        .hardnessAndResistance(0.3f, 0.3f)
        .sound(SoundType.GROUND)
        .harvestLevel(0)
    );
  }
}
