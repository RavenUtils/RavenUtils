package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.global_loot_modifiers.*;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootTables {

  public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER = DeferredRegister.create(
      ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, RavenUtils.MOD_ID
  );

  public static final RegistryObject<PassiveEntityLootModifier.Serializer> FRESH_HIDE = LOOT_MODIFIER
      .register("fresh_hide", PassiveEntityLootModifier.Serializer::new);

  public static final RegistryObject<QuartzFromStone.Serializer> QUARTZ_FROM_STONE = LOOT_MODIFIER
      .register("quartz_from_stone", QuartzFromStone.Serializer::new);

  public static final RegistryObject<SulfurFromCoalOre.Serializer> SULFUR_FROM_COAL_ORE = LOOT_MODIFIER
      .register("sulfur_from_coal_ore", SulfurFromCoalOre.Serializer::new);

  public static final RegistryObject<PlantFibreFromTallGrass.Serializer> PLANT_FIBRE_FROM_TALL_GRASS = LOOT_MODIFIER
      .register("plant_fibre_from_tall_grass", PlantFibreFromTallGrass.Serializer::new);

  public static final RegistryObject<ResinFromSpruceWood.Serializer> RESIN_FROM_SPRUCE_WOOD = LOOT_MODIFIER
      .register("resin_from_spruce_wood", ResinFromSpruceWood.Serializer::new);

  public static final RegistryObject<StickFromLeaves.Serializer> STICK_FROM_LEAVES = LOOT_MODIFIER
      .register("stick_from_leaves", StickFromLeaves.Serializer::new);

  public static final RegistryObject<SmallStoneFromDirt.Serializer> SMALL_STONE_FROM_DIRT = LOOT_MODIFIER
      .register("small_stone_from_dirt", SmallStoneFromDirt.Serializer::new);

  public static final RegistryObject<CobbleFromOre.Serializer> COBBLE_FROM_ORE = LOOT_MODIFIER
      .register("cobble_from_ore", CobbleFromOre.Serializer::new);

  public static final RegistryObject<NetherrackFromOre.Serializer> NETHERRACK_FROM_ORE = LOOT_MODIFIER
      .register("netherrack_from_ore", NetherrackFromOre.Serializer::new);
}
