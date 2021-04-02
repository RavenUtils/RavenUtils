package com.sasnos.ravenutils.screen;

import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.client.Minecraft;

public class SignScreenCaller {

  public static void openSignScreen(SignTileEntity tile) {
    Minecraft.getInstance().displayGuiScreen(new SignScreen(tile));
  }
}
