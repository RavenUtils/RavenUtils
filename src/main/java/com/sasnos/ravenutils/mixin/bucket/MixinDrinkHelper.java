package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DrinkHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DrinkHelper.class)
public abstract class MixinDrinkHelper {

  @Inject(method = "fill(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/item/ItemStack;",
          at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"), cancellable = true)
  private static void onFill(ItemStack empty, PlayerEntity player, ItemStack filled, boolean preventDuplicates,
                            CallbackInfoReturnable<ItemStack> cir) {
    int damage = 0;
    if(empty.getTag() != null)
      damage = empty.getTag().getInt("Damage");

    if (filled.isDamageable() && damage + 1 > filled.getMaxDamage()) {
      cir.setReturnValue(empty);
    } else if (filled.isDamageable()) {
      filled.setDamage(damage + 1);
    }
  }

}
