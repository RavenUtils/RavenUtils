package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.CRIMLEAF.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMLEAF.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CRIMWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), RenderType.getCutout());

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
        RenderTypeLookup.setRenderLayer(ModBlocks.DRYING_RACK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.FISH_TRAP.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.STICK_GROUND.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_GROUND.get(), RenderType.getTranslucent());
    }
}
