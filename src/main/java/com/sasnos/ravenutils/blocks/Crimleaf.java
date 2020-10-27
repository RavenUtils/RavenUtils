package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

public class Crimleaf extends FlowerBlock {

  public Crimleaf() {
    super(Effects.ABSORPTION, 5, AbstractBlock.Properties.create(Material.PLANTS)
        .sound(SoundType.CROP)
        .zeroHardnessAndResistance()
        .doesNotBlockMovement()
    );
  }
}