package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.tile_entities.BarrelTileEntity;
import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY =
      DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RavenUtils.MOD_ID);

  public static RegistryObject<TileEntityType<SignTileEntity>> SIGN_TILE_ENTITIES = TILE_ENTITY.register(
      "crimwood_sign",
      () -> TileEntityType.Builder
          .create(SignTileEntity::new, ModBlocks.CRIMWOOD_SIGN.get(), ModBlocks.CRIMWOOD_WALL_SIGN.get())
          .build(null));

  public static RegistryObject<TileEntityType<BarrelTileEntity>> BARREL_TILE_ENTITIES = TILE_ENTITY.register(
          "barrel",
          () -> TileEntityType.Builder
          .create(BarrelTileEntity::new, ModBlocks.BARREL.get()).build(null)
  );


}
