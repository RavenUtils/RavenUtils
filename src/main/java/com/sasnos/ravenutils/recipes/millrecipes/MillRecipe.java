package com.sasnos.ravenutils.recipes.millrecipes;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MillRecipe extends EssentialsRecipe {
    public static final ResourceLocation MILL = new ResourceLocation(RavenUtils.MOD_ID, "mill");
    private final ItemStack output;
    private final Ingredient input;
    private final int timer;
    private final ItemStack additionalResult;
    private final float additionalChange;

    public MillRecipe(ResourceLocation id, int time, Ingredient input, ItemStack output, ItemStack additionalResult, float additionalChange){
        this.id = id;
        this.output = output;
        this.input = input;
        this.timer = time;
        this.additionalChange = additionalChange;
        this.additionalResult = additionalResult;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    @Override
    public NonNullList<ItemStack> getOutput() {
        NonNullList<ItemStack> outputs = NonNullList.from(output);
        if (additionalResult != ItemStack.EMPTY) {
            float change = new Random().nextFloat();
            if (change <= additionalChange) {
                outputs.add(additionalResult);
            }
        }
        return outputs;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return output.copy();
    }

    @Override
    public @NotNull ResourceLocation getTypeId() {
        return MILL;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return input.test(inv.getStackInSlot(0));
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.MILL_RECIPE.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(input);
    }


    public ItemStack getAdditionalResult() {
        return additionalResult;
    }

    public float getAdditionalChange() {
        return additionalChange;
    }
}
