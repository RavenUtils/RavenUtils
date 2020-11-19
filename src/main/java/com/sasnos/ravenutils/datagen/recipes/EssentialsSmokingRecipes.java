package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class EssentialsSmokingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmokingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    /*
    CookingRecipeBuilder.cookingRecipe(
        Ingredient.fromItems(ModFoodItems.BUSHMEAT.get(),
            ModFoodItems.COOKED_BUSHMEAT.get(),
            0.35f,
            100,
        IRecipeSerializer.SMOKING);
     */
  }
}
