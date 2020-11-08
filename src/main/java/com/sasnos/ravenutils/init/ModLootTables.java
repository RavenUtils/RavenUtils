package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.lootmodifier.Passive_Entity_Modifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootTables {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER = DeferredRegister.create(
            ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, RavenUtils.MOD_ID
    );

    public static final RegistryObject<Passive_Entity_Modifier.Serializer> FRESH_HIDE = LOOT_MODIFIER.register("fresh_hide", Passive_Entity_Modifier.Serializer::new);
}
