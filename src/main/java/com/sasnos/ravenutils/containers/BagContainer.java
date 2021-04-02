package com.sasnos.ravenutils.containers;

import com.sasnos.ravenutils.api.containers.EssentialsCommonContainer;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.items.Bag;
import com.sasnos.ravenutils.utils.enums.BagTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BagContainer extends EssentialsCommonContainer {

  private final BagTypes bag;
  private final int selectedSlot;

  public BagContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
    this(windowId, playerInventory, extraData.readVarInt());
  }

  public BagContainer(
      int id,
      PlayerInventory playerInventory,
      int selectedSlot) {
    super(ModContainer.BAG_CONTAINER.get(), id, playerInventory);
    ItemStack bagStack = playerInventory.getStackInSlot(selectedSlot);
    if(!(bagStack.getItem() instanceof Bag)) {
      throw new IllegalStateException("Container can only handel Bag Items");
    }
    this.bag = ((Bag)bagStack.getItem()).getBagType();
    this.selectedSlot = selectedSlot;

    bagStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(iItemHandler -> {
      appendBackpackInventory(bag.getSlotBackpackX(), bag.getSlotBackpackY(), iItemHandler);
      layoutPlayerInventorySlots(bag.getSlotPlayerX(), bag.getSlotPlayerY());
    });

  }



  public void appendBackpackInventory(int x, int y, IItemHandler inv) {
    for (int height = 0; height < bag.getInventoryHeight(); height++) {
      for (int width = 0; width < bag.getInventoryWidth(); width++) {
        addSlot(new SlotItemHandler(inv, width + height * bag.getInventoryWidth(), width * 18 + x, height * 18 + y));
      }
    }
  }

  @Override
  public ItemStack transferStackInSlot(PlayerEntity player, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    final Slot slot = inventorySlots.get(index);

    if (slot != null && slot.getHasStack()) {
      final ItemStack itemstack1 = slot.getStack();
      itemstack = itemstack1.copy();
      int size = bag.getInventorySize();
      if (index < size) {
        if (!this.mergeItemStack(itemstack1, size, this.inventorySlots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.mergeItemStack(itemstack1, 0, size, false)) {
        return ItemStack.EMPTY;
      }

      if (itemstack1.isEmpty()) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      }
    }
    return itemstack;
  }

  @Override
  public ItemStack slotClick(int slotId, int dragType, ClickType clickType, PlayerEntity player) {
    Slot tmpSlot;
    if (slotId >= 0 && slotId < inventorySlots.size()) {
      tmpSlot = inventorySlots.get(slotId);
    } else {
      tmpSlot = null;
    }
    if (tmpSlot != null) {
      if (tmpSlot.inventory == player.inventory && tmpSlot.getSlotIndex() == selectedSlot) {
        return tmpSlot.getStack();
      }
    }
    if (clickType == ClickType.SWAP) {
      final ItemStack stack = player.inventory.getStackInSlot(dragType);
      final ItemStack currentItem = PlayerInventory.isHotbar(selectedSlot) ? player.inventory.mainInventory.get(selectedSlot) : selectedSlot == -1 ? player.inventory.offHandInventory.get(0) : ItemStack.EMPTY;

      if (!currentItem.isEmpty() && stack == currentItem) {
        return ItemStack.EMPTY;
      }
    }
    return super.slotClick(slotId, dragType, clickType, player);
  }

  @Override
  public boolean canInteractWith(PlayerEntity player) {
    return player.getHeldItem(player.getActiveHand()).getItem() instanceof Bag;
  }

  public BagTypes getBag() {
    return bag;
  }
}
