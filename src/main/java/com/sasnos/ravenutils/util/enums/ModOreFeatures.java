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

  RAVENINE(ModBlocks.RAVENINE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 2,18,5,5),
  RAVEN_EYE(ModBlocks.RAVEN_EYE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,2,8,0,5),
  FOSSIL_ORE(ModBlocks.FOSSIL_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,4,32,16,10),
  SALT_ORE(ModBlocks.SALT_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,10,50,24,15),
  BLACK_COAL_ORE(ModBlocks.BLACK_COAL_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,12,30,20,15),
  LIMESTONE(ModBlocks.LIMESTONE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,16,32,24,20);

  private final ConfiguredFeature<?, ?> ORE;

  ModOreFeatures(BlockState defaultState, RuleTest filler, int veinSize, int maxHeight, int minHeight, int veinsPerChunk) {
    ORE = Feature.ORE.withConfiguration(
        new OreFeatureConfig(
            filler,
            defaultState,
            veinSize))
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square().func_242731_b(veinsPerChunk);
  }

  public ConfiguredFeature<?, ?> GetOre() {
    return ORE;
  }

}