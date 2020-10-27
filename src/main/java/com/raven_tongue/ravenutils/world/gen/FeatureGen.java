package com.raven_tongue.ravenutils.world.gen;

import com.raven_tongue.ravenutils.util.enums.ModOreFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import static net.minecraft.world.biome.Biome.Category.*;

public class FeatureGen {

  public static void AddFeaturesToBiomes(BiomeLoadingEvent event) {
    if (event.getCategory().equals(NETHER)) {
      // do nothing
    } else if (event.getCategory().equals(THEEND)) {
      // do nothing
    } else {
      for (ModOreFeatures modOreFeature : ModOreFeatures.values()) {
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, modOreFeature.GetOre());
      }
    }
  }
}
