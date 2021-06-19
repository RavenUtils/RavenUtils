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

  private static final DirectionProperty FACING = HorizontalBlock.FACING;

  protected static final VoxelShape SHAPE_N = Stream.of(
      Block.box(6, 0, 6, 10, 1, 10),
      Block.box(5, 1, 5, 11, 2, 6),
      Block.box(5, 1, 10, 11, 2, 11),
      Block.box(10, 1, 6, 11, 2, 10),
      Block.box(5, 1, 6, 6, 2, 10),
      Block.box(7, 1, 7, 9, 6, 9),
      Block.box(7.8, 6, 8, 8.200000000000001, 6.7, 8)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_E = Stream.of(
      Block.box(6, 0, 6, 10, 1, 10),
      Block.box(10, 1, 5, 11, 2, 11),
      Block.box(5, 1, 5, 6, 2, 11),
      Block.box(6, 1, 10, 10, 2, 11),
      Block.box(6, 1, 5, 10, 2, 6),
      Block.box(7, 1, 7, 9, 6, 9),
      Block.box(8, 6, 7.8, 8, 6.7, 8.200000000000001)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_S = Stream.of(
      Block.box(6, 0, 6, 10, 1, 10),
      Block.box(5, 1, 10, 11, 2, 11),
      Block.box(5, 1, 5, 11, 2, 6),
      Block.box(5, 1, 6, 6, 2, 10),
      Block.box(10, 1, 6, 11, 2, 10),
      Block.box(7, 1, 7, 9, 6, 9),
      Block.box(7.799999999999999, 6, 8, 8.2, 6.7, 8)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  protected static final VoxelShape SHAPE_W = Stream.of(
      Block.box(6, 0, 6, 10, 1, 10),
      Block.box(5, 1, 5, 6, 2, 11),
      Block.box(10, 1, 5, 11, 2, 11),
      Block.box(6, 1, 5, 10, 2, 6),
      Block.box(6, 1, 10, 10, 2, 11),
      Block.box(7, 1, 7, 9, 6, 9),
      Block.box(8, 6, 7.799999999999999, 8, 6.7, 8.2)
  ).reduce((v1, v2) -> {
    return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
  }).get();

  public CandleBlock() {
    super(AbstractBlock.Properties.of(Material.DECORATION)
            .noCollission()
            .instabreak()
            .lightLevel((state) -> {
              return 10;
            })
            .sound(SoundType.WOOD),
        ParticleTypes.FLAME);
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

  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    double d0 = (double) pos.getX() + 0.5D;
    double d1 = (double) pos.getY() + 0.57D;
    double d2 = (double) pos.getZ() + 0.5D;
    worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    worldIn.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
  }
}
