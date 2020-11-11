package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.fluids.LimewaterFluid;
import com.sasnos.ravenutils.fluids.TanninFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

  public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, RavenUtils.MOD_ID);



  public static final RegistryObject<LimewaterFluid.Flowing> FLOWING_LIMEWATER = FLUIDS.register("flowing_limewater", LimewaterFluid.Flowing::new);
  public static final RegistryObject<LimewaterFluid.Source> LIMEWATER = FLUIDS.register("source_limewater", LimewaterFluid.Source::new);

  public static final RegistryObject<TanninFluid.Flowing> FLOWING_TANNIN = FLUIDS.register("flowing_tanning", TanninFluid.Flowing::new);

  public static final RegistryObject<TanninFluid.Source> TANNIN = FLUIDS.register("source_tanning", TanninFluid.Source::new);
}
