package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.sasnos.raven_api.containers.EssentialsMachineBlockContainer;
import com.sasnos.raven_api.tile_entities.EssentialsMachineTileEntity;
import com.sasnos.ravenutils.recipes.hand_mill_recipe.HandMillRecipe;
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
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class HandMillContainer extends EssentialsMachineBlockContainer {

  public HandMillContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
    this(windowId, playerInventory.player.level, extraData.readBlockPos(), playerInventory, playerInventory.player, new IntArray(4));
  }

  public HandMillContainer(int id, World world, BlockPos pos, PlayerInventory playerInventoryIn, PlayerEntity player, IIntArray data) {
    super(HandMillInit.HAND_MILL_CONTAINER.get(), id, world, pos, playerInventoryIn, player, HandMillInit.HAND_MILL.get(), data);
  }

  @Override
  protected void addSlots() {
    tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
      addSlot(new SlotItemHandler(h, 0, 80, 19));
      addSlot(new SlotItemHandler(h, 1, 68, 75));
      addSlot(new SlotItemHandler(h, 2, 92, 75));
    });
    layoutPlayerInventorySlots(8, 106);
  }

  @Override
  public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = slots.get(index);
    if (slot != null && slot.hasItem()) {
      ItemStack stack = slot.getItem();
      itemStack = stack.copy();

      if (Arrays.asList(0, 1, 2, 3, 4).contains(index)) {
        if (!this.moveItemStackTo(stack, 5, 38, true)) {
          return ItemStack.EMPTY;
        }
        slot.onQuickCraft(stack, itemStack);
      } else {
        ArrayList<Item> inputs = new ArrayList<>();
        Set<ItemStack> inputsStacks = EssentialsMachineTileEntity.getAllRecipeInputs(HandMillRecipe.HAND_MILL_RECIPE_TYPE, this.tileEntity.getLevel());
        inputsStacks.forEach(itemStack1 -> inputs.add(itemStack1.getItem()));
        if (inputs.contains(stack.getItem())) {
          if (!this.moveItemStackTo(stack, 0, 1, false)) {
            return ItemStack.EMPTY;
          }
          ((HandMillTileEntity) tileEntity).setCookingTimeTotal(((HandMillTileEntity) tileEntity).getRecipe(stack).getTimer());
        } else if (index < 28) {
          if (!this.moveItemStackTo(stack, 28, 37, false)) {
            return ItemStack.EMPTY;
          }
        } else if (index < 37 && !this.moveItemStackTo(stack, 1, 37, false)) {
          return ItemStack.EMPTY;
        }
      }
    }
    return itemStack;
  }
}
