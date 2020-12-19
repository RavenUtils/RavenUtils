package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class StoneGroundBlock extends StickAndStoneBlock {

  protected static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(
      Block.makeCuboidShape(6, 0, 7, 10, 2, 10),
      Block.makeCuboidShape(5, 0, 6, 7, 1, 7),
      IBooleanFunction.OR);

  protected static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(
      Block.makeCuboidShape(4.5, 0, 6.5, 7.5, 2, 10.5),
      Block.makeCuboidShape(7.5, 0, 5.5, 8.5, 1, 7.5),
      IBooleanFunction.OR);

  protected static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(
      Block.makeCuboidShape(4, 0, 5, 8, 2, 8),
      Block.makeCuboidShape(7, 0, 8, 9, 1, 9),
      IBooleanFunction.OR);

  protected static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(
      Block.makeCuboidShape(6.5, 0, 4.5, 9.5, 2, 8.5),
      Block.makeCuboidShape(5.5, 0, 7.5, 6.5, 1, 9.5),
      IBooleanFunction.OR);

  public StoneGroundBlock(Properties properties) {
    super(properties, ModItems.SMALL_STONE);
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

}
