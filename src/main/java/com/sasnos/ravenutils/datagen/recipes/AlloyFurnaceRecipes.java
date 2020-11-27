package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.builders.AlloyFurnaceRecipeBuilder;
import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class AlloyFurnaceRecipes extends EssentialsRecipeProvider {


    public AlloyFurnaceRecipes(Consumer<IFinishedRecipe> consumer) {
        super(consumer);
    }

    @Override
    public void init() {

        AlloyFurnaceRecipeBuilder.alloyRecipe(ModItems.BRONZE_INGOT.get(), 3, 200)
                .addMaterial(Ingredient.fromItems(ModItems.COPPER_INGOT.get()), 3)
                .addMaterial(Ingredient.fromItems(ModItems.TIN_INGOT.get()))
                .addCriterion("has_copper", EssentialsRecipe.hasItem(ModItems.COPPER_INGOT.get()))
                .addAdditionalOutput(Items.BONE, 5, 0.5f)
                .build(consumer);

    }
}
