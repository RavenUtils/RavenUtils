package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.datagen.builder.DryingRackRecipeBuilder;
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
    new DryingRackRecipeBuilder(Ingredient.of(ModItems.PLANT_FIBRE.get()), 1, 200, ModItems.DRIED_PLANT_FIBRE.get(), 0.1f)
        .addCriterion("has_plant_fibre", EssentialsRecipe.hasItem(ModItems.PLANT_FIBRE.get()))
        .build(consumer, EssentialsUtils.resourceLocation("dried_plant_fibre_from_drying"));

    new DryingRackRecipeBuilder(Ingredient.of(ModItems.MUD_BRICK.get()), 1, 1800, ModItems.MUD_BRICK_DRIED.get(), 0.2f)
        .addCriterion("has_mud_brick", EssentialsRecipe.hasItem(ModItems.MUD_BRICK.get()))
        .build(consumer, EssentialsUtils.resourceLocation("mud_brick_from_drying"));

    new DryingRackRecipeBuilder(Ingredient.of(ModItems.HIDE_TANNED.get()), 1, 1200, Items.LEATHER, 1f)
        .addCriterion("has_tanned_hide", EssentialsRecipe.hasItem(ModItems.HIDE_TANNED.get()))
        .build(consumer, EssentialsUtils.resourceLocation("leather_from_drying"));
  }
}
