package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.raven_api.containers.EssentialsMachineBlockContainer;
import com.sasnos.raven_api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.recipes.alloy_furnace.AlloyFurnaceRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class AlloyFurnaceContainer extends EssentialsMachineBlockContainer {

  public AlloyFurnaceContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
    this(windowId, playerInventory.player.world, extraData.readBlockPos(), playerInventory, playerInventory.player, new IntArray(4));
  }

  protected AlloyFurnaceContainer(int id, World world, BlockPos pos, PlayerInventory playerInventoryIn, PlayerEntity player, IIntArray furnaceData) {
    super(AlloyFurnaceInit.ALLOY_FURNACE_CONTAINER.get(), id, world, pos, playerInventoryIn, player, AlloyFurnaceInit.ALLOY_FURNACE.get(), furnaceData);
  }

  @Override
  protected void addSlots() {
    tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
      addSlot(new SlotItemHandler(h, 0, 32, 17));
      addSlot(new SlotItemHandler(h, 1, 56, 17));
      addSlot(new SlotItemHandler(h, 2, 44, 53));
      addSlot(new SlotItemHandler(h, 3, 125, 21));
      addSlot(new SlotItemHandler(h, 4, 125, 53));
    });
    layoutPlayerInventorySlots(8, 84);
  }

  @Override
  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = inventorySlots.get(index);
    if (slot != null && slot.getHasStack()) {
      ItemStack stack = slot.getStack();
      itemStack = stack.copy();

      if (Arrays.asList(0, 1, 2, 3, 4).contains(index)) {
        if (!this.mergeItemStack(stack, 5, 38, true)) {
          return ItemStack.EMPTY;
        }
        slot.onSlotChange(stack, itemStack);
      } else {
        ArrayList<Item> inputs = new ArrayList<>();
        Set<ItemStack> inputsStacks = EssentialsMachineTileEntity.getAllRecipeInputs(AlloyFurnaceRecipe.ALLOY_FURNACE_RECIPE_TYPE, this.tileEntity.getWorld());
        inputsStacks.forEach(itemStack1 -> inputs.add(itemStack1.getItem()));
        if (inputs.contains(stack.getItem())) {
          if (!this.mergeItemStack(stack, 0, 2, false)) {
            return ItemStack.EMPTY;
          }
          int timer = 0;
          AlloyFurnaceRecipe recipe = ((AlloyFurnaceTileEntity) tileEntity).getRecipe(itemStack);
          if (recipe != null) timer = recipe.getTimer();
          ((AlloyFurnaceTileEntity) tileEntity).setCookingTimeTotal(timer);
        } else if (ForgeHooks.getBurnTime(stack) > 0) {
          if (!this.mergeItemStack(stack, 2, 3, false)) {
            return ItemStack.EMPTY;
          }
        } else if (index < 28) {
          if (!this.mergeItemStack(stack, 28, 37, false)) {
            return ItemStack.EMPTY;
          }
        } else if (index < 37 && !this.mergeItemStack(stack, 1, 37, false)) {
          return ItemStack.EMPTY;
        }
      }

      if (itemStack.isEmpty()) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      }

      if (stack.getCount() == itemStack.getCount()) {
        return ItemStack.EMPTY;
      }

      slot.onTake(playerIn, stack);
    }

    return itemStack;
  }
}
