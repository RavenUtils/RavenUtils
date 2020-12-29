package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.builders.BarrelRecipeBuilder;
import com.sasnos.ravenutils.api.datagen.builders.DryingRackRecipeBuilder;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraftforge.fluids.FluidStack;

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

    new BarrelRecipeBuilder(20)
        .addFluidIntake(new FluidStack(Fluids.WATER, 200))
        .addItemIntake(new ItemStack(Items.WHEAT_SEEDS))
        .addItemOutput(new ItemStack(ModItems.STEEL_NUGGET.get()))
        .addFluidOutput(ModFluids.LIMEWATER.get())
        .addCriterion("has_water", hasItem(Items.WATER_BUCKET))
        .litClosed().build(consumer);

    new DryingRackRecipeBuilder(Ingredient.fromItems(ModItems.HIDE_TANNED.get()), 1, 200, Items.LEATHER, 1f)
        .addCriterion("has_tanned_hide", hasItem(ModItems.HIDE_TANNED.get()))
        .build(consumer, EssentialsUtils.resourceLocation("leather_from_drying"));

  }

  // expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance hasItem(Item item) {
    return RecipeProvider.hasItem(item);
  }

  public static ICriterionInstance hasItemTag(ITag<Item> tagItem) {
    return RecipeProvider.hasItem(tagItem);
  }
}
