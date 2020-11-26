package com.sasnos.ravenutils.blocks.trees;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.Random;

public class CrimwoodTree extends Tree {

  @Override
  protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
    return Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(
        new SimpleBlockStateProvider(ModBlocks.CRIMWOOD_LOG.get().getDefaultState()),
        new SimpleBlockStateProvider(ModBlocks.CRIMWOOD_LEAVES.get().getDefaultState()),
        new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
        new StraightTrunkPlacer(4, 2, 0),
        new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build());
  }
}