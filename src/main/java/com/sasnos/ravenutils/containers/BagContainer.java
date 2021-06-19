package com.sasnos.ravenutils.containers;

import com.sasnos.raven_api.containers.EssentialsCommonContainer;
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
    ItemStack bagStack = playerInventory.getItem(selectedSlot);
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
  public ItemStack quickMoveStack(PlayerEntity player, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    final Slot slot = slots.get(index);

    if (slot != null && slot.hasItem()) {
      final ItemStack itemstack1 = slot.getItem();
      itemstack = itemstack1.copy();
      int size = bag.getInventorySize();
      if (index < size) {
        if (!this.moveItemStackTo(itemstack1, size, this.slots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.moveItemStackTo(itemstack1, 0, size, false)) {
        return ItemStack.EMPTY;
      }

      if (itemstack1.isEmpty()) {
        slot.set(ItemStack.EMPTY);
      } else {
        slot.setChanged();
      }
    }
    return itemstack;
  }

  @Override
  public ItemStack clicked(int slotId, int dragType, ClickType clickType, PlayerEntity player) {
    Slot tmpSlot;
    if (slotId >= 0 && slotId < slots.size()) {
      tmpSlot = slots.get(slotId);
    } else {
      tmpSlot = null;
    }
    if (tmpSlot != null) {
      if (tmpSlot.container == player.inventory && tmpSlot.getSlotIndex() == selectedSlot) {
        return tmpSlot.getItem();
      }
    }
    if (clickType == ClickType.SWAP) {
      final ItemStack stack = player.inventory.getItem(dragType);
      final ItemStack currentItem = PlayerInventory.isHotbarSlot(selectedSlot) ? player.inventory.items.get(selectedSlot) : selectedSlot == -1 ? player.inventory.offhand.get(0) : ItemStack.EMPTY;

      if (!currentItem.isEmpty() && stack == currentItem) {
        return ItemStack.EMPTY;
      }
    }
    return super.clicked(slotId, dragType, clickType, player);
  }

  @Override
  public boolean stillValid(PlayerEntity player) {
    return player.getItemInHand(player.getUsedItemHand()).getItem() instanceof Bag;
  }

  public BagTypes getBag() {
    return bag;
  }
}
