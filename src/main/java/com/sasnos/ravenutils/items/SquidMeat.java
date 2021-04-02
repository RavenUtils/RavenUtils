package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.item.Item.Properties;

public class SquidMeat extends Item {

  public SquidMeat() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(2)
            .saturation(0.4f)
            .build()));
  }
}
