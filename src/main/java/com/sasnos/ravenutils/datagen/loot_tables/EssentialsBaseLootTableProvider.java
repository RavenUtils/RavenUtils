package com.sasnos.ravenutils.datagen.loot_tables;

import com.sasnos.raven_api.datagen.loot_table.BaseLootTableProvider;
import com.sasnos.ravenutils.RavenUtils;
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
    super(dataGeneratorIn, RavenUtils.MOD_ID);
  }

  @Override
  protected void addTables() {
    new OreBlocksLootTable();

    LootPool.Builder stick_ground = LootPool.lootPool()
        .name("stick_ground")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(Items.STICK)
            .apply(SetCount.setCount(new RandomValueRange(1, 1)))
        );
    localLootTables.put(ModBlocks.STICK_GROUND.get(), LootTable.lootTable().withPool(stick_ground));

    LootPool.Builder stone_ground = LootPool.lootPool()
        .name("stone_ground")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModItems.SMALL_STONE.get())
            .apply(SetCount.setCount(new RandomValueRange(1, 1)))
        );
    localLootTables.put(ModBlocks.STONE_GROUND.get(), LootTable.lootTable().withPool(stone_ground));

    LootPool.Builder crimwood_leaves = LootPool.lootPool()
        .name("crimwood_leaves")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.CRIMWOOD_LEAVES_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(3)
        )
        .add(ItemLootEntry.lootTableItem(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get())
            .apply(SetCount.setCount(new RandomValueRange(0, 1)))
            .apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.25f, 1))
            .apply(ExplosionDecay.explosionDecay())
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(Items.STICK)
            .apply(SetCount.setCount(new RandomValueRange(0, 1)))
            .apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.25f, 1))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.CRIMWOOD_LEAVES.get(), LootTable.lootTable().withPool(crimwood_leaves));

    localLootTables.put(ModBlocks.RESIN_BLOCK.get(), createStandardBlockTable("resin_block", ModBlocks.RESIN_BLOCK.get()));

    LootPool.Builder salt_ore = LootPool.lootPool()
        .name("salt_ore")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.SALT_ORE_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.COARSE_SALT.get())
            .apply(SetCount.setCount(new RandomValueRange(1, 3)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.SALT_ORE.get(), LootTable.lootTable().withPool(salt_ore));
    localLootTables.put(ModBlocks.SALT_BLOCK.get(), createStandardBlockTable("salt_block", ModBlocks.SALT_BLOCK.get()));

    LootPool.Builder limestone = LootPool.lootPool()
        .name("limetone")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.LIMESTONE_BLOCK_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.LIME.get())
            .apply(SetCount.setCount(new RandomValueRange(3, 6)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.LIMESTONE_BLOCK.get(), LootTable.lootTable().withPool(limestone));

    LootPool.Builder black_coal_ore = LootPool.lootPool()
        .name("black_coal_ore")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.BLACK_COAL_ORE_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.BLACK_COAL.get())
            .apply(SetCount.setCount(new RandomValueRange(1, 3)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.BLACK_COAL_ORE.get(), LootTable.lootTable().withPool(black_coal_ore));
    localLootTables.put(ModBlocks.BLACK_COAL_BLOCK.get(), createStandardBlockTable("black_coal_block", ModBlocks.BLACK_COAL_BLOCK.get()));

    LootPool.Builder sulfur_ore = LootPool.lootPool()
        .name("sulfur_ore")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.SULFUR_ORE_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.SULFUR.get())
            .apply(SetCount.setCount(new RandomValueRange(1, 3)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.SULFUR_ORE.get(), LootTable.lootTable().withPool(sulfur_ore));

    LootPool.Builder raven_eye_ore = LootPool.lootPool()
        .name("raven_eye_ore")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.RAVEN_EYE_ORE_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(3)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.RAVEN_EYE_GEM.get())
            .apply(SetCount.setCount(new RandomValueRange(1, 2)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(Items.COBBLESTONE)
            .apply(SetCount.setCount(new RandomValueRange(0, 1)))
            .apply(ExplosionDecay.explosionDecay())
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.RAVEN_EYE_ORE.get(), LootTable.lootTable().withPool(raven_eye_ore));
    localLootTables.put(ModBlocks.RAVEN_EYE_BLOCK.get(), createStandardBlockTable("raven_eye_block", ModBlocks.RAVEN_EYE_BLOCK.get()));

    localLootTables.put(ModBlocks.CRIMLEAF.get(), createStandardBlockTable("crimleaf", ModBlocks.CRIMLEAF.get()));
    LootPool.Builder potted_crimleaf_plant = LootPool.lootPool()
        .name("potted_crimleaf_plant")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.CRIMLEAF_ITEM.get()));
    LootPool.Builder potted_crimleaf_pot = LootPool.lootPool()
        .name("potted_crimleaf_pot")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(Items.FLOWER_POT));
    localLootTables.put(ModBlocks.POTTED_CRIMLEAF.get(), LootTable.lootTable()
        .withPool(potted_crimleaf_plant)
        .withPool(potted_crimleaf_pot));

    localLootTables.put(ModBlocks.CRIMWOOD_SAPLING.get(), createStandardBlockTable("crimwood_sapling", ModBlocks.CRIMWOOD_SAPLING.get()));
    LootPool.Builder potted_crimwood_sapling_plant = LootPool.lootPool()
        .name("potted_crimwood_sapling_plant")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get()));
    LootPool.Builder potted_crimwood_sapling_pot = LootPool.lootPool()
        .name("potted_crimwood_sapling_pot")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(Items.FLOWER_POT));
    localLootTables.put(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), LootTable.lootTable()
        .withPool(potted_crimwood_sapling_plant)
        .withPool(potted_crimwood_sapling_pot));

    localLootTables.put(ModBlocks.CANDLE.get(), createStandardBlockTable("candle", ModBlocks.CANDLE.get()));

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

    LootPool.Builder mud_block = LootPool.lootPool()
        .name("mud_block")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.MUD_BLOCK_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.MUD_LUMP.get())
            .apply(SetCount.setCount(new RandomValueRange(2, 4)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.MUD_BLOCK.get(), LootTable.lootTable().withPool(mud_block));
    localLootTables.put(ModBlocks.MUD_BRICK_SLAB.get(), createStandardBlockTable("mud_brick_slab", ModBlocks.MUD_BRICK_SLAB.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_STAIRS.get(), createStandardBlockTable("mud_brick_stairs", ModBlocks.MUD_BRICK_STAIRS.get()));
    localLootTables.put(ModBlocks.MUD_BRICK_WALL.get(), createStandardBlockTable("mud_brick_wall", ModBlocks.MUD_BRICK_WALL.get()));
    localLootTables.put(ModBlocks.MUD_BRICKS.get(), createStandardBlockTable("mud_bricks", ModBlocks.MUD_BRICKS.get()));

    LootPool.Builder peat_block = LootPool.lootPool()
        .name("peat_block")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.PEAT_BLOCK_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(ModItems.PEAT.get())
            .apply(SetCount.setCount(new RandomValueRange(2, 4)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.PEAT_BLOCK.get(), LootTable.lootTable().withPool(peat_block));

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
    LootPool.Builder millstone = LootPool.lootPool()
        .name("mill_stone")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(HandMillInit.MILLSTONE.get())
            .apply(CopyName.copyName(CopyName.Source.BLOCK_ENTITY))
            .apply(CopyNbt.copyData(CopyNbt.Source.BLOCK_ENTITY)
                .copy("damage", "Damage", CopyNbt.Action.REPLACE)
            )
            .apply(SetContents.setContents()
                .withEntry(DynamicLootEntry.dynamicEntry(new ResourceLocation("minecraft", "contents"))))
        );
    localLootTables.put(HandMillInit.MILLSTONE.get(), LootTable.lootTable().withPool(millstone));

    LootPool.Builder fossil_dirt = LootPool.lootPool()
        .name("fossil_dirt")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.FOSSIL_DIRT_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(4)
        )
        .add(ItemLootEntry.lootTableItem(Items.BONE)
            .apply(SetCount.setCount(new RandomValueRange(1, 3)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(3)
        )
        .add(ItemLootEntry.lootTableItem(Items.BONE_MEAL)
            .apply(SetCount.setCount(new RandomValueRange(2, 4)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(Items.SKELETON_SKULL)
                .apply(SetCount.setCount(new RandomValueRange(0, 1)))
                .apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.25f, 1))
                .setWeight(1)
            // todo add damaged tools, weapons, armor as rare drop
        );
    localLootTables.put(ModBlocks.FOSSIL_DIRT.get(), LootTable.lootTable().withPool(fossil_dirt));

    LootPool.Builder fossil_rock = LootPool.lootPool()
        .name("fossil_rock")
        .setRolls(ConstantRange.exactly(1))
        .add(ItemLootEntry.lootTableItem(ModBlockItems.FOSSIL_ROCK_ITEM.get())
            .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
            .setWeight(4)
        )
        .add(ItemLootEntry.lootTableItem(Items.BONE)
            .apply(SetCount.setCount(new RandomValueRange(1, 3)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(3)
        )
        .add(ItemLootEntry.lootTableItem(Items.BONE_MEAL)
            .apply(SetCount.setCount(new RandomValueRange(2, 4)))
            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
            .setWeight(2)
        )
        .add(ItemLootEntry.lootTableItem(Items.SKELETON_SKULL)
            .apply(SetCount.setCount(new RandomValueRange(0, 1)))
            .apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.25f, 1))
            .setWeight(1)
        );
    localLootTables.put(ModBlocks.FOSSIL_ROCK.get(), LootTable.lootTable().withPool(fossil_rock));
  }
}
