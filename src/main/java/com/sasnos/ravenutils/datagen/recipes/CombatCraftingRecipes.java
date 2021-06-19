package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;

public class CombatCraftingRecipes extends EssentialsRecipeProvider {
  public CombatCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // todo move these to Combat module!

    // copper
    ShapedRecipeBuilder.shaped(ModToolItems.COPPER_SWORD.get())
        .pattern("i")
        .pattern("i")
        .pattern("#")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .save(consumer);

    // bronze
    ShapedRecipeBuilder.shaped(ModToolItems.BRONZE_SWORD.get())
        .pattern("i")
        .pattern("i")
        .pattern("#")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    // silver
    ShapedRecipeBuilder.shaped(ModToolItems.SILVER_SWORD.get())
        .pattern("i")
        .pattern("i")
        .pattern("#")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .save(consumer);

    // steel
    ShapedRecipeBuilder.shaped(ModToolItems.STEEL_SWORD.get())
        .pattern("i")
        .pattern("i")
        .pattern("#")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    // mytherine
    // todo move to Smithing Recipes
    /* ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_SWORD.get())
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_SWORD)
        .addCriterion("has_netherite_sword", hasItem(Items.NETHERITE_SWORD))
        .build(consumer); */

    ShapedRecipeBuilder.shaped(ModArmorItems.MYTHERINE_HELMET.get())
        .pattern("xcx")
        .pattern(" A ")
        .pattern("xgx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('A', Items.NETHERITE_HELMET)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .define('g', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_netherite_helmet", hasItem(Items.NETHERITE_HELMET))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModArmorItems.MYTHERINE_CHESTPLATE.get())
        .pattern("xcx")
        .pattern(" A ")
        .pattern("xgx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('A', Items.NETHERITE_CHESTPLATE)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .define('g', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_netherite_chestplate", hasItem(Items.NETHERITE_CHESTPLATE))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModArmorItems.MYTHERINE_LEGGINGS.get())
        .pattern("xcx")
        .pattern(" A ")
        .pattern("xgx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('A', Items.NETHERITE_LEGGINGS)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .define('g', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_netherite_leggings", hasItem(Items.NETHERITE_LEGGINGS))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModArmorItems.MYTHERINE_BOOTS.get())
        .pattern("xcx")
        .pattern(" A ")
        .pattern("xgx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('A', Items.NETHERITE_BOOTS)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .define('g', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_netherite_boots", hasItem(Items.NETHERITE_BOOTS))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModArmorItems.MYTHERINE_SHIELD.get())
        .pattern("xcx")
        .pattern("xAx")
        .pattern("xgx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('A', Items.SHIELD)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .define('g', ModItems.RAVEN_EYE_GEM.get())
        .unlockedBy("has_shield", hasItem(Items.SHIELD))
        .save(consumer);
  }
}
