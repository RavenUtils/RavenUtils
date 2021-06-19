package com.sasnos.ravenutils.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class FishTrap extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.FACING;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.box(8, 0, 1, 9, 1, 15),
      Block.box(10, 1, 1, 11, 2, 15),
      Block.box(11, 3, 1, 12, 4, 15),
      Block.box(11, 5, 1, 12, 6, 15),
      Block.box(10, 7, 1, 11, 8, 15),
      Block.box(8, 8, 1, 9, 9, 15),
      Block.box(6, 8, 1, 7, 9, 15),
      Block.box(4, 7, 1, 5, 8, 15),
      Block.box(3, 5, 1, 4, 6, 15),
      Block.box(3, 3, 1, 4, 4, 15),
      Block.box(4, 1, 1, 5, 2, 15),
      Block.box(6, 0, 1, 7, 1, 15),
      Block.box(8, 6, 14, 9, 8, 15),
      Block.box(10, 6, 14, 11, 7, 15),
      Block.box(4, 6, 14, 5, 7, 15),
      Block.box(4, 5, 14, 11, 6, 15),
      Block.box(5, 7, 14, 6, 8, 15),
      Block.box(7, 7, 14, 8, 8, 15),
      Block.box(9, 7, 14, 10, 8, 15),
      Block.box(10, 4, 14, 11, 5, 15),
      Block.box(6, 4, 14, 7, 5, 15),
      Block.box(6, 2, 14, 7, 3, 15),
      Block.box(4, 2, 14, 5, 3, 15),
      Block.box(8, 2, 14, 9, 3, 15),
      Block.box(10, 2, 14, 11, 3, 15),
      Block.box(8, 4, 14, 9, 5, 15),
      Block.box(4, 4, 14, 5, 5, 15),
      Block.box(5, 1, 14, 10, 2, 15),
      Block.box(4, 3, 14, 11, 4, 15),
      Block.box(6, 6, 14, 7, 8, 15),
      Block.box(8, 1, 2, 9, 2, 3),
      Block.box(6, 1, 2, 7, 2, 3),
      Block.box(4, 3, 2, 5, 4, 3),
      Block.box(4, 5, 2, 5, 6, 3),
      Block.box(6, 7, 2, 7, 8, 3),
      Block.box(8, 7, 2, 9, 8, 3),
      Block.box(10, 5, 2, 11, 6, 3),
      Block.box(10, 3, 2, 11, 4, 3),
      Block.box(9, 3, 3, 10, 4, 4),
      Block.box(9, 5, 3, 10, 6, 4),
      Block.box(8, 6, 3, 9, 7, 4),
      Block.box(6, 6, 3, 7, 7, 4),
      Block.box(5, 5, 3, 6, 6, 4),
      Block.box(5, 3, 3, 6, 4, 4),
      Block.box(6, 2, 3, 7, 3, 4),
      Block.box(8, 2, 3, 9, 3, 4),
      Block.box(8, 3, 4, 9, 4, 5),
      Block.box(8, 5, 4, 9, 6, 5),
      Block.box(6, 5, 4, 7, 6, 5),
      Block.box(6, 3, 4, 7, 4, 5)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.box(1, 0, 8, 15, 1, 9),
      Block.box(1, 1, 10, 15, 2, 11),
      Block.box(1, 3, 11, 15, 4, 12),
      Block.box(1, 5, 11, 15, 6, 12),
      Block.box(1, 7, 10, 15, 8, 11),
      Block.box(1, 8, 8, 15, 9, 9),
      Block.box(1, 8, 6, 15, 9, 7),
      Block.box(1, 7, 4, 15, 8, 5),
      Block.box(1, 5, 3, 15, 6, 4),
      Block.box(1, 3, 3, 15, 4, 4),
      Block.box(1, 1, 4, 15, 2, 5),
      Block.box(1, 0, 6, 15, 1, 7),
      Block.box(1, 6, 8, 2, 8, 9),
      Block.box(1, 6, 10, 2, 7, 11),
      Block.box(1, 6, 4, 2, 7, 5),
      Block.box(1, 5, 4, 2, 6, 11),
      Block.box(1, 7, 5, 2, 8, 6),
      Block.box(1, 7, 7, 2, 8, 8),
      Block.box(1, 7, 9, 2, 8, 10),
      Block.box(1, 4, 10, 2, 5, 11),
      Block.box(1, 4, 6, 2, 5, 7),
      Block.box(1, 2, 6, 2, 3, 7),
      Block.box(1, 2, 4, 2, 3, 5),
      Block.box(1, 2, 8, 2, 3, 9),
      Block.box(1, 2, 10, 2, 3, 11),
      Block.box(1, 4, 8, 2, 5, 9),
      Block.box(1, 4, 4, 2, 5, 5),
      Block.box(1, 1, 5, 2, 2, 10),
      Block.box(1, 3, 4, 2, 4, 11),
      Block.box(1, 6, 6, 2, 8, 7),
      Block.box(13, 1, 8, 14, 2, 9),
      Block.box(13, 1, 6, 14, 2, 7),
      Block.box(13, 3, 4, 14, 4, 5),
      Block.box(13, 5, 4, 14, 6, 5),
      Block.box(13, 7, 6, 14, 8, 7),
      Block.box(13, 7, 8, 14, 8, 9),
      Block.box(13, 5, 10, 14, 6, 11),
      Block.box(13, 3, 10, 14, 4, 11),
      Block.box(12, 3, 9, 13, 4, 10),
      Block.box(12, 5, 9, 13, 6, 10),
      Block.box(12, 6, 8, 13, 7, 9),
      Block.box(12, 6, 6, 13, 7, 7),
      Block.box(12, 5, 5, 13, 6, 6),
      Block.box(12, 3, 5, 13, 4, 6),
      Block.box(12, 2, 6, 13, 3, 7),
      Block.box(12, 2, 8, 13, 3, 9),
      Block.box(11, 3, 8, 12, 4, 9),
      Block.box(11, 5, 8, 12, 6, 9),
      Block.box(11, 5, 6, 12, 6, 7),
      Block.box(11, 3, 6, 12, 4, 7)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.box(7, 0, 1, 8, 1, 15),
      Block.box(5, 1, 1, 6, 2, 15),
      Block.box(4, 3, 1, 5, 4, 15),
      Block.box(4, 5, 1, 5, 6, 15),
      Block.box(5, 7, 1, 6, 8, 15),
      Block.box(7, 8, 1, 8, 9, 15),
      Block.box(9, 8, 1, 10, 9, 15),
      Block.box(11, 7, 1, 12, 8, 15),
      Block.box(12, 5, 1, 13, 6, 15),
      Block.box(12, 3, 1, 13, 4, 15),
      Block.box(11, 1, 1, 12, 2, 15),
      Block.box(9, 0, 1, 10, 1, 15),
      Block.box(7, 6, 1, 8, 8, 2),
      Block.box(5, 6, 1, 6, 7, 2),
      Block.box(11, 6, 1, 12, 7, 2),
      Block.box(5, 5, 1, 12, 6, 2),
      Block.box(10, 7, 1, 11, 8, 2),
      Block.box(8, 7, 1, 9, 8, 2),
      Block.box(6, 7, 1, 7, 8, 2),
      Block.box(5, 4, 1, 6, 5, 2),
      Block.box(9, 4, 1, 10, 5, 2),
      Block.box(9, 2, 1, 10, 3, 2),
      Block.box(11, 2, 1, 12, 3, 2),
      Block.box(7, 2, 1, 8, 3, 2),
      Block.box(5, 2, 1, 6, 3, 2),
      Block.box(7, 4, 1, 8, 5, 2),
      Block.box(11, 4, 1, 12, 5, 2),
      Block.box(6, 1, 1, 11, 2, 2),
      Block.box(5, 3, 1, 12, 4, 2),
      Block.box(9, 6, 1, 10, 8, 2),
      Block.box(7, 1, 13, 8, 2, 14),
      Block.box(9, 1, 13, 10, 2, 14),
      Block.box(11, 3, 13, 12, 4, 14),
      Block.box(11, 5, 13, 12, 6, 14),
      Block.box(9, 7, 13, 10, 8, 14),
      Block.box(7, 7, 13, 8, 8, 14),
      Block.box(5, 5, 13, 6, 6, 14),
      Block.box(5, 3, 13, 6, 4, 14),
      Block.box(6, 3, 12, 7, 4, 13),
      Block.box(6, 5, 12, 7, 6, 13),
      Block.box(7, 6, 12, 8, 7, 13),
      Block.box(9, 6, 12, 10, 7, 13),
      Block.box(10, 5, 12, 11, 6, 13),
      Block.box(10, 3, 12, 11, 4, 13),
      Block.box(9, 2, 12, 10, 3, 13),
      Block.box(7, 2, 12, 8, 3, 13),
      Block.box(7, 3, 11, 8, 4, 12),
      Block.box(7, 5, 11, 8, 6, 12),
      Block.box(9, 5, 11, 10, 6, 12),
      Block.box(9, 3, 11, 10, 4, 12)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.box(1, 0, 7, 15, 1, 8),
      Block.box(1, 1, 5, 15, 2, 6),
      Block.box(1, 3, 4, 15, 4, 5),
      Block.box(1, 5, 4, 15, 6, 5),
      Block.box(1, 7, 5, 15, 8, 6),
      Block.box(1, 8, 7, 15, 9, 8),
      Block.box(1, 8, 9, 15, 9, 10),
      Block.box(1, 7, 11, 15, 8, 12),
      Block.box(1, 5, 12, 15, 6, 13),
      Block.box(1, 3, 12, 15, 4, 13),
      Block.box(1, 1, 11, 15, 2, 12),
      Block.box(1, 0, 9, 15, 1, 10),
      Block.box(14, 6, 7, 15, 8, 8),
      Block.box(14, 6, 5, 15, 7, 6),
      Block.box(14, 6, 11, 15, 7, 12),
      Block.box(14, 5, 5, 15, 6, 12),
      Block.box(14, 7, 10, 15, 8, 11),
      Block.box(14, 7, 8, 15, 8, 9),
      Block.box(14, 7, 6, 15, 8, 7),
      Block.box(14, 4, 5, 15, 5, 6),
      Block.box(14, 4, 9, 15, 5, 10),
      Block.box(14, 2, 9, 15, 3, 10),
      Block.box(14, 2, 11, 15, 3, 12),
      Block.box(14, 2, 7, 15, 3, 8),
      Block.box(14, 2, 5, 15, 3, 6),
      Block.box(14, 4, 7, 15, 5, 8),
      Block.box(14, 4, 11, 15, 5, 12),
      Block.box(14, 1, 6, 15, 2, 11),
      Block.box(14, 3, 5, 15, 4, 12),
      Block.box(14, 6, 9, 15, 8, 10),
      Block.box(2, 1, 7, 3, 2, 8),
      Block.box(2, 1, 9, 3, 2, 10),
      Block.box(2, 3, 11, 3, 4, 12),
      Block.box(2, 5, 11, 3, 6, 12),
      Block.box(2, 7, 9, 3, 8, 10),
      Block.box(2, 7, 7, 3, 8, 8),
      Block.box(2, 5, 5, 3, 6, 6),
      Block.box(2, 3, 5, 3, 4, 6),
      Block.box(3, 3, 6, 4, 4, 7),
      Block.box(3, 5, 6, 4, 6, 7),
      Block.box(3, 6, 7, 4, 7, 8),
      Block.box(3, 6, 9, 4, 7, 10),
      Block.box(3, 5, 10, 4, 6, 11),
      Block.box(3, 3, 10, 4, 4, 11),
      Block.box(3, 2, 9, 4, 3, 10),
      Block.box(3, 2, 7, 4, 3, 8),
      Block.box(4, 3, 7, 5, 4, 8),
      Block.box(4, 5, 7, 5, 6, 8),
      Block.box(4, 5, 9, 5, 6, 10),
      Block.box(4, 3, 9, 5, 4, 10)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  public FishTrap() {
    super(AbstractBlock.Properties.of(Material.DECORATION, MaterialColor.WATER)
        .strength(3.5F)
        .sound(SoundType.WOOD)
        .harvestTool(ToolType.AXE)
        .noCollission()
        .noOcclusion()
    );
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    switch (state.getValue(FACING)) {
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
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
  }

  @Override
  protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
