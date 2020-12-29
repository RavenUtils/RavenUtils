package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.builders.EssentialsSmithingRecipeBuilder;
import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsSmithingRecipes extends EssentialsRecipeProvider {
  public EssentialsSmithingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    /*EssentialsSmithingRecipeBuilder.smithingRecipe(Items.NETHERITE_SHOVEL, ModItems.MYTHERINE_INGOT.get(), ModToolItems.MYTHERINE_SHOVEL.get())
        .addCriterion("has_netherite_shovel", hasItem(Items.NETHERITE_SHOVEL))
        .build(consumer);

    EssentialsSmithingRecipeBuilder.smithingRecipe(Items.NETHERITE_AXE, ModItems.MYTHERINE_INGOT.get(), ModToolItems.MYTHERINE_AXE.get())
        .addCriterion("has_netherite_axe", hasItem(Items.NETHERITE_AXE))
        .build(consumer);

    EssentialsSmithingRecipeBuilder.smithingRecipe(Items.NETHERITE_PICKAXE, ModItems.MYTHERINE_INGOT.get(), ModToolItems.MYTHERINE_PICKAXE.get())
        .addCriterion("has_netherite_pickaxe", hasItem(Items.NETHERITE_PICKAXE))
        .build(consumer);

    EssentialsSmithingRecipeBuilder.smithingRecipe(Items.NETHERITE_HOE, ModItems.MYTHERINE_INGOT.get(), ModToolItems.MYTHERINE_HOE.get())
        .addCriterion("has_netherite_hoe", hasItem(Items.NETHERITE_HOE))
        .build(consumer);*/
  }
}