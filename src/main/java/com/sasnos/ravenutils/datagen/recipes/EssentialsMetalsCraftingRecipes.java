package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsMetalsCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsMetalsCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // nuggets to ingot
    ShapedRecipeBuilder.shapedRecipe(ModItems.COPPER_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.COPPER_NUGGET.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.TIN_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.TIN_NUGGET.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.ZINC_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.ZINC_NUGGET.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.SILVER_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.SILVER_NUGGET.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.LEAD_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.LEAD_NUGGET.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRONZE_NUGGET.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.BRASS_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRASS_NUGGET.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.STEEL_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.STEEL_NUGGET.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.MYTHERINE_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.MYTHERINE_NUGGET.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // ingot to nuggets
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COPPER_NUGGET.get(), 9)
        .addIngredient(ModItems.COPPER_INGOT.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.TIN_NUGGET.get(), 9)
        .addIngredient(ModItems.TIN_INGOT.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.ZINC_NUGGET.get(), 9)
        .addIngredient(ModItems.ZINC_INGOT.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_NUGGET.get(), 9)
        .addIngredient(ModItems.SILVER_INGOT.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEAD_NUGGET.get(), 9)
        .addIngredient(ModItems.LEAD_INGOT.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRONZE_NUGGET.get(), 9)
        .addIngredient(ModItems.BRONZE_INGOT.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRASS_NUGGET.get(), 9)
        .addIngredient(ModItems.BRASS_INGOT.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.STEEL_NUGGET.get(), 9)
        .addIngredient(ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MYTHERINE_NUGGET.get(), 9)
        .addIngredient(ModItems.MYTHERINE_INGOT.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // ingots to block
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.COPPER_INGOT.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.TIN_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.TIN_INGOT.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.ZINC_INGOT.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.SILVER_INGOT.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.LEAD_INGOT.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRONZE_INGOT.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRASS_INGOT.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // block to ingots
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COPPER_INGOT.get(), 9)
        .addIngredient(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.TIN_INGOT.get(), 9)
        .addIngredient(ModBlockItems.TIN_BLOCK_ITEM.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.ZINC_INGOT.get(), 9)
        .addIngredient(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_INGOT.get(), 9)
        .addIngredient(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEAD_INGOT.get(), 9)
        .addIngredient(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRONZE_INGOT.get(), 9)
        .addIngredient(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRASS_INGOT.get(), 9)
        .addIngredient(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.STEEL_INGOT.get(), 9)
        .addIngredient(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MYTHERINE_INGOT.get(), 9)
        .addIngredient(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // custom tools
    // copper

    // bronze

    // silver

    // steel

    // mytherine
  }
}
