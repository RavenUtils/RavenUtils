package com.sasnos.ravenutils.datagen.recipes;

import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

import java.util.function.Consumer;

public class EssentialsRecipe extends RecipeProvider {
  public EssentialsRecipe(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    new EssentialsCraftingRecipes(consumer);
    new EssentialsSmeltingRecipes(consumer);
    new EssentialsBlastingRecipes(consumer);
    new EssentialsSmokingRecipes(consumer);
    new EssentialsCampfireCookingRecipes(consumer);

    new EssentialsMortarAndPestleRecipes(consumer);
    new EssentialsMetalCraftingRecipes(consumer);
    new CombatCraftingRecipes(consumer);
  }

  // expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance hasItem(Item item) {
    return hasItem(item);
  }

  public static ICriterionInstance hasItemTag(ITag<Item> tagItem) {
    return hasItem(tagItem);
  }
}
