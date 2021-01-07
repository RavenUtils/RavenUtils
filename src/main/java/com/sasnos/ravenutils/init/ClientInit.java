package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceScreen;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillScreen;
import com.sasnos.ravenutils.client.render.BarrelRenderer;
import com.sasnos.ravenutils.client.render.DryingRackRenderer;
import com.sasnos.ravenutils.client.render.SignRenderer;
import com.sasnos.ravenutils.screen.BagScreen;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import com.sasnos.ravenutils.utils.RenderMaterials;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.DynamicBucketModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

  @SubscribeEvent
  public static void clientStartup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
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

    ScreenManager.registerFactory(AlloyFurnaceInit.ALLOY_FURNACE_CONTAINER.get(), AlloyFurnaceScreen::new);
    ScreenManager.registerFactory(ModContainer.BAG_CONTAINER.get(), BagScreen::new);
    ScreenManager.registerFactory(HandMillInit.HAND_MILL_CONTAINER.get(), HandMillScreen::new);

      ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignRenderer::new);
      ClientRegistry.bindTileEntityRenderer(ModTileEntities.BARREL_TILE_ENTITIES.get(), BarrelRenderer::new);
    });

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    ModelLoaderRegistry.registerLoader(EssentialsUtils.resourceLocation("bucket"), DynamicBucketModel.Loader.INSTANCE);
  }

  @SubscribeEvent
  public static void init(FMLClientSetupEvent event) {
    addShieldPropertyOverrides(new ResourceLocation("blocking"),
        (stack, world, entity) -> entity != null && entity.isHandActive()
            && entity.getActiveItemStack() == stack ? 1.0F : 0.0F,
        ModArmorItems.MYTHERINE_SHIELD.get());
  }

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    ModelLoaderRegistry.registerLoader(EssentialsUtils.resourceLocation("bucket"), DynamicBucketModel.Loader.INSTANCE);
  }

  private static void addShieldPropertyOverrides(ResourceLocation override, IItemPropertyGetter propertyGetter,
                                                 IItemProvider... shields) {
    for (IItemProvider shield : shields) {
      ItemModelsProperties.registerProperty(shield.asItem(), override, propertyGetter);
    }
  }

  @SuppressWarnings("deprecation")
  @SubscribeEvent
  public static void onStitch(TextureStitchEvent.Pre event) {
    if (event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {
      for (RenderMaterial textures : RenderMaterials.materials) {
        event.addSprite(textures.getTextureLocation());
      }
    }
  }
}
