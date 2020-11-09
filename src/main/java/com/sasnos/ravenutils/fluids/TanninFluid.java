package com.sasnos.ravenutils.fluids;

import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TanninFluid extends FlowingFluid {
  @Override
  public Fluid getFlowingFluid() {
    return ModFluids.FLOWING_TANNIN;
  }

  @Override
  public Fluid getStillFluid() {
    return ModFluids.TANNIN;
  }

  @Override
  public Item getFilledBucket() {
    return ModToolItems.TANNIN_BUCKET.get();
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

  @Nullable
  @OnlyIn(Dist.CLIENT)
  public IParticleData getDripParticleData() {
    return ParticleTypes.DRIPPING_WATER;
  }

  @Override
  protected boolean canSourcesMultiply() {
    return false;
  }

  @Override
  protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
    TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
    Block.spawnDrops(state, worldIn, pos, tileentity);
  }

  @Override
  public int getSlopeFindDistance(IWorldReader worldIn) {
    return 4;
  }

  @Override
  public BlockState getBlockState(FluidState state) {
    return ModBlocks.TANNIN_BLOCK.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
  }

  public boolean isEquivalentTo(Fluid fluidIn) {
    return fluidIn == Fluids.WATER || fluidIn == Fluids.FLOWING_WATER;
  }

  @Override
  public int getLevelDecreasePerBlock(IWorldReader worldIn) {
    return 1;
  }

  @Override
  public int getTickRate(IWorldReader p_205569_1_) {
    return 5;
  }

  @Override
  public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
    return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
  }

  @Override
  protected float getExplosionResistance() {
    return 100.0F;
  }

  public static class Flowing extends TanninFluid {
    @Override
    protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
      super.fillStateContainer(builder);
      builder.add(LEVEL_1_8);
    }

    @Override
    public int getLevel(FluidState state) {
      return state.get(LEVEL_1_8);
    }

    @Override
    public boolean isSource(FluidState state) {
      return false;
    }
  }

  public static class Source extends TanninFluid {
    @Override
    public int getLevel(FluidState state) {
      return 8;
    }

    @Override
    public boolean isSource(FluidState state) {
      return true;
    }
  }
}