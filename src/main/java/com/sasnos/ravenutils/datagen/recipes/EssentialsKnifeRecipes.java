package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.barks;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.knives;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.saplings;

public class EssentialsKnifeRecipes extends EssentialsRecipeProvider {
  public EssentialsKnifeRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    ShapelessRecipeBuilder.shapeless(ModItems.LEATHER_STRIP.get(), 4)
        .requires(Items.LEATHER)
        .requires(knives)
        .unlockedBy("has_leather", hasItem(Items.LEATHER))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.BUCKET_CLAY_UNFIRED.get())
        .requires(Items.CLAY)
        .requires(knives)
        .unlockedBy("has_clay", hasItem(Items.CLAY))
        .group("buckets")
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModToolItems.BUCKET_WOOD.get())
        .requires(ItemTags.LOGS_THAT_BURN)
        .requires(knives)
        .unlockedBy("has_wooden_log", hasItemTag(ItemTags.LOGS_THAT_BURN))
        .group("buckets")
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModToolItems.BUCKET_CRIMWOOD.get())
        .requires(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .requires(knives)
        .unlockedBy("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .group("buckets")
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.PLANT_FIBRE.get(), 3)
        .requires(saplings)
        .requires(knives)
        .unlockedBy("has_sapling", hasItemTag(saplings))
        .save(consumer, "plant_fibre_from_saplings");

    ShapelessRecipeBuilder.shapeless(ModItems.PLANT_FIBRE.get(), 2)
        .requires(ModBlockItems.REEDS_ITEM.get())
        .requires(knives)
        .unlockedBy("has_reeds", hasItem(ModBlockItems.REEDS_ITEM.get()))
        .save(consumer, "plant_fibre_from_reeds");

    ShapelessRecipeBuilder.shapeless(ModItems.PLANT_FIBRE.get(), 1)
        .requires(barks)
        .requires(knives)
        .unlockedBy("has_bark", hasItemTag(barks))
        .save(consumer, "plant_fibre_from_barks");

    ShapelessRecipeBuilder.shapeless(Items.STRING, 4)
        .requires(ItemTags.WOOL)
        .requires(knives)
        .unlockedBy("has_knife", hasItemTag(knives))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.STRING, 9)
        .requires(ModItems.CLOTH.get())
        .requires(knives)
        .unlockedBy("has_cloth", hasItem(ModItems.CLOTH.get()))
        .save(consumer, "string_from_knife");

    ShapedRecipeBuilder.shaped(ModToolItems.SEWING_NEEDLE_BONE.get(), 2)
        .pattern("h")
        .pattern("i")
        .define('h', knives)
        .define('i', Items.BONE)
        .unlockedBy("has_knife", hasItemTag(knives))
        .group("sewing_needles")
        .save(consumer);

  }
}
