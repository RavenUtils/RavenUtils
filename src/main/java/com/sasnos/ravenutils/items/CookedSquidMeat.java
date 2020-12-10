package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CookedSquidMeat extends Item {

  public CookedSquidMeat() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(5)
            .saturation(6.0f)
            .build()));
  }
}