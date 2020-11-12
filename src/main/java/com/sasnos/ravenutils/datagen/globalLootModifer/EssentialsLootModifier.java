package com.sasnos.ravenutils.datagen.globalLootModifer;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModLootTables;
import com.sasnos.ravenutils.lootModifier.PassiveEntityModifier;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.RandomValueRange;
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

    add("cat_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityModifier(

        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CAT).build()).build(),
        },
        new RandomValueRange(0, 2),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(1),
        false,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        true,
        NonNullList.create()
    ));

    NonNullList<PassiveEntityModifier.AdditionalItems> chicken = NonNullList.create();
    chicken.add(
        new PassiveEntityModifier.AdditionalItems(Items.FEATHER, new RandomValueRange(1, 3), 1f, true));

    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CHICKEN).build()).build(),
        },
        new RandomValueRange(0),
        false,
        Items.CHICKEN,
        new RandomValueRange(1),
        false,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        chicken
    ));
  }
}
