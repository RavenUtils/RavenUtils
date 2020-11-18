package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.tileEntities.SignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class CrimwwodSignStanding extends StandingSignBlock {

  public CrimwwodSignStanding(Properties properties, WoodType type) {
    super(properties, type);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new SignTileEntity();
  }
}
