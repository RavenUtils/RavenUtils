package com.sasnos.ravenutils.blocks;

import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

import net.minecraft.block.AbstractBlock.Properties;

public class Crimleaf extends FlowerBlock {

  public Crimleaf() {
    super(Effects.ABSORPTION, 5, Properties.of(Material.PLANT)
        .sound(SoundType.CROP)
        .instabreak()
        .noCollission()
        .lightLevel((state) -> {
          return 5;
        })
    );
  }
}