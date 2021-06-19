package com.sasnos.ravenutils.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import net.minecraft.item.Item.Properties;

public class Bushmeat extends Item {

  public Bushmeat() {
    super(new Properties()
        .tab(ItemGroup.TAB_FOOD)
        .food(new Food.Builder()
            .nutrition(2)
            .saturationMod(1.2f)
            .meat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 1), 1.0f)
            .effect(() -> new EffectInstance(Effects.CONFUSION, 300, 2), 0.8f)
            .build()));
  }
}
