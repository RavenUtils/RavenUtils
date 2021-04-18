package com.sasnos.ravenutils.utils;

import com.sasnos.raven_api.utils.Utils;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.BaseBucketItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;

public class EssentialsUtils {

  public static ResourceLocation resourceLocation(String namespace) {
    return Utils.createResourceLocation(RavenUtils.MOD_ID, namespace);
  }


  public static FluidStack createFluidStackFromBucket(BaseBucketItem bucket, ItemStack stack) {
    return new FluidStack(bucket.getFluid(stack), 1000);
  }

  public static boolean isObstructed(PlayerEntity player, BlockPos pos, Direction direction){
    return !isNormalCube(player, pos) || !isNormalCube(player, pos.offset(direction.getOpposite()));
  }

  public static boolean isNormalCube(PlayerEntity player, BlockPos pos) {
    return !player.world.getBlockState(pos).isSuffocating(player.world, pos);
  }

}
