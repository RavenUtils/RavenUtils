package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datageneration.recipies.EssentialsRecipeProvider;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class EssentialsCraftingRecipes extends EssentialsRecipeProvider {


  public EssentialsCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

    @Override
    public void init() {
        ShapelessRecipeBuilder.shapelessRecipe(Items.WOODEN_AXE)
                .addCriterion("dummy", EssentialsRecipe.externalHasItem(Items.BEDROCK))
                .build(consumer);
    }
}
