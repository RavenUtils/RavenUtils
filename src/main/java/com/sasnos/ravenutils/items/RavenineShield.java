package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class RavenineShield extends ShieldItem {
  public RavenineShield() {
    super(new Item.Properties()
        .group(RavenUtils.TAB)
        .maxStackSize(1)
        .maxDamage(9999));
    DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
  }

  @Override
  public int getUseDuration(ItemStack stack) {
    return 1024000;
  }
}
