package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.fluids.TanninFluid;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;

public class TanninBlock extends FlowingFluidBlock {

  public TanninBlock() {
    super(TanninFluid.Source::new,
        Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()
    );
  }
}
