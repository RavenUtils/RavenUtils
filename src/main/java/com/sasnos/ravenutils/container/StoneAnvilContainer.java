package com.sasnos.ravenutils.container;

import com.sasnos.ravenutils.blocks.StoneAnvil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.RepairContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.IWorldPosCallable;

public class StoneAnvilContainer extends RepairContainer {
    public StoneAnvilContainer(int id, PlayerInventory playerInventory) {
        super(id, playerInventory);
    }

    public StoneAnvilContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
        super(id, playerInventory, worldPosCallable);
    }

    @Override
    protected ItemStack func_230301_a_(PlayerEntity p_230301_1_, ItemStack p_230301_2_) {
        if (!p_230301_1_.abilities.isCreativeMode) {
            p_230301_1_.addExperienceLevel(-getMaximumCost());
        }

        float breakChance = 0.24f;

        this.field_234643_d_.setInventorySlotContents(0, ItemStack.EMPTY);
        if (this.materialCost > 0) {
            ItemStack itemstack = this.field_234643_d_.getStackInSlot(1);
            if (!itemstack.isEmpty() && itemstack.getCount() > this.materialCost) {
                itemstack.shrink(this.materialCost);
                this.field_234643_d_.setInventorySlotContents(1, itemstack);
            } else {
                this.field_234643_d_.setInventorySlotContents(1, ItemStack.EMPTY);
            }
        } else {
            this.field_234643_d_.setInventorySlotContents(1, ItemStack.EMPTY);
        }

        this.setMaximumCost(0);
        this.field_234644_e_.consume((p_234633_1_, p_234633_2_) -> {
            BlockState blockstate = p_234633_1_.getBlockState(p_234633_2_);
            if (!p_230301_1_.abilities.isCreativeMode && blockstate.isIn(BlockTags.ANVIL) && p_230301_1_.getRNG().nextFloat() < breakChance) {
                BlockState blockstate1 = StoneAnvil.damage(blockstate);
                if (blockstate1 == null) {
                    p_234633_1_.removeBlock(p_234633_2_, false);
                    p_234633_1_.playEvent(1029, p_234633_2_, 0);
                } else {
                    p_234633_1_.setBlockState(p_234633_2_, blockstate1, 2);
                    p_234633_1_.playEvent(1030, p_234633_2_, 0);
                }
            } else {
                p_234633_1_.playEvent(1030, p_234633_2_, 0);
            }

        });
        return p_230301_2_;
    }

}
