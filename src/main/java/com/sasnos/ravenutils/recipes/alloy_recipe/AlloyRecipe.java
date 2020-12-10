package com.sasnos.ravenutils.recipes.alloy_recipe;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.api.recipes.Material;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class AlloyRecipe extends EssentialsRecipe {

  public static final ResourceLocation ALLOY_FURNACE = new ResourceLocation(RavenUtils.MOD_ID, "alloy_furnace");
  private final ItemStack output;
  private final NonNullList<Material> input;
  private final int timer;
  private final ItemStack additionalResult;
  private final float additionalChance;


  public AlloyRecipe(ResourceLocation id, NonNullList<Material> input, ItemStack output, int time, ItemStack additional, float change) {
    super(id);
    this.output = output;
    this.input = input;
    this.timer = time;
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

  @NotNull
  @Override
  public ResourceLocation getTypeId() {
    return ALLOY_FURNACE;
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

  @NotNull
  @Override
  public ItemStack getRecipeOutput() {
    return output;
  }

  @Override
  public NonNullList<ItemStack> getOutput() {
    ArrayList<ItemStack> outputs = new ArrayList<>();
    outputs.add(output.copy());
    if (additionalResult != ItemStack.EMPTY) {
      float change = new Random().nextFloat();
      if (change <= additionalChance) {
        outputs.add(additionalResult.copy());
      }
    }
    NonNullList<ItemStack> list = NonNullList.create();
    list.addAll(outputs);
    return list;
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
