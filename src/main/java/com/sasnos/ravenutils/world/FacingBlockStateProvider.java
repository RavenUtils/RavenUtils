package com.sasnos.ravenutils.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sasnos.ravenutils.init.UtilInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.Random;

public class FacingBlockStateProvider extends BlockStateProvider {

    public static final Codec<FacingBlockStateProvider> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(ResourceLocation.CODEC.xmap(
                ForgeRegistries.BLOCKS::getValue,
                ForgeRegistryEntry::getRegistryName).optionalFieldOf("block", Blocks.AIR).forGetter(o -> o.block))
                .apply(builder, FacingBlockStateProvider::new);
    });

    private Block block;

  public FacingBlockStateProvider(Block block) {
    this.block = block;
  }

  @Override
  protected BlockStateProviderType<?> getProviderType() {
    return UtilInit.FACING_PROVIDER.get();
  }

  @Override
  public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
    Direction direction = Direction.getRandomDirection(randomIn);
    while (direction == Direction.UP || direction == Direction.DOWN){
      direction = Direction.getRandomDirection(randomIn);
    }
    return block.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, direction);
  }
}
