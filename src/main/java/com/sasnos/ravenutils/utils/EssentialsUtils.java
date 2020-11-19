package com.sasnos.ravenutils.utils;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.utils.Utils;
import net.minecraft.util.ResourceLocation;

public class EssentialsUtils {

  public static ResourceLocation resourceLocation(String namespace) {
    return Utils.createResourceLocation(RavenUtils.MOD_ID, namespace);
  }
}
