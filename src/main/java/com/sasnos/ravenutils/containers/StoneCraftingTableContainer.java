package com.sasnos.ravenutils.containers;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class StoneCraftingTableContainer extends WorkbenchContainer {

    private final IWorldPosCallable callablePos;

    public StoneCraftingTableContainer(int id, PlayerInventory playerInventory) {
        super(id, playerInventory);
        this.callablePos = IWorldPosCallable.DUMMY;
    }

    public StoneCraftingTableContainer(int id, PlayerInventory playerInventory, IWorldPosCallable p_i50090_3_) {
        super(id, playerInventory, p_i50090_3_);
        this.callablePos = p_i50090_3_;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(callablePos,
                playerIn,
                ModBlocks.STONE_CRAFTING_TABLE.get());
    }
}
