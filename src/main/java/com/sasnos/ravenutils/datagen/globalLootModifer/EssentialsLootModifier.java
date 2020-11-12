package com.sasnos.ravenutils.datagen.globalLootModifer;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModLootTables;
import com.sasnos.ravenutils.lootModifier.PassiveEntityLootModifier;
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

    add("cat_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CAT).build()
            ).build(),
        },
        new RandomValueRange(0, 2),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        false,
        NonNullList.create()
    ));

    add("ocelot_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.OCELOT).build()
            ).build(),
        },
        new RandomValueRange(0, 2),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        false,
        NonNullList.create()
    ));

    NonNullList<PassiveEntityLootModifier.AdditionalItems> chicken = NonNullList.create();
    chicken.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.FEATHER, 1, 3, 1f, true)
    );

    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CHICKEN).build()
            ).build(),
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

    NonNullList<PassiveEntityLootModifier.AdditionalItems> parrot = NonNullList.create();
    chicken.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.FEATHER, 1, 3, 1f, true)
    );

    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.PARROT).build()
            ).build(),
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
        parrot
    ));

    /*
    NonNullList<PassiveEntityLootModifier.AdditionalItems> duck = NonNullList.create();
    chicken.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.DUCK_FEATHER, 1, 3, 1f, true)
    );

    add("duck_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.DUCK).build()
            ).build(),
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
        duck
    ));
    */

    add("fox_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.FOX).build()
            ).build(),
        },
        new RandomValueRange(0, 2),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        false,
        NonNullList.create()
    ));

    /*
    add("snow_fox_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.SNOW_FOX).build()
            ).build(),
        },
        new RandomValueRange(0, 2),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        false,
        NonNullList.create()
    ));
    */

    NonNullList<PassiveEntityLootModifier.AdditionalItems> rabbit = NonNullList.create();
    rabbit.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.RABBIT_FOOT, 0, 1, 0.03f, true)
    );

    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.RABBIT).build()
            ).build(),
        },
        new RandomValueRange(0, 1),
        true,
        Items.RABBIT,
        new RandomValueRange(0, 1),
        true,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        rabbit
    ));

    add("horse_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.HORSE).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("donkey_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.DONKEY).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("mule_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.MULE).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("llama_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.LLAMA).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("trader_llama_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.TRADER_LLAMA).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("cow_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.COW).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("mooshroom_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.MOOSHROOM).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        Items.BEEF,
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(2, 6),
        true,
        NonNullList.create()
    ));

    add("sheep_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.SHEEP).build()
            ).build(),
        },
        new RandomValueRange(3, 6),
        true,
        Items.MUTTON,
        new RandomValueRange(3, 6),
        true,
        new RandomValueRange(1, 3),
        true,
        new RandomValueRange(1, 4),
        true,
        NonNullList.create()
    ));

    add("pig_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.PIG).build()
            ).build(),
        },
        new RandomValueRange(3, 6),
        true,
        Items.PORKCHOP,
        new RandomValueRange(3, 6),
        true,
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(1, 4),
        true,
        NonNullList.create()
    ));

    /* todo add in Magic module
    NonNullList<PassiveEntityLootModifier.AdditionalItems> wolf = NonNullList.create();
    wolf.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.WOLF_TOOTH, 1, 2, 0.1f, true)
    );
    */
    add("wolf_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.WOLF).build()
            ).build(),
        },
        new RandomValueRange(2, 4),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(1, 2),
        true,
        new RandomValueRange(1, 3),
        true,
        NonNullList.create()
        // wolf
    ));

    NonNullList<PassiveEntityLootModifier.AdditionalItems> turtle = NonNullList.create();
    turtle.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.SCUTE, 0, 2, 1f, true)
    );
    add("turtle_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.TURTLE).build()
            ).build(),
        },
        new RandomValueRange(0),
        false,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(2, 4),
        true,
        new RandomValueRange(0, 2),
        true,
        new RandomValueRange(0),
        false,
        turtle
    ));

    NonNullList<PassiveEntityLootModifier.AdditionalItems> polar_bear = NonNullList.create();
    polar_bear.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.COD, 0, 1, 1f, true)
    );
    /* todo add in Magic module
    polar_bear.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.BEAR_CLAW, 0, 2, 0.25f, true)
    );
    */
    add("polar_bear_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.POLAR_BEAR).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(3, 6),
        true,
        new RandomValueRange(2, 6),
        true,
        polar_bear
    ));

    NonNullList<PassiveEntityLootModifier.AdditionalItems> panda = NonNullList.create();
    panda.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.BAMBOO, 0, 1, 1f, true)
    );
    /* todo add in Magic module
    panda.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.BEAR_CLAW, 0, 2, 0.25f, true)
    );
    */
    add("panda_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.PANDA).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(3, 6),
        true,
        new RandomValueRange(2, 6),
        true,
        panda
    ));

    /*
    NonNullList<PassiveEntityLootModifier.AdditionalItems> black_bear = NonNullList.create();
    black_bear.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.HONEYCOMB, 0, 1, 1f, true)
    );
    black_bear.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.BEAR_CLAW, 0, 2, 0.25f, true)
    );
    add("black_bear_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.BLACK_BEAR).build()
            ).build(),
        },
        new RandomValueRange(4, 8),
        true,
        ModFoodItems.BUSHMEAT.get(),
        new RandomValueRange(4, 8),
        true,
        new RandomValueRange(3, 6),
        true,
        new RandomValueRange(2, 6),
        true,
        black_bear
    ));
    */

    NonNullList<PassiveEntityLootModifier.AdditionalItems> villager = NonNullList.create();
    /*
    villager.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.CLOTH, 0, 2, 1f, true)
    );
    */
    villager.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.COPPER_COIN.get(), 0, 1, 0.1f, true)
    );
    villager.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.BREAD, 0, 1, 0.25f, true)
    );
    villager.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.CARROT, 0, 1, 0.25f, true)
    );
    villager.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.APPLE, 0, 1, 0.25f, true)
    );
    add("villager_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.VILLAGER).build()
            ).build(),
        },
        new RandomValueRange(0),
        false,
        null,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        villager
    ));

    NonNullList<PassiveEntityLootModifier.AdditionalItems> wandering_trader = NonNullList.create();
    /*
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.CLOTH, 0, 2, 1f, true)
    );
    */
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.COPPER_COIN.get(), 0, 1, 0.50f, true)
    );
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.SILVER_COIN.get(), 0, 1, 0.25f, true)
    );
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        ModItems.GOLD_COIN.get(), 0, 1, 0.15f, true)
    );
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.BREAD, 0, 1, 0.25f, true)
    );
    wandering_trader.add(new PassiveEntityLootModifier.AdditionalItems(
        Items.APPLE, 0, 1, 0.25f, true)
    );
    add("wandering_trader_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.WANDERING_TRADER).build()
            ).build(),
        },
        new RandomValueRange(0),
        false,
        null,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        new RandomValueRange(0),
        false,
        wandering_trader
    ));
  }
}
