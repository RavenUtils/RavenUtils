package com.sasnos.ravenutils.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.jetbrains.annotations.Nullable;

public class StoneCraftingTableContainer implements INamedContainerProvider {
  @Override
  public ITextComponent getDisplayName() {
    return new TranslationTextComponent(Items.CRAFTING_TABLE.getTranslationKey());
  }

  @Nullable
  @Override
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
    return new WorkbenchContainer(p_createMenu_1_, p_createMenu_2_);
  }
}
