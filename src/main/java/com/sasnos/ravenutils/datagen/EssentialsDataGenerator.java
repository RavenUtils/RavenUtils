package com.sasnos.ravenutils.datagen;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.datagen.block_states.BlockStates;
import com.sasnos.ravenutils.datagen.global_loot_modifer.EssentialsLootModifier;
import com.sasnos.ravenutils.datagen.items.ItemModels;
import com.sasnos.ravenutils.datagen.lang.enUs;
import com.sasnos.ravenutils.datagen.loot_tables.EssentialsLootTableProvider;
import com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.datagen.tags.EssentialsBlockTags;
import com.sasnos.ravenutils.datagen.tags.EssentialsFluidTags;
import com.sasnos.ravenutils.datagen.tags.EssentialsItemTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
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
      generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
      generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
      generator.addProvider(new enUs(generator));
    }
    if (event.includeServer()) {
      BlockTagsProvider btg = new EssentialsBlockTags(generator, RavenUtils.MOD_ID, event.getExistingFileHelper());
      ItemTagsProvider itg = new EssentialsItemTags(generator, btg, event.getExistingFileHelper());
      FluidTagsProvider ftg = new EssentialsFluidTags(generator, event.getExistingFileHelper());
      generator.addProvider(new EssentialsLootModifier(generator));
      generator.addProvider(itg);
      generator.addProvider(btg);
      generator.addProvider(ftg);
      generator.addProvider(new EssentialsRecipe(generator));
      generator.addProvider(new EssentialsLootTableProvider(generator));
    }
  }
}
