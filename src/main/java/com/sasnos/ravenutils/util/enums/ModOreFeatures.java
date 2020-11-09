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

  MYTHERINE(ModBlocks.MYTHERINE_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 2,18,5,5),

  COPPER(ModBlocks.COPPER_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 6,42,12,15),
  TIN(ModBlocks.TIN_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 4,42,12,10),
  SILVER(ModBlocks.SILVER_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 4,24,8,5),
  SULFUR(ModBlocks.SULFUR_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 6,10,63,8),

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