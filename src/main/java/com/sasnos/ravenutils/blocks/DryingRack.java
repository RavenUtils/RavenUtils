package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class DryingRack extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.makeCuboidShape(1, 0, 1, 2, 14, 2),
      Block.makeCuboidShape(14, 0, 1, 15, 14, 2),
      Block.makeCuboidShape(14, 0, 14, 15, 14, 15),
      Block.makeCuboidShape(1, 0, 14, 2, 14, 15),
      Block.makeCuboidShape(0, 15, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 15, 2, 16, 16, 3),
      Block.makeCuboidShape(0, 15, 4, 16, 16, 5),
      Block.makeCuboidShape(0, 15, 6, 16, 16, 7),
      Block.makeCuboidShape(0, 15, 8, 16, 16, 9),
      Block.makeCuboidShape(0, 15, 10, 16, 16, 11),
      Block.makeCuboidShape(0, 15, 12, 16, 16, 13),
      Block.makeCuboidShape(0, 15, 14, 16, 16, 16),
      Block.makeCuboidShape(0, 16, 15, 16, 17, 16),
      Block.makeCuboidShape(1, 14, 0, 2, 15, 16),
      Block.makeCuboidShape(14, 14, 0, 15, 15, 16),
      Block.makeCuboidShape(2, 14, 0, 14, 15, 1),
      Block.makeCuboidShape(2, 7, 1, 14, 8, 2),
      Block.makeCuboidShape(2, 7, 14, 14, 8, 15),
      Block.makeCuboidShape(1, 7, 2, 2, 8, 14),
      Block.makeCuboidShape(14, 7, 2, 15, 8, 14),
      Block.makeCuboidShape(2, 14, 15, 14, 15, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.makeCuboidShape(14, 0, 1, 15, 14, 2),
      Block.makeCuboidShape(14, 0, 14, 15, 14, 15),
      Block.makeCuboidShape(1, 0, 14, 2, 14, 15),
      Block.makeCuboidShape(1, 0, 1, 2, 14, 2),
      Block.makeCuboidShape(15, 15, 0, 16, 16, 16),
      Block.makeCuboidShape(13, 15, 0, 14, 16, 16),
      Block.makeCuboidShape(11, 15, 0, 12, 16, 16),
      Block.makeCuboidShape(9, 15, 0, 10, 16, 16),
      Block.makeCuboidShape(7, 15, 0, 8, 16, 16),
      Block.makeCuboidShape(5, 15, 0, 6, 16, 16),
      Block.makeCuboidShape(3, 15, 0, 4, 16, 16),
      Block.makeCuboidShape(0, 15, 0, 2, 16, 16),
      Block.makeCuboidShape(0, 16, 0, 1, 17, 16),
      Block.makeCuboidShape(0, 14, 1, 16, 15, 2),
      Block.makeCuboidShape(0, 14, 14, 16, 15, 15),
      Block.makeCuboidShape(15, 14, 2, 16, 15, 14),
      Block.makeCuboidShape(14, 7, 2, 15, 8, 14),
      Block.makeCuboidShape(1, 7, 2, 2, 8, 14),
      Block.makeCuboidShape(2, 7, 1, 14, 8, 2),
      Block.makeCuboidShape(2, 7, 14, 14, 8, 15),
      Block.makeCuboidShape(0, 14, 2, 1, 15, 14)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.makeCuboidShape(14, 0, 14, 15, 14, 15),
      Block.makeCuboidShape(1, 0, 14, 2, 14, 15),
      Block.makeCuboidShape(1, 0, 1, 2, 14, 2),
      Block.makeCuboidShape(14, 0, 1, 15, 14, 2),
      Block.makeCuboidShape(0, 15, 15, 16, 16, 16),
      Block.makeCuboidShape(0, 15, 13, 16, 16, 14),
      Block.makeCuboidShape(0, 15, 11, 16, 16, 12),
      Block.makeCuboidShape(0, 15, 9, 16, 16, 10),
      Block.makeCuboidShape(0, 15, 7, 16, 16, 8),
      Block.makeCuboidShape(0, 15, 5, 16, 16, 6),
      Block.makeCuboidShape(0, 15, 3, 16, 16, 4),
      Block.makeCuboidShape(0, 15, 0, 16, 16, 2),
      Block.makeCuboidShape(0, 16, 0, 16, 17, 1),
      Block.makeCuboidShape(14, 14, 0, 15, 15, 16),
      Block.makeCuboidShape(1, 14, 0, 2, 15, 16),
      Block.makeCuboidShape(2, 14, 15, 14, 15, 16),
      Block.makeCuboidShape(2, 7, 14, 14, 8, 15),
      Block.makeCuboidShape(2, 7, 1, 14, 8, 2),
      Block.makeCuboidShape(14, 7, 2, 15, 8, 14),
      Block.makeCuboidShape(1, 7, 2, 2, 8, 14),
      Block.makeCuboidShape(2, 14, 0, 14, 15, 1)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.makeCuboidShape(1, 0, 14, 2, 14, 15),
      Block.makeCuboidShape(1, 0, 1, 2, 14, 2),
      Block.makeCuboidShape(14, 0, 1, 15, 14, 2),
      Block.makeCuboidShape(14, 0, 14, 15, 14, 15),
      Block.makeCuboidShape(0, 15, 0, 1, 16, 16),
      Block.makeCuboidShape(2, 15, 0, 3, 16, 16),
      Block.makeCuboidShape(4, 15, 0, 5, 16, 16),
      Block.makeCuboidShape(6, 15, 0, 7, 16, 16),
      Block.makeCuboidShape(8, 15, 0, 9, 16, 16),
      Block.makeCuboidShape(10, 15, 0, 11, 16, 16),
      Block.makeCuboidShape(12, 15, 0, 13, 16, 16),
      Block.makeCuboidShape(14, 15, 0, 16, 16, 16),
      Block.makeCuboidShape(15, 16, 0, 16, 17, 16),
      Block.makeCuboidShape(0, 14, 14, 16, 15, 15),
      Block.makeCuboidShape(0, 14, 1, 16, 15, 2),
      Block.makeCuboidShape(0, 14, 2, 1, 15, 14),
      Block.makeCuboidShape(1, 7, 2, 2, 8, 14),
      Block.makeCuboidShape(14, 7, 2, 15, 8, 14),
      Block.makeCuboidShape(2, 7, 14, 14, 8, 15),
      Block.makeCuboidShape(2, 7, 1, 14, 8, 2),
      Block.makeCuboidShape(15, 14, 2, 16, 15, 14)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  public DryingRack(Properties properties) {
    super(properties);
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    switch (state.get(FACING)) {
      case NORTH:
        return SHAPE_N;
      case EAST:
        return SHAPE_E;
      case SOUTH:
        return SHAPE_S;
      case WEST:
        return SHAPE_W;
      default:
        return SHAPE_N;
    }
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
