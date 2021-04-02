package com.sasnos.ravenutils.datagen.recipes;


import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class EssentialsStoneCuttingRecipes extends EssentialsRecipeProvider {
  public EssentialsStoneCuttingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // todo implement functionality to add stonecutting recipes
  }
}
