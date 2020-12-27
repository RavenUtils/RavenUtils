package com.sasnos.ravenutils.recipes.drying_rack;

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

public class DryingRackRecipe extends CommonRecipe {

  public static final IRecipeType<DryingRackRecipe> DRY_RACK_RECIPE_TYPE = IRecipeType.register(RavenUtils.MOD_ID + ":dry_rack");

  public DryingRackRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, int timer, NonNullList<ItemStack> result, float xp) {
    super(id, DRY_RACK_RECIPE_TYPE, ingredients, timer, result, xp);
  }

  @Override
  public boolean matches(RecipeWrapper inv, World worldIn) {
    return getIngredients().get(0).test(inv.getStackInSlot(0));
  }

  public boolean matches(RecipeWrapper inv, int slot) {
    return getIngredients().get(0).test(inv.getStackInSlot(slot));
  }

  @Override
  public IRecipeSerializer<?> getSerializer() {
    return ModRecipes.DRY_RACK_RECIPE_SERIALIZER.get();
  }
}
