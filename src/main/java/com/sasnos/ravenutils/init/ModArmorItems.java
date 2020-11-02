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

  public static final RegistryObject<ArmorItem> RAVENINE_HELMET = ITEMS.register("ravenine_helmet",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_CHESTPLATE = ITEMS.register("ravenine_chestplate",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_LEGGINGS = ITEMS.register("ravenine_leggings",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_BOOTS = ITEMS.register("ravenine_boots",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));
}