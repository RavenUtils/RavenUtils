package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.client.render.ShieldRenderer;
import com.sasnos.ravenutils.items.EssentialShieldItem;
import com.sasnos.ravenutils.utils.enums.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmorItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  /* todo move all armor to Combat module and adjust properties
  // copper
  public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
      () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
      () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
      () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
      () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));

  // bronze
  public static final RegistryObject<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",
      () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate",
      () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings",
      () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",
      () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));

  // silver
  public static final RegistryObject<ArmorItem> SILVER_HELMET = ITEMS.register("silver_helmet",
      () -> new ArmorItem(ModArmorMaterial.SILVER, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate",
      () -> new ArmorItem(ModArmorMaterial.SILVER, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> SILVER_LEGGINGS = ITEMS.register("silver_leggings",
      () -> new ArmorItem(ModArmorMaterial.SILVER, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> SILVER_BOOTS = ITEMS.register("silver_boots",
      () -> new ArmorItem(ModArmorMaterial.SILVER, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));

  // steel
  public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet",
      () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
      () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
      () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots",
      () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));
   */

  // mytherine
  public static final RegistryObject<ArmorItem> MYTHERINE_HELMET = ITEMS.register("mytherine_helmet",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_CHESTPLATE = ITEMS.register("mytherine_chestplate",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_LEGGINGS = ITEMS.register("mytherine_leggings",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> MYTHERINE_BOOTS = ITEMS.register("mytherine_boots",
      () -> new ArmorItem(ModArmorMaterial.MYTHERINE, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ShieldItem> MYTHERINE_SHIELD = ITEMS.register("mytherine_shield",
      () -> new EssentialShieldItem(new Item.Properties().defaultMaxDamage(24000).group(RavenUtils.TAB).setISTER(() -> ShieldRenderer::new)));
}