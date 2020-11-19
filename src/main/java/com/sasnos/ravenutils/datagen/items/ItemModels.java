package com.sasnos.ravenutils.datagen.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.DynamicBucketModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.sasnos.ravenutils.util.EssentialsUtils.resourceLocation;

public class ItemModels extends ItemModelProvider {

  public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, RavenUtils.MOD_ID, existingFileHelper);
  }

    @Override
    protected void registerModels() {

        withExistingParent("item/"+ModToolItems.BUCKET_WOOD.get().getRegistryName().getPath()
                , new ResourceLocation("forge", "item/bucket"))
                .texture("base", resourceLocation("items/bucket_wood"))
                .texture("inner", resourceLocation("items/bucket_wood_cutout"))
                .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
                .customLoader(DynamicBucketModelBuilder::begin)
                .fluid(Fluids.EMPTY);

        singleTexture("item/"+ ModToolItems.BUCKET_WOOD_MILK.get().getRegistryName().getPath(),
                mcLoc("item/handheld"),
                "layer0",
                resourceLocation("items/bucket_wood_milk"));

        withExistingParent("item/"+ModToolItems.BUCKET_MYTHERINE.get().getRegistryName().getPath()
                , new ResourceLocation("forge", "item/bucket"))
                .texture("base", resourceLocation("items/bucket_mytherine"))
                .texture("inner", resourceLocation("items/bucket_mytherine_cutout"))
                .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
                .customLoader(DynamicBucketModelBuilder::begin)
                .fluid(Fluids.EMPTY);

        singleTexture("item/"+ ModToolItems.BUCKET_MYTHERINE_MILK.get().getRegistryName().getPath(),
                mcLoc("item/handheld"),
                "layer0",
                resourceLocation("items/bucket_mythetine_milk"));

        withExistingParent("item/"+ModToolItems.BUCKET_CLAY.get().getRegistryName().getPath()
                , new ResourceLocation("forge", "item/bucket"))
        .texture("base", resourceLocation("items/bucket_clay"))
        .texture("inner",resourceLocation("items/bucket_clay_cutout") )
        .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

        singleTexture("item/"+ ModToolItems.BUCKET_CLAY_MILK.get().getRegistryName().getPath(),
                mcLoc("item/handheld"),
                "layer0",
                resourceLocation("items/bucket_clay_milk"));

        withExistingParent("item/"+ ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(),
                resourceLocation("block/stone_crafting_table"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_STONE_ITEM.get().getRegistryName().getPath(),
        resourceLocation("block/stone_anvil_stone"));
  }
}
