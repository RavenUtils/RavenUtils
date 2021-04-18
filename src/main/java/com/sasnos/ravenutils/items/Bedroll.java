package com.sasnos.ravenutils.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Bedroll extends BaseItemDamageable {
  public Bedroll(int maxDamage) {
    super(new Properties()
        .maxStackSize(1)
        .maxDamage(maxDamage)
        .setNoRepair());
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
    return enchantment == Enchantments.UNBREAKING;
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    if(handIn != Hand.MAIN_HAND) return super.onItemRightClick(worldIn,playerIn, handIn);
    if(!worldIn.isRemote){
      playerIn.trySleep(playerIn.getPosition()).ifLeft(sleepResult -> {
        if(sleepResult != null){
          playerIn.sendStatusMessage(sleepResult.getMessage(), true);
        }
      });
    }
    return super.onItemRightClick(worldIn, playerIn, handIn);
  }
}
