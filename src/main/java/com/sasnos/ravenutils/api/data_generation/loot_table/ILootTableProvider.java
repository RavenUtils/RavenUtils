package com.sasnos.ravenutils.api.data_generation.loot_table;

import net.minecraft.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface ILootTableProvider<T> {

  @NotNull
  Map<T, LootTable.Builder> getTables();
}
