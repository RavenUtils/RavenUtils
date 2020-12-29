package com.sasnos.ravenutils.recipes.hand_mill_recipe;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.CommonRecipe;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class HandMillRecipe extends CommonRecipe {

  public static final IRecipeType<HandMillRecipe> HAND_MILL_RECIPE_TYPE = IRecipeType.register(RavenUtils.MOD_ID + ":mill");

  private final float change;
  private final ItemStack additionalResult;
  private final float additionalChance;

  public HandMillRecipe(ResourceLocation id, int time, Ingredient input, float additionalDropChance, ItemStack output, ItemStack additionalResult, float additionalChance) {
    super(id, HAND_MILL_RECIPE_TYPE, NonNullList.from(Ingredient.EMPTY, input), time, NonNullList.from(ItemStack.EMPTY, output), 0);
    this.change = additionalDropChance;
    this.additionalChance = additionalChance;
    this.additionalResult = additionalResult;
  }

  @Override
  public int getTimer() {
    return timer;
  }

  @Override
  public boolean matches(RecipeWrapper inv, World worldIn) {
    return ingredients.get(0).test(inv.getStackInSlot(0));
  }

  @Override
  @NotNull
  public IRecipeSerializer<?> getSerializer() {
    return ModRecipes.HAND_MILL_RECIPE_SERIALIZER.get();
  }


  public float getAdditionalDropChange() {
    return change;
  }

  public ItemStack getAdditionalResult() {
    return additionalResult;
  }

  public float getAdditionalChance() {
    return additionalChance;
  }
}
