package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.builders.AlloyFurnaceRecipeBuilder;
import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class AlloyFurnaceRecipes extends EssentialsRecipeProvider {

  public AlloyFurnaceRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    // alloys and refinements from ingots
    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRONZE_INGOT.get(), 4, 200)
        .addMaterial(Ingredient.fromItems(ModItems.COPPER_INGOT.get()), 3)
        .addMaterial(Ingredient.fromItems(ModItems.TIN_INGOT.get()))
        .addCriterion("has_copper_ingot", EssentialsRecipe.hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer, new ResourceLocation("bronze_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRASS_INGOT.get(), 4, 200)
        .addMaterial(Ingredient.fromItems(ModItems.COPPER_INGOT.get()), 3)
        .addMaterial(Ingredient.fromItems(ModItems.ZINC_INGOT.get()))
        .addCriterion("has_copper_ingot", EssentialsRecipe.hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer, new ResourceLocation("brass_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.STEEL_INGOT.get(), 1, 300)
        .addMaterial(Ingredient.fromItems(Items.IRON_INGOT))
        .addMaterial(Ingredient.fromItems(ModItems.COAL_DUST.get()), 3)
        .addCriterion("has_iron_ingot", EssentialsRecipe.hasItem(Items.IRON_INGOT))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("steel_from_alloy_furnace"));

    // alloys from ores
    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRONZE_INGOT.get(), 3, 300)
        .addMaterial(Ingredient.fromItems(ModBlockItems.COPPER_ORE_ITEM.get()), 3)
        .addMaterial(Ingredient.fromItems(ModBlockItems.TIN_ORE_ITEM.get()))
        .addCriterion("has_copper_ore", EssentialsRecipe.hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 2, 0.75f)
        .build(consumer, new ResourceLocation("bronze_from_ore_in_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRASS_INGOT.get(), 3, 300)
        .addMaterial(Ingredient.fromItems(ModBlockItems.COPPER_ORE_ITEM.get()), 3)
        .addMaterial(Ingredient.fromItems(ModBlockItems.ZINC_ORE_ITEM.get()))
        .addCriterion("has_copper_ore", EssentialsRecipe.hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 2, 0.75f)
        .build(consumer, new ResourceLocation("brass_from_ore_in_alloy_furnace"));

    // common smelting with sand
    AlloyFurnaceRecipeBuilder.alloyRecipe(Items.IRON_INGOT, 2, 200)
        .addMaterial(Ingredient.fromItems(Items.IRON_ORE))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_iron_ore", EssentialsRecipe.hasItem(Items.IRON_ORE))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("iron_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(Items.GOLD_INGOT, 2, 200)
        .addMaterial(Ingredient.fromItems(Items.GOLD_ORE))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_gold_ore", EssentialsRecipe.hasItem(Items.GOLD_ORE))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("gold_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.COPPER_INGOT.get(), 2, 200)
        .addMaterial(Ingredient.fromItems(ModBlockItems.COPPER_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_copper_ore", EssentialsRecipe.hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("copper_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.TIN_INGOT.get(), 2, 150)
        .addMaterial(Ingredient.fromItems(ModBlockItems.TIN_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_tin_ore", EssentialsRecipe.hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("tin_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.ZINC_INGOT.get(), 2, 150)
        .addMaterial(Ingredient.fromItems(ModBlockItems.ZINC_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_zinc_ore", EssentialsRecipe.hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("zinc_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.LEAD_INGOT.get(), 2, 150)
        .addMaterial(Ingredient.fromItems(ModBlockItems.LEAD_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_lead_ore", EssentialsRecipe.hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("lead_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.SILVER_INGOT.get(), 2, 200)
        .addMaterial(Ingredient.fromItems(ModBlockItems.SILVER_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_silver_ore", EssentialsRecipe.hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("silver_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.MYTHERINE_NUGGET.get(), 2, 1200)
        .addMaterial(Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .addMaterial(Ingredient.fromTag(Tags.Items.SAND))
        .addCriterion("has_mytherine_ore", EssentialsRecipe.hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("mytherine_from_alloy_furnace"));
  }
}
