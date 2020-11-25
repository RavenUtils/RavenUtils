package com.sasnos.ravenutils.blocks.modules.handmill;

import com.sasnos.ravenutils.api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.recipes.millrecipes.MillRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class HandMillTileEntity extends EssentialsMachineTileEntity<MillRecipe> {

  public HandMillTileEntity() {
    super(HandMillInit.HAND_MILL_TILE_ENTITY.get(), ModRecipes.MILL_RECIPE_RECIPE_TYPE);
  }

  @Override
  protected MillRecipe matching(Set set, RecipeWrapper wrapper, World world) {
    return null;
  }

  @Override
  protected String getScreenName() {
    return "screen.ravenutils.hand_mill";
  }

  @Override
  protected ItemStackHandler createHandler() {
    return new ItemStackHandler(4) {
      @Override
      protected void onContentsChanged(int slot) {
        markDirty();
      }

      @Override
      public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (slot == 0) {
          return getAllRecipeInputs(ModRecipes.MILL_RECIPE_RECIPE_TYPE, world).contains(stack.getItem());
        }
        return false;
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (slot == 0 && !getAllRecipeInputsAsItems(ModRecipes.MILL_RECIPE_RECIPE_TYPE, world).contains(stack.getItem())) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  @Nullable
  @Override
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
    assert world != null;
    return new HandMillContainer(p_createMenu_1_, this.world, this.pos, p_createMenu_2_, p_createMenu_3_, teData);
  }

  @Override
  public void tick() {
  }
}
