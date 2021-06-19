package com.sasnos.ravenutils.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class Bedroll extends BaseItemDamageable {
  public Bedroll(int maxDamage) {
    super(new Properties()
        .stacksTo(1)
        .durability(maxDamage)
        .setNoRepair());
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
    return enchantment == Enchantments.UNBREAKING;
  }

  @Override
  public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
    if(handIn != Hand.MAIN_HAND) return super.use(worldIn,playerIn, handIn);
    if(!worldIn.isClientSide){
      playerIn.startSleepInBed(playerIn.blockPosition()).ifLeft(sleepResult -> {
        if(sleepResult != null){
          playerIn.displayClientMessage(sleepResult.getMessage(), true);
        }
      });
    }
    return super.use(worldIn, playerIn, handIn);
  }
}
