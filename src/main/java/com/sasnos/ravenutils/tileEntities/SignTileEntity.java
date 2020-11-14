package com.sasnos.ravenutils.tileEntities;

import com.sasnos.ravenutils.init.ModTileEntities;
import net.minecraft.tileentity.TileEntityType;

public class SignTileEntity extends net.minecraft.tileentity.SignTileEntity {

  public SignTileEntity() {
    super();
  }

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntities.SIGN_TILE_ENTITIES.get();
    }

}
