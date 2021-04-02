package com.sasnos.ravenutils.blocks.trees;

import com.google.common.collect.ImmutableList;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;

import java.util.OptionalInt;
import java.util.Random;

public class CrimwoodTree extends Tree {

  @Override
  protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
    return Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(
        new SimpleBlockStateProvider(ModBlocks.CRIMWOOD_LOG.get().getDefaultState()),
        new SimpleBlockStateProvider(ModBlocks.CRIMWOOD_LEAVES.get().getDefaultState()),
        new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(3), 4),
        new FancyTrunkPlacer(3, 14, 1),
        new TwoLayerFeature(1, 0, 0, OptionalInt.of(4)))
        .setDecorators(ImmutableList.of(
            TrunkVineTreeDecorator.INSTANCE,
            LeaveVineTreeDecorator.field_236871_b_
        ))
        .setHeightmap(Heightmap.Type.MOTION_BLOCKING).build());
  }
}