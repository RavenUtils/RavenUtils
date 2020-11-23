package com.sasnos.ravenutils.datagen.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.DynamicBucketModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.sasnos.ravenutils.utils.EssentialsUtils.resourceLocation;

public class ItemModels extends ItemModelProvider {

  public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, RavenUtils.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {

    // buckets
    withExistingParent("item/" + ModToolItems.BUCKET_WOOD.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", resourceLocation("items/bucket_wood"))
        .texture("inner", resourceLocation("items/bucket_wood_cutout"))
        .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    singleTexture("item/" + ModToolItems.BUCKET_WOOD_MILK.get().getRegistryName().getPath(),
        mcLoc("item/handheld"),
        "layer0",
        resourceLocation("items/bucket_wood_milk"));

    withExistingParent("item/" + ModToolItems.BUCKET_CRIMWOOD.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", resourceLocation("items/bucket_crimwood"))
        .texture("inner", resourceLocation("items/bucket_crimwood_cutout"))
        .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    singleTexture("item/" + ModToolItems.BUCKET_CRIMWOOD_MILK.get().getRegistryName().getPath(),
        mcLoc("item/handheld"),
        "layer0",
        resourceLocation("items/bucket_crimwood_milk"));

    withExistingParent("item/" + ModToolItems.BUCKET_CLAY.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", resourceLocation("items/bucket_clay"))
        .texture("inner", resourceLocation("items/bucket_clay_cutout"))
        .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    singleTexture("item/" + ModToolItems.BUCKET_CLAY_MILK.get().getRegistryName().getPath(),
        mcLoc("item/handheld"),
        "layer0",
        resourceLocation("items/bucket_clay_milk"));

        withExistingParent("item/" +ModToolItems.BUCKET_IRON.get().getRegistryName().getPath()
                , new ResourceLocation("forge", "item/bucket"))
                .texture("base", mcLoc("item/bucket"))
                .texture("inner", EssentialsUtils.resourceLocation("items/bucket_iron_cutout") )
                .texture("fluid", new ResourceLocation("forge","item/mask/bucket_fluid_cover"))
                .customLoader(DynamicBucketModelBuilder::begin)
                .fluid(Fluids.EMPTY);

    // crimwood
    withExistingParent("item/" + ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/crimwood_fence_gate"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_FENCE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/crimwood_fence_inventory"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/crimwood_trap_door"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_BUTTON_ITEM.get(),
        resourceLocation("block/crimwood_button_inventory"));

    // stone anvils
    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_ANDESITE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_anvil_andesite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_DIORITE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_anvil_diorite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_GRANITE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_anvil_granite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_STONE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_anvil_stone"));

    // miscellaneous
    withExistingParent("item/" + ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_crafting_table"));

    // berries
    singleTexture("item/" + ModFoodItems.BLUEBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        resourceLocation("items/blueberries"));

    singleTexture("item/" + ModFoodItems.ELDERBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        resourceLocation("items/elderberries"));

    singleTexture("item/" + ModFoodItems.RASPBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        resourceLocation("items/raspberries"));

    singleTexture("item/" + ModFoodItems.BLACKBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        resourceLocation("items/blackberries"));

    singleTexture("item/" + ModFoodItems.GOOSEBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        resourceLocation("items/gooseberries"));
  }
}
