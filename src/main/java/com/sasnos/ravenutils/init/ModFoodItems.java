package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.Bushmeat;
import com.sasnos.ravenutils.items.CookedBushmeat;
import com.sasnos.ravenutils.items.CookedPoultry;
import com.sasnos.ravenutils.items.Poultry;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFoodItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // meat
  public static final RegistryObject<Item> POULTRY = ITEMS.register("poultry", Poultry::new);
  public static final RegistryObject<Item> BUSHMEAT = ITEMS.register("bushmeat", Bushmeat::new);

  public static final RegistryObject<Item> COOKED_POULTRY = ITEMS.register("cooked_poultry", CookedPoultry::new);
  public static final RegistryObject<Item> COOKED_BUSHMEAT = ITEMS.register("cooked_bushmeat", CookedBushmeat::new);
}