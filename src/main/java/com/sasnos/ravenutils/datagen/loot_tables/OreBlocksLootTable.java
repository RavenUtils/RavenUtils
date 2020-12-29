package com.sasnos.ravenutils.datagen.loot_tables;

import com.sasnos.ravenutils.api.datagen.loot_table.BaseLootTableProvider;
import com.sasnos.ravenutils.api.datagen.loot_table.EssentialsLootTableProvider;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

import static com.sasnos.ravenutils.api.datagen.loot_table.BaseLootTableProvider.createStandardBlockTable;

public class OreBlocksLootTable extends EssentialsLootTableProvider<Block> {

  public static final Consumer<Map<Block, LootTable.Builder>> CONSUMER = blockBuilderMap -> {
    for (Map.Entry<Block, LootTable.Builder> entry : blockBuilderMap.entrySet()) {
      BaseLootTableProvider.tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());
    }
  };

  public OreBlocksLootTable() {
    super(CONSUMER, LootParameterSets.BLOCK);
  }

  @Override
  @NotNull
  public Map<Block, LootTable.Builder> getTables() {
    lootTables.put(ModBlocks.COPPER_ORE.get(), createStandardBlockTable("copper_ore", ModBlocks.COPPER_ORE.get()));
    lootTables.put(ModBlocks.TIN_ORE.get(), createStandardBlockTable("tin_ore", ModBlocks.TIN_ORE.get()));
    lootTables.put(ModBlocks.ZINC_ORE.get(), createStandardBlockTable("zinc_ore", ModBlocks.ZINC_ORE.get()));
    lootTables.put(ModBlocks.SILVER_ORE.get(), createStandardBlockTable("silver_ore", ModBlocks.SILVER_ORE.get()));
    lootTables.put(ModBlocks.LEAD_ORE.get(), createStandardBlockTable("lead_ore", ModBlocks.LEAD_ORE.get()));
    lootTables.put(ModBlocks.MYTHERINE_ORE.get(), createStandardBlockTable("mytherine_ore", ModBlocks.MYTHERINE_ORE.get()));

    lootTables.put(ModBlocks.COPPER_BLOCK.get(), createStandardBlockTable("copper_block", ModBlocks.COPPER_BLOCK.get()));
    lootTables.put(ModBlocks.TIN_BLOCK.get(), createStandardBlockTable("tin_block", ModBlocks.TIN_BLOCK.get()));
    lootTables.put(ModBlocks.ZINC_BLOCK.get(), createStandardBlockTable("zinc_block", ModBlocks.ZINC_BLOCK.get()));
    lootTables.put(ModBlocks.BRONZE_BLOCK.get(), createStandardBlockTable("bronze_block", ModBlocks.BRONZE_BLOCK.get()));
    lootTables.put(ModBlocks.BRASS_BLOCK.get(), createStandardBlockTable("brass_block", ModBlocks.BRASS_BLOCK.get()));
    lootTables.put(ModBlocks.SILVER_BLOCK.get(), createStandardBlockTable("silver_block", ModBlocks.SILVER_BLOCK.get()));
    lootTables.put(ModBlocks.LEAD_BLOCK.get(), createStandardBlockTable("lead_block", ModBlocks.LEAD_BLOCK.get()));
    lootTables.put(ModBlocks.STEEL_BLOCK.get(), createStandardBlockTable("steel_block", ModBlocks.STEEL_BLOCK.get()));
    lootTables.put(ModBlocks.MYTHERINE_BLOCK.get(), createStandardBlockTable("mytherine_block", ModBlocks.MYTHERINE_BLOCK.get()));

    return lootTables;
  }
}
