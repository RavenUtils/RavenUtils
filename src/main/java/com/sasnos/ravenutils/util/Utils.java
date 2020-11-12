package com.sasnos.ravenutils.util;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.util.ResourceLocation;

public class Utils {

  public static ResourceLocation RL(String namespace) {
    return new ResourceLocation(RavenUtils.MOD_ID, namespace);
  }
}
