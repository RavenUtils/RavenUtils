package com.sasnos.ravenutils.datagen.globalLootModifer;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModLootTables;
import com.sasnos.ravenutils.lootModifier.PassiveEntityModifier;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.EntityHasProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class EssentialsLootModifier extends GlobalLootModifierProvider {

  public EssentialsLootModifier(DataGenerator gen) {
    super(gen, RavenUtils.MOD_ID);
  }

  @Override
  protected void start() {

    add("loot_cat", ModLootTables.FRESH_HIDE.get(), new PassiveEntityModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(EntityType.CAT).build()
            ).build(),
        },
        0, 2,
        ModFoodItems.BUSHMEAT.get(), 0, 2,
        0, 1,
        0, 0,
        NonNullList.create()
    ));

    add("loot_ocelot", ModLootTables.FRESH_HIDE.get(), new PassiveEntityModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(EntityType.OCELOT).build()
            ).build(),
        },
        0, 2,
        ModFoodItems.BUSHMEAT.get(), 0, 2,
        0, 1,
        0, 0,
        NonNullList.create()
    ));

    add("loot_chicken", ModLootTables.FRESH_HIDE.get(), new PassiveEntityModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(EntityType.CHICKEN).build()
            ).build(),
        },
        0, 0,
        ModFoodItems.POULTRY.get(), 0, 1,
        0, 0,
        0, 0,
        NonNullList.create()
    ));
  }
}
