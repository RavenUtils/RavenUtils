package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsCookingRecipeBuilder;
import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
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
    CookingRecipeBuilder.blasting(
        Ingredient.of(ModBlockItems.COPPER_ORE_ITEM.get()),
        ModItems.COPPER_INGOT.get(),
        0.7f,
        100)
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer, "copper_ingot_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModBlockItems.TIN_ORE_ITEM.get()),
        ModItems.TIN_INGOT.get(),
        0.7f,
        80)
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer, "tin_ingot_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModBlockItems.ZINC_ORE_ITEM.get()),
        ModItems.ZINC_INGOT.get(),
        0.7f,
        80)
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer, "zinc_ingot_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModBlockItems.SILVER_ORE_ITEM.get()),
        ModItems.SILVER_INGOT.get(),
        0.7f,
        100)
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer, "silver_ingot_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModBlockItems.LEAD_ORE_ITEM.get()),
        ModItems.LEAD_INGOT.get(),
        0.7f,
        80)
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer, "lead_ingot_from_blasting");

    EssentialsCookingRecipeBuilder.blastingRecipe(
        Ingredient.of(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        new ItemStack(ModItems.MYTHERINE_NUGGET.get(), 2),
        1.0f,
        1000)
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_ingot_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModItems.COIN_COPPER.get()),
        ModItems.COPPER_NUGGET.get(),
        0.35f,
        100)
        .unlockedBy("has_copper_coin", hasItem(ModItems.COIN_COPPER.get()))
        .save(consumer, "copper_coin_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModItems.COIN_SILVER.get()),
        ModItems.SILVER_NUGGET.get(),
        0.35f,
        100)
        .unlockedBy("has_silver_coin", hasItem(ModItems.COIN_SILVER.get()))
        .save(consumer, "silver_coin_from_blasting");

    CookingRecipeBuilder.blasting(
        Ingredient.of(ModItems.COIN_GOLD.get()),
        Items.GOLD_NUGGET,
        0.35f,
        100)
        .unlockedBy("has_gold_coin", hasItem(ModItems.COIN_GOLD.get()))
        .save(consumer, "gold_coin_from_blasting");
  }
}
