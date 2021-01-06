package com.sasnos.ravenutils.items;


import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashSet;
import java.util.List;

public class Hammer extends ToolItem {
  public Hammer(int maxDamage, Rarity rarity, float attackDamage, float attackSpeed, IItemTier hammerTier) {
    super(attackDamage, attackSpeed, hammerTier, new HashSet<>(),
        new Properties()
            .maxStackSize(1)
            .maxDamage(maxDamage)
            .rarity(rarity)
            .setNoRepair()
            .group(RavenUtils.TAB));
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
    return false;
  }

  @Override
  public boolean hitEntity(ItemStack stack, LivingEntity entity, LivingEntity player) {
    IItemTier tier = ((Hammer) stack.getItem()).getTier();
    int knockBack = getKnockBackLevel(tier);

    entity.applyKnockback((float) knockBack * 0.5F, (double) MathHelper.sin(player.rotationYaw * ((float) Math.PI / 180F)), (double) (-MathHelper.cos(player.rotationYaw * ((float) Math.PI / 180F))));

    player.setMotion(player.getMotion().mul(0.6D, 1.0D, 0.6D));
    player.setSprinting(false);
    return super.hitEntity(stack, entity, player);
  }

  private int getKnockBackLevel(IItemTier tier) {
    int knockBack = 0;
    if (tier == ItemTier.STONE) {
      knockBack = 1;
    } else if (tier == ItemTier.IRON) {
      knockBack = 2;
    } else if (tier == ItemTier.DIAMOND) {
      knockBack = 3;
    }
    return knockBack;
  }

  @ParametersAreNonnullByDefault
  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    ItemStack dummyStack = new ItemStack(stack.getItem());
    dummyStack.setTag(stack.getTag());
    dummyStack.addEnchantment(Enchantments.KNOCKBACK, getKnockBackLevel(((Hammer) stack.getItem()).getTier()));
    ItemStack.addEnchantmentTooltips(tooltip, dummyStack.getEnchantmentTagList());
  }
}
