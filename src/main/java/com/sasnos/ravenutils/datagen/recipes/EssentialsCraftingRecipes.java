package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.*;

public class EssentialsCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // items to block
    ShapedRecipeBuilder.shapedRecipe(Items.COBBLESTONE)
        .patternLine("xx")
        .patternLine("xx")
        .key('x', ModItems.SMALL_STONE.get())
        .addCriterion("has_small_stone", hasItem(ModItems.SMALL_STONE.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BLACK_COAL.get())
        .addCriterion("has_black_coal", hasItem(ModItems.BLACK_COAL.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.PEAT_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.PEAT.get())
        .addCriterion("has_peat", hasItem(ModItems.PEAT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MUD_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.MUD_LUMP.get())
        .addCriterion("has_mud", hasItem(ModItems.MUD_LUMP.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_raven_eye", hasItem(ModItems.RAVEN_EYE_GEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.GELATIN_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.GELATIN.get())
        .addCriterion("has_gelatin", hasItem(ModItems.GELATIN.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.RESIN_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.RESIN_BALL.get())
        .addCriterion("has_resin_ball", hasItem(ModItems.RESIN_BALL.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.SALT_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.SALT.get())
        .addCriterion("has_salt", hasItem(ModItems.SALT.get()))
        .build(consumer);

    // block to items
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BLACK_COAL.get(), 9)
        .addIngredient(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get())
        .addCriterion("has_black_coal_block", hasItem(ModBlockItems.BLACK_COAL_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PEAT.get(), 9)
        .addIngredient(ModBlockItems.PEAT_BLOCK_ITEM.get())
        .addCriterion("has_peat_block", hasItem(ModBlockItems.PEAT_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MUD_LUMP.get(), 9)
        .addIngredient(ModBlockItems.MUD_BLOCK_ITEM.get())
        .addCriterion("has_mud_block", hasItem(ModBlockItems.MUD_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAVEN_EYE_GEM.get(), 9)
        .addIngredient(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get())
        .addCriterion("has_raven_eye_block", hasItem(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.GELATIN.get(), 9)
        .addIngredient(ModBlockItems.GELATIN_BLOCK_ITEM.get())
        .addCriterion("has_gelatin_block", hasItem(ModBlockItems.GELATIN_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RESIN_BALL.get(), 9)
        .addIngredient(ModBlockItems.RESIN_BLOCK_ITEM.get())
        .addCriterion("has_resin_block", hasItem(ModBlockItems.RESIN_BLOCK_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SALT.get(), 9)
        .addIngredient(ModBlockItems.SALT_BLOCK_ITEM.get())
        .addCriterion("has_salt_block", hasItem(ModBlockItems.SALT_BLOCK_ITEM.get()))
        .build(consumer);

    // axe
    ShapelessRecipeBuilder.shapelessRecipe(Items.ACACIA_PLANKS, 4)
        .addIngredient(Items.ACACIA_LOG)
        .addIngredient(axes)
        .addCriterion("has_acacia_log", hasItem(Items.ACACIA_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BIRCH_PLANKS, 4)
        .addIngredient(Items.BIRCH_LOG)
        .addIngredient(axes)
        .addCriterion("has_birch_log", hasItem(Items.BIRCH_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.DARK_OAK_PLANKS, 4)
        .addIngredient(Items.DARK_OAK_LOG)
        .addIngredient(axes)
        .addCriterion("has_dark_oak_log", hasItem(Items.DARK_OAK_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.JUNGLE_PLANKS, 4)
        .addIngredient(Items.JUNGLE_LOG)
        .addIngredient(axes)
        .addCriterion("has_jungle_log", hasItem(Items.JUNGLE_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.OAK_PLANKS, 4)
        .addIngredient(Items.OAK_LOG)
        .addIngredient(axes)
        .addCriterion("has_oak_log", hasItem(Items.OAK_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SPRUCE_PLANKS, 4)
        .addIngredient(Items.SPRUCE_LOG)
        .addIngredient(axes)
        .addCriterion("has_spruce_log", hasItem(Items.SPRUCE_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(), 4)
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(axes)
        .addCriterion("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .build(consumer);

    // hammer
    ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
        .addIngredient(Items.STONE)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer, "cobblestone_with_hammer");

    ShapelessRecipeBuilder.shapelessRecipe(Items.GRAVEL)
        .addIngredient(Items.COBBLESTONE)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SAND)
        .addIngredient(Items.GRAVEL)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LIME.get(), 4)
        .addIngredient(ModBlockItems.LIMESTONE_BLOCK_ITEM.get())
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_IRON.get())
        .patternLine("h")
        .patternLine("i")
        .key('h', hammers)
        .key('i', Items.IRON_NUGGET)
        .addCriterion("has_iron_nugget", hasItem(Items.IRON_NUGGET))
        .setGroup("sewing_needles")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_STEEL.get())
        .patternLine("h")
        .patternLine("i")
        .key('h', hammers)
        .key('i', ModItems.STEEL_NUGGET.get())
        .addCriterion("has_steel_nugget", hasItem(ModItems.STEEL_NUGGET.get()))
        .setGroup("sewing_needles")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.METAL_ROD_IRON.get())
        .patternLine("h")
        .patternLine("i")
        .patternLine("i")
        .key('h', hammers)
        .key('i', Items.IRON_INGOT)
        .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .setGroup("metal_rods")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.METAL_ROD_STEEL.get())
        .patternLine("h")
        .patternLine("i")
        .patternLine("i")
        .key('h', hammers)
        .key('i', ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("metal_rods")
        .build(consumer);

    // knife
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEATHER_STRIP.get(), 4)
        .addIngredient(Items.LEATHER)
        .addIngredient(knives)
        .addCriterion("has_knife", hasItem(Items.LEATHER))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUCKET_CLAY_UNFIRED.get())
        .addIngredient(Items.CLAY)
        .addIngredient(knives)
        .addCriterion("has_knife", hasItem(Items.CLAY))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_WOOD.get())
        .addIngredient(ItemTags.LOGS_THAT_BURN)
        .addIngredient(knives)
        .addCriterion("has_wooden_log", hasItemTag(ItemTags.LOGS_THAT_BURN))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_CRIMWOOD.get())
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(knives)
        .addCriterion("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 3)
        .addIngredient(saplings)
        .addIngredient(knives)
        .addCriterion("has_sapling", hasItemTag(saplings))
        .build(consumer, "plant_fibre_from_saplings");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 2)
        .addIngredient(ModBlockItems.REEDS_ITEM.get())
        .addIngredient(knives)
        .addCriterion("has_reeds", hasItem(ModBlockItems.REEDS_ITEM.get()))
        .build(consumer, "plant_fibre_from_reeds");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 1)
        .addIngredient(barks)
        .addIngredient(knives)
        .addCriterion("has_bark", hasItemTag(barks))
        .build(consumer, "plant_fibre_from_barks");

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 4)
        .addIngredient(ItemTags.WOOL)
        .addIngredient(knives)
        .addCriterion("has_knife", hasItemTag(knives))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 9)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(knives)
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer, "string_from_knife");

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_BONE.get(), 2)
        .patternLine("h")
        .patternLine("i")
        .key('h', knives)
        .key('i', Items.BONE)
        .addCriterion("has_knife", hasItemTag(knives))
        .setGroup("sewing_needles")
        .build(consumer);

    // materials
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_TWINE.get())
        .addIngredient(ModItems.PLANT_FIBRE.get())
        .addIngredient(ModItems.PLANT_FIBRE.get())
        .addIngredient(ModItems.PLANT_FIBRE.get())
        .addCriterion("has_plant_fibre", hasItem(ModItems.PLANT_FIBRE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModFoodItems.DOUGH.get())
        .addIngredient(ModFoodItems.WHEAT_FLOUR.get())
        .addIngredient(ModFoodItems.WHEAT_FLOUR.get())
        .addIngredient(ModItems.SALT.get())
        .addIngredient(Items.WATER_BUCKET)
        .addCriterion("has_wheat_flour", hasItem(ModFoodItems.WHEAT_FLOUR.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.HIDE_CURED.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModItems.HIDE_FRESH.get())
        .addCriterion("has_hide_fresh", hasItem(ModItems.HIDE_FRESH.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.CLOTH.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', Items.STRING)
        .addCriterion("has_strings", hasItem(Items.STRING))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.INK_BOTTLE.get())
        .addIngredient(Items.INK_SAC)
        .addIngredient(Items.GLASS_BOTTLE)
        .addCriterion("has_ink_sac", hasItem(Items.INK_SAC))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAVEN_EYE_GEM.get())
        .addIngredient(Items.EMERALD)
        .addIngredient(ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_crimleaf", hasItem(ModBlockItems.CRIMLEAF_ITEM.get()))
        .build(consumer, "raven_eye_gem_from_crimleaf");

    ShapedRecipeBuilder.shapedRecipe(ModItems.RESIN_BALL.get())
        .patternLine("xx")
        .patternLine("xx")
        .key('x', ModItems.RESIN_DROP.get())
        .addCriterion("has_resin_drop", hasItem(ModItems.RESIN_DROP.get()))
        .build(consumer, "resin_ball_from_resin_drop");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MUD_BRICK.get(), 1)
        .addIngredient(ModItems.MUD_LUMP.get())
        .addIngredient(knives)
        .addCriterion("has_mud_lump", hasItem(ModItems.MUD_LUMP.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.UNFIRED_BRICK.get(), 1)
        .addIngredient(Items.CLAY_BALL)
        .addIngredient(knives)
        .addCriterion("has_clay_ball", hasItem(Items.CLAY_BALL))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.GROUT.get(), 8)
        .patternLine("wl ")
        .patternLine("ssc")
        .patternLine("ssc")
        .key('c', Items.CLAY_BALL)
        .key('s', ItemTags.SAND)
        .key('l', ModItems.LIME.get())
        .key('w', buckets_water)
        .addCriterion("has_clay_ball", hasItem(Items.CLAY_BALL))
        .build(consumer);

    // tools
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MORTAR_WOOD.get())
        .patternLine(" s")
        .patternLine("b ")
        .key('b', Items.BOWL)
        .key('s', Tags.Items.RODS_WOODEN)
        .addCriterion("has_stick", hasItemTag(Tags.Items.RODS_WOODEN))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MORTAR_STONE.get())
        .patternLine(" c")
        .patternLine("b ")
        .key('b', Items.STONE)
        .key('c', chisels)
        .addCriterion("has_chisel", hasItemTag(chisels))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_STONE.get())
        .patternLine(" ox")
        .patternLine(" io")
        .patternLine("i  ")
        .key('o', Items.STONE)
        .key('x', strings)
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_stone", hasItem(Items.STONE))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_IRON.get())
        .patternLine(" ox")
        .patternLine(" io")
        .patternLine("i  ")
        .key('o', Items.IRON_INGOT)
        .key('x', ModItems.LEATHER_STRIP.get())
        .key('i', ModItems.METAL_ROD_IRON.get())
        .addCriterion("has_iron", hasItem(Items.IRON_INGOT))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_OBSIDIAN.get())
        .patternLine(" ox")
        .patternLine(" io")
        .patternLine("i  ")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.LEATHER_STRIP.get())
        .key('i', ModItems.METAL_ROD_STEEL.get())
        .addCriterion("has_leather_strip", hasItem(ModItems.LEATHER_STRIP.get()))
        .addCriterion("has_obsidian", hasItem(Items.OBSIDIAN))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_FLINT.get())
        .patternLine(" x")
        .patternLine("i ")
        .key('x', Items.BOWL)
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_flint_shard", hasItem(ModItems.FLINT_SHARD.get()))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_IRON.get())
        .patternLine("  h")
        .patternLine(" x ")
        .patternLine("i  ")
        .key('h', hammers)
        .key('x', Items.IRON_INGOT)
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_STEEL.get())
        .patternLine("  h")
        .patternLine(" x ")
        .patternLine("i  ")
        .key('h', hammers)
        .key('x', ModItems.STEEL_INGOT.get())
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.CHISEL_IRON.get())
        .patternLine("h")
        .patternLine("x")
        .patternLine("i")
        .key('h', hammers)
        .key('x', Items.IRON_INGOT)
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .setGroup("chisels")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.CHISEL_STEEL.get())
        .patternLine("h")
        .patternLine("x")
        .patternLine("i")
        .key('h', hammers)
        .key('x', ModItems.STEEL_INGOT.get())
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("chisels")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.CHISEL_DIAMOND.get())
        .patternLine("h")
        .patternLine("x")
        .patternLine("i")
        .key('h', hammers)
        .key('x', Items.DIAMOND)
        .key('i', Tags.Items.RODS_WOODEN)
        .addCriterion("has_diamond", hasItem(Items.DIAMOND))
        .setGroup("chisels")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_COPPER.get())
        .patternLine("i ")
        .patternLine("xi")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('x', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_BRONZE.get())
        .patternLine("i ")
        .patternLine("xi")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('x', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_SILVER.get())
        .patternLine("i ")
        .patternLine("xi")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('x', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_STEEL.get())
        .patternLine("i ")
        .patternLine("xi")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('x', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.SOAP.get())
        .addIngredient(ModItems.ASH.get())
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(buckets_water)
        .addCriterion("has_tallow", hasItem(ModItems.TALLOW.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BEDROLL.get())
        .patternLine("sn ")
        .patternLine("ccc")
        .patternLine("ccc")
        .key('s', strings)
        .key('n', sewing_needles)
        .key('c', ModItems.CLOTH.get())
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BAG_CLOTH.get())
        .patternLine("csc")
        .patternLine("cnc")
        .patternLine("ccc")
        .key('s', strings)
        .key('n', sewing_needles)
        .key('c', ModItems.CLOTH.get())
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .setGroup("bags")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BAG_LEATHER.get())
        .patternLine("lsl")
        .patternLine("lnl")
        .patternLine("lll")
        .key('s', ModItems.LEATHER_STRIP.get())
        .key('n', sewing_needles)
        .key('l', Items.LEATHER)
        .addCriterion("has_leather", hasItem(Items.LEATHER))
        .setGroup("bags")
        .build(consumer);

    // miscellaneous
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CANDLE_ITEM.get())
        .patternLine("s")
        .patternLine("t")
        .patternLine("b")
        .key('s', strings)
        .key('t', ModItems.TALLOW.get())
        .key('b', Items.BOWL)
        .addCriterion("has_tallow", hasItem(ModItems.TALLOW.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 3)
        .addIngredient(ItemTags.WOOL)
        .addIngredient(Tags.Items.RODS_WOODEN)
        .addCriterion("has_wool", hasItemTag(ItemTags.WOOL))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 6)
        .addIngredient(ItemTags.WOOL)
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(Tags.Items.RODS_WOODEN)
        .addCriterion("has_wool", hasItemTag(ItemTags.WOOL))
        .build(consumer, "torch_from_wool_with_tallow");

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 6)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(Tags.Items.RODS_WOODEN)
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer, "torch_from_cloth");

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 12)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(Tags.Items.RODS_WOODEN)
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer, "torch_from_cloth_with_tallow");

    ShapedRecipeBuilder.shapedRecipe(ModItems.UNFIRED_FLOWER_POT.get())
        .patternLine("ckc")
        .patternLine(" c ")
        .key('c', Items.CLAY_BALL)
        .key('k', knives)
        .addCriterion("has_clay_ball", hasItem(Items.CLAY_BALL))
        .build(consumer);

    /* ShapedRecipeBuilder.shapedRecipe(ModItems.UNFIRED_LARGE_FLOWER_POT.get())
        .patternLine("k")
        .patternLine("c")
        .key('c', Items.CLAY)
        .key('k', knives)
        .addCriterion("has_clay", hasItem(Items.CLAY))
        .build(consumer); */


     ShapedRecipeBuilder.shapedRecipe(ModItems.CRIMWOOD_SIGN.get())
        .patternLine("WWW")
        .patternLine("WWW")
        .patternLine(" # ")
        .key('#', Tags.Items.RODS_WOODEN)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    // functional blocks
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STONE_ANVIL_ANDESITE_ITEM.get())
        .patternLine("SSS")
        .patternLine(" S ")
        .patternLine("sss")
        .key('S', Items.ANDESITE)
        .key('s', Items.ANDESITE_SLAB)
        .addCriterion("has_andesite", hasItem(Items.ANDESITE))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STONE_ANVIL_DIORITE_ITEM.get())
        .patternLine("SSS")
        .patternLine(" S ")
        .patternLine("sss")
        .key('S', Items.DIORITE)
        .key('s', Items.DIORITE_SLAB)
        .addCriterion("has_diorite", hasItem(Items.DIORITE))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STONE_ANVIL_GRANITE_ITEM.get())
        .patternLine("SSS")
        .patternLine(" S ")
        .patternLine("sss")
        .key('S', Items.GRANITE)
        .key('s', Items.GRANITE_SLAB)
        .addCriterion("has_granite", hasItem(Items.GRANITE))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STONE_ANVIL_STONE_ITEM.get())
        .patternLine("SSS")
        .patternLine(" S ")
        .patternLine("sss")
        .key('S', Items.STONE)
        .key('s', Items.STONE_SLAB)
        .addCriterion("has_stone", hasItem(Items.STONE))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get())
        .patternLine("SS")
        .patternLine("SS")
        .key('S', Items.COBBLESTONE)
        .addCriterion("has_cobblestone", hasItem(Items.COBBLESTONE))
        .build(consumer);
  }
}
