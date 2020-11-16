package com.sasnos.ravenutils.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.RepairContainer;
import net.minecraft.util.IWorldPosCallable;

public class StoneAnvilContainer extends RepairContainer {
    public StoneAnvilContainer(int id, PlayerInventory playerInventory) {
        super(id, playerInventory);
    }

    public StoneAnvilContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
        super(id, playerInventory, worldPosCallable);
    }
}
