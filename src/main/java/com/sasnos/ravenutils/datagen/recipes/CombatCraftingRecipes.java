package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
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
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.COPPER_SWORD.get())
        .patternLine("i")
        .patternLine("i")
        .patternLine("#")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('#', rods_wood)
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer);

    // bronze
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BRONZE_SWORD.get())
        .patternLine("i")
        .patternLine("i")
        .patternLine("#")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('#', rods_wood)
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    // silver
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SILVER_SWORD.get())
        .patternLine("i")
        .patternLine("i")
        .patternLine("#")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('#', rods_wood)
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .build(consumer);

    // steel
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.STEEL_SWORD.get())
        .patternLine("i")
        .patternLine("i")
        .patternLine("#")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('#', rods_wood)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    // mytherine
    // todo move to Smithing Recipes
    /* ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_SWORD.get())
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_SWORD)
        .addCriterion("has_netherite_sword", hasItem(Items.NETHERITE_SWORD))
        .build(consumer); */

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_HELMET.get())
        .patternLine("xcx")
        .patternLine(" A ")
        .patternLine("xgx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('A', Items.NETHERITE_HELMET)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .key('g', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_netherite_helmet", hasItem(Items.NETHERITE_HELMET))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_CHESTPLATE.get())
        .patternLine("xcx")
        .patternLine(" A ")
        .patternLine("xgx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('A', Items.NETHERITE_CHESTPLATE)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .key('g', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_netherite_chestplate", hasItem(Items.NETHERITE_CHESTPLATE))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_LEGGINGS.get())
        .patternLine("xcx")
        .patternLine(" A ")
        .patternLine("xgx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('A', Items.NETHERITE_LEGGINGS)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .key('g', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_netherite_leggings", hasItem(Items.NETHERITE_LEGGINGS))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_BOOTS.get())
        .patternLine("xcx")
        .patternLine(" A ")
        .patternLine("xgx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('A', Items.NETHERITE_BOOTS)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .key('g', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_netherite_boots", hasItem(Items.NETHERITE_BOOTS))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_SHIELD.get())
        .patternLine("xcx")
        .patternLine("xAx")
        .patternLine("xgx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('A', Items.SHIELD)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .key('g', ModItems.RAVEN_EYE_GEM.get())
        .addCriterion("has_shield", hasItem(Items.SHIELD))
        .build(consumer);
  }
}
