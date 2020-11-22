package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class StickAndStoneBlock extends Block {

  private Item dropItem;

  public StickAndStoneBlock(Properties properties, Item dropItemIn) {
    super(properties);
    this.dropItem = dropItemIn;
  }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote && player.getHeldItem(handIn) == ItemStack.EMPTY){
            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(dropItem));
            worldIn.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
}
