package com.sasnos.ravenutils.utils.enums;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

  /* todo move to Combat module
  COPPER(RavenUtils.MOD_ID + ":copper",
      14000,
      new int[]{5, 10, 8, 5},
      100,
      SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
      4.0F, () -> {
    return Ingredient.fromItems(ModItems.COPPER_INGOT.get());
  },
      0.5F),
  BRONZE(RavenUtils.MOD_ID + ":bronze",
      14000,
      new int[]{5, 10, 8, 5},
      100,
      SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
      4.0F, () -> {
    return Ingredient.fromItems(ModItems.BRONZE_INGOT.get());
  },
      0.5F),
  SILVER(RavenUtils.MOD_ID + ":silver",
      14000,
      new int[]{5, 10, 8, 5},
      100,
      SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
      4.0F, () -> {
    return Ingredient.fromItems(ModItems.SILVER_INGOT.get());
  },
      0.5F),
  STEEL(RavenUtils.MOD_ID + ":steel",
      14000,
      new int[]{5, 10, 8, 5},
      100,
      SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
      4.0F, () -> {
    return Ingredient.fromItems(ModItems.STEEL_INGOT.get());
  },
      0.5F),
   */
  MYTHERINE(RavenUtils.MOD_ID + ":mytherine",
      14000,
      new int[]{5, 10, 8, 5},
      100,
      SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
      4.0F, () -> {
    return Ingredient.fromItems(ModItems.MYTHERINE_INGOT.get());
  },
      0.5F);

  private static final int[] MAX_DAMAGE_ARRAY = new int[]{11, 16, 15, 13};
  private final String name;
  private final int maxDamageFactor;
  private final int[] damageReductionAmountArray;
  private final int enchantability;
  private final SoundEvent soundEvent;
  private final float toughness;
  private final Supplier<Ingredient> repairMaterial;
  private final float knockbackResistance;

  ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
    this.name = name;
    this.maxDamageFactor = maxDamageFactor;
    this.damageReductionAmountArray = damageReductionAmountArray;
    this.enchantability = enchantability;
    this.soundEvent = soundEvent;
    this.toughness = toughness;
    this.repairMaterial = repairMaterial;
    this.knockbackResistance = knockbackResistance;
  }

  @Override
  public int getDurability(EquipmentSlotType slotIn) {
    return MAX_DAMAGE_ARRAY[slotIn.getIndex()] + this.maxDamageFactor;
  }

  @Override
  public int getDamageReductionAmount(EquipmentSlotType slotIn) {
    return this.damageReductionAmountArray[slotIn.getIndex()];
  }

  @Override
  public int getEnchantability() {
    return this.enchantability;
  }

  @Override
  public SoundEvent getSoundEvent() {
    return this.soundEvent;
  }

  @Override
  public Ingredient getRepairMaterial() {
    return this.repairMaterial.get();
  }

  @OnlyIn(Dist.CLIENT)
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public float getToughness() {
    return this.toughness;
  }

  @Override
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }
}
