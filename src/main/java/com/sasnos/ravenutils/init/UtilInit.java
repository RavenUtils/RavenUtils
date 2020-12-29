package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.world.FacingBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UtilInit {

  public static final DeferredRegister<BlockStateProviderType<?>> BLOCKSTATEPROVIDER =
      DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, RavenUtils.MOD_ID);

  public static final RegistryObject<BlockStateProviderType<FacingBlockStateProvider>> FACING_PROVIDER =
      BLOCKSTATEPROVIDER.register("facing_provider", () -> new BlockStateProviderType<>(FacingBlockStateProvider.CODEC));

}
