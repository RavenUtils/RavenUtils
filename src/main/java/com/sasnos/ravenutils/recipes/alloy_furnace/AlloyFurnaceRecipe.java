package com.sasnos.ravenutils.recipes.alloy_furnace;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.CommonRecipe;
import com.sasnos.ravenutils.api.recipes.Material;
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

public class AlloyFurnaceRecipe extends CommonRecipe {

  public static final IRecipeType<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_TYPE = IRecipeType.register(RavenUtils.MOD_ID + ":alloy_furnace");

  private final NonNullList<Material> input;
  private final ItemStack additionalResult;
  private final float additionalChance;


  public AlloyFurnaceRecipe(ResourceLocation id, NonNullList<Material> input, ItemStack output, int time, ItemStack additional, float change) {
    super(id, ALLOY_FURNACE_RECIPE_TYPE, null, time, NonNullList.from(ItemStack.EMPTY, output), 0);
    this.input = input;
    this.additionalResult = additional;
    this.additionalChance = change;
  }

  public NonNullList<Material> getInput() {
    return input;
  }

  @Override
  public int getTimer() {
    return timer;
  }

  @Override
  public boolean matches(RecipeWrapper inv, @NotNull World worldIn) {
    for (Material material : input) {
      if (!(material.test(inv.getStackInSlot(0)) || material.test(inv.getStackInSlot(1)))) {
        return false;
      }
    }
    return true;
  }



  @NotNull
  @Override
  public NonNullList<Ingredient> getIngredients() {
    NonNullList<Ingredient> allIngredients = NonNullList.create();
    input.stream().map(m -> m.ingredient).forEach(allIngredients::add);
    return allIngredients;
  }

  @NotNull
  @Override
  public ItemStack getCraftingResult(@NotNull RecipeWrapper inv) {
    return getRecipeOutput().copy();
  }


  public ItemStack getAdditionalResult() {
    return additionalResult;
  }

  public float getAdditionalChance() {
    return additionalChance;
  }

  @NotNull
  @Override
  public IRecipeSerializer<?> getSerializer() {
    return ModRecipes.ALLOY_FURNACE_RECIPE_SERIALIZER.get();
  }
}
