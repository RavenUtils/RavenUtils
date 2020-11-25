package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class AlloyFurnaceRecipes extends EssentialsRecipeProvider {


    public AlloyFurnaceRecipes(Consumer<IFinishedRecipe> consumer) {
        super(consumer);
    }

    @Override
    public void init() {

    }
}
