package com.sasnos.ravenutils.tileentiety;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.Nullable;

public class AnvilContainerProvider implements INamedContainerProvider {

    private ITextComponent containerName;

    public AnvilContainerProvider(ITextComponent containerName){
        this.containerName = containerName;
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return ContainerType.ANVIL.create(p_createMenu_1_, p_createMenu_2_);
    }

    @Override
    public ITextComponent getDisplayName() {
        return containerName;
    }
}
