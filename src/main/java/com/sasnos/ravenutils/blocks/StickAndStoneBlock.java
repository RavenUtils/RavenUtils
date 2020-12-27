package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class StickAndStoneBlock extends Block {

  protected static final Property<Direction> FACING = HorizontalBlock.HORIZONTAL_FACING;
  private final Supplier<Item> dropItem;

  public StickAndStoneBlock(Properties properties, Supplier<Item> dropItemIn) {
    super(properties);
    this.dropItem = dropItemIn;
  }

  @SuppressWarnings("deprecation")
  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (!worldIn.isRemote && player.getHeldItem(handIn) == ItemStack.EMPTY) {
      InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(dropItem.get()));
      worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
      return ActionResultType.SUCCESS;
    }
    return ActionResultType.PASS;
  }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
