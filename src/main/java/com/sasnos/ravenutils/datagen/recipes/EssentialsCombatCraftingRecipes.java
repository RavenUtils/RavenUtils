package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsCombatCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsCombatCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // todo move these to Combat module!

    // copper

    // bronze

    // silver

    // steel

    // mytherine
    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_CHESTPLATE.get())
        .patternLine("oco")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_CHESTPLATE)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_crimleaf", hasItem(ModBlockItems.CRIMLEAF_ITEM.get()))
        .build(consumer);
  }
}
