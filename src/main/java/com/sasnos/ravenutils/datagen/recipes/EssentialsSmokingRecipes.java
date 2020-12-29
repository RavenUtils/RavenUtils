package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModFoodItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsSmokingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmokingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        100,
        IRecipeSerializer.SMOKING)
        .addCriterion("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .build(consumer, "cooked_bushmeat_from_smoking");
  }
}
