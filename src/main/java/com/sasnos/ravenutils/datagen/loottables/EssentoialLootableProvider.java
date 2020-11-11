package com.sasnos.ravenutils.datagen.loottables;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.DataGenerator;

public class EssentoialLootableProvider extends BaseLootTableProvider {

    public EssentoialLootableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(ModBlocks.BRASS_BLOCK.get(), createStandardTable("brass_blokc", ModBlocks.BRASS_BLOCK.get()));
    }
}
