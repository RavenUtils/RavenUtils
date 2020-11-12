package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.datagen.tags.EssentialsItemTags;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class EssentialsRecipe extends RecipeProvider {

  public EssentialsRecipe(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

    new EssentialsCraftingRecipes(consumer);
    new EssentialsCookingRecipes(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
        .addIngredient(Items.STONE)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItem(EssentialsItemTags.hammers))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_CHESTPLATE.get()) //TODO: change Item for now it is a test
        .patternLine("oxo")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_CHESTPLATE)
        .addCriterion("has_netherite_chestplate", hasItem(Items.NETHERITE_CHESTPLATE))
        .build(consumer);

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.LADDER),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_ladder", hasItem(Items.LADDER))
        .build(consumer);

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        ModItems.MYTHERINE_NUGGET.get(),
        0.1f,
        800)
        .addCriterion("has_raven_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        600,
        IRecipeSerializer.CAMPFIRE_COOKING)
        .addCriterion("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .build(consumer);

    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        100,
        IRecipeSerializer.SMOKING);


  }
}
