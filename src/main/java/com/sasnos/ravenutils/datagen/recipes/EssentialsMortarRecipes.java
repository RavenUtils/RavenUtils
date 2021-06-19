package com.sasnos.ravenutils.datagen.recipes;


import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.mortars;

public class EssentialsMortarRecipes extends EssentialsRecipeProvider {
  public EssentialsMortarRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    ShapelessRecipeBuilder.shapeless(ModItems.CHARCOAL_DUST.get())
        .requires(Items.CHARCOAL)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.COAL_DUST.get())
        .requires(Items.COAL)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.COAL_DUST.get(), 2)
        .requires(ModItems.BLACK_COAL.get())
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "coal_dust_from_black_coal");

    ShapelessRecipeBuilder.shapeless(ModItems.RAVEN_EYE_DUST.get())
        .requires(ModItems.RAVEN_EYE_GEM.get())
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.QUARTZ_SAND.get())
        .requires(Items.QUARTZ)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.SUGAR, 2)
        .requires(Items.SUGAR_CANE)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.SALT.get())
        .requires(ModItems.COARSE_SALT.get())
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "salt_from_mortar");

    ShapelessRecipeBuilder.shapeless(ModFoodItems.WHEAT_FLOUR.get(), 2)
        .requires(Items.WHEAT)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.BLACK_DYE, 2)
        .requires(Items.WITHER_ROSE)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.BLUE_DYE, 2)
        .requires(Items.CORNFLOWER)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.LIGHT_BLUE_DYE, 2)
        .requires(Items.BLUE_ORCHID)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_DYE, 2)
        .requires(Items.AZURE_BLUET)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_DYE, 2)
        .requires(Items.OXEYE_DAISY)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "gray_dye_from_daisy");

    ShapelessRecipeBuilder.shapeless(Items.LIGHT_GRAY_DYE, 2)
        .requires(Items.WHITE_TULIP)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "gray_dye_from_tulip");

    ShapelessRecipeBuilder.shapeless(Items.MAGENTA_DYE, 2)
        .requires(Items.ALLIUM)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.MAGENTA_DYE, 4)
        .requires(Items.LILAC)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "magenta_dye_lilac");

    ShapelessRecipeBuilder.shapeless(Items.ORANGE_DYE, 2)
        .requires(Items.ORANGE_TULIP)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.PINK_DYE, 4)
        .requires(Items.PEONY)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.PINK_DYE, 2)
        .requires(Items.PINK_TULIP)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "pink_dye_from_tulip");

    ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 2)
        .requires(Items.POPPY)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 4)
        .requires(Items.ROSE_BUSH)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "red_dye_from_rose");

    ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 2)
        .requires(Items.RED_TULIP)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer, "red_dye_from_tulip");

    ShapelessRecipeBuilder.shapeless(Items.WHITE_DYE, 2)
        .requires(Items.LILY_OF_THE_VALLEY)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.YELLOW_DYE, 2)
        .requires(Items.DANDELION)
        .requires(mortars)
        .unlockedBy("has_mortar", hasItemTag(mortars))
        .save(consumer);
  }
}
