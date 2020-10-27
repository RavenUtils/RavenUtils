package com.raven_tongue.ravenutils;

import com.raven_tongue.ravenutils.init.ModBlocks;
import com.raven_tongue.ravenutils.init.ModItems;
import com.raven_tongue.ravenutils.world.gen.FeatureGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ravenutils")
public class RavenUtils {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "ravenutils";

  public RavenUtils() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureGen::AddFeaturesToBiomes);

    ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {
    RenderTypeLookup.setRenderLayer(ModBlocks.CRIMLEAF.get(), RenderType.getCutout());
  }

  private void doClientStuff(final FMLClientSetupEvent event) {
  }

  public static final ItemGroup TAB = new ItemGroup("Raven Utils") {
    @Override
    public ItemStack createIcon() {
      // adjust later
      return new ItemStack(ModBlocks.RAVEN_EYE_BLOCK.get());
    }
  };
}
