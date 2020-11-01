package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Porkchop extends Item {

  public Porkchop() {
    super(new Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(3)
            .saturation(1.8f)
            .meat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 1), 0.5f)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.6f)
            .build()));
  }
}
