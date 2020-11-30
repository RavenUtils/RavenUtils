package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.builders.AlloyFurnaceRecipeBuilder;
import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class AlloyFurnaceRecipes extends EssentialsRecipeProvider {

  public AlloyFurnaceRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRONZE_INGOT.get(), 3, 200)
        .addMaterial(Ingredient.fromItems(ModItems.COPPER_INGOT.get()), 3)
        .addMaterial(Ingredient.fromItems(ModItems.TIN_INGOT.get()))
        .addCriterion("has_copper_ingot", EssentialsRecipe.hasItem(ModItems.COPPER_INGOT.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("bronze_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRASS_INGOT.get(), 3, 200)
        .addMaterial(Ingredient.fromItems(ModItems.COPPER_INGOT.get()), 3)
        .addMaterial(Ingredient.fromItems(ModItems.ZINC_INGOT.get()))
        .addCriterion("has_copper_ingot", EssentialsRecipe.hasItem(ModItems.COPPER_INGOT.get()))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("brass_from_alloy_furnace"));

    AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.STEEL_INGOT.get(), 1, 300)
        .addMaterial(Ingredient.fromItems(Items.IRON_INGOT))
        .addMaterial(Ingredient.fromItems(ModItems.COAL_DUST.get()), 3)
        .addCriterion("has_iron_ingot", EssentialsRecipe.hasItem(Items.IRON_INGOT))
        .addAdditionalOutput(ModItems.SLAG.get(), 1, 0.5f)
        .build(consumer, new ResourceLocation("steel_from_alloy_furnace"));

  }
}
