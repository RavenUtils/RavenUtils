package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModFluids;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;

import net.minecraft.block.AbstractBlock.Properties;

public class TanninBlock extends FlowingFluidBlock {

  public TanninBlock() {
    super(ModFluids.TANNIN,
        Properties.of(Material.WATER)
            .noCollission()
            .strength(100.0F)
            .noDrops()

    );
  }
}
