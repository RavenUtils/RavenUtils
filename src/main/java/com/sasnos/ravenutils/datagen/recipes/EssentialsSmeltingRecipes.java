package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datageneration.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsSmeltingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmeltingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.LADDER),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_ladder", hasItem(Items.LADDER))
        .build(consumer);
  }
}
