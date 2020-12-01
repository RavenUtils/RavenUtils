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
  public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
  protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

  public Reeds(AbstractBlock.Properties properties) {
    super(properties);
    this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
  }

  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }

  public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    if (!state.isValidPosition(worldIn, pos)) {
      worldIn.destroyBlock(pos, true);
    }

  }

  public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
    if (worldIn.isAirBlock(pos.up())) {
      int i;
      for (i = 1; worldIn.getBlockState(pos.down(i)).isIn(this); ++i) {
      }

      if (i < 3) {
        int j = state.get(AGE);
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
          if (j == 15) {
            worldIn.setBlockState(pos.up(), this.getDefaultState());
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
          } else {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 2);
          }
        }
      }
    }
  }

  public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    if (!stateIn.isValidPosition(worldIn, currentPos)) {
      worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
    }

    return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
  }

  public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
    BlockState soil = worldIn.getBlockState(pos.down());
    if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this)) return true;
    BlockState blockstate = worldIn.getBlockState(pos.down());
    if (blockstate.getBlock() == this) {
      return true;
    } else {
      if (blockstate.isIn(Blocks.GRASS_BLOCK) || blockstate.isIn(Blocks.DIRT) || blockstate.isIn(ModBlocks.MUD_BLOCK.get())) {
        BlockPos blockpos = pos.down();

        for (Direction direction : Direction.Plane.HORIZONTAL) {
          BlockState blockstate1 = worldIn.getBlockState(blockpos.offset(direction));
          FluidState fluidstate = worldIn.getFluidState(blockpos.offset(direction));
          if (fluidstate.isTagged(FluidTags.WATER) || blockstate1.isIn(Blocks.FROSTED_ICE)) {
            return true;
          }
        }
      }

      return false;
    }
  }

  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(AGE);
  }

  @Override
  public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
    return net.minecraftforge.common.PlantType.BEACH;
  }

  @Override
  public BlockState getPlant(IBlockReader world, BlockPos pos) {
    return getDefaultState();
  }
}
