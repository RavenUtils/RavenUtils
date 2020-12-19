package com.sasnos.ravenutils.recipes.dry_rack;

import com.sasnos.ravenutils.api.recipes.CommonRecipe;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class DryRackRecipe extends CommonRecipe {

    public static final ResourceLocation DRYRACK = EssentialsUtils.resourceLocation("sry_rack");

    public DryRackRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, int timer, NonNullList<ItemStack> result, float xp) {
        super(id, ingredients, timer, result, xp);
    }

    @Override
    public @NotNull ResourceLocation getTypeId() {
        return DRYRACK;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return getIngredients().get(0).test(inv.getStackInSlot(0));
    }

    public boolean matches(RecipeWrapper inv, int slot) {
        return getIngredients().get(0).test(inv.getStackInSlot(slot));
    }


    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.DRY_RACK_RECIPE_SERIALIZER.get();
    }
}
