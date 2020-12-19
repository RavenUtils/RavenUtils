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

    private Block block;

    public FacingBlockStateProvider(Block block){
        this.block = block;
    }

    @Override
    protected BlockStateProviderType<?> getProviderType() {
        return null;
    }

    @Override
    public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
        return block.getDefaultState().with(BlockStateProperties.FACING, Direction.getRandomDirection(randomIn));
    }
}
