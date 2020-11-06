package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.fluids.LimewaterFluid;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;

public class LimewaterBlock extends FlowingFluidBlock {

  public LimewaterBlock() {
    super(LimewaterFluid.Source::new,
        Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()
    );
  }
}
