package com.sasnos.ravenutils.blocks.crimwood;

import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class CrimwoodSignWall extends WallSignBlock {

  public CrimwoodSignWall(Properties properties, WoodType type) {
    super(properties, type);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new SignTileEntity();
  }
}
