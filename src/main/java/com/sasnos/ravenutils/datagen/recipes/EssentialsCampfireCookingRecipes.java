package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModFoodItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsCampfireCookingRecipes extends EssentialsRecipeProvider {
  public EssentialsCampfireCookingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        600,
        IRecipeSerializer.CAMPFIRE_COOKING)
        .addCriterion("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .build(consumer);

    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.DOUGH.get()),
        Items.BREAD,
        0.35f,
        600,
        IRecipeSerializer.CAMPFIRE_COOKING)
        .addCriterion("has_dough", hasItem(ModFoodItems.DOUGH.get()))
        .build(consumer);
  }
}
