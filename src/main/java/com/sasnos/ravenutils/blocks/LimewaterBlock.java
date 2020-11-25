package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModFluids;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;

public class LimewaterBlock extends FlowingFluidBlock {

  public LimewaterBlock() {
    super(ModFluids.LIMEWATER,
        Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()
    );
  }
}
