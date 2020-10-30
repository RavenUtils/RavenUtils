package com.sasnos.ravenutils.util.enums;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public enum ModOreFeatures {

  RAVENINE(ModBlocks.RAVENINE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a, 3,18,0,15),
  RAVEN_EYE(ModBlocks.RAVEN_EYE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a,3,8,0,15),
  FOSSIL_ORE(ModBlocks.FOSSIL_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a,6,32,16,30),
  SALT_ORE(ModBlocks.SALT_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a,12,50,24,30),
  BLACK_COAL_ORE(ModBlocks.BLACK_COAL_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.field_241882_a,10,30,20,30);

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