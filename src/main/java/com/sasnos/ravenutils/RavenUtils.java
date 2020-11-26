package com.sasnos.ravenutils;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.handmill.HandMillInit;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModLootTables;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.init.ModTileEntities;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import com.sasnos.ravenutils.world.gen.FeatureGen;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Supplier;

@Mod(RavenUtils.MOD_ID)
public class RavenUtils {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "ravenutils";

  public RavenUtils() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, EventPriority.LOW, FeatureGen::registerFeatures);
    MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureGen::addFeaturesToBiomes);

    ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModArmorItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModFoodItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModToolItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModToolItems.VANILLA_ITEM_OVERRIDE.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModLootTables.LOOT_MODIFIER.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModTileEntities.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModContainer.CONTAINERTYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModRecipes.RECIPE_SERIALIZER.register(FMLJavaModLoadingContext.get().getModEventBus());

    new EssentialsTags().init();

    ((FlowerPotBlock)Blocks.FLOWER_POT)
            .addPlant(EssentialsUtils.resourceLocation("crimleaf"), ModBlocks.POTTED_CRIMLEAF);
    ((FlowerPotBlock)Blocks.FLOWER_POT)
            .addPlant(EssentialsUtils.resourceLocation("crimwood_sapling"), ModBlocks.POTTED_CRIMWOOD_SAPLING);

    //modules aka machines and stuff
    new AlloyFurnaceInit();
    new HandMillInit();

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMLEAF.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMLEAF.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_SAPLING.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), RenderType.getCutout());

    // todo move bushes to Cuisine module
    RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRY_BUSH.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.ELDERBERRY_BUSH.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.RASPBERRY_BUSH.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.BLACKBERRY_BUSH.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.GOOSEBERRY_BUSH.get(), RenderType.getCutout());

    RenderTypeLookup.setRenderLayer(ModBlocks.RESIN_BLOCK.get(), RenderType.getTranslucent());
    RenderTypeLookup.setRenderLayer(ModBlocks.GELATIN_BLOCK.get(), RenderType.getTranslucent());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_DOOR.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_TRAPDOOR.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CANDLE.get(), RenderType.getTranslucent());

    event.enqueueWork(() -> {
      try {
        Field saturation = ObfuscationReflectionHelper.findField(Food.class, "field_221471_b");
        Field effect = ObfuscationReflectionHelper.findField(Food.class, "field_221475_f");
        List<Pair<Supplier<EffectInstance>, Float>> effects = Lists.newArrayList();
        saturation.setAccessible(true);

        saturation.setFloat(Foods.PORKCHOP, 1.8f);
        saturation.setFloat(Foods.CHICKEN, 1.2f);
        saturation.setFloat(Foods.RABBIT, 1.8f);
        saturation.setFloat(Foods.MUTTON, 1.2f);
        saturation.setFloat(Foods.BEEF, 1.8f);

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.2f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.7f));
        effect.set(Foods.MUTTON, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.2f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.7f));
        effect.set(Foods.RABBIT, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 200, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 100, 1), 0.8f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 200, 2), 0.7f));
        effect.set(Foods.CHICKEN, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.5f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.6f));
        effect.set(Foods.PORKCHOP, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 0.5f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.1f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.3f));

        Field maxDamage = ObfuscationReflectionHelper.findField(Item.class, "field_77699_b");
        maxDamage.setAccessible(true);
        maxDamage.setInt(Items.BUCKET, 512);

      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    });
  }

  @SubscribeEvent
  public static void rightclickEvent(PlayerInteractEvent.RightClickBlock event) {
    if (event.getHand() == Hand.MAIN_HAND) {
      event.getPos();
    }
  }

  public static final ItemGroup TAB = new ItemGroup("ravenutils") {
    @Override
    public ItemStack createIcon() {
      // todo adjust later
      return new ItemStack(ModBlocks.RAVEN_EYE_BLOCK.get());
    }
  };

}
