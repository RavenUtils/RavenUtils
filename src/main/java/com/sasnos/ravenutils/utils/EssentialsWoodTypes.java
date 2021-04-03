package com.sasnos.ravenutils.utils;

import net.minecraft.block.WoodType;

public class EssentialsWoodTypes extends WoodType{
  public static final WoodType CRIMWOOD = new EssentialsWoodTypes("crimwood");

  protected EssentialsWoodTypes(String nameIn) {
    super(nameIn);
  }
}
