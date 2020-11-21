package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsCookingRecipeBuilder;
import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.grasses_tall;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.saplings;

public class EssentialsSmeltingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmeltingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // food
    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        200)
        .addCriterion("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .build(consumer, "cooked_bushmeat_from_smelting");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModFoodItems.DOUGH.get()),
        Items.BREAD,
        0.35f,
        200)
        .addCriterion("has_dough", hasItem(ModFoodItems.DOUGH.get()))
        .build(consumer, "bread_from_smelting");

    // ores
    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.COPPER_ORE_ITEM.get()),
        ModItems.COPPER_INGOT.get(),
        0.7f,
        200)
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer, "copper_ingot_from_smelting");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.TIN_ORE_ITEM.get()),
        ModItems.TIN_INGOT.get(),
        0.7f,
        150)
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer, "tin_ingot_from_smelting");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.ZINC_ORE_ITEM.get()),
        ModItems.ZINC_INGOT.get(),
        0.7f,
        150)
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer, "zinc_ingot_from_smelting");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.SILVER_ORE_ITEM.get()),
        ModItems.SILVER_INGOT.get(),
        0.7f,
        200)
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer, "silver_ingot_from_smelting");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.LEAD_ORE_ITEM.get()),
        ModItems.LEAD_INGOT.get(),
        0.7f,
        150)
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer, "lead_ingot_from_smelting");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        new ItemStack(ModItems.MYTHERINE_NUGGET.get(), 2),
        1.0f,
        1200)
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_ingot_from_smelting");

    // miscellaneous
    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModItems.BUCKET_CLAY_UNFIRED.get()),
        ModToolItems.BUCKET_CLAY.get(),
        0.25f,
        450)
        .addCriterion("has_unfired_clay_bucket", hasItem(ModItems.BUCKET_CLAY_UNFIRED.get()))
        .build(consumer);

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.BOOK),
        new ItemStack(ModItems.ASH.get(), 3),
        0.1f,
        120)
        .addCriterion("has_book", hasItem(Items.BOOK))
        .build(consumer);

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.FILLED_MAP),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_map", hasItem(Items.MAP))
        .build(consumer, "ash_from_smelting_filled_map");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.LADDER),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_map", hasItem(Items.MAP))
        .build(consumer, "ash_from_smelting_ladder");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromTag(ItemTags.LEAVES),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_leaves", hasItemTag(ItemTags.LEAVES))
        .build(consumer, "ash_from_smelting_leaves");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.MAP),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_map", hasItem(Items.MAP))
        .build(consumer, "ash_from_smelting_map");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.PAPER),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_paper", hasItem(Items.PAPER))
        .build(consumer, "ash_from_smelting_paper");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromTag(grasses_tall),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_tall_grass", hasItemTag(grasses_tall))
        .build(consumer, "ash_from_smelting_tall_grass");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromTag(saplings),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_sapling", hasItemTag(saplings))
        .build(consumer, "ash_from_smelting_sapling");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.SCAFFOLDING),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_scaffolding", hasItem(Items.SCAFFOLDING))
        .build(consumer, "ash_from_smelting_scaffolding");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromTag(Tags.Items.RODS_WOODEN),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_stick", hasItemTag(Tags.Items.RODS_WOODEN))
        .build(consumer, "ash_from_smelting_stick");

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModItems.COIN_COPPER.get()),
        ModItems.COPPER_NUGGET.get(),
        0.35f,
        200)
        .addCriterion("has_copper_coin", hasItem(ModItems.COIN_COPPER.get()))
        .build(consumer);

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModItems.COIN_SILVER.get()),
        ModItems.SILVER_NUGGET.get(),
        0.35f,
        200)
        .addCriterion("has_silver_coin", hasItem(ModItems.COIN_SILVER.get()))
        .build(consumer);

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModItems.COIN_GOLD.get()),
        Items.GOLD_NUGGET,
        0.35f,
        200)
        .addCriterion("has_gold_coin", hasItem(ModItems.COIN_GOLD.get()))
        .build(consumer);
  }
}
