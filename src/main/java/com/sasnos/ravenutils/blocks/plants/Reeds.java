package com.sasnos.ravenutils.blocks.plants;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class Reeds extends Block implements net.minecraftforge.common.IPlantable {
  public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
  protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

  public Reeds(AbstractBlock.Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
  }

  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }

  public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    if (!state.canSurvive(worldIn, pos)) {
      worldIn.destroyBlock(pos, true);
    }

  }

  public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
    if (worldIn.isEmptyBlock(pos.above())) {
      int i;
      for (i = 1; worldIn.getBlockState(pos.below(i)).is(this); ++i) {
      }

      if (i < 3) {
        int j = state.getValue(AGE);
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
          if (j == 15) {
            worldIn.setBlockAndUpdate(pos.above(), this.defaultBlockState());
            worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 2);
          } else {
            worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(j + 1)), 2);
          }
        }
      }
    }
  }

  public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    if (!stateIn.canSurvive(worldIn, currentPos)) {
      worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
    }

    return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
  }

  public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
    BlockState soil = worldIn.getBlockState(pos.below());
    if (soil.canSustainPlant(worldIn, pos.below(), Direction.UP, this)) return true;
    BlockState blockstate = worldIn.getBlockState(pos.below());
    if (blockstate.getBlock() == this) {
      return true;
    } else {
      if (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.DIRT) || blockstate.is(ModBlocks.MUD_BLOCK.get())) {
        BlockPos blockpos = pos.below();

        for (Direction direction : Direction.Plane.HORIZONTAL) {
          BlockState blockstate1 = worldIn.getBlockState(blockpos.relative(direction));
          FluidState fluidstate = worldIn.getFluidState(blockpos.relative(direction));
          if (fluidstate.is(FluidTags.WATER) || blockstate1.is(Blocks.FROSTED_ICE)) {
            return true;
          }
        }
      }

      return false;
    }
  }

  protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(AGE);
  }

  @Override
  public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
    return net.minecraftforge.common.PlantType.BEACH;
  }

  @Override
  public BlockState getPlant(IBlockReader world, BlockPos pos) {
    return defaultBlockState();
  }
}
