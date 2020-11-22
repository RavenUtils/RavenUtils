package com.sasnos.ravenutils.containers;

import com.sasnos.ravenutils.api.containers.EssentialsCommonContainer;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.inventories.BagInventory;
import com.sasnos.ravenutils.items.Bag;
import com.sasnos.ravenutils.utils.enums.Bags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class BagContainer extends EssentialsCommonContainer {

    private Bags bag;
    private IInventory bagInv;
    private int selectedSlot;

    // Client
    public static BagContainer createClientContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
        final Bags bag = buffer.readEnumValue(Bags.class);
        final int selectedSlot = buffer.readVarInt();
        return new BagContainer(id, playerInventory, new Inventory(bag.getInventorySize()), bag, selectedSlot);
    }

    public BagContainer(
            int id,
            PlayerInventory playerInventory,
            Inventory inventory,
            Bags bag,
            int selectedSlot) {
        super(ModContainer.BAG_CONTAINER.get(), id, playerInventory);
        this.bag = bag;
        bagInv = inventory;
        this.selectedSlot = selectedSlot;

        appendBackpackInventory(bag.getSlotBackpackX(), bag.getSlotBackpackY());

        layoutPlayerInventorySlots(bag.getSlotPlayerX(), bag.getSlotPlayerY());
    }

    public void appendBackpackInventory(int x, int y) {
        for (int height = 0; height < bag.getInventoryHeight(); height++) {
            for (int width = 0; width < bag.getInventoryWidth(); width++) {
                addSlot(new BagSlot(bagInv, width + height * bag.getInventoryWidth(), width * 18 + x, height * 18 + y));
            }
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if (bagInv instanceof BagInventory) {
            ((BagInventory) bagInv).writeItemStack();
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
        if (bagInv instanceof BagInventory) {
            final ItemStack stack = ((BagInventory) bagInv).getStack();
            return !stack.isEmpty() && stack.getItem() instanceof Bag;
        }
        return true;
    }

    public Bags getBag() {
        return bag;
    }
}
