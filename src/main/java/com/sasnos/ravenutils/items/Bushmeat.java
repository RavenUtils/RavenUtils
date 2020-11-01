package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Bushmeat extends Item {

  public Bushmeat() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(2)
            .saturation(1.2f)
            .meat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 1), 1.0f)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.8f)
            .build()));
  }
}
