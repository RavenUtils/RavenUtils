package com.sasnos.ravenutils.screen;

import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.DistExecutor;

public class SignScreenCaller implements DistExecutor.SafeRunnable {

    private final SignTileEntity tile;

    public SignScreenCaller(SignTileEntity tile){
        this.tile = tile;
    }

    @Override
    public void run() {
        Minecraft.getInstance().displayGuiScreen(new SignScreen(tile));
    }
}
