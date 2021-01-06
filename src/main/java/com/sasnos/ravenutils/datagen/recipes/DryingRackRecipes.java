package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.builders.DryingRackRecipeBuilder;
import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class DryingRackRecipes extends EssentialsRecipeProvider {

  public DryingRackRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    new DryingRackRecipeBuilder(Ingredient.fromItems(ModItems.HIDE_TANNED.get()), 1, 200, Items.LEATHER, 1f)
        .addCriterion("has_tanned_hide", EssentialsRecipe.hasItem(ModItems.HIDE_TANNED.get()))
        .build(consumer, EssentialsUtils.resourceLocation("leather_from_drying"));
  }
}
