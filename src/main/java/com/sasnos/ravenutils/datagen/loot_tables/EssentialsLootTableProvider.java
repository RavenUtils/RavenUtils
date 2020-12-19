package com.sasnos.ravenutils.datagen.loot_tables;


import com.sasnos.ravenutils.api.data_generation.loot_table.BaseLootTableProvider;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
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

public class EssentialsLootTableProvider extends BaseLootTableProvider {

  public EssentialsLootTableProvider(DataGenerator dataGeneratorIn) {
    super(dataGeneratorIn);
  }

  @Override
  protected void addTables() {
    // lootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), createStandardTable("crimwood_leaves", ModBlocks.CRIMWOOD_LEAVES.get())); // add sticks

    lootTables.put(ModBlocks.RESIN_BLOCK.get(), createStandardTable("resin_block", ModBlocks.RESIN_BLOCK.get()));
    // lootTables.put(ModBlocks.SALT_ORE.get(), createStandardTable("salt_ore", ModBlocks.SALT_ORE.get()));
    lootTables.put(ModBlocks.SALT_BLOCK.get(), createStandardTable("salt_block", ModBlocks.SALT_BLOCK.get()));

    // lootTables.put(ModBlocks.FOSSIL_ROCK.get(), createStandardTable("fossil_rock", ModBlocks.FOSSIL_ROCK.get()));

    // lootTables.put(ModBlocks.LIMESTONE.get(), createStandardTable("limestone", ModBlocks.LIMESTONE.get()));
    // lootTables.put(ModBlocks.BLACK_COAL_ORE.get(), createStandardTable("black_coal_ore", ModBlocks.BLACK_COAL_ORE.get()));
    lootTables.put(ModBlocks.BLACK_COAL_BLOCK.get(), createStandardTable("black_coal_block", ModBlocks.BLACK_COAL_BLOCK.get()));
    // lootTables.put(ModBlocks.SULFUR_ORE.get(), createStandardTable("sulfur_ore", ModBlocks.SULFUR_ORE.get()));

    // lootTables.put(ModBlocks.RAVEN_EYE_ORE.get(), createStandardTable("raven_eye_ore", ModBlocks.RAVEN_EYE_ORE.get()));
    lootTables.put(ModBlocks.RAVEN_EYE_BLOCK.get(), createStandardTable("raven_eye_block", ModBlocks.RAVEN_EYE_BLOCK.get()));

    lootTables.put(ModBlocks.COPPER_ORE.get(), createStandardTable("copper_ore", ModBlocks.COPPER_ORE.get()));
    lootTables.put(ModBlocks.TIN_ORE.get(), createStandardTable("tin_ore", ModBlocks.TIN_ORE.get()));
    lootTables.put(ModBlocks.ZINC_ORE.get(), createStandardTable("zinc_ore", ModBlocks.ZINC_ORE.get()));
    lootTables.put(ModBlocks.SILVER_ORE.get(), createStandardTable("silver_ore", ModBlocks.SILVER_ORE.get()));
    lootTables.put(ModBlocks.LEAD_ORE.get(), createStandardTable("lead_ore", ModBlocks.LEAD_ORE.get()));
    lootTables.put(ModBlocks.MYTHERINE_ORE.get(), createStandardTable("mytherine_ore", ModBlocks.MYTHERINE_ORE.get()));

    lootTables.put(ModBlocks.COPPER_BLOCK.get(), createStandardTable("copper_block", ModBlocks.COPPER_BLOCK.get()));
    lootTables.put(ModBlocks.TIN_BLOCK.get(), createStandardTable("tin_block", ModBlocks.TIN_BLOCK.get()));
    lootTables.put(ModBlocks.ZINC_BLOCK.get(), createStandardTable("zinc_block", ModBlocks.ZINC_BLOCK.get()));
    lootTables.put(ModBlocks.BRONZE_BLOCK.get(), createStandardTable("bronze_block", ModBlocks.BRONZE_BLOCK.get()));
    lootTables.put(ModBlocks.BRASS_BLOCK.get(), createStandardTable("brass_block", ModBlocks.BRASS_BLOCK.get()));
    lootTables.put(ModBlocks.SILVER_BLOCK.get(), createStandardTable("silver_block", ModBlocks.SILVER_BLOCK.get()));
    lootTables.put(ModBlocks.LEAD_BLOCK.get(), createStandardTable("lead_block", ModBlocks.LEAD_BLOCK.get()));
    lootTables.put(ModBlocks.STEEL_BLOCK.get(), createStandardTable("steel_block", ModBlocks.STEEL_BLOCK.get()));
    lootTables.put(ModBlocks.MYTHERINE_BLOCK.get(), createStandardTable("mytherine_block", ModBlocks.MYTHERINE_BLOCK.get()));

    lootTables.put(ModBlocks.CRIMLEAF.get(), createStandardTable("crimleaf", ModBlocks.CRIMLEAF.get()));
    // lootTables.put(ModBlocks.POTTED_CRIMLEAF.get(), createStandardTable("potted_crimleaf", ModBlocks.POTTED_CRIMLEAF.get()));
    lootTables.put(ModBlocks.CRIMWOOD_SAPLING.get(), createStandardTable("crimwood_sapling", ModBlocks.CRIMWOOD_SAPLING.get()));
    // lootTables.put(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), createStandardTable("potted_crimwood_sapling", ModBlocks.POTTED_CRIMWOOD_SAPLING.get()));

    lootTables.put(ModBlocks.CRIMWOOD.get(), createStandardTable("crimwood", ModBlocks.CRIMWOOD.get()));
    lootTables.put(ModBlocks.CRIMWOOD_STRIPPED.get(), createStandardTable("crimwood_stripped", ModBlocks.CRIMWOOD_STRIPPED.get()));
    lootTables.put(ModBlocks.CRIMWOOD_BUTTON.get(), createStandardTable("crimwood_button", ModBlocks.CRIMWOOD_BUTTON.get()));
    lootTables.put(ModBlocks.CRIMWOOD_DOOR.get(), createStandardTable("crimwood_door", ModBlocks.CRIMWOOD_DOOR.get()));
    lootTables.put(ModBlocks.CRIMWOOD_FENCE.get(), createStandardTable("crimwood_fence", ModBlocks.CRIMWOOD_FENCE.get()));
    lootTables.put(ModBlocks.CRIMWOOD_FENCE_GATE.get(), createStandardTable("crimwood_fence_gate", ModBlocks.CRIMWOOD_FENCE_GATE.get()));
    lootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), createStandardTable("crimwood_leaves", ModBlocks.CRIMWOOD_LEAVES.get()));
    lootTables.put(ModBlocks.CRIMWOOD_LOG.get(), createStandardTable("crimwood_log", ModBlocks.CRIMWOOD_LOG.get()));
    lootTables.put(ModBlocks.CRIMWOOD_LOG_STRIPPED.get(), createStandardTable("crimwood_log_stripped", ModBlocks.CRIMWOOD_LOG_STRIPPED.get()));
    lootTables.put(ModBlocks.CRIMWOOD_PLANKS.get(), createStandardTable("crimwood_planks", ModBlocks.CRIMWOOD_PLANKS.get()));
    lootTables.put(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(), createStandardTable("crimwood_pressure_plate", ModBlocks.CRIMWOOD_PRESSURE_PLATE.get()));
    lootTables.put(ModBlocks.CRIMWOOD_SIGN.get(), createStandardTable("crimwood_sign", ModBlocks.CRIMWOOD_SIGN.get()));
    lootTables.put(ModBlocks.CRIMWOOD_SLAB.get(), createStandardTable("crimwood_slab", ModBlocks.CRIMWOOD_SLAB.get()));
    lootTables.put(ModBlocks.CRIMWOOD_STAIRS.get(), createStandardTable("crimwood_stairs", ModBlocks.CRIMWOOD_STAIRS.get()));
    lootTables.put(ModBlocks.CRIMWOOD_TRAPDOOR.get(), createStandardTable("crimwood_trapdoor", ModBlocks.CRIMWOOD_TRAPDOOR.get()));

    // lootTables.put(ModBlocks.MUD_BLOCK.get(), createStandardTable("mud_block", ModBlocks.MUD_BLOCK.get()));
    lootTables.put(ModBlocks.MUD_BRICK_SLAB.get(), createStandardTable("mud_brick_slab", ModBlocks.MUD_BRICK_SLAB.get()));
    lootTables.put(ModBlocks.MUD_BRICK_STAIRS.get(), createStandardTable("mud_brick_stairs", ModBlocks.MUD_BRICK_STAIRS.get()));
    lootTables.put(ModBlocks.MUD_BRICK_WALL.get(), createStandardTable("mud_brick_wall", ModBlocks.MUD_BRICK_WALL.get()));
    lootTables.put(ModBlocks.MUD_BRICKS.get(), createStandardTable("mud_bricks", ModBlocks.MUD_BRICKS.get()));

    // lootTables.put(ModBlocks.PEAT_BLOCK.get(), createStandardTable("peat_block", ModBlocks.PEAT_BLOCK.get()));

    lootTables.put(ModBlocks.BLUEBERRY_BUSH.get(), createStandardTable("blueberry_bush", ModBlocks.BLUEBERRY_BUSH.get()));
    lootTables.put(ModBlocks.ELDERBERRY_BUSH.get(), createStandardTable("elderberry_bush", ModBlocks.ELDERBERRY_BUSH.get()));
    lootTables.put(ModBlocks.RASPBERRY_BUSH.get(), createStandardTable("raspberry_bush", ModBlocks.RASPBERRY_BUSH.get()));
    lootTables.put(ModBlocks.BLACKBERRY_BUSH.get(), createStandardTable("blackberry_bush", ModBlocks.BLACKBERRY_BUSH.get()));
    lootTables.put(ModBlocks.GOOSEBERRY_BUSH.get(), createStandardTable("gooseberry_bush", ModBlocks.GOOSEBERRY_BUSH.get()));

    // lootTables.put(ModBlocks.STONE_GROUND.get(), createStandardTable("stone_ground", ModItems.SMALL_STONE.get()));
    // lootTables.put(ModBlocks.STICK_GROUND.get(), createStandardTable("stick_ground", Items.STICK));

    lootTables.put(AlloyFurnaceInit.ALLOY_FURNACE.get(), createStandardTable("alloy_furnace", AlloyFurnaceInit.ALLOY_FURNACE.get()));
    lootTables.put(ModBlocks.STONE_ANVIL_ANDESITE.get(), createStandardTable("stone_anvil_andesite", ModBlocks.STONE_ANVIL_ANDESITE.get()));
    lootTables.put(ModBlocks.STONE_ANVIL_DIORITE.get(), createStandardTable("stone_anvil_diorite", ModBlocks.STONE_ANVIL_DIORITE.get()));
    lootTables.put(ModBlocks.STONE_ANVIL_GRANITE.get(), createStandardTable("stone_anvil_granite", ModBlocks.STONE_ANVIL_GRANITE.get()));
    lootTables.put(ModBlocks.STONE_ANVIL_STONE.get(), createStandardTable("stone_anvil_stone", ModBlocks.STONE_ANVIL_STONE.get()));
    lootTables.put(ModBlocks.STONE_CRAFTING_TABLE.get(), createStandardTable("stone_crafting_table", ModBlocks.STONE_CRAFTING_TABLE.get()));
    lootTables.put(ModBlocks.DRYING_RACK.get(), createStandardTable("drying_rack", ModBlocks.DRYING_RACK.get()));
    // lootTables.put(ModBlocks.BARREL.get(), createStandardTable("barrel", ModBlocks.BARREL.get()));

    lootTables.put(HandMillInit.HAND_MILL.get(), createStandardTable("hand_mill", HandMillInit.HAND_MILL.get()));
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
    lootTables.put(HandMillInit.MILLSTONE.get(), LootTable.builder().addLootPool(millstone));

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
    lootTables.put(ModBlocks.FOSSIL_DIRT.get(), LootTable.builder().addLootPool(fossil_dirt));

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
    lootTables.put(ModBlocks.FOSSIL_ROCK.get(), LootTable.builder().addLootPool(fossil_rock));
  }
}
