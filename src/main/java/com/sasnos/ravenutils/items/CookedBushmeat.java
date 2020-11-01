package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CookedBushmeat extends Item {

  public CookedBushmeat() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(6)
            .saturation(8.0f)
            .meat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 400, 1), 0.5f)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 1), 0.5f)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 300, 1), 0.4f)
            .build()));
  }
}
