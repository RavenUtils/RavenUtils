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
    new EssentialsSmithingRecipes(consumer);
    new EssentialsCampfireCookingRecipes(consumer);
    new EssentialsStoneCuttingRecipes(consumer);
    new EssentialsBuildingBlocksRecipes(consumer);
    new EssentialsMortarRecipes(consumer);
    new EssentialsHammerRecipes(consumer);
    new EssentialsKnifeRecipes(consumer);
    new EssentialsAxeRecipes(consumer);
    new EssentialsHandsawRecipes(consumer);
    new EssentialsMetalCraftingRecipes(consumer);
    new HandMillRecipes(consumer);
    new CombatCraftingRecipes(consumer);
    new AlloyFurnaceRecipes(consumer);
    new BarrelRecipes(consumer);
    new DryingRackRecipes(consumer);
  }

  // expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance hasItem(Item item) {
    return RecipeProvider.hasItem(item);
  }

  public static ICriterionInstance hasItemTag(ITag<Item> tagItem) {
    return RecipeProvider.hasItem(tagItem);
  }
}
