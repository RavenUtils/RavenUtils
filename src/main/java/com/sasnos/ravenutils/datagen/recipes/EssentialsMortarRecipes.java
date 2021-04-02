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
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHARCOAL_DUST.get())
        .addIngredient(Items.CHARCOAL)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COAL_DUST.get())
        .addIngredient(Items.COAL)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COAL_DUST.get(), 2)
        .addIngredient(ModItems.BLACK_COAL.get())
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "coal_dust_from_black_coal");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAVEN_EYE_DUST.get())
        .addIngredient(ModItems.RAVEN_EYE_GEM.get())
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.QUARTZ_SAND.get())
        .addIngredient(Items.QUARTZ)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SUGAR, 2)
        .addIngredient(Items.SUGAR_CANE)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SALT.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "salt_from_mortar");

    ShapelessRecipeBuilder.shapelessRecipe(ModFoodItems.WHEAT_FLOUR.get(), 2)
        .addIngredient(Items.WHEAT)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BLACK_DYE, 2)
        .addIngredient(Items.WITHER_ROSE)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BLUE_DYE, 2)
        .addIngredient(Items.CORNFLOWER)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_BLUE_DYE, 2)
        .addIngredient(Items.BLUE_ORCHID)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.AZURE_BLUET)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.OXEYE_DAISY)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "gray_dye_from_daisy");

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.WHITE_TULIP)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "gray_dye_from_tulip");

    ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 2)
        .addIngredient(Items.ALLIUM)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 4)
        .addIngredient(Items.LILAC)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "magenta_dye_lilac");

    ShapelessRecipeBuilder.shapelessRecipe(Items.ORANGE_DYE, 2)
        .addIngredient(Items.ORANGE_TULIP)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.PINK_DYE, 4)
        .addIngredient(Items.PEONY)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.PINK_DYE, 2)
        .addIngredient(Items.PINK_TULIP)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "pink_dye_from_tulip");

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 2)
        .addIngredient(Items.POPPY)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 4)
        .addIngredient(Items.ROSE_BUSH)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "red_dye_from_rose");

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 2)
        .addIngredient(Items.RED_TULIP)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer, "red_dye_from_tulip");

    ShapelessRecipeBuilder.shapelessRecipe(Items.WHITE_DYE, 2)
        .addIngredient(Items.LILY_OF_THE_VALLEY)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.YELLOW_DYE, 2)
        .addIngredient(Items.DANDELION)
        .addIngredient(mortars)
        .addCriterion("has_mortar", hasItemTag(mortars))
        .build(consumer);
  }
}
