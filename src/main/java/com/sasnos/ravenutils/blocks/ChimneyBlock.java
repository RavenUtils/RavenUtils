package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.AbstractBlock.Properties;

public class ChimneyBlock extends Block implements IChimney {

  public ChimneyBlock(Properties properties) {
    super(properties);
  }

  @Override
  public void updateBlock(IWorld worldIn, BlockState facingState) {

  }

  @SuppressWarnings("deprecation")
  @Override
  public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    if (facing == Direction.DOWN) updateBlock(worldIn, facingState);
    return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
  }

  @Override
  public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    super.setPlacedBy(worldIn, pos, state, placer, stack);
  }
}
