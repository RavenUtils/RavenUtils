package com.sasnos.ravenutils.tile_entities;

import com.sasnos.ravenutils.api.tile_entities.EssentialsRecipeTileEntity;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.recipes.dry_rack.DryRackRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;

public class DryingRackTileEntity extends EssentialsRecipeTileEntity<DryRackRecipe> {

    public DryingRackTileEntity(TileEntityType<?> tileEntityTypeIn, IRecipeType<?> recipeType) {
        super(tileEntityTypeIn, ModRecipes.DRY_RACK_RECIPE);
    }

    @Override
    protected ItemStackHandler createHandler() {
        return null;
    }

    @Override
    protected DryRackRecipe getRecipe(ItemStack stack) {
        return null;
    }
}
