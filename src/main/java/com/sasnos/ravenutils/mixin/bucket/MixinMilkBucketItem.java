package com.sasnos.ravenutils.mixin.bucket;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public abstract class MixinMilkBucketItem extends Item {

  public MixinMilkBucketItem(Properties properties) {
    super(properties);
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return false;
  }

  @Inject(method = "onItemUseFinish", at = @At("RETURN"), cancellable = true)
  public void onOnItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving, CallbackInfoReturnable<ItemStack> cir) {
    ItemStack bucket = cir.getReturnValue();
    if(bucket.getItem() == Items.BUCKET){
      CompoundNBT tag = stack.getTag();
      int damage = tag == null ? 0 : tag.getInt("Damage");
      bucket.damageItem(damage + 1, entityLiving, (entity) -> entity.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1, 1));
    }
  }
}
