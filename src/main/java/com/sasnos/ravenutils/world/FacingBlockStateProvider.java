package com.sasnos.ravenutils.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;

import java.util.Random;

public class FacingBlockStateProvider extends BlockStateProvider {

  private final Block block;

  public FacingBlockStateProvider(Block block) {
    this.block = block;
  }

  @Override
  protected BlockStateProviderType<?> getProviderType() {
    return null;
  }

  @Override
  public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
    Direction direction = Direction.getRandomDirection(randomIn);
    while (direction == Direction.UP || direction == Direction.DOWN){
      direction = Direction.getRandomDirection(randomIn);
    }
    return block.getDefaultState().with(BlockStateProperties.FACING, direction);
  }
}
