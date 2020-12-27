package com.sasnos.ravenutils.items;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class Hammer extends BaseItemDamageable {
    public Hammer(int maxDamage, Rarity rarity) {
        super(new Properties()
                .maxStackSize(1)
                .maxDamage(maxDamage)
                .rarity(rarity)
                .setNoRepair());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.KNOCKBACK;
    }
}
