package com.sasnos.ravenutils.api.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public abstract class EssentialsCommonContainer extends Container {
    protected TileEntity tileEntity;
    protected PlayerEntity playerEntity;
    protected IItemHandler playerInventory;
    protected Block blocktype;

    protected EssentialsCommonContainer(@Nullable ContainerType<?> type,
                                        int id, World world, BlockPos pos,
                                        PlayerInventory playerInventoryIn,
                                        PlayerEntity player,
                                        Block blocktype) {
        super(type, id);
        tileEntity = world.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventoryIn);
        this.blocktype = blocktype;

        if(tileEntity != null){
            addSlots();
        }
    }

    protected abstract void addSlots();


    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(
                IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()),
                playerEntity,
                blocktype);
    }

    protected void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

    @Override
    public abstract ItemStack transferStackInSlot(PlayerEntity playerIn, int index);

    protected int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    protected int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

}
