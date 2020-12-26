package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.global_loot_modifiers.AdditionalDropsForBlocks;
import com.sasnos.ravenutils.global_loot_modifiers.PassiveEntityLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootTables {

  public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER = DeferredRegister.create(
      ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, RavenUtils.MOD_ID
  );

  public static final RegistryObject<PassiveEntityLootModifier.Serializer> PASSIVE_ENTITY = LOOT_MODIFIER
      .register("passive_entity", PassiveEntityLootModifier.Serializer::new);

  public static final RegistryObject<AdditionalDropsForBlocks.Serializer> AdditionalDrops = LOOT_MODIFIER
      .register("additional_drops", AdditionalDropsForBlocks.Serializer::new);
}
