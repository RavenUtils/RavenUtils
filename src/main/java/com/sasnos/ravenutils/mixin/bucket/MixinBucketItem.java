package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BucketItem.class)
public abstract class MixinBucketItem extends Item {

  @Final
  @Shadow
  private Fluid containedBlock;

  public MixinBucketItem(Properties properties) {
    super(properties);
  }

  @Override
  public boolean isEnchantable(@NotNull ItemStack stack) {
    return false;
  }


  @Inject(method = "emptyBucket",at = @At("RETURN"), cancellable = true)
  protected void onEmptyBucket(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
    if (cir.getReturnValue().getItem() == Items.BUCKET){
      ItemStack newBucket = cir.getReturnValue();
      newBucket.damageItem(stack.getDamage()+1, player,
              (playerEntity) -> playerEntity.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1, 1));
    }
  }
}
