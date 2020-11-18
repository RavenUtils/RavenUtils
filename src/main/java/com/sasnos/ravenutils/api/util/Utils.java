package com.sasnos.ravenutils.api.util;

import net.minecraft.util.ResourceLocation;

public class Utils {
  public static ResourceLocation createResourceLocation(String modId, String namespace) {
    return new ResourceLocation(modId, namespace);
  }
}
