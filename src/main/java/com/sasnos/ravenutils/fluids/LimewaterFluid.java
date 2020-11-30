package com.sasnos.ravenutils.fluids;

import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class LimewaterFluid {

  private static final ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(ModFluids.LIMEWATER, ModFluids.FLOWING_LIMEWATER,
      FluidAttributes.builder(
          new ResourceLocation("block/water_still"),
          new ResourceLocation("block/water_flow"))
          .color(0xFFA6A6A6))
      .bucket(ModToolItems.BUCKET_IRON_LIMEWATER)
      .block(() -> (FlowingFluidBlock) ModBlocks.LIMEWATER_BLOCK.get())
      .slopeFindDistance(4)
      .levelDecreasePerBlock(1)
      .explosionResistance(100F);

  public static class Flowing extends ForgeFlowingFluid.Flowing {
    public Flowing() {
      super(properties);
    }
  }

  public static class Source extends ForgeFlowingFluid.Source {
    public Source() {
      super(properties);
    }
  }
}
