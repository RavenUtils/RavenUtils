package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
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

    ShapelessRecipeBuilder.shapeless(Items.ACACIA_PLANKS, 3)
        .requires(Items.ACACIA_LOG)
        .requires(axes)
        .unlockedBy("has_acacia_log", hasItem(Items.ACACIA_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.ACACIA_SLAB, 2)
        .requires(Items.ACACIA_PLANKS)
        .requires(axes)
        .unlockedBy("has_acacia_planks", hasItem(Items.ACACIA_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.BIRCH_PLANKS, 3)
        .requires(Items.BIRCH_LOG)
        .requires(axes)
        .unlockedBy("has_birch_log", hasItem(Items.BIRCH_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.BIRCH_SLAB, 2)
        .requires(Items.BIRCH_PLANKS)
        .requires(axes)
        .unlockedBy("has_birch_planks", hasItem(Items.BIRCH_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.DARK_OAK_PLANKS, 3)
        .requires(Items.DARK_OAK_LOG)
        .requires(axes)
        .unlockedBy("has_dark_oak_log", hasItem(Items.DARK_OAK_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.DARK_OAK_SLAB, 2)
        .requires(Items.DARK_OAK_PLANKS)
        .requires(axes)
        .unlockedBy("has_dark_oak_planks", hasItem(Items.DARK_OAK_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.JUNGLE_PLANKS, 3)
        .requires(Items.JUNGLE_LOG)
        .requires(axes)
        .unlockedBy("has_jungle_log", hasItem(Items.JUNGLE_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.JUNGLE_SLAB, 2)
        .requires(Items.JUNGLE_PLANKS)
        .requires(axes)
        .unlockedBy("has_jungle_planks", hasItem(Items.JUNGLE_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.OAK_PLANKS, 3)
        .requires(Items.OAK_LOG)
        .requires(axes)
        .unlockedBy("has_oak_log", hasItem(Items.OAK_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.OAK_SLAB, 2)
        .requires(Items.OAK_PLANKS)
        .requires(axes)
        .unlockedBy("has_oak_planks", hasItem(Items.OAK_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.SPRUCE_PLANKS, 3)
        .requires(Items.SPRUCE_LOG)
        .requires(axes)
        .unlockedBy("has_spruce_log", hasItem(Items.SPRUCE_LOG))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.SPRUCE_SLAB, 2)
        .requires(Items.SPRUCE_PLANKS)
        .requires(axes)
        .unlockedBy("has_spruce_planks", hasItem(Items.SPRUCE_PLANKS))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(), 3)
        .requires(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .requires(axes)
        .unlockedBy("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModBlockItems.CRIMWOOD_SLAB_ITEM.get(), 2)
        .requires(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .requires(axes)
        .unlockedBy("has_crimwood_planks", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.STICK, 4)
        .requires(planks)
        .requires(axes)
        .unlockedBy("has_planks", hasItemTag(planks))
        .save(consumer);

  }
}
