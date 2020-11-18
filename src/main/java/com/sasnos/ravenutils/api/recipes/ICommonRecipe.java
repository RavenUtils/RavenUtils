package com.sasnos.ravenutils.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public interface ICommonRecipe extends IRecipe<RecipeWrapper> {

    @Override
    default IRecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getOptional(getTypeId()).get();//.getValue(RECIPE_TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return false;
    }

    int getTimer();

    NonNullList<ItemStack> getOutput();

    @NotNull
    ResourceLocation getTypeId();
}
