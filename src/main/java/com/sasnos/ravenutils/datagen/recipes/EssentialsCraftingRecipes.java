package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.barks;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.buckets_water;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.chisels;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.fishing_rods;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.hammers;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.knives;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.planks;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.sewing_needles;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.strings;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.tongs;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.wooden_slabs;

public class EssentialsCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // items to block
    ShapedRecipeBuilder.shaped(Items.COBBLESTONE)
        .pattern("xx")
        .pattern("xx")
        .define('x', ModItems.SMALL_STONE.get())
        .unlockedBy("has_small_stone", hasItem(ModItems.SMALL_STONE.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.BLACK_COAL.get())
        .unlockedBy("has_black_coal", hasItem(ModItems.BLACK_COAL.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.PEAT_BLOCK_ITEM.get())
        .pattern("xx")
        .pattern("xx")
        .define('x', ModItems.PEAT.get())
        .unlockedBy("has_peat", hasItem(ModItems.PEAT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.MUD_BLOCK_ITEM.get())
        .pattern("xx")
        .pattern("xx")
        .define('x', ModItems.MUD_LUMP.get())
        .unlockedBy("has_mud", hasItem(ModItems.MUD_LUMP.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_raven_eye", hasItem(ModItems.RAVEN_EYE_GEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.GELATIN_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.GELATIN.get())
        .unlockedBy("has_gelatin", hasItem(ModItems.GELATIN.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.RESIN_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.RESIN_BALL.get())
        .unlockedBy("has_resin_ball", hasItem(ModItems.RESIN_BALL.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.SALT_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.SALT.get())
        .unlockedBy("has_salt", hasItem(ModItems.SALT.get()))
        .save(consumer);

    // block to items
    ShapelessRecipeBuilder.shapeless(ModItems.BLACK_COAL.get(), 9)
        .requires(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get())
        .unlockedBy("has_black_coal_block", hasItem(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.PEAT.get(), 9)
        .requires(ModBlockItems.PEAT_BLOCK_ITEM.get())
        .unlockedBy("has_peat_block", hasItem(ModBlockItems.PEAT_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.MUD_LUMP.get(), 9)
        .requires(ModBlockItems.MUD_BLOCK_ITEM.get())
        .unlockedBy("has_mud_block", hasItem(ModBlockItems.MUD_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.RAVEN_EYE_GEM.get(), 9)
        .requires(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get())
        .unlockedBy("has_raven_eye_block", hasItem(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.GELATIN.get(), 9)
        .requires(ModBlockItems.GELATIN_BLOCK_ITEM.get())
        .unlockedBy("has_gelatin_block", hasItem(ModBlockItems.GELATIN_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.RESIN_BALL.get(), 9)
        .requires(ModBlockItems.RESIN_BLOCK_ITEM.get())
        .unlockedBy("has_resin_block", hasItem(ModBlockItems.RESIN_BLOCK_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.SALT.get(), 9)
        .requires(ModBlockItems.SALT_BLOCK_ITEM.get())
        .unlockedBy("has_salt_block", hasItem(ModBlockItems.SALT_BLOCK_ITEM.get()))
        .save(consumer);

    // materials
    ShapelessRecipeBuilder.shapeless(ModItems.PLANT_TWINE.get())
        .requires(ModItems.PLANT_FIBRE.get())
        .requires(ModItems.PLANT_FIBRE.get())
        .requires(ModItems.PLANT_FIBRE.get())
        .unlockedBy("has_plant_fibre", hasItem(ModItems.PLANT_FIBRE.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.FLINT_SHARD.get())
        .requires(Items.FLINT)
        .requires(ModItems.SMALL_STONE.get())
        .unlockedBy("has_flint", hasItem(Items.FLINT))
        .save(consumer, "flint_shard_with_small_stone");

    ShapelessRecipeBuilder.shapeless(ModFoodItems.DOUGH.get())
        .requires(ModFoodItems.WHEAT_FLOUR.get())
        .requires(ModFoodItems.WHEAT_FLOUR.get())
        .requires(ModItems.SALT.get())
        .requires(Items.WATER_BUCKET)
        .unlockedBy("has_wheat_flour", hasItem(ModFoodItems.WHEAT_FLOUR.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.HIDE_CURED.get())
        .requires(ModItems.COARSE_SALT.get())
        .requires(ModItems.COARSE_SALT.get())
        .requires(ModItems.HIDE_FRESH.get())
        .unlockedBy("has_hide_fresh", hasItem(ModItems.HIDE_FRESH.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.CLOTH.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', Items.STRING)
        .unlockedBy("has_strings", hasItem(Items.STRING))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.INK_BOTTLE.get())
        .requires(Items.INK_SAC)
        .requires(Items.GLASS_BOTTLE)
        .unlockedBy("has_ink_sac", hasItem(Items.INK_SAC))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.RAVEN_EYE_GEM.get())
        .requires(Items.EMERALD)
        .requires(ModBlockItems.CRIMLEAF_ITEM.get())
        .unlockedBy("has_crimleaf", hasItem(ModBlockItems.CRIMLEAF_ITEM.get()))
        .save(consumer, "raven_eye_gem_from_crimleaf");

    ShapedRecipeBuilder.shaped(ModItems.RESIN_BALL.get())
        .pattern("xx")
        .pattern("xx")
        .define('x', ModItems.RESIN_DROP.get())
        .unlockedBy("has_resin_drop", hasItem(ModItems.RESIN_DROP.get()))
        .save(consumer, "resin_ball_from_resin_drop");

    ShapelessRecipeBuilder.shapeless(ModItems.MUD_BRICK.get(), 1)
        .requires(ModItems.MUD_LUMP.get())
        .requires(knives)
        .unlockedBy("has_mud_lump", hasItem(ModItems.MUD_LUMP.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.UNFIRED_BRICK.get(), 1)
        .requires(Items.CLAY_BALL)
        .requires(knives)
        .unlockedBy("has_clay_ball", hasItem(Items.CLAY_BALL))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.GROUT.get(), 8)
        .pattern("wl ")
        .pattern("ssc")
        .pattern("ssc")
        .define('c', Items.CLAY_BALL)
        .define('s', ItemTags.SAND)
        .define('l', ModItems.LIME.get())
        .define('w', buckets_water)
        .unlockedBy("has_clay_ball", hasItem(Items.CLAY_BALL))
        .save(consumer);

    // tools
    ShapelessRecipeBuilder.shapeless(ModToolItems.FIRESTARTER.get())
        .requires(ModItems.DRIED_PLANT_FIBRE.get())
        .requires(rods_wood)
        .requires(barks)
        .unlockedBy("has_bark", hasItemTag(barks))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.WOODEN_SWORD)
        .pattern(" p ")
        .pattern(" ps")
        .pattern(" # ")
        .define('p', planks)
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_planks", hasItemTag(planks))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.WOODEN_SHOVEL)
        .pattern(" ps")
        .pattern(" # ")
        .pattern(" # ")
        .define('p', planks)
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_planks", hasItemTag(planks))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.WOODEN_HOE)
        .pattern("pps")
        .pattern(" # ")
        .pattern(" # ")
        .define('p', planks)
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_planks", hasItemTag(planks))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.FLINT_AXE.get())
        .pattern("ffs")
        .pattern("f# ")
        .pattern(" # ")
        .define('f', ModItems.FLINT_SHARD.get())
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_flint_shard", hasItem(ModItems.FLINT_SHARD.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.STONE_AXE)
        .pattern("ccs")
        .pattern("c# ")
        .pattern(" # ")
        .define('c', Items.COBBLESTONE)
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_cobblestone", hasItem(Items.COBBLESTONE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.STONE_HOE)
        .pattern("ccs")
        .pattern(" # ")
        .pattern(" # ")
        .define('c', Items.COBBLESTONE)
        .define('s', strings)
        .define('#', rods_wood)
        .unlockedBy("has_cobblestone", hasItem(Items.COBBLESTONE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.MORTAR_WOOD.get())
        .pattern(" s")
        .pattern("b ")
        .define('b', Items.BOWL)
        .define('s', rods_wood)
        .unlockedBy("has_stick", hasItemTag(rods_wood))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.MORTAR_STONE.get())
        .pattern(" c")
        .pattern("b ")
        .define('b', Items.STONE)
        .define('c', chisels)
        .unlockedBy("has_chisel", hasItemTag(chisels))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.HAMMER_STONE.get())
        .pattern(" ox")
        .pattern(" io")
        .pattern("i  ")
        .define('o', Items.STONE)
        .define('x', strings)
        .define('i', rods_wood)
        .unlockedBy("has_stone", hasItem(Items.STONE))
        .group("hammers")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.HAMMER_IRON.get())
        .pattern(" ox")
        .pattern(" io")
        .pattern("i  ")
        .define('o', Items.IRON_INGOT)
        .define('x', ModItems.LEATHER_STRIP.get())
        .define('i', ModItems.METAL_ROD_IRON.get())
        .unlockedBy("has_iron", hasItem(Items.IRON_INGOT))
        .group("hammers")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.HAMMER_OBSIDIAN.get())
        .pattern(" ox")
        .pattern(" io")
        .pattern("i  ")
        .define('o', Items.OBSIDIAN)
        .define('x', ModItems.LEATHER_STRIP.get())
        .define('i', ModItems.METAL_ROD_STEEL.get())
        .unlockedBy("has_leather_strip", hasItem(ModItems.LEATHER_STRIP.get()))
        .unlockedBy("has_obsidian", hasItem(Items.OBSIDIAN))
        .group("hammers")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.TONGS_WOOD.get())
        .pattern("is")
        .pattern(" i")
        .define('s', strings)
        .define('i', rods_wood)
        .unlockedBy("has_leather_strip", hasItemTag(rods_wood))
        .group("tongs")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.TONGS_IRON.get())
        .pattern(" th")
        .pattern("ix ")
        .pattern(" i ")
        .define('t', tongs)
        .define('h', hammers)
        .define('x', Items.IRON_NUGGET)
        .define('i', ModItems.METAL_ROD_IRON.get())
        .unlockedBy("has_iron_rod", hasItem(ModItems.METAL_ROD_IRON.get()))
        .group("tongs")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.TONGS_STEEL.get())
        .pattern(" th")
        .pattern("ix ")
        .pattern(" i ")
        .define('t', tongs)
        .define('h', hammers)
        .define('x', ModItems.STEEL_NUGGET.get())
        .define('i', ModItems.METAL_ROD_STEEL.get())
        .unlockedBy("has_steel_rod", hasItem(ModItems.METAL_ROD_STEEL.get()))
        .group("tongs")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.HANDSAW_IRON.get())
        .pattern(" th")
        .pattern("nin")
        .pattern(" r ")
        .define('t', tongs)
        .define('h', hammers)
        .define('n', Items.IRON_NUGGET)
        .define('i', Items.IRON_INGOT)
        .define('r', ModItems.METAL_ROD_IRON.get())
        .unlockedBy("has_iron_rod", hasItem(ModItems.METAL_ROD_IRON.get()))
        .group("handsaws")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.HANDSAW_STEEL.get())
        .pattern(" th")
        .pattern("nin")
        .pattern(" r ")
        .define('t', tongs)
        .define('h', hammers)
        .define('n', ModItems.STEEL_NUGGET.get())
        .define('i', ModItems.STEEL_INGOT.get())
        .define('r', ModItems.METAL_ROD_STEEL.get())
        .unlockedBy("has_steel_rod", hasItem(ModItems.METAL_ROD_STEEL.get()))
        .group("handsaws")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.KNIFE_FLINT.get())
        .pattern(" x")
        .pattern("i ")
        .define('x', ModItems.FLINT_SHARD.get())
        .define('i', rods_wood)
        .unlockedBy("has_flint_shard", hasItem(ModItems.FLINT_SHARD.get()))
        .group("knives")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.KNIFE_IRON.get())
        .pattern("  h")
        .pattern(" x ")
        .pattern("i  ")
        .define('h', hammers)
        .define('x', Items.IRON_INGOT)
        .define('i', rods_wood)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .group("knives")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.KNIFE_STEEL.get())
        .pattern("  h")
        .pattern(" x ")
        .pattern("i  ")
        .define('h', hammers)
        .define('x', ModItems.STEEL_INGOT.get())
        .define('i', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .group("knives")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.CHISEL_IRON.get())
        .pattern("h")
        .pattern("x")
        .pattern("i")
        .define('h', hammers)
        .define('x', Items.IRON_INGOT)
        .define('i', rods_wood)
        .unlockedBy("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .group("chisels")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.CHISEL_STEEL.get())
        .pattern("h")
        .pattern("x")
        .pattern("i")
        .define('h', hammers)
        .define('x', ModItems.STEEL_INGOT.get())
        .define('i', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .group("chisels")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.CHISEL_DIAMOND.get())
        .pattern("h")
        .pattern("x")
        .pattern("i")
        .define('h', hammers)
        .define('x', Items.DIAMOND)
        .define('i', rods_wood)
        .unlockedBy("has_diamond", hasItem(Items.DIAMOND))
        .group("chisels")
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.SHEARS)
        .pattern("i ")
        .pattern("xi")
        .define('i', Items.IRON_INGOT)
        .define('x', ModItems.LEATHER_STRIP.get())
        .unlockedBy("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .group("shears")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SHEARS_COPPER.get())
        .pattern("i ")
        .pattern("xi")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('x', ModItems.LEATHER_STRIP.get())
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .group("shears")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SHEARS_BRONZE.get())
        .pattern("i ")
        .pattern("xi")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('x', ModItems.LEATHER_STRIP.get())
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .group("shears")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SHEARS_SILVER.get())
        .pattern("i ")
        .pattern("xi")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('x', ModItems.LEATHER_STRIP.get())
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .group("shears")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SHEARS_STEEL.get())
        .pattern("i ")
        .pattern("xi")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('x', ModItems.LEATHER_STRIP.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .group("shears")
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModToolItems.SOAP.get())
        .requires(ModItems.ASH.get())
        .requires(ModItems.TALLOW.get())
        .requires(buckets_water)
        .unlockedBy("has_tallow", hasItem(ModItems.TALLOW.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BEDROLL.get())
        .pattern("sn ")
        .pattern("ccc")
        .pattern("ccc")
        .define('s', strings)
        .define('n', sewing_needles)
        .define('c', ModItems.CLOTH.get())
        .unlockedBy("has_cloth", hasItem(ModItems.CLOTH.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BAG_CLOTH.get())
        .pattern("csc")
        .pattern("cnc")
        .pattern("ccc")
        .define('s', strings)
        .define('n', sewing_needles)
        .define('c', ModItems.CLOTH.get())
        .unlockedBy("has_cloth", hasItem(ModItems.CLOTH.get()))
        .group("bags")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BAG_LEATHER.get())
        .pattern("lsl")
        .pattern("lnl")
        .pattern("lll")
        .define('s', ModItems.LEATHER_STRIP.get())
        .define('n', sewing_needles)
        .define('l', Items.LEATHER)
        .unlockedBy("has_leather", hasItem(Items.LEATHER))
        .group("bags")
        .save(consumer);

    // miscellaneous
    ShapedRecipeBuilder.shaped(ModBlockItems.CANDLE_ITEM.get())
        .pattern("s")
        .pattern("t")
        .pattern("b")
        .define('s', strings)
        .define('t', ModItems.TALLOW.get())
        .define('b', Items.BOWL)
        .unlockedBy("has_tallow", hasItem(ModItems.TALLOW.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.TORCH, 3)
        .requires(ItemTags.WOOL)
        .requires(rods_wood)
        .unlockedBy("has_wool", hasItemTag(ItemTags.WOOL))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.TORCH, 6)
        .requires(ItemTags.WOOL)
        .requires(ModItems.TALLOW.get())
        .requires(rods_wood)
        .unlockedBy("has_wool", hasItemTag(ItemTags.WOOL))
        .save(consumer, "torch_from_wool_with_tallow");

    ShapelessRecipeBuilder.shapeless(Items.TORCH, 6)
        .requires(ModItems.CLOTH.get())
        .requires(rods_wood)
        .unlockedBy("has_cloth", hasItem(ModItems.CLOTH.get()))
        .save(consumer, "torch_from_cloth");

    ShapelessRecipeBuilder.shapeless(Items.TORCH, 12)
        .requires(ModItems.CLOTH.get())
        .requires(ModItems.TALLOW.get())
        .requires(rods_wood)
        .unlockedBy("has_cloth", hasItem(ModItems.CLOTH.get()))
        .save(consumer, "torch_from_cloth_with_tallow");

    ShapedRecipeBuilder.shaped(ModItems.UNFIRED_FLOWER_POT.get())
        .pattern("ckc")
        .pattern(" c ")
        .define('c', Items.CLAY_BALL)
        .define('k', knives)
        .unlockedBy("has_clay_ball", hasItem(Items.CLAY_BALL))
        .save(consumer);

    /*
    ShapedRecipeBuilder.shapedRecipe(ModItems.UNFIRED_LARGE_FLOWER_POT.get())
      .patternLine("k")
      .patternLine("c")
      .key('c', Items.CLAY)
      .key('k', knives)
      .addCriterion("has_clay", hasItem(Items.CLAY))
      .build(consumer);
    */

    ShapedRecipeBuilder.shaped(ModItems.CRIMWOOD_SIGN.get())
        .pattern("WWW")
        .pattern("WWW")
        .pattern(" # ")
        .define('#', rods_wood)
        .define('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.LADDER, 2)
        .pattern("rsr")
        .pattern("rrr")
        .pattern("rsr")
        .define('r', rods_wood)
        .define('s', strings)
        .unlockedBy("has_stick", hasItemTag(rods_wood))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.IRON_BARS, 2)
        .pattern(" th")
        .pattern("###")
        .pattern("###")
        .define('t', tongs)
        .define('h', hammers)
        .define('#', Items.IRON_INGOT)
        .unlockedBy("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .save(consumer);

    // functional blocks
    ShapedRecipeBuilder.shaped(ModBlockItems.STONE_ANVIL_ANDESITE_ITEM.get())
        .pattern("SSS")
        .pattern(" S ")
        .pattern("sss")
        .define('S', Items.ANDESITE)
        .define('s', Items.ANDESITE_SLAB)
        .unlockedBy("has_andesite", hasItem(Items.ANDESITE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.STONE_ANVIL_DIORITE_ITEM.get())
        .pattern("SSS")
        .pattern(" S ")
        .pattern("sss")
        .define('S', Items.DIORITE)
        .define('s', Items.DIORITE_SLAB)
        .unlockedBy("has_diorite", hasItem(Items.DIORITE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.STONE_ANVIL_GRANITE_ITEM.get())
        .pattern("SSS")
        .pattern(" S ")
        .pattern("sss")
        .define('S', Items.GRANITE)
        .define('s', Items.GRANITE_SLAB)
        .unlockedBy("has_granite", hasItem(Items.GRANITE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.STONE_ANVIL_STONE_ITEM.get())
        .pattern("SSS")
        .pattern(" S ")
        .pattern("sss")
        .define('S', Items.STONE)
        .define('s', Items.STONE_SLAB)
        .unlockedBy("has_stone", hasItem(Items.STONE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get())
        .pattern("SS")
        .pattern("SS")
        .define('S', Items.COBBLESTONE)
        .unlockedBy("has_cobblestone", hasItem(Items.COBBLESTONE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(AlloyFurnaceInit.ALLOY_FURNACE_ITEM.get())
        .pattern("sss")
        .pattern("fcf")
        .pattern("sss")
        .define('s', Items.COBBLESTONE)
        .define('f', Items.FURNACE)
        .define('c', Items.CAULDRON)
        .unlockedBy("has_furnace", hasItem(Items.FURNACE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.BARREL_ITEM.get())
        .pattern("# #")
        .pattern("# #")
        .pattern("#s#")
        .define('#', planks)
        .define('s', wooden_slabs)
        .unlockedBy("has_wooden_slab", hasItemTag(wooden_slabs))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.BARREL_LID.get())
        .pattern("ss")
        .pattern("ss")
        .define('s', wooden_slabs)
        .unlockedBy("has_wooden_slab", hasItemTag(wooden_slabs))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.DRYING_RACK_ITEM.get())
        .pattern("###")
        .pattern("#s#")
        .pattern("# #")
        .define('#', rods_wood)
        .define('s', strings)
        .unlockedBy("has_string", hasItemTag(strings))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.FISH_TRAP_ITEM.get())
        .pattern("###")
        .pattern("#r#")
        .pattern("###")
        .define('#', rods_wood)
        .define('r', fishing_rods)
        .unlockedBy("has_fishing_rod", hasItemTag(fishing_rods))
        .save(consumer);

    /*
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.ANIMAL_TRAP_ITEM.get())
        .patternLine("###")
        .patternLine("#c#")
        .patternLine("###")
        .key('#', rods_wood)
        .key('c', Items.CARROT_ON_A_STICK)
        .addCriterion("has_carrot_on_a_stick", hasItem(Items.CARROT_ON_A_STICK))
        .build(consumer);
    */
  }
}
