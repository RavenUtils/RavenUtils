package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModFluids;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;

public class TanninBlock extends FlowingFluidBlock {

  public TanninBlock() {
    super(ModFluids.TANNIN,
        Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()

    );
  }
}
