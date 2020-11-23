package com.sasnos.ravenutils.datagen.global_loot_modifer;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.global_loot_modifiers.QuarzFromStone;
import com.sasnos.ravenutils.init.ModLootTables;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.Alternative;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class EssentialsLootModifier extends GlobalLootModifierProvider {

  public EssentialsLootModifier(DataGenerator gen) {
    super(gen, RavenUtils.MOD_ID);
  }

  @Override
  protected void start() {

//    add("cat_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
//
//        new ILootCondition[]{
//            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
//                EntityPredicate.Builder.create().type(EntityType.CAT).build()).build()
//        },
//        new RandomValueRange(0, 2),
//        true,
//        ModFoodItems.BUSHMEAT.get(),
//        new RandomValueRange(1),
//        false,
//        new RandomValueRange(0, 1),
//        true,
//        new RandomValueRange(0),
//        true,
//        NonNullList.create()
//    ));
//
//    NonNullList<PassiveEntityLootModifier.AdditionalItems> chicken = NonNullList.create();
//    chicken.add(
//        new PassiveEntityLootModifier.AdditionalItems(Items.FEATHER, new RandomValueRange(1, 3), 1f, true));
//
//    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
//        new ILootCondition[]{
//            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
//                EntityPredicate.Builder.create().type(EntityType.CHICKEN).build()).build()
//        },
//        new RandomValueRange(0),
//        false,
//        Items.CHICKEN,
//        new RandomValueRange(1),
//        false,
//        new RandomValueRange(0),
//        false,
//        new RandomValueRange(0),
//        false,
//        chicken
//    ));

    add("stone_quarz_modifier", ModLootTables.QUARZ_DROPPER.get(), new QuarzFromStone(
            new ILootCondition[]{
                    Alternative.builder(
                      BlockStateProperty.builder(Blocks.GRANITE),
                      BlockStateProperty.builder(Blocks.ANDESITE),
                      BlockStateProperty.builder(Blocks.DIORITE)
                    ).build(),
                    RandomChanceWithLooting.builder(0.1f, 0.5f).build()
            },
            1
    ));
  }
}
