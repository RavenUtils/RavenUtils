package com.sasnos.ravenutils.world.gen;

import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.world.FacingBlockStateProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
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

  private static final HashMap<ResourceLocation, ConfiguredFeature<?, ?>> ores = new HashMap<>();

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
        8, 63, 12, 10,
        resourceLocation("copper_ore_config"));
    TIN = registerOre(
        ModBlocks.TIN_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        6, 63, 12, 8,
        resourceLocation("tin_ore_config"));
    ZINC = registerOre(
        ModBlocks.ZINC_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        6, 63, 12, 8,
        resourceLocation("zinc_ore_config"));
    SILVER = registerOre(
        ModBlocks.SILVER_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        6, 24, 8, 4,
        resourceLocation("silver_ore_config"));
    LEAD = registerOre(
        ModBlocks.LEAD_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        6, 24, 8, 4,
        resourceLocation("lead_ore_config"));
    MYTHERINE = registerOre(
        ModBlocks.MYTHERINE_ORE.get().getDefaultState(),
        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
        2, 18, 5, 3,
        resourceLocation("mytherine_ore_config"));
    ores.forEach(
        (resourceLocation, configuredFeature) ->
            Registry.register(registry, resourceLocation, configuredFeature));

    HashSet<Block> whiteList = new HashSet<>(Arrays.asList(
        Blocks.GRASS_BLOCK, Blocks.COARSE_DIRT,
        Blocks.MOSSY_COBBLESTONE, Blocks.COBBLESTONE,
        Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE
    ));
    HashSet<BlockState> blacklist = new HashSet<>();
    blacklist.add(Blocks.AIR.getDefaultState());
    STICK_GROUND = Feature.RANDOM_PATCH.withConfiguration(
        new BlockClusterFeatureConfig.Builder(
            new FacingBlockStateProvider(ModBlocks.STICK_GROUND.get()), SimpleBlockPlacer.PLACER)
            .whitelist(whiteList)
            .replaceable().tries(2)
            .build()
    ).withPlacement(Features.Placements.PATCH_PLACEMENT);
    STONE_GROUND = Feature.RANDOM_PATCH.withConfiguration(
        new BlockClusterFeatureConfig.Builder(
            new FacingBlockStateProvider(ModBlocks.STONE_GROUND.get()), SimpleBlockPlacer.PLACER)
            .whitelist(whiteList)
            .replaceable().tries(2)
            .build()
    ).withPlacement(Features.Placements.PATCH_PLACEMENT);
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
      }
        if (event.getCategory() != Biome.Category.DESERT &&
            event.getCategory() != Biome.Category.ICY &&
            event.getCategory() != Biome.Category.MUSHROOM &&
            event.getCategory() != Biome.Category.OCEAN
        ) {
//          event.getGeneration()
//              .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STICK_GROUND)
//              .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STONE_GROUND);
          // todo add spawning of Fossil Dirt (Grass and Dirt blocks only)
        }
      }
    }
  }
