package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CookedPoultry extends Item {

  public CookedPoultry() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(6)
            .saturation(7.2f)
            .meat()
            .build()));
  }
}
