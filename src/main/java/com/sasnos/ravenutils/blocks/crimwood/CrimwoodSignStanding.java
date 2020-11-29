package com.sasnos.ravenutils.blocks.crimwood;

import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class CrimwoodSignStanding extends StandingSignBlock {

  public CrimwoodSignStanding(Properties properties, WoodType type) {
    super(properties, type);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new SignTileEntity();
  }
}
