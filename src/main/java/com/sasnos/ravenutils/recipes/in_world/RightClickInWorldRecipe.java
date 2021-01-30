package com.sasnos.ravenutils.recipes.in_world;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.api.utils.blockingridient.BlockIngredient;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class RightClickInWorldRecipe extends EssentialsRecipe {

    public static final IRecipeType<RightClickInWorldRecipe> RIGHT_CLICK_IN_WORLD_RECIPE = IRecipeType.register(RavenUtils.MOD_ID + ":right_click");

    private final NonNullList<Ingredient> input;
    private final NonNullList<ItemStack> output;
    private final BlockIngredient block;

    public RightClickInWorldRecipe(ResourceLocation id, Ingredient input, BlockIngredient blockInput, NonNullList<ItemStack> output) {
        super(id, RIGHT_CLICK_IN_WORLD_RECIPE);
        this.input = NonNullList.from(Ingredient.EMPTY, input);
        this.output = output;
        this.block = blockInput;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return input;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.RIGHT_CLICK_IN_WORLD_RECIPE_SERIALIZER.get();
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public NonNullList<ItemStack> getOutput() {

        NonNullList<ItemStack> stacks = NonNullList.create();
        for (ItemStack stack : output) {
            stacks.add(stack.copy());
        }
        return stacks;
    }

    @Override
    public float getXp() {
        return 0;
    }

    @Deprecated
    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return false;
    }

    public boolean matches(Block block, ItemStack itemStack) {
        return this.block.test(block) && input.get(0).test(itemStack);
    }

    public BlockIngredient getBlocks() {
        return block;
    }
}
