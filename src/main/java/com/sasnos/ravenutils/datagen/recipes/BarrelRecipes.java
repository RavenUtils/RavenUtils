package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.builders.BarrelRecipeBuilder;
import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
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
    new BarrelRecipeBuilder(20)
        .addFluidIntake(new FluidStack(Fluids.WATER, 200))
        .addItemIntake(new ItemStack(Items.WHEAT_SEEDS))
        .addItemOutput(new ItemStack(ModItems.STEEL_NUGGET.get()))
        .addFluidOutput(ModFluids.LIMEWATER.get())
        .addCriterion("has_water", EssentialsRecipe.hasItem(Items.WATER_BUCKET))
        .litClosed().build(consumer);
  }
}
