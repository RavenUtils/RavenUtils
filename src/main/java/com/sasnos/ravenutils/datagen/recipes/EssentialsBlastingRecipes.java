package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datageneration.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsBlastingRecipes extends EssentialsRecipeProvider {
  public EssentialsBlastingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        ModItems.MYTHERINE_NUGGET.get(),
        0.1f,
        800)
        .addCriterion("has_raven_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);
  }
}
