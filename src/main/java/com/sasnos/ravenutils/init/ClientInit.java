package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.modules.alloyfurnace.EssentialsAlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.alloyfurnace.EssentialsFurnaceScreen;
import com.sasnos.ravenutils.render.SignRenderer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

  @SubscribeEvent
  public static void clientStartup(final FMLClientSetupEvent event) {
    ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignRenderer::new);
    ScreenManager.registerFactory(EssentialsAlloyFurnaceInit.alloyFurnaceContainer.get(), EssentialsFurnaceScreen::new);
  }
}
