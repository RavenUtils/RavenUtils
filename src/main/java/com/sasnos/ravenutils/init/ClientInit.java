package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

    @SubscribeEvent
    public static void clientStartup(final FMLClientSetupEvent event){
        //ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TE.get(), SignRenderer::new);
    }
}
