package com.sasnos.ravenutils.api.recipes;

import net.minecraft.util.ResourceLocation;

public abstract class EssentialsRecipe implements ICommonRecipe {
  protected ResourceLocation id;

  @Override
  public ResourceLocation getId() {
    return id;
  }


}
