package com.sasnos.ravenutils.inventories;

import com.sasnos.ravenutils.utils.enums.BagTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BagItemHandlerProvider implements ICapabilitySerializable<CompoundNBT> {

    private ItemStackHandler itemHandler;
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public BagItemHandlerProvider(BagTypes type){
        itemHandler = new ItemStackHandler(type.getInventorySize());
    }

    public void invalidate(){
        handler.invalidate();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return LazyOptional.empty();
    }



    @Override
    public CompoundNBT serializeNBT() {
        if(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY == null){
            return new CompoundNBT();
        }
        else {
            return itemHandler.serializeNBT();
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY != null){
            itemHandler.deserializeNBT(nbt);
        }
    }
}
