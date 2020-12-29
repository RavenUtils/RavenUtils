package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.api.recipes.EssentialsRecipe;
import com.sasnos.ravenutils.api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.recipes.alloy_furnace.AlloyFurnaceRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AlloyFurnaceTileEntity extends EssentialsMachineTileEntity<AlloyFurnaceRecipe> {

  public static final String SCREEN_NAME = "screen.ravenutils.alloy_furnace";


  public AlloyFurnaceTileEntity() {
    super(AlloyFurnaceInit.ALLOY_FURNACE_TILE_ENTITY.get(), AlloyFurnaceRecipe.ALLOY_FURNACE_RECIPE_TYPE);
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
        if (slot == 0 || slot == 1) {
          return getAllRecipeInputsAsItems(AlloyFurnaceRecipe.ALLOY_FURNACE_RECIPE_TYPE, world).contains(stack.getItem());
        }
        if (slot == 2) {
          return ForgeHooks.getBurnTime(stack) > 0;
        }
        if (slot == 3 || slot == 4) {
          List<IRecipe<?>> recipes = findRecipeByType(AlloyFurnaceRecipe.ALLOY_FURNACE_RECIPE_TYPE, world).stream().filter(iRecipe -> {
            return ((AlloyFurnaceRecipe) iRecipe).getOutput().get(0).getItem() == stack.getItem()
                || ((AlloyFurnaceRecipe) iRecipe).getAdditionalResult().getItem() == stack.getItem();
          }).collect(Collectors.toList());
          return !recipes.isEmpty();
        }
        return false;
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if ((slot == 0 || slot == 1) && !getAllRecipeInputsAsItems(AlloyFurnaceRecipe.ALLOY_FURNACE_RECIPE_TYPE, world).contains(stack.getItem())) {
          return stack;
        }
        if (slot == 2 && !(ForgeHooks.getBurnTime(stack) > 0)) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  @Override
  protected boolean canSmelt(@Nullable IRecipe<?> recipeIn) {
    if (!this.itemHandler.getStackInSlot(0).isEmpty() && recipeIn != null) {
      ItemStack output = ((AlloyFurnaceRecipe) recipeIn).getOutput().get(0);
      ItemStack additionalOutput = ((AlloyFurnaceRecipe) recipeIn).getAdditionalResult();
      if (output.isEmpty()) {
        return false;
      } else {
        ItemStack outputSlot = this.itemHandler.getStackInSlot(3);
        ItemStack additionalSlot = this.itemHandler.getStackInSlot(4);
        if (outputSlot.isEmpty() && additionalSlot.isEmpty()) {
          return true;
        } else if (!outputSlot.isItemEqual(output) && !(additionalOutput != ItemStack.EMPTY && additionalSlot.isItemEqual(additionalOutput))) {
          return false;
        } else {
          boolean regularOutput = itemHandler.insertItem(3, output, true) == ItemStack.EMPTY;
          boolean additionalOutputFree = itemHandler.insertItem(4, additionalOutput, true) == ItemStack.EMPTY;
          return regularOutput && additionalOutputFree;
        }
      }
    } else {
      return false;
    }
  }

  @Override
  protected void smelt(@Nullable IRecipe<?> recipe) {
    if (recipe != null && this.canSmelt(recipe)) {
      ItemStack input = this.itemHandler.getStackInSlot(0);
      ItemStack additionalInput = itemHandler.getStackInSlot(1);
      NonNullList<ItemStack> outputList = ((AlloyFurnaceRecipe) recipe).getOutput();
      ItemStack output = outputList.get(0).copy();
      ItemStack additionalOutput = outputList.size() > 1 ? outputList.get(1).copy() : ItemStack.EMPTY;
      ItemStack outputSlot = this.itemHandler.getStackInSlot(3);
      ItemStack additionalOutputSlot = itemHandler.getStackInSlot(4);

      if (outputSlot.isEmpty()) {
        this.itemHandler.setStackInSlot(3, output);
      } else if (outputSlot.getItem() == output.getItem()) {
        outputSlot.grow(output.getCount());
      }

      if (additionalOutputSlot.isEmpty()) {
        this.itemHandler.setStackInSlot(4, additionalOutput.copy());
      } else if (additionalOutput.getItem() == additionalOutput.getItem()) {
        additionalOutputSlot.grow(additionalOutput.getCount());
      }

      if (((AlloyFurnaceRecipe) recipe).getInput().get(0).test(input)) {
        input.shrink(((AlloyFurnaceRecipe) recipe).getInput().get(0).count);
      } else {
        input.shrink(((AlloyFurnaceRecipe) recipe).getInput().get(1).count);
      }

      if (((EssentialsRecipe) recipe).hasAdditionalInput()) {
        if (((AlloyFurnaceRecipe) recipe).getInput().get(1).test(additionalInput)) {
          additionalInput.shrink(((AlloyFurnaceRecipe) recipe).getInput().get(1).count);
        } else {
          additionalInput.shrink(((AlloyFurnaceRecipe) recipe).getInput().get(0).count);
        }
      }
    }
  }

  @Override
  public int getFuelSlot() {
    return 2;
  }

  @Override
  protected AlloyFurnaceRecipe matchingOutput(Set<IRecipe<?>> recipes, ItemStack result, World world) {
    for (IRecipe<?> iRecipe : recipes) {
      if (!(iRecipe instanceof AlloyFurnaceRecipe)) continue;
      AlloyFurnaceRecipe recipe = (AlloyFurnaceRecipe) iRecipe;
      if (ItemStack.areItemStacksEqual(recipe.getOutput().get(0), result)) {
        return recipe;
      }
    }
    return null;
  }

  @Override
  protected AlloyFurnaceRecipe matching(Set<IRecipe<?>> recipes, RecipeWrapper wrapper, World world) {
    for (IRecipe<?> iRecipe : recipes) {
      if (!(iRecipe instanceof AlloyFurnaceRecipe)) continue;
      AlloyFurnaceRecipe recipe = (AlloyFurnaceRecipe) iRecipe;
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
