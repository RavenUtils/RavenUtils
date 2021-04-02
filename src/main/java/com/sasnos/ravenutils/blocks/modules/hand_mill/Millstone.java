package com.sasnos.ravenutils.blocks.modules.hand_mill;


import com.sasnos.raven_api.blocks.EssentialsMachineBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

public class Millstone extends EssentialsMachineBlock {

  public Millstone() {
    super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
            .harvestTool(ToolType.PICKAXE)
            .hardnessAndResistance(1.2f)
            .harvestLevel(1));
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos.down());
      TileEntity owntile = worldIn.getTileEntity(pos);
      if (tile instanceof HandMillTileEntity) {
        if (player.getHeldItem(handIn) == ItemStack.EMPTY && ((HandMillTileEntity) tile).hasInput()) {
          ((HandMillTileEntity) tile).addTick();
        } else {
          worldIn.getBlockState(pos.down()).onBlockActivated(worldIn, player, handIn, hit.withPosition(pos.down()));
        }
      }

      if (owntile instanceof MillStoneTileEntity) {
        MillStoneTileEntity millStoneTileEntity = (MillStoneTileEntity) owntile;
        if (millStoneTileEntity.addDamage()) {
          worldIn.destroyBlock(pos, false);
        }
      }
    }
    return ActionResultType.SUCCESS;
  }

  @Override
  protected boolean isItemToStartBurning(ItemStack item) {
    return false;
  }

  @Override
  public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    TileEntity te = worldIn.getTileEntity(pos);
    if (te instanceof MillStoneTileEntity) {
      ((MillStoneTileEntity) te).setDamage(stack.getMaxDamage(), stack.getDamage());
    }
    super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
  }


  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new MillStoneTileEntity();
  }
}
