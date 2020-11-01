package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Poultry extends Item {

  public Poultry() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(2)
            .saturation(1.2f)
            .meat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 200, 2), 1.0f)
            .effect(() -> new EffectInstance(Effects.POISON, 100, 1), 0.8f)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 2), 0.7f)
            .build()));
  }
}
