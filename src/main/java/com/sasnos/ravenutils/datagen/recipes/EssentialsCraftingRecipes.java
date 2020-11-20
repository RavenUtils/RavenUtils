package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.datagen.tags.EssentialsItemTags;
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
        .addCriterion("has_black_coal", hasItem(ModItems.BLACK_COAL.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAVEN_EYE_GEM.get(), 9)
        .addIngredient(ModBlockItems.RAVEN_EYE_BLOCK_ITEM.get())
        .addCriterion("has_raven_eye", hasItem(ModItems.RAVEN_EYE_GEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.GELATIN.get(), 9)
        .addIngredient(ModBlockItems.GELATIN_BLOCK_ITEM.get())
        .addCriterion("has_gelatin", hasItem(ModItems.GELATIN.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RESIN_BALL.get(), 9)
        .addIngredient(ModBlockItems.RESIN_BLOCK_ITEM.get())
        .addCriterion("has_resin_ball", hasItem(ModItems.RESIN_BALL.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SALT.get(), 9)
        .addIngredient(ModBlockItems.SALT_BLOCK_ITEM.get())
        .addCriterion("has_salt", hasItem(ModItems.SALT.get()))
        .build(consumer);

    // hammer
    ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
        .addIngredient(Items.STONE)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItemTag(EssentialsItemTags.hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.GRAVEL)
        .addIngredient(Items.COBBLESTONE)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItemTag(EssentialsItemTags.hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SAND)
        .addIngredient(Items.GRAVEL)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItemTag(EssentialsItemTags.hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LIME.get(), 4)
        .addIngredient(ModBlockItems.LIMESTONE_ITEM.get())
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItemTag(EssentialsItemTags.hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.IRON_NEEDLE.get())
        .addIngredient(Items.IRON_NUGGET)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItemTag(EssentialsItemTags.hammers))
        .build(consumer);

    // knife
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEATHER_STRIP.get(), 4)
        .addIngredient(Items.LEATHER)
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUCKET_CLAY_UNFIRED.get())
        .addIngredient(Items.CLAY)
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_WOOD.get())
        .addIngredient(ItemTags.makeWrapperTag("minecraft:logs_that_burn"))
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_CRIMWOOD.get())
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 4)
        .addIngredient(ItemTags.makeWrapperTag("minecraft:wool"))
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 9)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BONE_NEEDLE.get(), 4)
        .addIngredient(Items.BONE)
        .addIngredient(EssentialsItemTags.knives)
        .addCriterion("has_knife", hasItemTag(EssentialsItemTags.knives))
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
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.RESIN_BALL.get())
        .patternLine("xx")
        .patternLine("xx")
        .key('x', ModItems.RESIN_DROP.get())
        .addCriterion("has_resin_drop", hasItem(ModItems.RESIN_DROP.get()))
        .build(consumer);

    // tools
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MORTAR_AND_PESTLE.get())
        .patternLine(" s")
        .patternLine("b ")
        .key('b', Items.BOWL)
        .key('s', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_stick", hasItemTag(ItemTags.makeWrapperTag("forge:rods/wooden")))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_STONE.get())
        .patternLine("oxo")
        .patternLine(" i ")
        .patternLine(" i ")
        .key('o', Items.STONE)
        .key('x', EssentialsItemTags.strings)
        .key('i', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_stone", hasItem(Items.STONE))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_IRON.get())
        .patternLine("oxo")
        .patternLine(" i ")
        .patternLine(" i ")
        .key('o', Items.IRON_INGOT)
        .key('x', ModItems.LEATHER_STRIP.get())
        .key('i', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_iron", hasItem(Items.IRON_INGOT))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.HAMMER_OBSIDIAN.get())
        .patternLine("oxo")
        .patternLine(" i ")
        .patternLine(" i ")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_obsidian", hasItem(Items.OBSIDIAN))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_FLINT.get())
        .patternLine(" x")
        .patternLine("i ")
        .key('x', Items.BOWL)
        .key('i', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_flint_shard", hasItem(ModItems.FLINT_SHARD.get()))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_IRON.get())
        .patternLine(" x")
        .patternLine("i ")
        .key('x', Items.IRON_INGOT)
        .key('i', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_iron", hasItem(Items.IRON_INGOT))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.KNIFE_DIAMOND.get())
        .patternLine(" x")
        .patternLine("i ")
        .key('x', Items.DIAMOND)
        .key('i', ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_diamond", hasItem(Items.DIAMOND))
        .setGroup("knives")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_COPPER.get())
        .patternLine("I ")
        .patternLine("xI")
        .key('I', ModItems.COPPER_INGOT.get())
        .key('X', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_BRONZE.get())
        .patternLine("I ")
        .patternLine("xI")
        .key('I', ModItems.BRONZE_INGOT.get())
        .key('X', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_SILVER.get())
        .patternLine("I ")
        .patternLine("xI")
        .key('I', ModItems.SILVER_INGOT.get())
        .key('X', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SHEARS_STEEL.get())
        .patternLine("I ")
        .patternLine("xI")
        .key('I', ModItems.STEEL_INGOT.get())
        .key('X', ModItems.LEATHER_STRIP.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("shears")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.SOAP.get())
        .addIngredient(ModItems.ASH.get())
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(EssentialsItemTags.water_buckets)
        .addCriterion("has_tallow", hasItem(ModItems.TALLOW.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BEDROLL.get())
        .patternLine("sn ")
        .patternLine("ccc")
        .patternLine("ccc")
        .key('s', EssentialsItemTags.strings)
        .key('n', ModToolItems.BONE_NEEDLE.get())
        .key('c', ModItems.CLOTH.get())
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer);

    // miscellaneous
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CANDLE_ITEM.get())
        .patternLine("s")
        .patternLine("t")
        .patternLine("b")
        .key('s', EssentialsItemTags.strings)
        .key('t', ModItems.TALLOW.get())
        .key('b', Items.BOWL)
        .addCriterion("has_tallow", hasItem(ModItems.TALLOW.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 3)
        .addIngredient(ItemTags.makeWrapperTag("minecraft:wool"))
        .addIngredient(ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_wool", hasItemTag(ItemTags.makeWrapperTag("minecraft:wool")))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 6)
        .addIngredient(ItemTags.makeWrapperTag("minecraft:wool"))
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_wool", hasItemTag(ItemTags.makeWrapperTag("minecraft:wool")))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 6)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.TORCH, 12)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(ModItems.TALLOW.get())
        .addIngredient(ItemTags.makeWrapperTag("forge:rods/wooden"))
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer);

    // crimwood blocks
  }
}
