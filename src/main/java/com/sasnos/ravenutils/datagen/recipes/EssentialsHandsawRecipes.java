package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.handsaws;

public class EssentialsHandsawRecipes extends EssentialsRecipeProvider {
  public EssentialsHandsawRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    ShapelessRecipeBuilder.shapelessRecipe(Items.ACACIA_PLANKS, 6)
        .addIngredient(Items.ACACIA_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_acacia_log", hasItem(Items.ACACIA_LOG))
        .build(consumer, "acacia_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.ACACIA_SLAB, 3)
        .addIngredient(Items.ACACIA_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_acacia_planks", hasItem(Items.ACACIA_PLANKS))
        .build(consumer, "acacia_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.BIRCH_PLANKS, 6)
        .addIngredient(Items.BIRCH_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_birch_log", hasItem(Items.BIRCH_LOG))
        .build(consumer, "birch_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.BIRCH_SLAB, 3)
        .addIngredient(Items.BIRCH_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_birch_planks", hasItem(Items.BIRCH_PLANKS))
        .build(consumer, "birch_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.DARK_OAK_PLANKS, 6)
        .addIngredient(Items.DARK_OAK_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_dark_oak_log", hasItem(Items.DARK_OAK_LOG))
        .build(consumer, "dark_oak_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.DARK_OAK_SLAB, 3)
        .addIngredient(Items.DARK_OAK_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_dark_oak_planks", hasItem(Items.DARK_OAK_PLANKS))
        .build(consumer, "dark_oak_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.JUNGLE_PLANKS, 6)
        .addIngredient(Items.JUNGLE_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_jungle_log", hasItem(Items.JUNGLE_LOG))
        .build(consumer, "jungle_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.JUNGLE_SLAB, 3)
        .addIngredient(Items.JUNGLE_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_jungle_planks", hasItem(Items.JUNGLE_PLANKS))
        .build(consumer, "jungle_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.OAK_PLANKS, 6)
        .addIngredient(Items.OAK_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_oak_log", hasItem(Items.OAK_LOG))
        .build(consumer, "oak_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.OAK_SLAB, 3)
        .addIngredient(Items.OAK_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_oak_planks", hasItem(Items.OAK_PLANKS))
        .build(consumer, "oak_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.SPRUCE_PLANKS, 6)
        .addIngredient(Items.SPRUCE_LOG)
        .addIngredient(handsaws)
        .addCriterion("has_spruce_log", hasItem(Items.SPRUCE_LOG))
        .build(consumer, "spruce_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.SPRUCE_SLAB, 3)
        .addIngredient(Items.SPRUCE_PLANKS)
        .addIngredient(handsaws)
        .addCriterion("has_spruce_planks", hasItem(Items.SPRUCE_PLANKS))
        .build(consumer, "spruce_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(), 6)
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(handsaws)
        .addCriterion("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .build(consumer, "crimwood_planks_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_SLAB_ITEM.get(), 3)
        .addIngredient(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addIngredient(handsaws)
        .addCriterion("has_crimwood_planks", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer, "crimwood_slab_with_handsaw");

    ShapelessRecipeBuilder.shapelessRecipe(Items.STICK, 8)
        .addIngredient(ItemTags.WOODEN_SLABS)
        .addIngredient(handsaws)
        .addCriterion("has_slab", hasItemTag(ItemTags.WOODEN_SLABS))
        .build(consumer, "sticks_with_handsaw");

  }
}
