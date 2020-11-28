package com.sasnos.ravenutils.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

public class Barrel extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  public static BooleanProperty HAS_LID = BlockStateProperties.OPEN;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.makeCuboidShape(1, 1, 0, 15, 16, 1),
      Block.makeCuboidShape(1, 1, 15, 15, 16, 16),
      Block.makeCuboidShape(0, 1, 1, 1, 16, 15),
      Block.makeCuboidShape(15, 1, 1, 16, 16, 15),
      Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
      Block.makeCuboidShape(0, 1, 0, 1, 16, 1),
      Block.makeCuboidShape(0, 1, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 1, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 1, 0, 16, 16, 1)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.makeCuboidShape(15, 1, 1, 16, 16, 15),
      Block.makeCuboidShape(0, 1, 1, 1, 16, 15),
      Block.makeCuboidShape(1, 1, 0, 15, 16, 1),
      Block.makeCuboidShape(1, 1, 15, 15, 16, 16),
      Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
      Block.makeCuboidShape(15, 1, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 1, 0, 1, 16, 1),
      Block.makeCuboidShape(0, 1, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 1, 15, 16, 16, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.makeCuboidShape(1, 1, 15, 15, 16, 16),
      Block.makeCuboidShape(1, 1, 0, 15, 16, 1),
      Block.makeCuboidShape(15, 1, 1, 16, 16, 15),
      Block.makeCuboidShape(0, 1, 1, 1, 16, 15),
      Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
      Block.makeCuboidShape(15, 1, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 1, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 1, 0, 1, 16, 1),
      Block.makeCuboidShape(0, 1, 15, 1, 16, 16)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.makeCuboidShape(0, 1, 1, 1, 16, 15),
      Block.makeCuboidShape(15, 1, 1, 16, 16, 15),
      Block.makeCuboidShape(1, 1, 15, 15, 16, 16),
      Block.makeCuboidShape(1, 1, 0, 15, 16, 1),
      Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
      Block.makeCuboidShape(0, 1, 15, 1, 16, 16),
      Block.makeCuboidShape(15, 1, 15, 16, 16, 16),
      Block.makeCuboidShape(15, 1, 0, 16, 16, 1),
      Block.makeCuboidShape(0, 1, 0, 1, 16, 1)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  public Barrel() {
    super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
        .hardnessAndResistance(5.0F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
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
