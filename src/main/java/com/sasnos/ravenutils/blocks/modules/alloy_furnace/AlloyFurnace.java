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
      Block.makeCuboidShape(0, 0, 1, 16, 3, 16),
      Block.makeCuboidShape(2, 13, 2, 14, 16, 14),
      Block.makeCuboidShape(1, 0, 0, 15, 15, 1),
      Block.makeCuboidShape(15, 3, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
      Block.makeCuboidShape(0, 3, 15, 1, 16, 16),
      Block.makeCuboidShape(0, 0, 0, 1, 16, 1),
      Block.makeCuboidShape(15, 0, 0, 16, 16, 1),
      Block.makeCuboidShape(2, 3, 14, 14, 16, 15),
      Block.makeCuboidShape(2, 8, 1, 14, 16, 2),
      Block.makeCuboidShape(1, 3, 1, 2, 16, 15),
      Block.makeCuboidShape(14, 3, 1, 15, 16, 15),
      Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
      Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
      Block.makeCuboidShape(1, 15, 0, 15, 16, 1)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.makeCuboidShape(-0.4666666666666668, 0, -0.4666666666666668, 14.533333333333333, 3, 15.533333333333333),
      Block.makeCuboidShape(1.5333333333333332, 13, 1.5333333333333332, 13.533333333333333, 16, 13.533333333333333),
      Block.makeCuboidShape(14.533333333333333, 0, 0.5333333333333332, 15.533333333333333, 15, 14.533333333333333),
      Block.makeCuboidShape(-0.4666666666666668, 3, 14.533333333333333, 0.5333333333333332, 16, 15.533333333333333),
      Block.makeCuboidShape(0.5333333333333332, 15, 14.533333333333333, 14.533333333333333, 16, 15.533333333333333),
      Block.makeCuboidShape(-0.4666666666666668, 3, -0.4666666666666668, 0.5333333333333332, 16, 0.5333333333333332),
      Block.makeCuboidShape(14.533333333333333, 0, -0.4666666666666668, 15.533333333333333, 16, 0.5333333333333332),
      Block.makeCuboidShape(14.533333333333333, 0, 14.533333333333333, 15.533333333333333, 16, 15.533333333333333),
      Block.makeCuboidShape(0.5333333333333332, 3, 1.5333333333333332, 1.5333333333333332, 16, 13.533333333333333),
      Block.makeCuboidShape(13.533333333333333, 8, 1.5333333333333332, 14.533333333333333, 16, 13.533333333333333),
      Block.makeCuboidShape(0.5333333333333332, 3, 0.5333333333333332, 14.533333333333333, 16, 1.5333333333333332),
      Block.makeCuboidShape(0.5333333333333332, 3, 13.533333333333333, 14.533333333333333, 16, 14.533333333333333),
      Block.makeCuboidShape(0.5333333333333332, 15, -0.4666666666666668, 14.533333333333333, 16, 0.5333333333333332),
      Block.makeCuboidShape(-0.4666666666666668, 15, 0.5333333333333332, 0.5333333333333332, 16, 14.533333333333333),
      Block.makeCuboidShape(14.533333333333333, 15, 0.5333333333333332, 15.533333333333333, 16, 14.533333333333333)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.makeCuboidShape(0, 0, -0.9333333333333336, 16, 3, 14.066666666666666),
      Block.makeCuboidShape(2, 13, 1.0666666666666664, 14, 16, 13.066666666666666),
      Block.makeCuboidShape(1, 0, 14.066666666666666, 15, 15, 15.066666666666666),
      Block.makeCuboidShape(0, 3, -0.9333333333333336, 1, 16, 0.06666666666666643),
      Block.makeCuboidShape(0, 15, 0.06666666666666643, 1, 16, 14.066666666666666),
      Block.makeCuboidShape(15, 3, -0.9333333333333336, 16, 16, 0.06666666666666643),
      Block.makeCuboidShape(15, 0, 14.066666666666666, 16, 16, 15.066666666666666),
      Block.makeCuboidShape(0, 0, 14.066666666666666, 1, 16, 15.066666666666666),
      Block.makeCuboidShape(2, 3, 0.06666666666666643, 14, 16, 1.0666666666666664),
      Block.makeCuboidShape(2, 8, 13.066666666666666, 14, 16, 14.066666666666666),
      Block.makeCuboidShape(14, 3, 0.06666666666666643, 15, 16, 14.066666666666666),
      Block.makeCuboidShape(1, 3, 0.06666666666666643, 2, 16, 14.066666666666666),
      Block.makeCuboidShape(15, 15, 0.06666666666666643, 16, 16, 14.066666666666666),
      Block.makeCuboidShape(1, 15, -0.9333333333333336, 15, 16, 0.06666666666666643),
      Block.makeCuboidShape(1, 15, 14.066666666666666, 15, 16, 15.066666666666666)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.makeCuboidShape(1.4666666666666668, 0, -0.4666666666666668, 16.46666666666667, 3, 15.533333333333333),
      Block.makeCuboidShape(2.466666666666667, 13, 1.5333333333333332, 14.466666666666667, 16, 13.533333333333333),
      Block.makeCuboidShape(0.4666666666666668, 0, 0.5333333333333332, 1.4666666666666668, 15, 14.533333333333333),
      Block.makeCuboidShape(15.466666666666667, 3, -0.4666666666666668, 16.46666666666667, 16, 0.5333333333333332),
      Block.makeCuboidShape(1.4666666666666668, 15, -0.4666666666666668, 15.466666666666667, 16, 0.5333333333333332),
      Block.makeCuboidShape(15.466666666666667, 3, 14.533333333333333, 16.46666666666667, 16, 15.533333333333333),
      Block.makeCuboidShape(0.4666666666666668, 0, 14.533333333333333, 1.4666666666666668, 16, 15.533333333333333),
      Block.makeCuboidShape(0.4666666666666668, 0, -0.4666666666666668, 1.4666666666666668, 16, 0.5333333333333332),
      Block.makeCuboidShape(14.466666666666667, 3, 1.5333333333333332, 15.466666666666667, 16, 13.533333333333333),
      Block.makeCuboidShape(1.4666666666666668, 8, 1.5333333333333332, 2.466666666666667, 16, 13.533333333333333),
      Block.makeCuboidShape(1.4666666666666668, 3, 13.533333333333333, 15.466666666666667, 16, 14.533333333333333),
      Block.makeCuboidShape(1.4666666666666668, 3, 0.5333333333333332, 15.466666666666667, 16, 1.5333333333333332),
      Block.makeCuboidShape(1.4666666666666668, 15, 14.533333333333333, 15.466666666666667, 16, 15.533333333333333),
      Block.makeCuboidShape(15.466666666666667, 15, 0.5333333333333332, 16.46666666666667, 16, 14.533333333333333),
      Block.makeCuboidShape(0.4666666666666668, 15, 0.5333333333333332, 1.4666666666666668, 16, 14.533333333333333)
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
