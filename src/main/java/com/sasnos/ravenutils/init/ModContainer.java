package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.containers.BagContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainer {
  public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
      DeferredRegister.create(ForgeRegistries.CONTAINERS, RavenUtils.MOD_ID);

  public static final RegistryObject<ContainerType<BagContainer>> BAG_CONTAINER =
          CONTAINER_TYPES.register("bag_container", () -> IForgeContainerType.create(BagContainer::createClientContainer));
}
