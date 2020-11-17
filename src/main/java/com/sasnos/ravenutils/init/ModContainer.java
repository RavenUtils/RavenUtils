package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainer {
    public static final DeferredRegister<ContainerType<?>> CONTAINERTYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, RavenUtils.MOD_ID);
}
