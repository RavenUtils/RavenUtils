package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.sasnos.ravenutils.api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.recipes.mill_recipe.MillRecipe;
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

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class HandMillTileEntity extends EssentialsMachineTileEntity<MillRecipe> {

  public static final String SCREEN_NAME = "screen.ravenutils.hand_mill";
  private int counter;

  public HandMillTileEntity() {
    super(HandMillInit.HAND_MILL_TILE_ENTITY.get(), ModRecipes.MILL_RECIPE_TYPE);
  }

  /**
   * no used here
   *
   * @return dummy
   */
  @Override
  public int getFuelSlot() {
    return 0;
  }

  @Override
  protected MillRecipe matching(Set<IRecipe<?>> recipes, RecipeWrapper wrapper, World world) {
    for (IRecipe<?> iRecipe : recipes) {
      if (!(iRecipe instanceof MillRecipe)) continue;
      MillRecipe recipe = (MillRecipe) iRecipe;
      if (recipe.matches(wrapper, world)) {
        return recipe;
      }
    }
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
          return getAllRecipeInputsAsItems(ModRecipes.MILL_RECIPE_TYPE, world).contains(stack.getItem());
        }
        if (slot == 1 || slot == 2) {
          List<IRecipe<?>> recipes = findRecipeByType(ModRecipes.MILL_RECIPE_TYPE, world).stream().filter(iRecipe -> {
            return ((MillRecipe) iRecipe).getCraftingResult(null).getItem() == stack.getItem()
                || ((MillRecipe) iRecipe).getAdditionalResult().getItem() == stack.getItem();
          }).collect(Collectors.toList());
          return !recipes.isEmpty();
        }
        return false;
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (slot == 0 && !getAllRecipeInputsAsItems(ModRecipes.MILL_RECIPE_TYPE, world).contains(stack.getItem())) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  public boolean hasInput() {
    return itemHandler.getStackInSlot(0) != ItemStack.EMPTY;
  }

  @Nullable
  @Override
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
    assert world != null;
    return new HandMillContainer(p_createMenu_1_, this.world, this.pos, p_createMenu_2_, p_createMenu_3_, teData);
  }

  public boolean addTick() {
    if (this.world.isRemote && !itemHandler.getStackInSlot(0).isEmpty()) {
      return true;
    } else if (this.world.isRemote && itemHandler.getStackInSlot(0).isEmpty()) {
      return false;
    }

    if (itemHandler.getStackInSlot(0).isEmpty()
        ||
        itemHandler.getStackInSlot(1).getMaxStackSize() == itemHandler.getStackInSlot(1).getCount()) return false;

    MillRecipe recipe = getRecipe(itemHandler.getStackInSlot(0));
    int timer = recipe.getTimer() / 10;

    if (counter == 0) {
      startCrafting();
    }
    if (counter == timer) {
      finishCrafting(recipe);
      return true;
    }

    counter++;

    return true;
  }

  private void finishCrafting(MillRecipe recipe) {
    Random rand = new Random();
    ItemStack output = recipe.getOutput().get(0);
    if (rand.nextFloat() <= recipe.getAdditionalDropChange()) {
      output.setCount(output.getCount() + 1);
    }
    itemHandler.insertItem(1, output, false);
    itemHandler.extractItem(0, 1, false);
    if (rand.nextFloat() <= recipe.getAdditionalChance()) {
      itemHandler.insertItem(2, recipe.getAdditionalResult(), false);
    }
    counter = 0;
    markDirty();
  }

  private void startCrafting() {
  }

  @Override
  public void tick() {
  }
}
