package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.api.utils.Utils;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.items.BaseBucketItem;
import com.sasnos.ravenutils.tile_entities.BarrelTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class Barrel extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  public static BooleanProperty HAS_LID = BlockStateProperties.OPEN;


  public Barrel() {
    super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
        .hardnessAndResistance(5.0F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
  }

  @SuppressWarnings("deprecation")
  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

    if(!worldIn.isRemote){
      ItemStack playerItem = player.getHeldItem(handIn);
      if (playerItem.getItem() == ModItems.BARREL_LIT.get() && !state.get(Barrel.HAS_LID)){
        worldIn.setBlockState(pos, state.with(Barrel.HAS_LID, true));
        playerItem.shrink(1);
        return ActionResultType.SUCCESS;
      }
      TileEntity tile = worldIn.getTileEntity(pos);
      if(tile == null) throw new IllegalStateException("missing TileEntity for Barrel @ " + pos.getCoordinatesAsString());
      int index = player.inventory.currentItem;
      LazyOptional<IFluidHandler> fluidHandler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
      if(fluidHandler.isPresent()){
        IFluidHandler handler = fluidHandler.resolve().get();
        if(playerItem.getItem() instanceof BucketItem){
          BucketItem bucket = (BucketItem) playerItem.getItem();
          FluidStack filler = Utils.createFluidStackFromBucket(bucket);
          if(handler.isFluidValid(0, filler)){
            int amount = handler.fill(filler, IFluidHandler.FluidAction.SIMULATE);
            if(amount == 0) return ActionResultType.FAIL;
            handler.fill(filler, IFluidHandler.FluidAction.EXECUTE);

            player.replaceItemInInventory(index, bucket.getContainerItem(playerItem));
            return ActionResultType.SUCCESS;
          }
        }

        if(playerItem.getItem() instanceof BaseBucketItem){
          BaseBucketItem baseBucketItem = (BaseBucketItem) playerItem.getItem();
          FluidStack filler = Utils.createFluidStackFromBucket(baseBucketItem, playerItem);
          int amount = handler.fill(filler, IFluidHandler.FluidAction.SIMULATE);
          if(amount == 0) return ActionResultType.FAIL;
          handler.fill(filler, IFluidHandler.FluidAction.EXECUTE);
          player.replaceItemInInventory(index, baseBucketItem.getContainerItem(playerItem));
          return ActionResultType.SUCCESS;
        }
      }



      LazyOptional<IItemHandler> itemhandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
      if(itemhandler.isPresent()) {
        IItemHandler handler = itemhandler.resolve().get();
        if (playerItem != ItemStack.EMPTY) {
          if (handler.isItemValid(0, playerItem)) {
            ItemStack old = handler.insertItem(0, playerItem, false);
            player.replaceItemInInventory(index, old);
            return ActionResultType.SUCCESS;
          }
          return ActionResultType.FAIL;
        } else {
          ItemStack item = handler.getStackInSlot(0);
          if(item == ItemStack.EMPTY) return ActionResultType.PASS;
          player.addItemStackToInventory(item);
          return ActionResultType.SUCCESS;
        }
      }
    }

    return ActionResultType.SUCCESS;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new BarrelTileEntity();
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
    builder.add(HAS_LID);
  }
}
