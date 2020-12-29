package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DrinkHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DrinkHelper.class)
public abstract class MixinDrinkHelper {

  /**
   * @reason add way to add damage to the bucket
   * @author Unbekannt
   */
  @Overwrite
  public static ItemStack fill(ItemStack empty, PlayerEntity player, ItemStack filled, boolean preventDuplicates) {
    boolean flag = player.abilities.isCreativeMode;
    if (preventDuplicates && flag) {
      if (!player.inventory.hasItemStack(filled)) {
        player.inventory.addItemStackToInventory(filled);
      }

      return empty;
    } else {
      int damage = empty.getDamage();
      if (!flag) {
        empty.shrink(1);
      }

      if (filled.isDamageable() && damage + 1 > filled.getMaxDamage()) {
        return empty;
      } else if (filled.isDamageable()) {
        filled.setDamage(damage + 1);
      }

      if (empty.isEmpty()) {
        return filled;
      } else {
        if (!player.inventory.addItemStackToInventory(filled)) {
          player.dropItem(filled, false);
        }

        return empty;
      }
    }
  }

}
