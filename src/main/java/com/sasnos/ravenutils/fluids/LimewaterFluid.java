package com.sasnos.ravenutils.fluids;

import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.Random;

public abstract class LimewaterFluid extends ForgeFlowingFluid {

  private static final ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(() -> ModFluids.LIMEWATER, () -> ModFluids.FLOWING_LIMEWATER,
      net.minecraftforge.fluids.FluidAttributes.builder(
          new net.minecraft.util.ResourceLocation("block/water_still"),
          new net.minecraft.util.ResourceLocation("block/water_flow"))
          .color(0xFFFFCC35)
          .translationKey("block.lavalamp.salty_water_block"))
      .bucket(ModToolItems.LIMEWATER_BUCKET)
      .block(() -> (FlowingFluidBlock) ModBlocks.LIMEWATER_BLOCK.get())
      .slopeFindDistance(4)
      .levelDecreasePerBlock(1)
      .explosionResistance(100F);

  protected LimewaterFluid(Properties properties) {
    super(properties);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
    if (!state.isSource() && !state.get(FALLING)) {
      if (random.nextInt(64) == 0) {
        worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
      }
    } else if (random.nextInt(10) == 0) {
      worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
    }

  }

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
