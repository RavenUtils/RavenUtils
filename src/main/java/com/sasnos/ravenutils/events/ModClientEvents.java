package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

  @SubscribeEvent
  public static void onFluidRegistry(RegistryEvent.Register<Fluid> event) {
    // event.getRegistry().register(new LimewaterFluid.Flowing().setRegistryName("limewater_flowing"));
    // event.getRegistry().register(new LimewaterFluid.Source().setRegistryName("limewater"));

    // event.getRegistry().register(new TanninFluid.Flowing().setRegistryName("tannin_flowing"));
    // event.getRegistry().register(new TanninFluid.Source().setRegistryName("tannin"));
  }
}
