package com.sasnos.ravenutils;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.init.ModEntities;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModLootTables;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.init.ModTileEntities;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.init.UtilInit;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import com.sasnos.ravenutils.world.gen.FeatureGen;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Supplier;

@Mod(RavenUtils.MOD_ID)
@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RavenUtils {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "ravenutils";

  public RavenUtils() {
    ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModArmorItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModFoodItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModToolItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModToolItems.VANILLA_ITEM_OVERRIDE.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModLootTables.LOOT_MODIFIER.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModTileEntities.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModContainer.CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModRecipes.RECIPE_SERIALIZER.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    UtilInit.BLOCKSTATEPROVIDER.register(FMLJavaModLoadingContext.get().getModEventBus());

    new EssentialsTags().init();

    ((FlowerPotBlock) Blocks.FLOWER_POT)
        .addPlant(EssentialsUtils.resourceLocation("crimleaf"), ModBlocks.POTTED_CRIMLEAF);
    ((FlowerPotBlock) Blocks.FLOWER_POT)
        .addPlant(EssentialsUtils.resourceLocation("crimwood_sapling"), ModBlocks.POTTED_CRIMWOOD_SAPLING);

    //modules aka machines and stuff
    new AlloyFurnaceInit();
    new HandMillInit();



    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }


  public static final ItemGroup TAB = new ItemGroup("ravenutils") {
    @Override
    public ItemStack createIcon() {
      // todo adjust later
      return new ItemStack(ModBlockItems.CRIMLEAF_ITEM.get());
    }
  };

}
