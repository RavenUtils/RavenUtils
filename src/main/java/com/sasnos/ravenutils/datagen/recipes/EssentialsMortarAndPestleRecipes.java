package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datageneration.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsMortarAndPestleRecipes extends EssentialsRecipeProvider {
  public EssentialsMortarAndPestleRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHARCOAL_DUST.get())
        .addIngredient(Items.CHARCOAL)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COAL_DUST.get())
        .addIngredient(Items.COAL)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COAL_DUST.get(), 2)
        .addIngredient(ModItems.BLACK_COAL.get())
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.QUARTZ_SAND.get())
        .addIngredient(Items.QUARTZ)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SUGAR, 2)
        .addIngredient(Items.SUGAR_CANE)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SALT.get(), 2)
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModFoodItems.WHEAT_FLOUR.get(), 2)
        .addIngredient(Items.WHEAT)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BLACK_DYE, 2)
        .addIngredient(Items.WITHER_ROSE)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.BLUE_DYE, 2)
        .addIngredient(Items.CORNFLOWER)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_BLUE_DYE, 2)
        .addIngredient(Items.BLUE_ORCHID)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.AZURE_BLUET)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.OXEYE_DAISY)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
        .addIngredient(Items.WHITE_TULIP)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 2)
        .addIngredient(Items.ALLIUM)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 4)
        .addIngredient(Items.LILAC)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.ORANGE_DYE, 2)
        .addIngredient(Items.ORANGE_TULIP)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.PINK_DYE, 4)
        .addIngredient(Items.PEONY)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.PINK_DYE, 2)
        .addIngredient(Items.PINK_TULIP)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 2)
        .addIngredient(Items.POPPY)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 4)
        .addIngredient(Items.ROSE_BUSH)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.RED_DYE, 2)
        .addIngredient(Items.RED_TULIP)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.WHITE_DYE, 2)
        .addIngredient(Items.LILY_OF_THE_VALLEY)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.YELLOW_DYE, 2)
        .addIngredient(Items.DANDELION)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .build(consumer);
  }
}
