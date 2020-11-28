package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceScreen;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillScreen;
import com.sasnos.ravenutils.screen.BagScreen;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.DynamicBucketModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

  @SubscribeEvent
  public static void clientStartup(final FMLClientSetupEvent event) {
    // ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignRenderer::new);
    ScreenManager.registerFactory(AlloyFurnaceInit.alloyFurnaceContainer.get(), AlloyFurnaceScreen::new);
    ScreenManager.registerFactory(ModContainer.BAG_CONTAINER.get(), BagScreen::new);
    ScreenManager.registerFactory(HandMillInit.HANDMILL_CONTAINER.get(), HandMillScreen::new);
  }

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    ModelLoaderRegistry.registerLoader(EssentialsUtils.resourceLocation("bucket"), DynamicBucketModel.Loader.INSTANCE);
  }

}
