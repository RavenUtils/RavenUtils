package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.item.Item.Properties;

public class CookedSquidMeat extends Item {

  public CookedSquidMeat() {
    super(new Properties()
        .tab(ItemGroup.TAB_FOOD)
        .food(new Food.Builder()
            .nutrition(5)
            .saturationMod(6.0f)
            .build()));
  }
}
