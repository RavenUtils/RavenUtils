package com.sasnos.ravenutils.recipes.barrel;

import com.sasnos.raven_api.recipes.CommonRecipe;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class BarrelRecipe extends CommonRecipe {

  public static final IRecipeType<BarrelRecipe> BARREL_RECIPE_TYPE = IRecipeType.register(RavenUtils.MOD_ID + ":barrel");

  private final Fluid fluidOutput;

  private final FluidStack fluidInput;
  private final boolean lidClosed;

  public BarrelRecipe(ResourceLocation recipeId, Ingredient itemInput, FluidStack fluidInput, ItemStack itemOutput, Fluid fluidOutput, boolean lidClosed, int timer) {
    super(recipeId, BARREL_RECIPE_TYPE, NonNullList.from(Ingredient.EMPTY, itemInput), timer, NonNullList.from(ItemStack.EMPTY, itemOutput), 0);
    this.fluidOutput = fluidOutput;
    this.fluidInput = fluidInput;
    this.lidClosed = lidClosed;
  }

  public boolean isLidClosed() {
    return lidClosed;
  }

  public Fluid getFluidOutput() {
    return fluidOutput;
  }

  public FluidStack getFluidInput() {
    return fluidInput;
  }

  @Override
  public boolean matches(RecipeWrapper inv, World worldIn) {
    return ingredients.get(0).test(inv.getStackInSlot(0));
  }

  @Override
  public IRecipeSerializer<?> getSerializer() {
    return ModRecipes.BARREL_RECIPE_SERIALIZER.get();
  }
}
