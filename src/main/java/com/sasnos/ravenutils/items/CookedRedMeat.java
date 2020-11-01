package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CookedRedMeat extends Item {

  public CookedRedMeat() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(8)
            .saturation(12.8f)
            .meat()
            .build()));
  }
}
