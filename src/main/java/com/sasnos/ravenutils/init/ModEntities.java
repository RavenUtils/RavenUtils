package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, RavenUtils.MOD_ID);

}
