package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.datagen.tags.EssentialsItemTags;
import com.sasnos.ravenutils.init.*;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
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
    new EssentialsMetalsCraftingRecipes(consumer);
  }

  // expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance hasItem(Item item) {
    return hasItem(item);
  }

  public static ICriterionInstance hasItemTag(ITag<Item> tagItem) {
    return hasItem(tagItem);
  }
}
