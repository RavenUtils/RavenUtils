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
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.*;
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

    LootPool.Builder stick_ground = LootPool.builder()
        .name("stick_ground")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(Items.STICK)
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 1)))
        );
    localLootTables.put(ModBlocks.STICK_GROUND.get(), LootTable.builder().addLootPool(stick_ground));

    LootPool.Builder stone_ground = LootPool.builder()
        .name("stone_ground")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModItems.SMALL_STONE.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 1)))
        );
    localLootTables.put(ModBlocks.STONE_GROUND.get(), LootTable.builder().addLootPool(stone_ground));

    LootPool.Builder crimwood_leaves = LootPool.builder()
        .name("crimwood_leaves")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.CRIMWOOD_LEAVES_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(3)
        )
        .addEntry(ItemLootEntry.builder(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
            .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
            .acceptFunction(ExplosionDecay.builder())
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(Items.STICK)
            .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
            .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
            .weight(1)
        );
    localLootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), LootTable.builder().addLootPool(crimwood_leaves));

    localLootTables.put(ModBlocks.RESIN_BLOCK.get(), createStandardBlockTable("resin_block", ModBlocks.RESIN_BLOCK.get()));

    LootPool.Builder salt_ore = LootPool.builder()
        .name("salt_ore")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.SALT_ORE_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.COARSE_SALT.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.SALT_ORE.get(), LootTable.builder().addLootPool(salt_ore));
    localLootTables.put(ModBlocks.SALT_BLOCK.get(), createStandardBlockTable("salt_block", ModBlocks.SALT_BLOCK.get()));

    LootPool.Builder limestone = LootPool.builder()
        .name("limetone")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.LIMESTONE_BLOCK_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.LIME.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(3, 6)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.LIMESTONE_BLOCK.get(), LootTable.builder().addLootPool(limestone));

    LootPool.Builder black_coal_ore = LootPool.builder()
        .name("black_coal_ore")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.BLACK_COAL_ORE_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.BLACK_COAL.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.BLACK_COAL_ORE.get(), LootTable.builder().addLootPool(black_coal_ore));
    localLootTables.put(ModBlocks.BLACK_COAL_BLOCK.get(), createStandardBlockTable("black_coal_block", ModBlocks.BLACK_COAL_BLOCK.get()));

    LootPool.Builder sulfur_ore = LootPool.builder()
        .name("sulfur_ore")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.SULFUR_ORE_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.SULFUR.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.SULFUR_ORE.get(), LootTable.builder().addLootPool(sulfur_ore));

    LootPool.Builder raven_eye_ore = LootPool.builder()
        .name("raven_eye_ore")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.RAVEN_EYE_ORE_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(3)
        )
        .addEntry(ItemLootEntry.builder(ModItems.RAVEN_EYE_GEM.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 2)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(Items.COBBLESTONE)
            .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
            .acceptFunction(ExplosionDecay.builder())
            .weight(1)
        );
    localLootTables.put(ModBlocks.RAVEN_EYE_ORE.get(), LootTable.builder().addLootPool(raven_eye_ore));
    localLootTables.put(ModBlocks.RAVEN_EYE_BLOCK.get(), createStandardBlockTable("raven_eye_block", ModBlocks.RAVEN_EYE_BLOCK.get()));

    localLootTables.put(ModBlocks.CRIMLEAF.get(), createStandardBlockTable("crimleaf", ModBlocks.CRIMLEAF.get()));
    LootPool.Builder potted_crimleaf_plant = LootPool.builder()
        .name("potted_crimleaf_plant")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.CRIMLEAF_ITEM.get()));
    LootPool.Builder potted_crimleaf_pot = LootPool.builder()
        .name("potted_crimleaf_pot")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(Items.FLOWER_POT));
    localLootTables.put(ModBlocks.POTTED_CRIMLEAF.get(), LootTable.builder()
        .addLootPool(potted_crimleaf_plant)
        .addLootPool(potted_crimleaf_pot));

    localLootTables.put(ModBlocks.CRIMWOOD_SAPLING.get(), createStandardBlockTable("crimwood_sapling", ModBlocks.CRIMWOOD_SAPLING.get()));
    LootPool.Builder potted_crimwood_sapling_plant = LootPool.builder()
        .name("potted_crimwood_sapling_plant")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get()));
    LootPool.Builder potted_crimwood_sapling_pot = LootPool.builder()
        .name("potted_crimwood_sapling_pot")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(Items.FLOWER_POT));
    localLootTables.put(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), LootTable.builder()
        .addLootPool(potted_crimwood_sapling_plant)
        .addLootPool(potted_crimwood_sapling_pot));

    localLootTables.put(ModBlocks.CANDLE.get(), createStandardBlockTable("candle", ModBlocks.CANDLE.get()));

    localLootTables.put(ModBlocks.CRIMWOOD.get(), createStandardBlockTable("crimwood", ModBlocks.CRIMWOOD.get()));
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

    LootPool.Builder mud_block = LootPool.builder()
        .name("mud_block")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.MUD_BLOCK_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.MUD_LUMP.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.MUD_BLOCK.get(), LootTable.builder().addLootPool(mud_block));
    localLootTables.put(ModBlocks.MUD_BRICK_SLAB.get(), createStandardBlockTable("mud_brick_slab", ModBlocks.MUD_BRICK_SLAB.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_STAIRS.get(), createStandardBlockTable("mud_brick_stairs", ModBlocks.MUD_BRICK_STAIRS.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_WALL.get(), createStandardBlockTable("mud_brick_wall", ModBlocks.MUD_BRICK_WALL.get()));
    localLootTables.put(ModBlocks.MUD_BRICKS.get(), createStandardBlockTable("mud_bricks", ModBlocks.MUD_BRICKS.get()));

    LootPool.Builder peat_block = LootPool.builder()
        .name("peat_block")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.PEAT_BLOCK_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(ModItems.PEAT.get())
            .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(1)
        );
    localLootTables.put(ModBlocks.PEAT_BLOCK.get(), LootTable.builder().addLootPool(peat_block));

    localLootTables.put(ModBlocks.BLUEBERRY_BUSH.get(), createStandardBlockTable("blueberry_bush", ModBlocks.BLUEBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.ELDERBERRY_BUSH.get(), createStandardBlockTable("elderberry_bush", ModBlocks.ELDERBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.RASPBERRY_BUSH.get(), createStandardBlockTable("raspberry_bush", ModBlocks.RASPBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.BLACKBERRY_BUSH.get(), createStandardBlockTable("blackberry_bush", ModBlocks.BLACKBERRY_BUSH.get()));
    localLootTables.put(ModBlocks.GOOSEBERRY_BUSH.get(), createStandardBlockTable("gooseberry_bush", ModBlocks.GOOSEBERRY_BUSH.get()));

    localLootTables.put(AlloyFurnaceInit.ALLOY_FURNACE.get(), createStandardBlockTable("alloy_furnace", AlloyFurnaceInit.ALLOY_FURNACE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_ANDESITE.get(), createStandardBlockTable("stone_anvil_andesite", ModBlocks.STONE_ANVIL_ANDESITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_DIORITE.get(), createStandardBlockTable("stone_anvil_diorite", ModBlocks.STONE_ANVIL_DIORITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_GRANITE.get(), createStandardBlockTable("stone_anvil_granite", ModBlocks.STONE_ANVIL_GRANITE.get()));
    localLootTables.put(ModBlocks.STONE_ANVIL_STONE.get(), createStandardBlockTable("stone_anvil_stone", ModBlocks.STONE_ANVIL_STONE.get()));
    localLootTables.put(ModBlocks.STONE_CRAFTING_TABLE.get(), createStandardBlockTable("stone_crafting_table", ModBlocks.STONE_CRAFTING_TABLE.get()));
    localLootTables.put(ModBlocks.DRYING_RACK.get(), createStandardBlockTable("drying_rack", ModBlocks.DRYING_RACK.get()));
    // localLootTables.put(ModBlocks.BARREL.get(), createStandardBlockTable("barrel", ModBlocks.BARREL.get()));

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
        .addEntry(ItemLootEntry.builder(ModBlockItems.FOSSIL_DIRT_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(4)
        )
        .addEntry(ItemLootEntry.builder(Items.BONE)
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(3)
        )
        .addEntry(ItemLootEntry.builder(Items.BONE_MEAL)
            .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(Items.SKELETON_SKULL)
                .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
                .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
                .weight(1)
            // todo add damaged tools, weapons, armor as rare drop
        );
    localLootTables.put(ModBlocks.FOSSIL_DIRT.get(), LootTable.builder().addLootPool(fossil_dirt));

    LootPool.Builder fossil_rock = LootPool.builder()
        .name("fossil_rock")
        .rolls(ConstantRange.of(1))
        .addEntry(ItemLootEntry.builder(ModBlockItems.FOSSIL_ROCK_ITEM.get())
            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .weight(4)
        )
        .addEntry(ItemLootEntry.builder(Items.BONE)
            .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(3)
        )
        .addEntry(ItemLootEntry.builder(Items.BONE_MEAL)
            .acceptFunction(SetCount.builder(new RandomValueRange(2, 4)))
            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
            .weight(2)
        )
        .addEntry(ItemLootEntry.builder(Items.SKELETON_SKULL)
            .acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))
            .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.25f, 1))
            .weight(1)
        );
    localLootTables.put(ModBlocks.FOSSIL_ROCK.get(), LootTable.builder().addLootPool(fossil_rock));
  }
}
