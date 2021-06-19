package com.sasnos.ravenutils.containers;

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
  protected ItemStack onTake(PlayerEntity p_230301_1_, ItemStack p_230301_2_) {
    if (!p_230301_1_.abilities.instabuild) {
      p_230301_1_.giveExperienceLevels(-getCost());
    }

    float breakChance = 0.24f;

    this.inputSlots.setItem(0, ItemStack.EMPTY);
    if (this.repairItemCountCost > 0) {
      ItemStack itemstack = this.inputSlots.getItem(1);
      if (!itemstack.isEmpty() && itemstack.getCount() > this.repairItemCountCost) {
        itemstack.shrink(this.repairItemCountCost);
        this.inputSlots.setItem(1, itemstack);
      } else {
        this.inputSlots.setItem(1, ItemStack.EMPTY);
      }
    } else {
      this.inputSlots.setItem(1, ItemStack.EMPTY);
    }

    this.setMaximumCost(0);
    this.access.execute((p_234633_1_, p_234633_2_) -> {
      BlockState blockstate = p_234633_1_.getBlockState(p_234633_2_);
      if (!p_230301_1_.abilities.instabuild && blockstate.is(BlockTags.ANVIL) && p_230301_1_.getRandom().nextFloat() < breakChance) {
        BlockState blockstate1 = StoneAnvil.damage(blockstate);
        if (blockstate1 == null) {
          p_234633_1_.removeBlock(p_234633_2_, false);
          p_234633_1_.levelEvent(1029, p_234633_2_, 0);
        } else {
          p_234633_1_.setBlock(p_234633_2_, blockstate1, 2);
          p_234633_1_.levelEvent(1030, p_234633_2_, 0);
        }
      } else {
        p_234633_1_.levelEvent(1030, p_234633_2_, 0);
      }

    });
    return p_230301_2_;
  }

}
