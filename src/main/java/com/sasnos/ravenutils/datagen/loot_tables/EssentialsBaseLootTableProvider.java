package com.sasnos.ravenutils.datagen.loot_tables;


import com.sasnos.ravenutils.api.data_generation.loot_table.BaseLootTableProvider;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.DynamicLootEntry;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetContents;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class EssentialsBaseLootTableProvider extends BaseLootTableProvider {
  
  private final Map<Block, LootTable.Builder> localLootTables = new HashMap<>();

  public EssentialsBaseLootTableProvider(DataGenerator dataGeneratorIn) {
    super(dataGeneratorIn);
  }

  @Override
  protected void addTables() {
    new OreBlocksLootTable();
    // localLootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), createStandardTable("crimwood_leaves", ModBlocks.CRIMWOOD_LEAVES.get())); // add sticks

    localLootTables.put(ModBlocks.RESIN_BLOCK.get(), createStandardBlockTable("resin_block", ModBlocks.RESIN_BLOCK.get()));
    // localLootTables.put(ModBlocks.SALT_ORE.get(), createStandardTable("salt_ore", ModBlocks.SALT_ORE.get()));
    localLootTables.put(ModBlocks.SALT_BLOCK.get(), createStandardBlockTable("salt_block", ModBlocks.SALT_BLOCK.get()));

    // localLootTables.put(ModBlocks.FOSSIL_ROCK.get(), createStandardTable("fossil_rock", ModBlocks.FOSSIL_ROCK.get()));

    // localLootTables.put(ModBlocks.LIMESTONE.get(), createStandardTable("limestone", ModBlocks.LIMESTONE.get()));
    // localLootTables.put(ModBlocks.BLACK_COAL_ORE.get(), createStandardTable("black_coal_ore", ModBlocks.BLACK_COAL_ORE.get()));
    localLootTables.put(ModBlocks.BLACK_COAL_BLOCK.get(), createStandardBlockTable("black_coal_block", ModBlocks.BLACK_COAL_BLOCK.get()));
    // localLootTables.put(ModBlocks.SULFUR_ORE.get(), createStandardTable("sulfur_ore", ModBlocks.SULFUR_ORE.get()));

    // localLootTables.put(ModBlocks.RAVEN_EYE_ORE.get(), createStandardTable("raven_eye_ore", ModBlocks.RAVEN_EYE_ORE.get()));
    localLootTables.put(ModBlocks.RAVEN_EYE_BLOCK.get(), createStandardBlockTable("raven_eye_block", ModBlocks.RAVEN_EYE_BLOCK.get()));

//    localLootTables.put(ModBlocks.COPPER_ORE.get(), createStandardBlockTable("copper_ore", ModBlocks.COPPER_ORE.get()));
//    localLootTables.put(ModBlocks.TIN_ORE.get(), createStandardBlockTable("tin_ore", ModBlocks.TIN_ORE.get()));
//    localLootTables.put(ModBlocks.ZINC_ORE.get(), createStandardBlockTable("zinc_ore", ModBlocks.ZINC_ORE.get()));
//    localLootTables.put(ModBlocks.SILVER_ORE.get(), createStandardBlockTable("silver_ore", ModBlocks.SILVER_ORE.get()));
//    localLootTables.put(ModBlocks.LEAD_ORE.get(), createStandardBlockTable("lead_ore", ModBlocks.LEAD_ORE.get()));
//    localLootTables.put(ModBlocks.MYTHERINE_ORE.get(), createStandardBlockTable("mytherine_ore", ModBlocks.MYTHERINE_ORE.get()));
//
//    localLootTables.put(ModBlocks.COPPER_BLOCK.get(), createStandardBlockTable("copper_block", ModBlocks.COPPER_BLOCK.get()));
//    localLootTables.put(ModBlocks.TIN_BLOCK.get(), createStandardBlockTable("tin_block", ModBlocks.TIN_BLOCK.get()));
//    localLootTables.put(ModBlocks.ZINC_BLOCK.get(), createStandardBlockTable("zinc_block", ModBlocks.ZINC_BLOCK.get()));
//    localLootTables.put(ModBlocks.BRONZE_BLOCK.get(), createStandardBlockTable("bronze_block", ModBlocks.BRONZE_BLOCK.get()));
//    localLootTables.put(ModBlocks.BRASS_BLOCK.get(), createStandardBlockTable("brass_block", ModBlocks.BRASS_BLOCK.get()));
//    localLootTables.put(ModBlocks.SILVER_BLOCK.get(), createStandardBlockTable("silver_block", ModBlocks.SILVER_BLOCK.get()));
//    localLootTables.put(ModBlocks.LEAD_BLOCK.get(), createStandardBlockTable("lead_block", ModBlocks.LEAD_BLOCK.get()));
//    localLootTables.put(ModBlocks.STEEL_BLOCK.get(), createStandardBlockTable("steel_block", ModBlocks.STEEL_BLOCK.get()));
//    localLootTables.put(ModBlocks.MYTHERINE_BLOCK.get(), createStandardBlockTable("mytherine_block", ModBlocks.MYTHERINE_BLOCK.get()));

    localLootTables.put(ModBlocks.CRIMLEAF.get(), createStandardBlockTable("crimleaf", ModBlocks.CRIMLEAF.get()));
    // localLootTables.put(ModBlocks.POTTED_CRIMLEAF.get(), createStandardTable("potted_crimleaf", ModBlocks.POTTED_CRIMLEAF.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_SAPLING.get(), createStandardBlockTable("crimwood_sapling", ModBlocks.CRIMWOOD_SAPLING.get()));
    // localLootTables.put(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), createStandardTable("potted_crimwood_sapling", ModBlocks.POTTED_CRIMWOOD_SAPLING.get()));

    localLootTables.put(ModBlocks.CRIMWOOD.get(), createStandardBlockTable("crimwood", ModBlocks.CRIMWOOD.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_STRIPPED.get(), createStandardBlockTable("crimwood_stripped", ModBlocks.CRIMWOOD_STRIPPED.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_BUTTON.get(), createStandardBlockTable("crimwood_button", ModBlocks.CRIMWOOD_BUTTON.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_DOOR.get(), createStandardBlockTable("crimwood_door", ModBlocks.CRIMWOOD_DOOR.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_FENCE.get(), createStandardBlockTable("crimwood_fence", ModBlocks.CRIMWOOD_FENCE.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_FENCE_GATE.get(), createStandardBlockTable("crimwood_fence_gate", ModBlocks.CRIMWOOD_FENCE_GATE.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), createStandardBlockTable("crimwood_leaves", ModBlocks.CRIMWOOD_LEAVES.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_LOG.get(), createStandardBlockTable("crimwood_log", ModBlocks.CRIMWOOD_LOG.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_LOG_STRIPPED.get(), createStandardBlockTable("crimwood_log_stripped", ModBlocks.CRIMWOOD_LOG_STRIPPED.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_PLANKS.get(), createStandardBlockTable("crimwood_planks", ModBlocks.CRIMWOOD_PLANKS.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(), createStandardBlockTable("crimwood_pressure_plate", ModBlocks.CRIMWOOD_PRESSURE_PLATE.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_SIGN.get(), createStandardBlockTable("crimwood_sign", ModBlocks.CRIMWOOD_SIGN.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_SLAB.get(), createStandardBlockTable("crimwood_slab", ModBlocks.CRIMWOOD_SLAB.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_STAIRS.get(), createStandardBlockTable("crimwood_stairs", ModBlocks.CRIMWOOD_STAIRS.get()));
    localLootTables.put(ModBlocks.CRIMWOOD_TRAPDOOR.get(), createStandardBlockTable("crimwood_trapdoor", ModBlocks.CRIMWOOD_TRAPDOOR.get()));

    // localLootTables.put(ModBlocks.MUD_BLOCK.get(), createStandardTable("mud_block", ModBlocks.MUD_BLOCK.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_SLAB.get(), createStandardBlockTable("mud_brick_slab", ModBlocks.MUD_BRICK_SLAB.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_STAIRS.get(), createStandardBlockTable("mud_brick_stairs", ModBlocks.MUD_BRICK_STAIRS.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_WALL.get(), createStandardBlockTable("mud_brick_wall", ModBlocks.MUD_BRICK_WALL.get()));
    localLootTables.put(ModBlocks.MUD_BRICKS.get(), createStandardBlockTable("mud_bricks", ModBlocks.MUD_BRICKS.get()));

    // localLootTables.put(ModBlocks.PEAT_BLOCK.get(), createStandardTable("peat_block", ModBlocks.PEAT_BLOCK.get()));

    localLootTables.put(ModBlocks.BLUEBERRY_BUSH.get(), createStandardBlockTable("blueberry_bush", ModBlocks.BLUEBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.ELDERBERRY_BUSH.get(), createStandardBlockTable("elderberry_bush", ModBlocks.ELDERBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.RASPBERRY_BUSH.get(), createStandardBlockTable("raspberry_bush", ModBlocks.RASPBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.BLACKBERRY_BUSH.get(), createStandardBlockTable("blackberry_bush", ModBlocks.BLACKBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.GOOSEBERRY_BUSH.get(), createStandardBlockTable("gooseberry_bush", ModBlocks.GOOSEBERRY_BUSH.get()));

    // localLootTables.put(ModBlocks.STONE_GROUND.get(), createStandardTable("stone_ground", ModItems.SMALL_STONE.get()));
    // localLootTables.put(ModBlocks.STICK_GROUND.get(), createStandardTable("stick_ground", Items.STICK));

    localLootTables.put(AlloyFurnaceInit.ALLOY_FURNACE.get(), createStandardBlockTable("alloy_furnace", AlloyFurnaceInit.ALLOY_FURNACE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_ANDESITE.get(), createStandardBlockTable("stone_anvil_andesite", ModBlocks.STONE_ANVIL_ANDESITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_DIORITE.get(), createStandardBlockTable("stone_anvil_diorite", ModBlocks.STONE_ANVIL_DIORITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_GRANITE.get(), createStandardBlockTable("stone_anvil_granite", ModBlocks.STONE_ANVIL_GRANITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_STONE.get(), createStandardBlockTable("stone_anvil_stone", ModBlocks.STONE_ANVIL_STONE.get()));
    localLootTables.put(ModBlocks.STONE_CRAFTING_TABLE.get(), createStandardBlockTable("stone_crafting_table", ModBlocks.STONE_CRAFTING_TABLE.get()));
    localLootTables.put(ModBlocks.DRYING_RACK.get(), createStandardBlockTable("drying_rack", ModBlocks.DRYING_RACK.get()));
    // localLootTables.put(ModBlocks.BARREL.get(), createStandardTable("barrel", ModBlocks.BARREL.get()));

    localLootTables.put(HandMillInit.HAND_MILL.get(), createStandardBlockTable("hand_mill", HandMillInit.HAND_MILL.get()));
    LootPool.Builder millstone = LootPool.builder()
        .name("mill_stone")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(HandMillInit.MILLSTONE.get())
            .acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY))
            .acceptFunction(CopyNbt.builder(CopyNbt.Source.BLOCK_ENTITY)
                .addOperation("damage", "Damage", CopyNbt.Action.REPLACE)
            )
            .acceptFunction(SetContents.builderIn()
                .addLootEntry(DynamicLootEntry.func_216162_a(new ResourceLocation("minecraft", "contents"))))
        );
    localLootTables.put(HandMillInit.MILLSTONE.get(), LootTable.builder().addLootPool(millstone));

    LootPool.Builder fossil_dirt = LootPool.builder()
        .name("fossil_dirt")
        .rolls(ConstantRange.of(1))
        .addEntry(
            ItemLootEntry.builder(ModBlockItems.FOSSIL_DIRT_ITEM.get())
                .acceptCondition(MatchTool
                    .builder(
                        ItemPredicate.Builder.create()
                            .enchantment(
                                new EnchantmentPredicate(
                                    Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)
                                )
                            )
                    )
                ).weight(4))
        .addEntry(
            ItemLootEntry.builder(Items.BONE)
                .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
                .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                .acceptFunction(ExplosionDecay.builder()).weight(3))

        .addEntry(
            ItemLootEntry.builder(Items.BONE_MEAL)
                .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
                .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                .acceptFunction(ExplosionDecay.builder()).weight(2))

        .addEntry(
            ItemLootEntry.builder(Items.SKELETON_SKULL)
                .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
                .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
                .weight(1)
            // todo add damaged tools, weapons, armor as rare drop
        );
    localLootTables.put(ModBlocks.FOSSIL_DIRT.get(), LootTable.builder().addLootPool(fossil_dirt));

    LootPool.Builder fossil_rock = LootPool.builder()
        .name("fossil_rock")
        .rolls(ConstantRange.of(1))
        .addEntry(
            ItemLootEntry.builder(ModBlockItems.FOSSIL_ROCK_ITEM.get())
                .acceptCondition(MatchTool
                    .builder(
                        ItemPredicate.Builder.create()
                            .enchantment(
                                new EnchantmentPredicate(
                                    Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)
                                )
                            )
                    )
                ).weight(4))
        .addEntry(
            ItemLootEntry.builder(Items.BONE)
                .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
                .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                .acceptFunction(ExplosionDecay.builder()).weight(3))

        .addEntry(
            ItemLootEntry.builder(Items.BONE_MEAL)
                .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
                .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                .acceptFunction(ExplosionDecay.builder()).weight(2))

        .addEntry(
            ItemLootEntry.builder(Items.SKELETON_SKULL)
                .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
                .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
                .weight(1)
        );
    localLootTables.put(ModBlocks.FOSSIL_ROCK.get(), LootTable.builder().addLootPool(fossil_rock));

    lootTables.add(localLootTables);
  }
}
