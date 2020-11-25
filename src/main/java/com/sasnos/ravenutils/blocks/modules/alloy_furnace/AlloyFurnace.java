package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.api.blocks.EssentialsMachineBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
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

public class AlloyFurnace extends EssentialsMachineBlock {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
      Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
      Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
      Block.makeCuboidShape(14, 3, 1, 15, 16, 15),
      Block.makeCuboidShape(1, 3, 1, 2, 16, 15),
      Block.makeCuboidShape(2, 8, 1, 14, 16, 2),
      Block.makeCuboidShape(2, 3, 14, 14, 16, 15),
      Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
      Block.makeCuboidShape(0, 3, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
      Block.makeCuboidShape(15, 3, 15, 16, 16, 16),
      Block.makeCuboidShape(1, 0, 0, 15, 15, 1),
      Block.makeCuboidShape(2, 13, 2, 14, 16, 14),
      Block.makeCuboidShape(0, 0, 1, 16, 3, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
      Block.makeCuboidShape(2, 15, 1, 1, 16, 15),
      Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
      Block.makeCuboidShape(1, 3, 14, 15, 16, 15),
      Block.makeCuboidShape(1, 3, 1, 15, 16, 2),
      Block.makeCuboidShape(14, 8, 2, 15, 16, 14),
      Block.makeCuboidShape(1, 3, 2, 2, 16, 14),
      Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
      Block.makeCuboidShape(2, 3, 0, 1, 16, 1),
      Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
      Block.makeCuboidShape(2, 3, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 0, 1, 16, 15, 15),
      Block.makeCuboidShape(2, 13, 2, 14, 16, 14),
      Block.makeCuboidShape(2, 0, 0, 15, 3, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
      Block.makeCuboidShape(1, 15, 2, 15, 16, 1),
      Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
      Block.makeCuboidShape(1, 3, 1, 2, 16, 15),
      Block.makeCuboidShape(14, 3, 1, 15, 16, 15),
      Block.makeCuboidShape(2, 8, 14, 14, 16, 15),
      Block.makeCuboidShape(2, 3, 1, 14, 16, 2),
      Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 0, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 3, 2, 16, 16, 1),
      Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
      Block.makeCuboidShape(0, 3, 2, 1, 16, 1),
      Block.makeCuboidShape(1, 0, 15, 15, 15, 16),
      Block.makeCuboidShape(2, 13, 2, 14, 16, 14),
      Block.makeCuboidShape(0, 0, 2, 16, 3, 15)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
      Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
      Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
      Block.makeCuboidShape(1, 3, 1, 15, 16, 2),
      Block.makeCuboidShape(1, 3, 14, 15, 16, 15),
      Block.makeCuboidShape(1, 8, 2, 2, 16, 14),
      Block.makeCuboidShape(14, 3, 2, 15, 16, 14),
      Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
      Block.makeCuboidShape(0, 0, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 3, 15, 16, 16, 16),
      Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
      Block.makeCuboidShape(15, 3, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 0, 1, 1, 15, 15),
      Block.makeCuboidShape(2, 13, 2, 14, 16, 14),
      Block.makeCuboidShape(1, 0, 0, 16, 3, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  public AlloyFurnace() {
    super(AbstractBlock.Properties.from(Blocks.FURNACE));
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new AlloyFurnaceTileEntity();
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
