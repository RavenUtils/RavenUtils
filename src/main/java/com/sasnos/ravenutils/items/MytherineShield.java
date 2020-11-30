package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.render.ShieldRenderer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

import java.util.concurrent.Callable;

public class MytherineShield extends ShieldItem {
  public MytherineShield() {
    super(new Item.Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .maxDamage(9999)
        .setISTER(() -> getISTER()));
    DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
  }

  private static Callable<ItemStackTileEntityRenderer> getISTER() {
    return ShieldRenderer::new;
  }

  @Override
  public int getUseDuration(ItemStack stack) {
    return 1024000;
  }
}
