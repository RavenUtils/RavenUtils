package com.sasnos.ravenutils.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public abstract class EssentialsRecipe implements ICommonRecipe {
  protected ResourceLocation id;

  @Override
  public ResourceLocation getId() {
    return id;
  }

  @Override
  public abstract NonNullList<Ingredient> getIngredients();

  @Override
  public ItemStack getRecipeOutput() {
    return ItemStack.EMPTY;
  }

  public boolean hasAdditionalInput(){
    return getIngredients().size() > 1;
  }
}
