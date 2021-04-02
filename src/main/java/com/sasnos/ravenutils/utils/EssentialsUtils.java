package com.sasnos.ravenutils.utils;

import com.sasnos.raven_api.utils.Utils;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.BaseBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class EssentialsUtils {

  public static ResourceLocation resourceLocation(String namespace) {
    return Utils.createResourceLocation(RavenUtils.MOD_ID, namespace);
  }


  public static FluidStack createFluidStackFromBucket(BaseBucketItem bucket, ItemStack stack) {
    return new FluidStack(bucket.getFluid(stack), 1000);
  }
}
