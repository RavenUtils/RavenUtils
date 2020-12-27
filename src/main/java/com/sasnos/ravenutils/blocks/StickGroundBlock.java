package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class StickGroundBlock extends StickAndStoneBlock {

  protected static final VoxelShape SHAPE_N = Block.makeCuboidShape(8, 0, 4, 9, 1, 12);
  protected static final VoxelShape SHAPE_E = Block.makeCuboidShape(4.5, 0, 7.5, 12.5, 1, 8.5);
  protected static final VoxelShape SHAPE_S = Block.makeCuboidShape(8, 0, 4, 9, 1, 12);
  protected static final VoxelShape SHAPE_W = Block.makeCuboidShape(4.5, 0, 7.5, 12.5, 1, 8.5);

  public StickGroundBlock(Properties properties) {
    super(properties, () -> Items.STICK);
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
