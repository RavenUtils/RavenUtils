package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.utils.blockingridient.BlockIngredient;
import com.sasnos.ravenutils.datagen.builder.RightClickInWorldRecipeBuilder;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;

import java.util.function.Consumer;

public class EssentialsRecipe extends RecipeProvider {
  public EssentialsRecipe(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
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

    new RightClickInWorldRecipeBuilder(Ingredient.of(Items.FLINT),
            new ItemStack(ModItems.FLINT_SHARD.get(), 2),
            BlockIngredient.fromBlockTag(BlockTags.BASE_STONE_OVERWORLD))
            .addCriterion("has_flint", hasItem(Items.FLINT))
            .build(consumer);

    new RightClickInWorldRecipeBuilder(Ingredient.of(Items.STONE_AXE),
            new ItemStack(ModItems.BARK_SPRUCE.get(), 1),
            BlockIngredient.fromBlocks(Blocks.SPRUCE_LOG))
            .addOutput(new ItemStack(ModItems.RESIN_DROP.get(), 2))
            .addCriterion("has_axe", hasItem(Items.STONE_AXE))
            .build(consumer);
  }

  // expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance hasItem(Item item) {
    return RecipeProvider.has(item);
  }

  public static ICriterionInstance hasItemTag(ITag<Item> tagItem) {
    return RecipeProvider.has(tagItem);
  }
}
