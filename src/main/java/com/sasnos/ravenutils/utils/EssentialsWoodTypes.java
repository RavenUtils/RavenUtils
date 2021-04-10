package com.sasnos.ravenutils.utils;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.model.RenderMaterial;

import java.util.Set;

public class EssentialsWoodTypes extends WoodType {
  private static final Set<WoodType> VALUES = new ObjectArraySet<>();
  public static final WoodType CRIMWOOD = register(new EssentialsWoodTypes("crimwood", RenderMaterials.CRIMWOOD_SIGN));


  private final RenderMaterial material;

  protected EssentialsWoodTypes(String nameIn, RenderMaterial materials) {
    super(nameIn);
    material = materials;
  }

  public RenderMaterial getMaterial() {
    return material;
  }

}
