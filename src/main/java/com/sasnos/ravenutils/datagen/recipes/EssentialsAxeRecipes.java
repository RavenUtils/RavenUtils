package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.axes;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.planks;

public class EssentialsAxeRecipes extends EssentialsRecipeProvider {
  public EssentialsAxeRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    ShapelessRecipeBuilder.shapelessRecipe(Items.ACACIA_PLANKS, 3)
        .addIngredient(Items.ACACIA_LOG)
        .addIngredient(axes)
        .addCriterion("has_acacia_log", hasItem(Items.ACACIA_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.ACACIA_SLAB, 2)
        .addIngredient(Items.ACACIA_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_acacia_planks", hasItem(Items.ACACIA_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BIRCH_PLANKS, 3)
        .addIngredient(Items.BIRCH_LOG)
        .addIngredient(axes)
        .addCriterion("has_birch_log", hasItem(Items.BIRCH_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BIRCH_SLAB, 2)
        .addIngredient(Items.BIRCH_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_birch_planks", hasItem(Items.BIRCH_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.DARK_OAK_PLANKS, 3)
        .addIngredient(Items.DARK_OAK_LOG)
        .addIngredient(axes)
        .addCriterion("has_dark_oak_log", hasItem(Items.DARK_OAK_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.DARK_OAK_SLAB, 2)
        .addIngredient(Items.DARK_OAK_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_dark_oak_planks", hasItem(Items.DARK_OAK_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.JUNGLE_PLANKS, 3)
        .addIngredient(Items.JUNGLE_LOG)
        .addIngredient(axes)
        .addCriterion("has_jungle_log", hasItem(Items.JUNGLE_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.JUNGLE_SLAB, 2)
        .addIngredient(Items.JUNGLE_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_jungle_planks", hasItem(Items.JUNGLE_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.OAK_PLANKS, 3)
        .addIngredient(Items.OAK_LOG)
        .addIngredient(axes)
        .addCriterion("has_oak_log", hasItem(Items.OAK_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.OAK_SLAB, 2)
        .addIngredient(Items.OAK_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_oak_planks", hasItem(Items.OAK_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SPRUCE_PLANKS, 3)
        .addIngredient(Items.SPRUCE_LOG)
        .addIngredient(axes)
        .addCriterion("has_spruce_log", hasItem(Items.SPRUCE_LOG))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SPRUCE_SLAB, 2)
        .addIngredient(Items.SPRUCE_PLANKS)
        .addIngredient(axes)
        .addCriterion("has_spruce_planks", hasItem(Items.SPRUCE_PLANKS))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(), 3)
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(axes)
        .addCriterion("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_SLAB_ITEM.get(), 2)
        .addIngredient(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addIngredient(axes)
        .addCriterion("has_crimwood_planks", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.STICK, 4)
        .addIngredient(planks)
        .addIngredient(axes)
        .addCriterion("has_planks", hasItemTag(planks))
        .build(consumer);

  }
}
