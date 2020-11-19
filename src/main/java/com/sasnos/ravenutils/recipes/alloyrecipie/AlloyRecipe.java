package com.sasnos.ravenutils.recipes.alloyrecipie;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.api.recipes.Material;
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

public class AlloyRecipe extends EssentialsRecipe {

    public static final ResourceLocation ALLOY_FURNACE = new ResourceLocation(RavenUtils.MOD_ID, "alloy_furnace");
    private final ItemStack output;
    private final NonNullList<Material> input;
    private final int timer;
    private final ItemStack additionalResult;
    private final float additionalChange;
    

    public AlloyRecipe(ResourceLocation id, NonNullList<Material> input, ItemStack output, int time, ItemStack additional, float change){
        this.output = output;
        this.input = input;
        this.timer = time;
        this.id = id;
        this.additionalResult = additional;
        this.additionalChange = change;
    }

    public NonNullList<Material> getInput() {
        return input;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    @NotNull
    @Override
    public ResourceLocation getTypeId() {
        return ALLOY_FURNACE;
    }

    @Override
    public boolean matches(RecipeWrapper inv, @NotNull World worldIn) {
        for (Material material : input){
            if(!(material.test(inv.getStackInSlot(0)) || material.test(inv.getStackInSlot(1)))){
                return false;
            }
        }
        return true;
    }

    @NotNull
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> allIngredients = NonNullList.create();
        input.stream().map(m -> m.ingredient).forEach(allIngredients::add);
        return allIngredients;
    }

    @NotNull
    @Override
    public ItemStack getCraftingResult(@NotNull RecipeWrapper inv) {
        return getRecipeOutput().copy();
    }

    @NotNull
    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }

    @Override
    public NonNullList<ItemStack> getOutput(){
        NonNullList<ItemStack> result = NonNullList.from(output);
        if(additionalResult != ItemStack.EMPTY){
            float change = new Random().nextFloat();
            if(change <= additionalChange){
                result.add(additionalResult);
            }
        }
        return result;
    }

    public ItemStack getAdditionalResult(){
        return additionalResult;
    }

    public float getAdditionalChange() {
        return additionalChange;
    }

    @NotNull
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.ALLOY_RECIPE.get();
    }
}
