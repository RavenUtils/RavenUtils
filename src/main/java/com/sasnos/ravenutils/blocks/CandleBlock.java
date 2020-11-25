package com.sasnos.ravenutils.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class CandleBlock extends TorchBlock {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.makeCuboidShape(5, 0, 6, 10, 1, 11),
      Block.makeCuboidShape(4, 1, 5, 11, 2, 6),
      Block.makeCuboidShape(4, 1, 11, 11, 2, 12),
      Block.makeCuboidShape(10, 1, 6, 11, 2, 11),
      Block.makeCuboidShape(4, 1, 6, 5, 2, 11),
      Block.makeCuboidShape(6, 1, 7, 9, 6, 10),
      Block.makeCuboidShape(7, 6, 8, 8, 7, 9)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.makeCuboidShape(5, 0, 5, 10, 1, 10),
      Block.makeCuboidShape(10, 1, 4, 11, 2, 11),
      Block.makeCuboidShape(4, 1, 4, 5, 2, 11),
      Block.makeCuboidShape(5, 1, 10, 10, 2, 11),
      Block.makeCuboidShape(5, 1, 4, 10, 2, 5),
      Block.makeCuboidShape(6, 1, 6, 9, 6, 9),
      Block.makeCuboidShape(7, 6, 7, 8, 7, 8)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.makeCuboidShape(6, 0, 5, 11, 1, 10),
      Block.makeCuboidShape(5, 1, 10, 12, 2, 11),
      Block.makeCuboidShape(5, 1, 4, 12, 2, 5),
      Block.makeCuboidShape(5, 1, 5, 6, 2, 10),
      Block.makeCuboidShape(11, 1, 5, 12, 2, 10),
      Block.makeCuboidShape(7, 1, 6, 10, 6, 9),
      Block.makeCuboidShape(8, 6, 7, 9, 7, 8)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.makeCuboidShape(6, 0, 6, 11, 1, 11),
      Block.makeCuboidShape(5, 1, 5, 6, 2, 12),
      Block.makeCuboidShape(11, 1, 5, 12, 2, 12),
      Block.makeCuboidShape(6, 1, 5, 11, 2, 6),
      Block.makeCuboidShape(6, 1, 11, 11, 2, 12),
      Block.makeCuboidShape(7, 1, 7, 10, 6, 10),
      Block.makeCuboidShape(8, 6, 8, 9, 7, 9)
  ).reduce((v1, v2) -> {
    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
  }).get();

  public CandleBlock() {
    super(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(0)
            .doesNotBlockMovement()
            .zeroHardnessAndResistance()
            .setLightLevel((state) -> {
              return 10;
            })
            .sound(SoundType.WOOD),
        ParticleTypes.FLAME);
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

  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    double d0 = (double) pos.getX() + 0.5D;
    double d1 = (double) pos.getY() + 0.57D;
    double d2 = (double) pos.getZ() + 0.5D;
    worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    worldIn.addParticle(this.particleData, d0, d1, d2, 0.0D, 0.0D, 0.0D);
  }
}
