package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.builders.MillRecipeBuilder;
import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class MillRecipes extends EssentialsRecipeProvider {

    public MillRecipes(Consumer<IFinishedRecipe> consumer) {
        super(consumer);
    }

    @Override
    public void init() {
        MillRecipeBuilder
                .millRecipe(Ingredient.fromItems(Items.WHEAT),
                        1, 10, Items.WHEAT_SEEDS, 1f)
        .addCriterion("has_wheat", EssentialsRecipe.hasItem(Items.WHEAT))
        .setAdditionalOutput(new ItemStack(Items.BONE, 5), 0.5f)
        .build(consumer);
    }
}
