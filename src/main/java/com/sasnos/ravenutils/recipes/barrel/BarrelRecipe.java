package com.sasnos.ravenutils.recipes.barrel;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.CommonRecipe;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class BarrelRecipe extends CommonRecipe {
    public static final ResourceLocation BARREL = new ResourceLocation(RavenUtils.MOD_ID, "barrel_recipe");

    private final Fluid fluidOutput;

    private final FluidStack fluidInput;
    private final boolean lidClosed;

    public BarrelRecipe(ResourceLocation recipeId, Ingredient itemInput, FluidStack fluidInput, ItemStack itemOutput, Fluid fluidOutput, boolean lidClosed, int timer) {
        super(recipeId, NonNullList.from(Ingredient.EMPTY, itemInput), timer, NonNullList.from(ItemStack.EMPTY, itemOutput));
        this.fluidOutput = fluidOutput;
        this.fluidInput = fluidInput;
        this.lidClosed = lidClosed;
    }

    @Override
    public @NotNull ResourceLocation getTypeId() {
        return BARREL;
    }

    public boolean isLidClosed() {
        return lidClosed;
    }

    public Fluid getFluidOutput() {
        return fluidOutput;
    }

    public FluidStack getFluidInput() {
        return fluidInput;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return ingredients.get(0).test(inv.getStackInSlot(0));
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.BARREL_RECIPE_SERIALIZER.get();
    }
}
