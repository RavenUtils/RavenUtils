package com.sasnos.ravenutils.datagen.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
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

    // material
    // todo move Blood Bottle to Magic module
    singleTexture("item/" + ModItems.BLOOD_BOTTLE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/blood_bottle"));

    singleTexture("item/" + ModItems.ASH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/ash"));

    singleTexture("item/" + ModItems.BLACK_COAL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/black_coal"));

    // metal and ore block(items)
    withExistingParent("item/" + ModBlockItems.BRASS_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/brass_block"));

    withExistingParent("item/" + ModBlockItems.BRONZE_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/bronze_block"));

    withExistingParent("item/" + ModBlockItems.COPPER_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/copper_ore"));

    withExistingParent("item/" + ModBlockItems.COPPER_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/copper_block"));

    withExistingParent("item/" + ModBlockItems.TIN_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/tin_ore"));

    withExistingParent("item/" + ModBlockItems.TIN_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/tin_block"));

    withExistingParent("item/" + ModBlockItems.ZINC_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/zinc_ore"));

    withExistingParent("item/" + ModBlockItems.ZINC_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/zinc_block"));

    withExistingParent("item/" + ModBlockItems.SILVER_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/silver_ore"));

    withExistingParent("item/" + ModBlockItems.SILVER_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/silver_block"));

    withExistingParent("item/" + ModBlockItems.LEAD_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/lead_ore"));

    withExistingParent("item/" + ModBlockItems.LEAD_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/lead_block"));

    withExistingParent("item/" + ModBlockItems.STEEL_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/steel_block"));

    withExistingParent("item/" + ModBlockItems.MYTHERINE_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mytherine_ore"));

    withExistingParent("item/" + ModBlockItems.MYTHERINE_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mytherine_block"));

    // other blocks/ ores
    withExistingParent("item/" + ModBlockItems.FOSSIL_DIRT_ITEM.get().getRegistryName().getPath(),
        modLoc("block/fossil_dirt"));

    withExistingParent("item/" + ModBlockItems.FOSSIL_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/fossil_ore"));

    withExistingParent("item/" + ModBlockItems.LIMESTONE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/limestone"));

    withExistingParent("item/" + ModBlockItems.SULFUR_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/sulfur_ore"));

    withExistingParent("item/" + ModBlockItems.BLACK_COAL_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/black_coal_ore"));

    withExistingParent("item/" + ModBlockItems.BLACK_COAL_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/black_coal_block"));

    withExistingParent("item/" + ModBlockItems.SALT_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/salt_ore"));

    withExistingParent("item/" + ModBlockItems.SALT_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/salt_block"));

    withExistingParent("item/" + ModBlockItems.RAVEN_EYE_ORE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/raven_eye_ore"));

    withExistingParent("item/" + ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/raven_eye_block"));

    withExistingParent("item/" + ModBlockItems.RESIN_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/resin_block"));

    withExistingParent("item/" + ModBlockItems.GELATIN_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/gelatin_block"));

    // tools
    singleTexture("item/" + ModToolItems.BEDROLL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bedroll"));

    // sewing needles
    singleTexture("item/" + ModToolItems.SEWING_NEEDLE_BONE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/sewing_needle_bone"));

    singleTexture("item/" + ModToolItems.SEWING_NEEDLE_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/sewing_needle_iron"));

    singleTexture("item/" + ModToolItems.SEWING_NEEDLE_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/sewing_needle_steel"));

    // shears
    singleTexture("item/" + ModToolItems.SHEARS_COPPER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/shears_copper"));

    singleTexture("item/" + ModToolItems.SHEARS_BRONZE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/shears_bronze"));

    singleTexture("item/" + ModToolItems.SHEARS_SILVER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/shears_silver"));

    singleTexture("item/" + ModToolItems.SHEARS_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/shears_steel"));

    // mortars
    singleTexture("item/" + ModToolItems.MORTAR_WOOD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mortar_wood"));

    singleTexture("item/" + ModToolItems.MORTAR_STONE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mortar_stone"));

    // bags
    singleTexture("item/" + ModToolItems.BAG_CLOTH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bag_cloth"));

    singleTexture("item/" + ModToolItems.BAG_LEATHER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bag_leather"));

    // buckets
    withExistingParent("item/" + ModToolItems.BUCKET_WOOD.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", modLoc("items/bucket_wood"))
        .texture("inner", modLoc("items/bucket_wood_cutout"))
        .texture("fluid", modLoc("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    singleTexture("item/" + ModToolItems.BUCKET_WOOD_MILK.get().getRegistryName().getPath(),
        mcLoc("item/handheld"),
        "layer0",
        resourceLocation("items/bucket_wood_milk"));

    withExistingParent("item/" + ModToolItems.BUCKET_CRIMWOOD.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", modLoc("items/bucket_crimwood"))
        .texture("inner", modLoc("items/bucket_crimwood_cutout"))
        .texture("fluid", modLoc("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    singleTexture("item/" + ModToolItems.BUCKET_CRIMWOOD_MILK.get().getRegistryName().getPath(),
        mcLoc("item/handheld"),
        "layer0",
        resourceLocation("items/bucket_crimwood_milk"));

    withExistingParent("item/" + ModToolItems.BUCKET_CLAY.get().getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", modLoc("items/bucket_clay"))
        .texture("inner", modLoc("items/bucket_clay_cutout"))
        .texture("fluid", modLoc("items/bucket_fluid_layer"))
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

    // miscellaneous
    withExistingParent("item/" + ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_crafting_table"));

    // berries
    // todo move berries to Cuisine module
    singleTexture("item/" + ModFoodItems.BLUEBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/blueberries"));

    singleTexture("item/" + ModFoodItems.ELDERBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/elderberries"));

    singleTexture("item/" + ModFoodItems.RASPBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/raspberries"));

    singleTexture("item/" + ModFoodItems.BLACKBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/blackberries"));

    singleTexture("item/" + ModFoodItems.GOOSEBERRIES.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/gooseberries"));

    // crimwood itemblocks
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
  }
}
