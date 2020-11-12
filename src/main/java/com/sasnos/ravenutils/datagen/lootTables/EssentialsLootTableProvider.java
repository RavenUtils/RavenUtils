package com.sasnos.ravenutils.datagen.lootTables;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.DataGenerator;

public class EssentialsLootTableProvider extends BaseLootTableProvider {

  public EssentialsLootTableProvider(DataGenerator dataGeneratorIn) {
    super(dataGeneratorIn);
  }

  @Override
  protected void addTables() {
    lootTables.put(ModBlocks.BRASS_BLOCK.get(), createStandardTable("brass_block", ModBlocks.BRASS_BLOCK.get()));
  }
}
