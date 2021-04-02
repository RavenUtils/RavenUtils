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

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEATHER_STRIP.get(), 4)
        .addIngredient(Items.LEATHER)
        .addIngredient(knives)
        .addCriterion("has_leather", hasItem(Items.LEATHER))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BUCKET_CLAY_UNFIRED.get())
        .addIngredient(Items.CLAY)
        .addIngredient(knives)
        .addCriterion("has_clay", hasItem(Items.CLAY))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_WOOD.get())
        .addIngredient(ItemTags.LOGS_THAT_BURN)
        .addIngredient(knives)
        .addCriterion("has_wooden_log", hasItemTag(ItemTags.LOGS_THAT_BURN))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModToolItems.BUCKET_CRIMWOOD.get())
        .addIngredient(ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addIngredient(knives)
        .addCriterion("has_crimwood_log", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .setGroup("buckets")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 3)
        .addIngredient(saplings)
        .addIngredient(knives)
        .addCriterion("has_sapling", hasItemTag(saplings))
        .build(consumer, "plant_fibre_from_saplings");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 2)
        .addIngredient(ModBlockItems.REEDS_ITEM.get())
        .addIngredient(knives)
        .addCriterion("has_reeds", hasItem(ModBlockItems.REEDS_ITEM.get()))
        .build(consumer, "plant_fibre_from_reeds");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.PLANT_FIBRE.get(), 1)
        .addIngredient(barks)
        .addIngredient(knives)
        .addCriterion("has_bark", hasItemTag(barks))
        .build(consumer, "plant_fibre_from_barks");

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 4)
        .addIngredient(ItemTags.WOOL)
        .addIngredient(knives)
        .addCriterion("has_knife", hasItemTag(knives))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 9)
        .addIngredient(ModItems.CLOTH.get())
        .addIngredient(knives)
        .addCriterion("has_cloth", hasItem(ModItems.CLOTH.get()))
        .build(consumer, "string_from_knife");

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_BONE.get(), 2)
        .patternLine("h")
        .patternLine("i")
        .key('h', knives)
        .key('i', Items.BONE)
        .addCriterion("has_knife", hasItemTag(knives))
        .setGroup("sewing_needles")
        .build(consumer);

  }
}
