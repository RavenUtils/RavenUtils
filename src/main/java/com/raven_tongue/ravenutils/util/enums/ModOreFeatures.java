package com.raven_tongue.ravenutils.util.enums;

import com.raven_tongue.ravenutils.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public enum ModOreFeatures {

  RAVENINE(ModBlocks.RAVENINE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a, 2,18,0,10),
  RAVEN_EYE(ModBlocks.RAVEN_EYE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a,2,8,0,20);

  private final ConfiguredFeature<?, ?> ORE;

  ModOreFeatures(BlockState defaultState, RuleTest filler, int veinSize, int maxHeight, int minHeight, int veinsPerChunk) {
    ORE = Feature.ORE.withConfiguration(
        new OreFeatureConfig(
            filler,
            defaultState,
            veinSize))
        .withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).func_242728_a().func_242731_b(veinsPerChunk);
  }

  public ConfiguredFeature<?, ?> GetOre() {
    return ORE;
  }

}