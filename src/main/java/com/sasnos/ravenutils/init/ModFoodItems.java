package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.*;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFoodItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  public static final RegistryObject<Item> BUSHMEAT = ITEMS.register("bushmeat", Bushmeat::new);
  public static final RegistryObject<Item> COOKED_BUSHMEAT = ITEMS.register("cooked_bushmeat", CookedBushmeat::new);

  public static final RegistryObject<Item> SQUID_MEAT = ITEMS.register("squid_meat", SquidMeat::new);
  public static final RegistryObject<Item> COOKED_SQUID_MEAT = ITEMS.register("cooked_squid_meat", CookedSquidMeat::new);

  public static final RegistryObject<Item> WHEAT_FLOUR = ITEMS.register("wheat_flour", ItemBase::new);
  public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", ItemBase::new);
  public static final RegistryObject<Item> DUCK_EGG = ITEMS.register("duck_egg", DuckEgg::new);

  public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
      () -> new BlockNamedItem(ModBlocks.BLUEBERRY_BUSH.get(), (new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> ELDERBERRIES = ITEMS.register("elderberries",
      () -> new BlockNamedItem(ModBlocks.ELDERBERRY_BUSH.get(), (new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> RASPBERRIES = ITEMS.register("raspberries",
      () -> new BlockNamedItem(ModBlocks.RASPBERRY_BUSH.get(), (new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> BLACKBERRIES = ITEMS.register("blackberries",
      () -> new BlockNamedItem(ModBlocks.BLACKBERRY_BUSH.get(), (new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.SWEET_BERRIES)));
  public static final RegistryObject<Item> GOOSEBERRIES = ITEMS.register("gooseberries",
      () -> new BlockNamedItem(ModBlocks.GOOSEBERRY_BUSH.get(), (new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.SWEET_BERRIES)));
}