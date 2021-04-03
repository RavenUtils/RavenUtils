package com.sasnos.ravenutils.tile_entities;

import com.sasnos.ravenutils.init.ModTileEntities;
import net.minecraft.tileentity.TileEntityType;

public class SignTileEntity extends net.minecraft.tileentity.SignTileEntity {

  @Override
  public TileEntityType<?> getType() {
    return ModTileEntities.SIGN_TILE_ENTITIES.get();
  }

}
