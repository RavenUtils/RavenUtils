package com.sasnos.ravenutils.containers;

import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class BagSlot extends Slot {

    public BagSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return !(stack.getItem() == ModToolItems.BAG_CLOTH.get() || stack.getItem() == ModToolItems.BAG_LEATHER.get());
    }
}
