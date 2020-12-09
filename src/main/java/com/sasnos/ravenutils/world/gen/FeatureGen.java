package com.sasnos.ravenutils.world.gen;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static com.sasnos.ravenutils.utils.EssentialsUtils.resourceLocation;
import static net.minecraft.world.biome.Biome.Category.NETHER;
import static net.minecraft.world.biome.Biome.Category.THEEND;

public class FeatureGen {

  private static HashMap<ResourceLocation, ConfiguredFeature<?, ?>> ores = new HashMap<>();

  public static ConfiguredFeature<?, ?> LIMESTONE;
  public static ConfiguredFeature<?, ?> BLACK_COAL_ORE;
  public static ConfiguredFeature<?, ?> SULFUR;
  public static ConfiguredFeature<?, ?> FOSSIL_ROCK;
  public static ConfiguredFeature<?, ?> SALT_ORE;
  public static ConfiguredFeature<?, ?> RAVEN_EYE;
  public static ConfiguredFeature<?, ?> COPPER;
  public static ConfiguredFeature<?, ?> TIN;
  public static ConfiguredFeature<?, ?> ZINC;
  public static ConfiguredFeature<?, ?> SILVER;
  public static ConfiguredFeature<?, ?> LEAD;
  public static ConfiguredFeature<?, ?> MYTHERINE;
  public static ConfiguredFeature<?, ?> STICK_GROUND;
  public static ConfiguredFeature<?, ?> STONE_GROUND;

  public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

    LIMESTONE = registerOre(
        ModBlocks.LIMESTONE_BLOCK.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        14, 32, 24, 12,
        resourceLocation("limestone"));
    BLACK_COAL_ORE = registerOre(
        ModBlocks.BLACK_COAL_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        12, 30, 20, 10,
        resourceLocation("black_coal_ore_config"));
    SULFUR = registerOre(
        ModBlocks.SULFUR_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        6, 10, 63, 6,
        resourceLocation("sulfur_ore_config"));
    FOSSIL_ROCK = registerOre(
        ModBlocks.FOSSIL_ROCK.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        4, 32, 16, 8,
        resourceLocation("fossil_rock_config"));
    SALT_ORE = registerOre(
        ModBlocks.SALT_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        12, 42, 24, 10,
        resourceLocation("salt_ore_congig"));
    RAVEN_EYE = registerOre(
        ModBlocks.RAVEN_EYE_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        2, 8, 0, 4,
        resourceLocation("raven_eye_config"));
    COPPER = registerOre(
        ModBlocks.COPPER_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        7, 63, 12, 10,
        resourceLocation("copper_ore_config"));
    TIN = registerOre(
        ModBlocks.TIN_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        5, 63, 12, 8,
        resourceLocation("tin_ore_config"));
    ZINC = registerOre(
        ModBlocks.ZINC_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        5, 63, 12, 8,
        resourceLocation("zinc_ore_config"));
    SILVER = registerOre(
        ModBlocks.SILVER_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        4, 24, 8, 4,
        resourceLocation("silver_ore_config"));
    LEAD = registerOre(
        ModBlocks.LEAD_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        4, 24, 8, 4,
        resourceLocation("lead_ore_config"));
    MYTHERINE = registerOre(
        ModBlocks.MYTHERINE_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        2, 18, 5, 3,
        resourceLocation("mytherine_ore_config"));
    ores.forEach(
        (resourceLocation, configuredFeature) ->
            Registry.register(registry, resourceLocation, configuredFeature));

    HashSet<Block> whiteList = new HashSet<>();
    whiteList.addAll(Arrays.asList(Blocks.GRASS_BLOCK, Blocks.STONE));
    HashSet<BlockState> blacklist = new HashSet<>();
    blacklist.add(Blocks.AIR.getDefaultState());
    STICK_GROUND = Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.STICK_GROUND.get().getDefaultState()), SimpleBlockPlacer.PLACER)
                    .whitelist(whiteList).blacklist(blacklist)
                    .replaceable().tries(2)
                    .build()
    ).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 10)));
    STONE_GROUND = Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.STONE_GROUND.get().getDefaultState()), new SimpleBlockPlacer())
                    .whitelist(whiteList).blacklist(blacklist)
                    .replaceable().tries(2)
                    .build()
    ).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 10)));
    Registry.register(registry, resourceLocation("stick_ground"), STICK_GROUND);
    Registry.register(registry, resourceLocation("stone_ground"), STONE_GROUND);
  }

  private static ConfiguredFeature<?, ?> registerOre(BlockState defaultState, RuleTest filler, int veinSize, int maxHeight, int minHeight, int veinsPerChunk, ResourceLocation rl) {

    ConfiguredFeature<?, ?> ORE = Feature.ORE.withConfiguration(
        new OreFeatureConfig(
            filler,
            defaultState,
            veinSize))
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square().func_242731_b(veinsPerChunk);
    ores.put(rl, ORE);

    return ORE;
  }


  public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
    if (event.getCategory().equals(NETHER)) {
      // do nothing
    } else if (event.getCategory().equals(THEEND)) {
      // do nothing
    } else {
      for (ConfiguredFeature<?, ?> modOreFeature : ores.values()) {
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, modOreFeature);
        if (event.getCategory().equals(Biome.Category.PLAINS)){
          event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STICK_GROUND)
          .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STONE_GROUND);
        }
      }
    }
  }
}
