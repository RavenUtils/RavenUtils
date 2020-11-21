package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModFoodItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ElderberryBush extends SweetBerryBushBlock {

  public ElderberryBush(Properties properties) {
    super(properties);
  }

  @Override
  public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
    return new ItemStack(ModFoodItems.ELDERBERRIES.get());
  }

  @Override
  public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
  }
}