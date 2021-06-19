package com.sasnos.ravenutils.world.gen;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.sasnos.ravenutils.world.gen.FeatureRegister.STICK_GROUND;
import static com.sasnos.ravenutils.world.gen.FeatureRegister.STONE_GROUND;
import static net.minecraft.world.biome.Biome.Category.NETHER;
import static net.minecraft.world.biome.Biome.Category.THEEND;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FeatureGen {

  @SubscribeEvent
  public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
    if (event.getCategory().equals(NETHER)) {
      // do nothing
    } else if (event.getCategory().equals(THEEND)) {
      // do nothing
    } else {
      for (ConfiguredFeature<?, ?> modOreFeature : FeatureRegister.ores.values()) {
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, modOreFeature);
      }
      if (event.getCategory() != Biome.Category.DESERT &&
              event.getCategory() != Biome.Category.ICY &&
              event.getCategory() != Biome.Category.MUSHROOM &&
              event.getCategory() != Biome.Category.OCEAN
      ) {
        event.getGeneration()
                .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STICK_GROUND)
                .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, STONE_GROUND);
        // todo add spawning of Fossil Dirt (Grass and Dirt blocks only)
      }
    }
  }
}
