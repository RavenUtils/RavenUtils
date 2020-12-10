package com.sasnos.ravenutils.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public abstract class CommonRecipe extends EssentialsRecipe {

    protected final NonNullList<ItemStack> result;
    protected final NonNullList<Ingredient> ingredients;
    protected final int timer;

    public CommonRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, int timer, NonNullList<ItemStack> result) {
        super(id);
        this.ingredients = ingredients;
        this.timer = timer;
        this.result = result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    @Override
    public NonNullList<ItemStack> getOutput() {
        return result;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return ingredients.get(0).getMatchingStacks()[0];
    }

}
