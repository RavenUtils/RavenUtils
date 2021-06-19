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

    ShapelessRecipeBuilder.shapeless(Items.ACACIA_PLANKS, 6)
        .requires(Items.ACACIA_LOG)
        .requires(handsaws)
        .unlockedBy("has_acacia_log", hasItem(Items.ACACIA_LOG))
        .save(consumer, "acacia_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.ACACIA_SLAB, 3)
        .requires(Items.ACACIA_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_acacia_planks", hasItem(Items.ACACIA_PLANKS))
        .save(consumer, "acacia_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.BIRCH_PLANKS, 6)
        .requires(Items.BIRCH_LOG)
        .requires(handsaws)
        .unlockedBy("has_birch_log", hasItem(Items.BIRCH_LOG))
        .save(consumer, "birch_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.BIRCH_SLAB, 3)
        .requires(Items.BIRCH_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_birch_planks", hasItem(Items.BIRCH_PLANKS))
        .save(consumer, "birch_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.DARK_OAK_PLANKS, 6)
        .requires(Items.DARK_OAK_LOG)
        .requires(handsaws)
        .unlockedBy("has_dark_oak_log", hasItem(Items.DARK_OAK_LOG))
        .save(consumer, "dark_oak_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.DARK_OAK_SLAB, 3)
        .requires(Items.DARK_OAK_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_dark_oak_planks", hasItem(Items.DARK_OAK_PLANKS))
        .save(consumer, "dark_oak_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.JUNGLE_PLANKS, 6)
        .requires(Items.JUNGLE_LOG)
        .requires(handsaws)
        .unlockedBy("has_jungle_log", hasItem(Items.JUNGLE_LOG))
        .save(consumer, "jungle_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.JUNGLE_SLAB, 3)
        .requires(Items.JUNGLE_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_jungle_planks", hasItem(Items.JUNGLE_PLANKS))
        .save(consumer, "jungle_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.OAK_PLANKS, 6)
        .requires(Items.OAK_LOG)
        .requires(handsaws)
        .unlockedBy("has_oak_log", hasItem(Items.OAK_LOG))
        .save(consumer, "oak_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.OAK_SLAB, 3)
        .requires(Items.OAK_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_oak_planks", hasItem(Items.OAK_PLANKS))
        .save(consumer, "oak_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.SPRUCE_PLANKS, 6)
        .requires(Items.SPRUCE_LOG)
        .requires(handsaws)
        .unlockedBy("has_spruce_log", hasItem(Items.SPRUCE_LOG))
        .save(consumer, "spruce_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.SPRUCE_SLAB, 3)
        .requires(Items.SPRUCE_PLANKS)
        .requires(handsaws)
        .unlockedBy("has_spruce_planks", hasItem(Items.SPRUCE_PLANKS))
        .save(consumer, "spruce_slabs_with_handsaw");

    ShapelessRecipeBuilder.shapeless(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(), 6)
        .requires(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .requires(handsaws)
        .unlockedBy("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .save(consumer, "crimwood_planks_with_handsaw");

    ShapelessRecipeBuilder.shapeless(ModBlockItems.CRIMWOOD_SLAB_ITEM.get(), 3)
        .requires(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .requires(handsaws)
        .unlockedBy("has_crimwood_planks", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer, "crimwood_slab_with_handsaw");

    ShapelessRecipeBuilder.shapeless(Items.STICK, 8)
        .requires(ItemTags.WOODEN_SLABS)
        .requires(handsaws)
        .unlockedBy("has_slab", hasItemTag(ItemTags.WOODEN_SLABS))
        .save(consumer, "sticks_with_handsaw");

  }
}
