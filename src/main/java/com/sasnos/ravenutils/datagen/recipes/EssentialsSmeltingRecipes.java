package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsCookingRecipeBuilder;
import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
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

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.grasses_tall;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.saplings;

public class EssentialsSmeltingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmeltingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // food
    CookingRecipeBuilder.smelting(
        Ingredient.of(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        200)
        .unlockedBy("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .save(consumer, "cooked_bushmeat_from_smelting");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModFoodItems.DOUGH.get()),
        Items.BREAD,
        0.35f,
        200)
        .unlockedBy("has_dough", hasItem(ModFoodItems.DOUGH.get()))
        .save(consumer, "bread_from_smelting");

    // ores
    CookingRecipeBuilder.smelting(
        Ingredient.of(ModBlockItems.COPPER_ORE_ITEM.get()),
        ModItems.COPPER_INGOT.get(),
        0.7f,
        200)
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer, "copper_ingot_from_smelting");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModBlockItems.TIN_ORE_ITEM.get()),
        ModItems.TIN_INGOT.get(),
        0.7f,
        150)
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer, "tin_ingot_from_smelting");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModBlockItems.ZINC_ORE_ITEM.get()),
        ModItems.ZINC_INGOT.get(),
        0.7f,
        150)
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer, "zinc_ingot_from_smelting");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModBlockItems.SILVER_ORE_ITEM.get()),
        ModItems.SILVER_INGOT.get(),
        0.7f,
        200)
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer, "silver_ingot_from_smelting");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModBlockItems.LEAD_ORE_ITEM.get()),
        ModItems.LEAD_INGOT.get(),
        0.7f,
        150)
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer, "lead_ingot_from_smelting");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.of(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        new ItemStack(ModItems.MYTHERINE_NUGGET.get(), 2),
        1.0f,
        1200)
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_ingot_from_smelting");

    // material
    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.UNFIRED_BRICK.get()),
        Items.BRICK,
        0.3f,
        200)
        .unlockedBy("has_unfired_brick", hasItem(ModItems.UNFIRED_BRICK.get()))
        .save(consumer);

    // miscellaneous
    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.UNFIRED_FLOWER_POT.get()),
        Items.FLOWER_POT,
        0.3f,
        200)
        .unlockedBy("has_unfired_flower_pot", hasItem(ModItems.UNFIRED_FLOWER_POT.get()))
        .save(consumer);

    /* CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(ModItems.UNFIRED_LARGE_FLOWER_POT.get()),
        ModBlockItems.LARGE_FLOWER_POT_ITEM.get(),
        0.5f,
        350)
        .addCriterion("has_unfired_large_flower_pot", hasItem(ModItems.UNFIRED_LARGE_FLOWER_POT.get()))
        .build(consumer); */

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.BUCKET_CLAY_UNFIRED.get()),
        ModToolItems.BUCKET_CLAY.get(),
        0.25f,
        450)
        .unlockedBy("has_unfired_clay_bucket", hasItem(ModItems.BUCKET_CLAY_UNFIRED.get()))
        .save(consumer);

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.of(Items.BOOK),
        new ItemStack(ModItems.ASH.get(), 3),
        0.1f,
        120)
        .addCriterion("has_book", hasItem(Items.BOOK))
        .build(consumer);

    CookingRecipeBuilder.smelting(
        Ingredient.of(Items.FILLED_MAP),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_map", hasItem(Items.MAP))
        .save(consumer, "ash_from_smelting_filled_map");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.of(Items.LADDER),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_map", hasItem(Items.MAP))
        .build(consumer, "ash_from_smelting_ladder");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.of(ItemTags.LEAVES),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_leaves", hasItemTag(ItemTags.LEAVES))
        .build(consumer, "ash_from_smelting_leaves");

    CookingRecipeBuilder.smelting(
        Ingredient.of(Items.MAP),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_map", hasItem(Items.MAP))
        .save(consumer, "ash_from_smelting_map");

    CookingRecipeBuilder.smelting(
        Ingredient.of(Items.PAPER),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_paper", hasItem(Items.PAPER))
        .save(consumer, "ash_from_smelting_paper");

    CookingRecipeBuilder.smelting(
        Ingredient.of(grasses_tall),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_tall_grass", hasItemTag(grasses_tall))
        .save(consumer, "ash_from_smelting_tall_grass");

    EssentialsCookingRecipeBuilder.smeltingRecipe(
        Ingredient.of(saplings),
        new ItemStack(ModItems.ASH.get(), 2),
        0.1f,
        60)
        .addCriterion("has_sapling", hasItemTag(saplings))
        .build(consumer, "ash_from_smelting_sapling");

    CookingRecipeBuilder.smelting(
        Ingredient.of(Items.SCAFFOLDING),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_scaffolding", hasItem(Items.SCAFFOLDING))
        .save(consumer, "ash_from_smelting_scaffolding");

    CookingRecipeBuilder.smelting(
        Ingredient.of(rods_wood),
        ModItems.ASH.get(),
        0.1f,
        60)
        .unlockedBy("has_stick", hasItemTag(rods_wood))
        .save(consumer, "ash_from_smelting_stick");

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.COIN_COPPER.get()),
        ModItems.COPPER_NUGGET.get(),
        0.35f,
        200)
        .unlockedBy("has_copper_coin", hasItem(ModItems.COIN_COPPER.get()))
        .save(consumer);

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.COIN_SILVER.get()),
        ModItems.SILVER_NUGGET.get(),
        0.35f,
        200)
        .unlockedBy("has_silver_coin", hasItem(ModItems.COIN_SILVER.get()))
        .save(consumer);

    CookingRecipeBuilder.smelting(
        Ingredient.of(ModItems.COIN_GOLD.get()),
        Items.GOLD_NUGGET,
        0.35f,
        200)
        .unlockedBy("has_gold_coin", hasItem(ModItems.COIN_GOLD.get()))
        .save(consumer);
  }
}
