package com.sasnos.ravenutils;

import com.sasnos.ravenutils.init.*;
import com.sasnos.ravenutils.world.gen.FeatureGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RavenUtils.MOD_ID)
public class RavenUtils {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "ravenutils";

  public RavenUtils() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureGen::AddFeaturesToBiomes);

    ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModArmorItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModFoodItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModToolItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event)
  {
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMLEAF.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMLEAF.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_SAPLING.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_DOOR.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_TRAPDOOR.get(), RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(ModBlocks.RESIN_BLOCK.get(), RenderType.getTranslucent());
  }


  public static final ItemGroup TAB = new ItemGroup("Raven Utils") {
    @Override
    public ItemStack createIcon() {
      // adjust later
      return new ItemStack(ModBlocks.RAVEN_EYE_BLOCK.get());
    }
  };

}
