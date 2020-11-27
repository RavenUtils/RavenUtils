package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.recipes.alloy_recipe.AlloyRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class AlloyFurnaceTileEntity extends EssentialsMachineTileEntity<AlloyRecipe> {

  public static final String SCREEN_NAME = "screen.ravenutils.alloy_furnace";

  public AlloyFurnaceTileEntity() {
    super(AlloyFurnaceInit.ALLOY_FURNACE_TILE_ENTITY.get(), ModRecipes.ALLOY_FURNACE_RECIPE_TYPE);
  }

  @Override
  protected ItemStackHandler createHandler() {
    return new ItemStackHandler(5) {
      @Override
      protected void onContentsChanged(int slot) {
        markDirty();
      }

      @Override
      public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return super.isItemValid(slot, stack);
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  @Override
  protected AlloyRecipe matching(Set<IRecipe<?>> recipes, RecipeWrapper wrapper, World world) {
    for (IRecipe<?> iRecipe : recipes) {
      if (!(iRecipe instanceof AlloyRecipe)) continue;
      AlloyRecipe recipe = (AlloyRecipe) iRecipe;
      if (recipe.matches(wrapper, world)) {
        return recipe;
      }
    }
    return null;
  }

  @Override
  protected String getScreenName() {
    return SCREEN_NAME;
  }

  @Nullable
  @Override
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
    assert world != null;
    return new AlloyFurnaceContainer(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_, teData);
  }

}
