package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFoodItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // meat
  public static final RegistryObject<Item> BUSHMEAT = ITEMS.register("bushmeat", Bushmeat::new);
  public static final RegistryObject<Item> COOKED_BUSHMEAT = ITEMS.register("cooked_bushmeat", CookedBushmeat::new);

  public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", ItemBase::new);
  public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", ItemBase::new);
  public static final RegistryObject<Item> DUCK_EGG = ITEMS.register("duck_egg", ItemBase::new);
}