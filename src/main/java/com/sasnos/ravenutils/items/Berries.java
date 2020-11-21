package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Berries extends Item {

  public Berries() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(2)
            .saturation(0.1f)
            .build()));
  }
}
