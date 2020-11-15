package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.particles.ParticleTypes;

public class CandleBlock extends TorchBlock {

  public CandleBlock() {
    super(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
        .doesNotBlockMovement()
        .zeroHardnessAndResistance()
        .setLightLevel((state) -> {
          return 10;
        })
        .sound(SoundType.WOOD), ParticleTypes.FLAME);
  }
}
