package com.sasnos.ravenutils.datagen.global_loot_modifiers;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.global_loot_modifiers.*;
import com.sasnos.ravenutils.init.ModLootTables;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.Alternative;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class EssentialsLootModifiers extends GlobalLootModifierProvider {

  public EssentialsLootModifiers(DataGenerator gen) {
    super(gen, RavenUtils.MOD_ID);
  }

  @Override
  protected void start() {

    /*
    add("cat_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CAT).build()).build()
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

    NonNullList<PassiveEntityLootModifier.AdditionalItems> chicken = NonNullList.create();
    chicken.add(
        new PassiveEntityLootModifier.AdditionalItems(Items.FEATHER, new RandomValueRange(1, 3), 1f, true));

    add("chicken_modifier", ModLootTables.FRESH_HIDE.get(), new PassiveEntityLootModifier(
        new ILootCondition[]{
            EntityHasProperty.func_237477_a_(LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.create().type(EntityType.CHICKEN).build()).build()
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
    */

    add("quartz_from_stone_modifier", ModLootTables.QUARTZ_FROM_STONE.get(), new QuartzFromStone(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.GRANITE),
            BlockStateProperty.builder(Blocks.ANDESITE),
            BlockStateProperty.builder(Blocks.DIORITE)
        ).build(), RandomChanceWithLooting.builder(0.1f, 0.5f).build()
        }, 1
    ));

    add("sulfur_from_coal_ore", ModLootTables.SULFUR_FROM_COAL_ORE.get(), new SulfurFromCoalOre(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.COAL_ORE)
        ).build(), RandomChanceWithLooting.builder(0.03f, 0.25f).build()
        }, 1
    ));

    add("plant_fibre_from_tall_grass_modifier", ModLootTables.PLANT_FIBRE_FROM_TALL_GRASS.get(), new PlantFibreFromTallGrass(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.TALL_GRASS)
        ).build(), RandomChanceWithLooting.builder(0.35f, 0.5f).build()
        }, 1
    ));

    // todo how to maybe drop resin only once from a log?
    add("resin_from_spruce_wood_modifier", ModLootTables.RESIN_FROM_SPRUCE_WOOD.get(), new ResinFromSpruceWood(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.SPRUCE_LOG)
        ).build(), RandomChanceWithLooting.builder(0.25f, 0.25f).build()
        }, 1
    ));

    add("small_stone_from_dirt", ModLootTables.SMALL_STONE_FROM_DIRT.get(), new SmallStoneFromDirt(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.DIRT),
            BlockStateProperty.builder(Blocks.COARSE_DIRT),
            BlockStateProperty.builder(Blocks.GRASS_BLOCK),
            BlockStateProperty.builder(Blocks.FARMLAND)
        ).build(), RandomChanceWithLooting.builder(0.15f, 0.25f).build()
        }, 1
    ));

    add("stick_from_leaves_modifier", ModLootTables.STICK_FROM_LEAVES.get(), new StickFromLeaves(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.ACACIA_LEAVES),
            BlockStateProperty.builder(Blocks.BIRCH_LEAVES),
            BlockStateProperty.builder(Blocks.DARK_OAK_LEAVES),
            BlockStateProperty.builder(Blocks.JUNGLE_LEAVES),
            BlockStateProperty.builder(Blocks.OAK_LEAVES),
            BlockStateProperty.builder(Blocks.SPRUCE_LEAVES)
        ).build(), RandomChanceWithLooting.builder(0.25f, 0.25f).build()
        }, 1
    ));

    add("cobble_from_ore", ModLootTables.COBBLE_FROM_ORE.get(), new CobbleFromOre(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.REDSTONE_ORE),
            BlockStateProperty.builder(Blocks.LAPIS_ORE),
            BlockStateProperty.builder(Blocks.EMERALD_ORE),
            BlockStateProperty.builder(Blocks.DIAMOND_ORE),
            BlockStateProperty.builder(Blocks.COAL_ORE)
        ).build(), RandomChanceWithLooting.builder(0.35f, 0.05f).build()
        }, 1
    ));

    add("netherrack_from_ore", ModLootTables.NETHERRACK_FROM_ORE.get(), new NetherrackFromOre(
        new ILootCondition[]{Alternative.builder(
            BlockStateProperty.builder(Blocks.NETHER_GOLD_ORE),
            BlockStateProperty.builder(Blocks.NETHER_QUARTZ_ORE)
        ).build(), RandomChanceWithLooting.builder(0.35f, 0.05f).build()
        }, 1
    ));
  }
}
