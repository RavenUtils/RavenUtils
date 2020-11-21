package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsCookingRecipeBuilder;
import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsBlastingRecipes extends EssentialsRecipeProvider {
  public EssentialsBlastingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.COPPER_ORE_ITEM.get()),
        ModItems.COPPER_INGOT.get(),
        0.7f,
        100)
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer, "copper_ingot_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.TIN_ORE_ITEM.get()),
        ModItems.TIN_INGOT.get(),
        0.7f,
        80)
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer, "tin_ingot_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.ZINC_ORE_ITEM.get()),
        ModItems.ZINC_INGOT.get(),
        0.7f,
        80)
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer, "zinc_ingot_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.SILVER_ORE_ITEM.get()),
        ModItems.SILVER_INGOT.get(),
        0.7f,
        100)
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer, "silver_ingot_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.LEAD_ORE_ITEM.get()),
        ModItems.LEAD_INGOT.get(),
        0.7f,
        80)
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer, "lead_ingot_from_blasting");

    EssentialsCookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        new ItemStack(ModItems.MYTHERINE_NUGGET.get(), 2),
        1.0f,
        1000)
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_ingot_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModItems.COIN_COPPER.get()),
        ModItems.COPPER_NUGGET.get(),
        0.35f,
        100)
        .addCriterion("has_copper_coin", hasItem(ModItems.COIN_COPPER.get()))
        .build(consumer, "copper_coin_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModItems.COIN_SILVER.get()),
        ModItems.SILVER_NUGGET.get(),
        0.35f,
        100)
        .addCriterion("has_silver_coin", hasItem(ModItems.COIN_SILVER.get()))
        .build(consumer, "silver_coin_from_blasting");

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModItems.COIN_GOLD.get()),
        Items.GOLD_NUGGET,
        0.35f,
        100)
        .addCriterion("has_gold_coin", hasItem(ModItems.COIN_GOLD.get()))
        .build(consumer, "gold_coin_from_blasting");
  }
}
