package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.datagen.builder.BarrelRecipeBuilder;
import com.sasnos.ravenutils.init.ModFluids;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Consumer;

public class BarrelRecipes extends EssentialsRecipeProvider {

  public BarrelRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    new BarrelRecipeBuilder(0)
        .addFluidIntake(new FluidStack(Fluids.WATER, 1000))
        .addItemIntake(new ItemStack(ModItems.LIME.get(), 1))
        .addFluidOutput(ModFluids.LIMEWATER.get())
        .addCriterion("has_lime", EssentialsRecipe.hasItem(ModItems.LIME.get()))
        .lidClosed().build(consumer);

    new BarrelRecipeBuilder(1200)
        .addFluidIntake(new FluidStack(Fluids.WATER, 10000))
        .addItemIntake(new ItemStack(Items.OAK_LOG))
        .addFluidOutput(ModFluids.TANNIN.get())
        .addCriterion("has_oak_log", EssentialsRecipe.hasItem(Items.OAK_LOG))
        .lidClosed().build(consumer);

    new BarrelRecipeBuilder(3600)
        .addFluidIntake(new FluidStack(ModFluids.LIMEWATER.get(), 2000))
        .addItemIntake(new ItemStack(ModItems.HIDE_CURED.get(), 1))
        .addItemOutput(new ItemStack(ModItems.HIDE_LIMED.get(), 1))
        .addCriterion("has_cured_hide", EssentialsRecipe.hasItem(ModItems.HIDE_CURED.get()))
        .lidClosed().build(consumer);

    new BarrelRecipeBuilder(3600)
        .addFluidIntake(new FluidStack(ModFluids.TANNIN.get(), 2000))
        .addItemIntake(new ItemStack(ModItems.HIDE_SCRAPED.get(), 1))
        .addItemOutput(new ItemStack(ModItems.HIDE_TANNED.get(), 1))
        .addCriterion("has_scraped_hide", EssentialsRecipe.hasItem(ModItems.HIDE_SCRAPED.get()))
        .lidClosed().build(consumer);
  }
}
