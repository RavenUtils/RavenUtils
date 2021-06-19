package com.sasnos.ravenutils.datagen.global_loot_modifiers;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.global_loot_modifiers.AdditionalDropsForBlocks;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModLootTables;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.conditions.Alternative;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.util.NonNullList;
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
            EntityHasProperty.hasProperties(LootContext.EntityTarget.THIS,
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
            EntityHasProperty.hasProperties(LootContext.EntityTarget.THIS,
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

    add("quartz_from_stone_modifier", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.GRANITE),
            BlockStateProperty.hasBlockStateProperties(Blocks.ANDESITE),
            BlockStateProperty.hasBlockStateProperties(Blocks.DIORITE)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.1f, 0.5f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(ModItems.QUARTZ_SAND.get()))
    ));

    add("sulfur_from_coal_ore", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.COAL_ORE)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.03f, 0.25f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(ModItems.SULFUR.get()))
    ));

    add("plant_fibre_from_tall_vegetation", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.TALL_GRASS),
            BlockStateProperty.hasBlockStateProperties(Blocks.LARGE_FERN),
            BlockStateProperty.hasBlockStateProperties(Blocks.TALL_SEAGRASS),
            BlockStateProperty.hasBlockStateProperties(Blocks.CACTUS)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.35f, 0.5f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(ModItems.PLANT_FIBRE.get()))
    ));

    add("plant_fibre_from_small_vegetation", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.GRASS),
            BlockStateProperty.hasBlockStateProperties(Blocks.FERN),
            BlockStateProperty.hasBlockStateProperties(Blocks.SEAGRASS)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.25f, 0.35f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(ModItems.PLANT_FIBRE.get()))
    ));

    add("small_stone_from_dirt", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.DIRT),
            BlockStateProperty.hasBlockStateProperties(Blocks.COARSE_DIRT),
            BlockStateProperty.hasBlockStateProperties(Blocks.GRASS_BLOCK),
            BlockStateProperty.hasBlockStateProperties(Blocks.FARMLAND)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.15f, 0.25f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(ModItems.SMALL_STONE.get()))
    ));

    add("stick_from_leaves_modifier", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.ACACIA_LEAVES),
            BlockStateProperty.hasBlockStateProperties(Blocks.BIRCH_LEAVES),
            BlockStateProperty.hasBlockStateProperties(Blocks.DARK_OAK_LEAVES),
            BlockStateProperty.hasBlockStateProperties(Blocks.JUNGLE_LEAVES),
            BlockStateProperty.hasBlockStateProperties(Blocks.OAK_LEAVES),
            BlockStateProperty.hasBlockStateProperties(Blocks.SPRUCE_LEAVES)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.25f, 0.25f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(Items.STICK))
    ));

    add("cobble_from_ore", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.REDSTONE_ORE),
            BlockStateProperty.hasBlockStateProperties(Blocks.LAPIS_ORE),
            BlockStateProperty.hasBlockStateProperties(Blocks.EMERALD_ORE),
            BlockStateProperty.hasBlockStateProperties(Blocks.DIAMOND_ORE),
            BlockStateProperty.hasBlockStateProperties(Blocks.COAL_ORE)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.35f, 0.05f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(Items.COBBLESTONE))
    ));

    add("netherrack_from_ore", ModLootTables.AdditionalDrops.get(), new AdditionalDropsForBlocks(
        new ILootCondition[]{Alternative.alternative(
            BlockStateProperty.hasBlockStateProperties(Blocks.NETHER_GOLD_ORE),
            BlockStateProperty.hasBlockStateProperties(Blocks.NETHER_QUARTZ_ORE)
        ).build(), RandomChanceWithLooting.randomChanceAndLootingBoost(0.35f, 0.05f).build()
        }, NonNullList.of(ItemStack.EMPTY, new ItemStack(Items.NETHERRACK))
    ));

  }
}
