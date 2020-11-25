package com.sasnos.ravenutils.blocks.modules.handmill;

import com.sasnos.ravenutils.api.blocks.EssentialsCommonMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

public class Millstone extends EssentialsCommonMachineBlock {


  public Millstone() {
    super(Properties.create(Material.ROCK, MaterialColor.STONE)
        .harvestTool(ToolType.PICKAXE)
        .hardnessAndResistance(1.2f)
        .harvestLevel(1));
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos.down());
      if (tile instanceof HandMillTileEntity) {
        worldIn.getBlockState(pos.down()).onBlockActivated(worldIn, player, handIn, hit.withPosition(pos.down()));
      }
    }
    return ActionResultType.SUCCESS;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return false;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return null;
  }
}
