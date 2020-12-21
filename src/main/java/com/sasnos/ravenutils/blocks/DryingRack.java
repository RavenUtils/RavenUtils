package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.api.blocks.EssentialsCommonMachineBlock;
import com.sasnos.ravenutils.tile_entities.DryingRackTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public class DryingRack extends EssentialsCommonMachineBlock {

  public static final DirectionProperty FACING = BlockStateProperties.FACING;


  public DryingRack() {
    super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
        .hardnessAndResistance(2.5F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
            .notSolid()
    );
  }

  @SuppressWarnings("deprecation")
  @Override
  public @NotNull ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

    if(!worldIn.isRemote){
      TileEntity tile = worldIn.getTileEntity(pos);

      if(!(tile instanceof DryingRackTileEntity)) return ActionResultType.FAIL;

      DryingRackTileEntity dryTile = (DryingRackTileEntity) tile;
      LazyOptional<IItemHandler> cap = dryTile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

      if(!cap.isPresent()) return ActionResultType.FAIL;

      IItemHandler handler = cap.resolve().get();

      double x = Math.abs(hit.getHitVec().x);
      double z = Math.abs(hit.getHitVec().z);
      BigDecimal bigx = new BigDecimal( x % 1);
      BigDecimal bigz = new BigDecimal( z % 1);
      Direction facing = state.get(FACING);

      boolean top = isTop(bigx, bigz, facing, true);

      boolean left = isTop(bigz, bigx , facing, false);

      int slot = getSelectedSlot(top, left);

      ItemStack stack = handler.getStackInSlot(slot);
      if(player.getHeldItem(handIn) == ItemStack.EMPTY || ItemStack.areItemsEqual(stack, player.getHeldItem(handIn))){
        if(stack == ItemStack.EMPTY) return ActionResultType.CONSUME;
        player.addItemStackToInventory(handler.extractItem(slot, 1, false));

      }
      else {
        if(stack != ItemStack.EMPTY || !handler.isItemValid(slot, stack)) return ActionResultType.FAIL;
        ItemStack remain = handler.insertItem(slot, player.getHeldItem(handIn), false);
        if(!player.isCreative()){
          if(remain == ItemStack.EMPTY){
            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
          }
          else
          {
            player.getHeldItem(handIn).setCount(remain.getCount());
          }
        }

      }
    }

    return ActionResultType.SUCCESS;
  }

  private boolean isTop(BigDecimal x, BigDecimal z, Direction facing, boolean isForTop) {
    int compareX = x.compareTo(new BigDecimal("0.5"));
    int compareZ = z.compareTo(new BigDecimal("0.5"));
    if (facing == Direction.NORTH) {
      if(isForTop){
        return (compareZ >= 0 && compareX < 0) || (compareX >= 0 && compareZ > 0) ;
      }
      return (compareX >= 0 && compareZ < 0) || (compareX <= 0 && compareZ <= 0);

    } else if (facing == Direction.EAST) {
      if(isForTop){
        return compareX >= 0;
      }
      else {
        return compareX > 0;
      }
    } else if (facing == Direction.SOUTH) {
      if(isForTop){
        return (compareX >=0 && compareZ <= 0) || (compareX < 0 && compareZ <= 0);
      }
      return (compareX >=0 && compareZ >= 0) || (compareX < 0 && compareZ >= 0);

    } else if (facing == Direction.WEST) {
      if(isForTop){
        return compareX < 0;
      }
      else {
        return (compareX < 0 && compareZ >= 0) || (compareX < 0 && compareZ < 0) ;
      }
    }

    return true;
  }

  private int getSelectedSlot(boolean top, boolean left) {
      //top left
      if (top && left) return 0;
      //top right
      if (top) return 1;
      //bottom left
      if (left) return 2;
      //bottom right
      return 3;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new DryingRackTileEntity();
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
