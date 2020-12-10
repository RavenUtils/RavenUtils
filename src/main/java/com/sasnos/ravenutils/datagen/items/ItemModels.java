package com.sasnos.ravenutils.datagen.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.loaders.DynamicBucketModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.sasnos.ravenutils.utils.EssentialsUtils.resourceLocation;


public class ItemModels extends ItemModelProvider {

  public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, RavenUtils.MOD_ID, existingFileHelper);
  }

  @SuppressWarnings("ConstantConditions")
  @Override
  protected void registerModels() {

    // material
    // todo move Blood Bottle to Magic module
    singleTexture("item/" + ModItems.BLOOD_BOTTLE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/blood_bottle"));

    singleTexture("item/" + ModItems.INK_BOTTLE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/ink_bottle"));

    singleTexture("item/" + ModItems.ASH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/ash"));

    singleTexture("item/" + ModItems.BLACK_COAL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/black_coal"));

    singleTexture("item/" + ModItems.PEAT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/peat"));

    singleTexture("item/" + ModItems.COAL_DUST.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/coal_dust"));

    singleTexture("item/" + ModItems.CHARCOAL_DUST.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/charcoal_dust"));

    singleTexture("item/" + ModItems.CLOTH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/cloth"));

    singleTexture("item/" + ModItems.COARSE_SALT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/coarse_salt"));

    singleTexture("item/" + ModItems.BUCKET_CLAY_UNFIRED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bucket_clay_unfired"));

    singleTexture("item/" + ModItems.SALT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/salt"));

    singleTexture("item/" + ModItems.QUARTZ_SAND.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/quartz_sand"));

    singleTexture("item/" + ModItems.NITER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/niter"));

    singleTexture("item/" + ModItems.PLANT_FIBRE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/plant_fibre"));

    singleTexture("item/" + ModItems.DRIED_PLANT_FIBRE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/dried_plant_fibre"));

    singleTexture("item/" + ModItems.BARK_ACACIA.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_acacia"));

    singleTexture("item/" + ModItems.BARK_BIRCH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_birch"));

    singleTexture("item/" + ModItems.BARK_CRIMSON_STEM.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_crimson_stem"));

    singleTexture("item/" + ModItems.BARK_CRIMWOOD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_crimwood"));

    singleTexture("item/" + ModItems.BARK_DARK_OAK.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_dark_oak"));

    singleTexture("item/" + ModItems.BARK_JUNGLE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_jungle"));

    singleTexture("item/" + ModItems.BARK_OAK.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_oak"));

    singleTexture("item/" + ModItems.BARK_SPRUCE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_spruce"));

    singleTexture("item/" + ModItems.BARK_WARPED_STEM.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bark_warped_stem"));

    singleTexture("item/" + ModItems.PLANT_TWINE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/plant_twine"));

    singleTexture("item/" + ModItems.FLINT_SHARD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/flint_shard"));

    singleTexture("item/" + ModItems.GELATIN.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/gelatin"));

    singleTexture("item/" + ModItems.LIME.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/lime"));

    singleTexture("item/" + ModItems.GROUT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/grout"));

    singleTexture("item/" + ModItems.MUD_LUMP.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mud_lump"));

    singleTexture("item/" + ModItems.MUD_BRICK.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mud_brick_wet"));

    singleTexture("item/" + ModItems.MUD_BRICK_DRIED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mud_brick_dried"));

    singleTexture("item/" + ModItems.UNFIRED_BRICK.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/unfired_brick"));

    singleTexture("item/" + ModItems.UNFIRED_FLOWER_POT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/unfired_flower_pot"));

    singleTexture("item/" + ModItems.RESIN_DROP.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/resin_drop"));

    singleTexture("item/" + ModItems.RESIN_BALL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/resin_ball"));

    singleTexture("item/" + ModItems.SLAG.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/slag"));

    singleTexture("item/" + ModItems.SMALL_STONE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/small_stone"));

    singleTexture("item/" + ModItems.SULFUR.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/sulfur"));

    singleTexture("item/" + ModItems.TALLOW.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tallow"));

    singleTexture("item/" + ModItems.LEATHER_STRIP.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/leather_strip"));

    singleTexture("item/" + ModItems.RAVEN_EYE_GEM.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/raven_eye_gem"));

    singleTexture("item/" + ModItems.RAVEN_EYE_DUST.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/raven_eye_dust"));

    singleTexture("item/" + ModItems.METAL_ROD_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/metal_rod_iron"));

    singleTexture("item/" + ModItems.METAL_ROD_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/metal_rod_steel"));

    // vegetation
    withExistingParent("item/" + ModBlockItems.CRIMLEAF_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimleaf"));

    singleTexture("item/" + ModItems.REED_SEEDS.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/reed_seeds"));

    singleTexture("item/" + ModBlockItems.REEDS_ITEM.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/reeds"));

    // food(-related) items
    singleTexture("item/" + ModFoodItems.BUSHMEAT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bushmeat"));

    singleTexture("item/" + ModFoodItems.COOKED_BUSHMEAT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/cooked_bushmeat"));

    singleTexture("item/" + ModFoodItems.SQUID_MEAT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/squid_meat"));

    singleTexture("item/" + ModFoodItems.COOKED_SQUID_MEAT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/cooked_squid_meat"));

    singleTexture("item/" + ModFoodItems.WHEAT_FLOUR.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/wheat_flour"));

    singleTexture("item/" + ModFoodItems.DOUGH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/dough"));

    singleTexture("item/" + ModFoodItems.DUCK_EGG.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/duck_egg"));

    // hides
    singleTexture("item/" + ModItems.HIDE_FRESH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_fresh"));

    singleTexture("item/" + ModItems.HIDE_CURED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_cured"));

    singleTexture("item/" + ModItems.HIDE_LIMED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_limed"));

    singleTexture("item/" + ModItems.HIDE_SCRAPED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_scraped"));

    singleTexture("item/" + ModItems.HIDE_TANNED.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_tanned"));

    singleTexture("item/" + ModItems.HIDE_FRESH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_fresh"));

    singleTexture("item/" + ModItems.HIDE_FRESH.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hide_fresh"));

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

    // metal ingots & nuggets
    singleTexture("item/" + ModItems.COPPER_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_nugget"));

    singleTexture("item/" + ModItems.COPPER_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_ingot"));

    singleTexture("item/" + ModItems.TIN_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tin_nugget"));

    singleTexture("item/" + ModItems.TIN_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tin_ingot"));

    singleTexture("item/" + ModItems.ZINC_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/zinc_nugget"));

    singleTexture("item/" + ModItems.ZINC_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/zinc_ingot"));

    singleTexture("item/" + ModItems.BRASS_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/brass_nugget"));

    singleTexture("item/" + ModItems.BRASS_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/brass_ingot"));

    singleTexture("item/" + ModItems.BRONZE_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_nugget"));

    singleTexture("item/" + ModItems.BRONZE_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_ingot"));

    singleTexture("item/" + ModItems.LEAD_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/lead_nugget"));

    singleTexture("item/" + ModItems.LEAD_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/lead_ingot"));

    singleTexture("item/" + ModItems.SILVER_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_nugget"));

    singleTexture("item/" + ModItems.SILVER_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_ingot"));

    singleTexture("item/" + ModItems.STEEL_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_nugget"));

    singleTexture("item/" + ModItems.STEEL_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_ingot"));

    singleTexture("item/" + ModItems.MYTHERINE_NUGGET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_nugget"));

    singleTexture("item/" + ModItems.MYTHERINE_INGOT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_ingot"));

    // other blocks/ ores
    withExistingParent("item/" + ModBlockItems.FOSSIL_DIRT_ITEM.get().getRegistryName().getPath(),
        modLoc("block/fossil_dirt"));

    withExistingParent("item/" + ModBlockItems.FOSSIL_ROCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/fossil_rock"));

    withExistingParent("item/" + ModBlockItems.QUICKSAND_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/quicksand_block"));

    withExistingParent("item/" + ModBlockItems.LIMESTONE_BLOCK_ITEM.get().getRegistryName().getPath(),
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

    withExistingParent("item/" + ModBlockItems.PEAT_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/peat_block"));

    // tools
    singleTexture("item/" + ModToolItems.BEDROLL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bedroll"));

    singleTexture("item/" + ModToolItems.SOAP.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/soap"));

    singleTexture("item/" + ModToolItems.FLINT_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/flint_axe"));

    singleTexture("item/" + ModToolItems.FIRESTARTER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/firestarter"));

    // hammers
    singleTexture("item/" + ModToolItems.HAMMER_STONE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hammer_stone"));

    singleTexture("item/" + ModToolItems.HAMMER_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hammer_iron"));

    singleTexture("item/" + ModToolItems.HAMMER_OBSIDIAN.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/hammer_obsidian"));

    // tongs
    singleTexture("item/" + ModToolItems.TONGS_WOOD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tongs_wood"));

    singleTexture("item/" + ModToolItems.TONGS_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tongs_iron"));

    singleTexture("item/" + ModToolItems.TONGS_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/tongs_steel"));

    // handsaws
    singleTexture("item/" + ModToolItems.HANDSAW_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/handsaw_iron"));

    singleTexture("item/" + ModToolItems.HANDSAW_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/handsaw_steel"));

    // knives
    singleTexture("item/" + ModToolItems.KNIFE_FLINT.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/knife_flint"));

    singleTexture("item/" + ModToolItems.KNIFE_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/knife_iron"));

    singleTexture("item/" + ModToolItems.KNIFE_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/knife_steel"));

    // chisels
    singleTexture("item/" + ModToolItems.CHISEL_IRON.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/chisel_iron"));

    singleTexture("item/" + ModToolItems.CHISEL_STEEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/chisel_steel"));

    singleTexture("item/" + ModToolItems.CHISEL_DIAMOND.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/chisel_diamond"));

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
        modLoc("items/bucket_wood_milk"));

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
        modLoc("items/bucket_crimwood_milk"));

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
        modLoc("items/bucket_clay_milk"));

    withExistingParent("item/" + Items.BUCKET.getRegistryName().getPath(),
        new ResourceLocation("forge", "item/bucket"))
        .texture("base", mcLoc("item/bucket"))
        .texture("inner", resourceLocation("items/bucket_iron_cutout"))
        .texture("fluid", resourceLocation("items/bucket_fluid_layer"))
        .customLoader(DynamicBucketModelBuilder::begin)
        .fluid(Fluids.EMPTY);

    // common tools
    // todo move swords to Combat module
    singleTexture("item/" + ModToolItems.COPPER_SWORD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_sword"));

    singleTexture("item/" + ModToolItems.COPPER_SHOVEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_shovel"));

    singleTexture("item/" + ModToolItems.COPPER_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_axe"));

    singleTexture("item/" + ModToolItems.COPPER_PICKAXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_pickaxe"));

    singleTexture("item/" + ModToolItems.COPPER_HOE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/copper_hoe"));

    singleTexture("item/" + ModToolItems.BRONZE_SWORD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_sword"));

    singleTexture("item/" + ModToolItems.BRONZE_SHOVEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_shovel"));

    singleTexture("item/" + ModToolItems.BRONZE_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_axe"));

    singleTexture("item/" + ModToolItems.BRONZE_PICKAXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_pickaxe"));

    singleTexture("item/" + ModToolItems.BRONZE_HOE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/bronze_hoe"));

    singleTexture("item/" + ModToolItems.SILVER_SWORD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_sword"));

    singleTexture("item/" + ModToolItems.SILVER_SHOVEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_shovel"));

    singleTexture("item/" + ModToolItems.SILVER_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_axe"));

    singleTexture("item/" + ModToolItems.SILVER_PICKAXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_pickaxe"));

    singleTexture("item/" + ModToolItems.SILVER_HOE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/silver_hoe"));

    singleTexture("item/" + ModToolItems.STEEL_SWORD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_sword"));

    singleTexture("item/" + ModToolItems.STEEL_SHOVEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_shovel"));

    singleTexture("item/" + ModToolItems.STEEL_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_axe"));

    singleTexture("item/" + ModToolItems.STEEL_PICKAXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_pickaxe"));

    singleTexture("item/" + ModToolItems.STEEL_HOE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/steel_hoe"));

    singleTexture("item/" + ModToolItems.MYTHERINE_SWORD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_sword"));

    singleTexture("item/" + ModToolItems.MYTHERINE_SHOVEL.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_shovel"));

    singleTexture("item/" + ModToolItems.MYTHERINE_AXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_axe"));

    singleTexture("item/" + ModToolItems.MYTHERINE_PICKAXE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_pickaxe"));

    singleTexture("item/" + ModToolItems.MYTHERINE_HOE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_hoe"));

    // todo move armors to Combat module
    // armor
    singleTexture("item/" + ModArmorItems.MYTHERINE_HELMET.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_helmet"));

    singleTexture("item/" + ModArmorItems.MYTHERINE_CHESTPLATE.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_chestplate"));

    singleTexture("item/" + ModArmorItems.MYTHERINE_LEGGINGS.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_leggings"));

    singleTexture("item/" + ModArmorItems.MYTHERINE_BOOTS.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/mytherine_boots"));

    ModelFile block = withExistingParent("item/" + ModArmorItems.MYTHERINE_SHIELD.get().getRegistryName().getPath()+"_block",
            mcLoc("item/shield_blocking")).texture("particle", modLoc("blocks/crimwood_planks"));

    withExistingParent("item/" + ModArmorItems.MYTHERINE_SHIELD.get().getRegistryName().getPath(),
            mcLoc("item/shield")).texture("particle", modLoc("blocks/crimwood_planks"))
    .override().predicate(mcLoc("blocking"), 1).model(block);



//     singleTexture("item/" + ModArmorItems.MYTHERINE_SHIELD.get().getRegistryName().getPath(),
//        mcLoc("item/generated"),
//        "layer0",
//        resourceLocation("item/mytherine_shield"));
//
//    withExistingParent("item/" + ModArmorItems.MYTHERINE_SHIELD.get().getRegistryName().getPath()+"_blocking",
//            modLoc("item/mytherine_shield"));

    // miscellaneous
    withExistingParent("item/" + ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_crafting_table"));

    singleTexture("item/" + ModItems.COIN_COPPER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/coin_copper"));

    singleTexture("item/" + ModItems.COIN_SILVER.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/coin_silver"));

    singleTexture("item/" + ModItems.COIN_GOLD.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/coin_gold"));

    // berries
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
    withExistingParent("item/" + ModBlockItems.CRIMWOOD_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood"));

    singleTexture("item/" + ModBlockItems.CRIMWOOD_DOOR_ITEM.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/crimwood_door"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_LEAVES_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_leaves"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_LOG_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_log"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_LOG_STRIPPED_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_log_stripped"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_PLANKS_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_planks"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_pressure_plate"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_SAPLING_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_sapling"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_SLAB_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_slab"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_STAIRS_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_stairs"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_fence_gate"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_FENCE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_fence_inventory"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_trap_door"));

    withExistingParent("item/" + ModBlockItems.CRIMWOOD_BUTTON_ITEM.get().getRegistryName().getPath(),
        modLoc("block/crimwood_button_inventory"));

     singleTexture("item/" + ModItems.CRIMWOOD_SIGN.get().getRegistryName().getPath(),
        mcLoc("item/generated"),
        "layer0",
        modLoc("items/crimwood_sign"));

    // mud itemblocks
    withExistingParent("item/" + ModBlockItems.MUD_BLOCK_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mud_block"));

    withExistingParent("item/" + ModBlockItems.MUD_BRICKS_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mud_bricks"));

    withExistingParent("item/" + ModBlockItems.MUD_BRICK_SLAB_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mud_brick_slab"));

    withExistingParent("item/" + ModBlockItems.MUD_BRICK_STAIRS_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mud_brick_stairs"));

    withExistingParent("item/" + ModBlockItems.MUD_BRICK_WALL_ITEM.get().getRegistryName().getPath(),
        modLoc("block/mud_brick_wall_inventory"));

    // stone anvils
    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_ANDESITE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_anvil_andesite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_DIORITE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_anvil_diorite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_GRANITE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_anvil_granite"));

    withExistingParent("item/" + ModBlockItems.STONE_ANVIL_STONE_ITEM.get().getRegistryName().getPath(),
        modLoc("block/stone_anvil_stone"));
  }
}
