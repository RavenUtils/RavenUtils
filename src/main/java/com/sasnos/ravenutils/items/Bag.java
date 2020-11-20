package com.sasnos.ravenutils.items;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;

public class Bag extends ChestContainer {
  public Bag(ContainerType<?> type, int id, PlayerInventory player, int rows) {
    super(type, id, player, new Inventory(9 * rows), rows);

  }

}
