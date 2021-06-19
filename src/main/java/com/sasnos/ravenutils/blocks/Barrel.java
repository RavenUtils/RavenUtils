package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipe;
import com.sasnos.ravenutils.tile_entities.BarrelTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
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
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class Barrel extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.FACING;
  public static BooleanProperty HAS_LID = BlockStateProperties.OPEN;

  public Barrel() {
    super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD)
        .strength(5.0F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
  }

  @SuppressWarnings("deprecation")
  @Override
  public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

    if (!worldIn.isClientSide) {
      ItemStack playerItem = player.getItemInHand(handIn);
      if (playerItem.getItem() == ModItems.BARREL_LID.get() && !state.getValue(Barrel.HAS_LID)) {
        worldIn.setBlockAndUpdate(pos, state.setValue(Barrel.HAS_LID, true));
        playerItem.shrink(1);
        return ActionResultType.SUCCESS;
      } else if (playerItem == ItemStack.EMPTY && state.getValue(Barrel.HAS_LID)) {
        worldIn.setBlockAndUpdate(pos, state.setValue(HAS_LID, false));
        player.addItem(new ItemStack(ModItems.BARREL_LID.get()));
        return ActionResultType.SUCCESS;
      }

      TileEntity genTile = worldIn.getBlockEntity(pos);
      if (!(genTile instanceof BarrelTileEntity))
        throw new IllegalStateException("missing TileEntity for Barrel @ " + pos.toShortString());
      BarrelTileEntity tile = (BarrelTileEntity) genTile;

      int index = player.inventory.selected;
      if (playerItem.getCapability(
          CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).isPresent() ||
          playerItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY
          ).isPresent()) {
        LazyOptional<IFluidHandler> fluidHandler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
        if (fluidHandler.isPresent()) {
          IFluidHandler handler = fluidHandler.resolve().get();
          boolean worked = FluidUtil.interactWithFluidHandler(player, handIn, handler);
          if (worked) {
            tile.updateClient();

            return ActionResultType.SUCCESS;
          }
          return ActionResultType.FAIL;
        }
      }

      LazyOptional<IItemHandler> itemhandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
      if (itemhandler.isPresent()) {
        IItemHandler handler = itemhandler.resolve().get();
        if (playerItem != ItemStack.EMPTY) {
          if (handler.isItemValid(0, playerItem)) {
            ItemStack old = handler.insertItem(0, playerItem, false);
            player.setSlot(index, old);
            tile.updateClient();
            int timer = 0;
            BarrelRecipe recipe = tile.getRecipe(handler.getStackInSlot(0));
            if (recipe != null) timer = recipe.getTimer();
            tile.setCookingTimeTotal(timer);

            return ActionResultType.SUCCESS;
          }
          return ActionResultType.FAIL;
        } else {
          ItemStack item = handler.getStackInSlot(0);
          if (item == ItemStack.EMPTY) return ActionResultType.PASS;
          player.addItem(item);
          tile.updateClient();

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
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(HAS_LID, false);
  }

  @Override
  protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
    builder.add(HAS_LID);
  }
}
