package com.sasnos.ravenutils.utils;

import com.sasnos.ravenutils.items.BaseBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

/**
 * Wrapper around a clay bucket to get the fluid stored
 */
public class EssentialsFluidBucketWrapper extends FluidBucketWrapper {
  public EssentialsFluidBucketWrapper(ItemStack container) {
    super(container);
  }

  @Override
  public FluidStack getFluid() {
    Item item = container.getItem();
    if (item instanceof BaseBucketItem) {
      return new FluidStack(((BaseBucketItem) item).getFluid(container), FluidAttributes.BUCKET_VOLUME);
    }
    return FluidStack.EMPTY;
  }

  @Override
  protected void setFluid(FluidStack stack) {
    if (stack.isEmpty()) {
      container = container.getContainerItem();
    } else {
      Item item = container.getItem();
      if (item instanceof BaseBucketItem) {
        container = ((BaseBucketItem) item).withFluid(container, stack.getFluid());
      } else {
        container = ItemStack.EMPTY;
      }
    }
  }
}