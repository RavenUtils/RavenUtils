package com.sasnos.ravenutils.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import org.jetbrains.annotations.Nullable;

public class EssentialShieldItem extends ShieldItem {
    public EssentialShieldItem(Properties builder) {
        super(builder);

        DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }
}
