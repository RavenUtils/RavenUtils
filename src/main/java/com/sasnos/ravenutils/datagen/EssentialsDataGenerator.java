package com.sasnos.ravenutils.datagen;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.datagen.globalLootModifer.EssentialsLootModifier;
import com.sasnos.ravenutils.datagen.recipies.EssentialsRecipe;
import com.sasnos.ravenutils.datagen.tags.EssentialItemTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EssentialsDataGenerator {

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    if (event.includeClient()) {

    }
    if (event.includeServer()) {
      BlockTagsProvider btg = new BlockTagsProvider(generator, RavenUtils.MOD_ID, event.getExistingFileHelper());
      ItemTagsProvider itg = new EssentialItemTags(generator, btg, event.getExistingFileHelper());
      generator.addProvider(new EssentialsLootModifier(generator));
      generator.addProvider(itg);
      generator.addProvider(new EssentialsRecipe(generator));
    }
  }
}
