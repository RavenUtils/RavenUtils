package com.sasnos.ravenutils.api.data_generation.recipes;

import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public abstract class EssentialsRecipeProvider implements IEssentialRecipeProvider {

  protected Consumer<IFinishedRecipe> consumer;

  public EssentialsRecipeProvider(Consumer<IFinishedRecipe> consumer) {
    this.consumer = consumer;
    init();
  }
}
