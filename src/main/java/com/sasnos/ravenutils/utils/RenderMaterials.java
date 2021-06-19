package com.sasnos.ravenutils.utils;

import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;

import java.util.ArrayList;
import java.util.List;

public class RenderMaterials {

  public static final List<RenderMaterial> materials = new ArrayList<>();

  public static final RenderMaterial CRIMWOOD_SIGN = material("entity/signs/crimwood");

  public static final RenderMaterial MYTHERINE_SHIELD_BASE = material("entity/shields/mytherine_shield_base");

  public static final RenderMaterial MYTHERINE_SHIELD_BASE_NOPATTERN = material("entity/shields/mytherine_shield_base_nopattern");

  @SuppressWarnings("deprecation")
  private static RenderMaterial material(String path) {
    RenderMaterial material = new RenderMaterial(
        AtlasTexture.LOCATION_BLOCKS, EssentialsUtils.resourceLocation(path));
    materials.add(material);
    return material;
  }

}
