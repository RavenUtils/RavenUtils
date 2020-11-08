package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.util.enums.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmorItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  public static final RegistryObject<ArmorItem> MYTHERINE_HELMET = ITEMS.register("mytherine_helmet",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_CHESTPLATE = ITEMS.register("mytherine_chestplate",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_LEGGINGS = ITEMS.register("mytherine_leggings",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_BOOTS = ITEMS.register("mytherine_boots",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));
}