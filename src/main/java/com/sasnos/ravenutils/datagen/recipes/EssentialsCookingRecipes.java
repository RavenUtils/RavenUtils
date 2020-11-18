package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datageneration.recipies.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class EssentialsCookingRecipes extends EssentialsRecipeProvider {


  public EssentialsCookingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

  }
}
