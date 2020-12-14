package com.sasnos.ravenutils.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;

public class SafeClientCall {

    public static ClientWorld getClientWorld(){
        return Minecraft.getInstance().world;
    }
}
