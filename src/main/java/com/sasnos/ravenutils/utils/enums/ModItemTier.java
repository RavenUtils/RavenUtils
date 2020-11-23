package com.sasnos.ravenutils.utils.enums;

import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

  // see https://mcreator.net/wiki/how-make-tool for property examples
  COPPER(1,
      180,
      8.0F,
      1.0F,
      14, () -> {
    return Ingredient.fromItems(ModItems.COPPER_INGOT.get());
  }),
  BRONZE(3,
      640,
      10.0F,
      3.0F,
      18, () -> {
    return Ingredient.fromItems(ModItems.BRONZE_INGOT.get());
  }),
  SILVER(2,
      210,
      6.0F,
      2.0F,
      22, () -> {
    return Ingredient.fromItems(ModItems.SILVER_INGOT.get());
  }),
  STEEL(4,
      1080,
      12.0F,
      4.0F,
      18, () -> {
    return Ingredient.fromItems(ModItems.STEEL_INGOT.get());
  }),
  MYTHERINE(7,
      16000,
      24.0F,
      6.0F,
      66, () -> {
    return Ingredient.fromItems(ModItems.MYTHERINE_INGOT.get());
  });

  private final int harvestLevel;
  private final int maxUses;
  private final float efficiency;
  private final float attackDamage;
  private final int enchantability;
  private final Supplier<Ingredient> repairMaterial;

  ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
    this.harvestLevel = harvestLevel;
    this.maxUses = maxUses;
    this.efficiency = efficiency;
    this.attackDamage = attackDamage;
    this.enchantability = enchantability;
    this.repairMaterial = repairMaterial;
  }

  @Override
  public int getMaxUses() {
    return maxUses;
  }

  @Override
  public float getEfficiency() {
    return efficiency;
  }

  @Override
  public float getAttackDamage() {
    return attackDamage;
  }

  @Override
  public int getHarvestLevel() {
    return harvestLevel;
  }

  @Override
  public int getEnchantability() {
    return enchantability;
  }

  @Override
  public Ingredient getRepairMaterial() {
    return repairMaterial.get();
  }
}
