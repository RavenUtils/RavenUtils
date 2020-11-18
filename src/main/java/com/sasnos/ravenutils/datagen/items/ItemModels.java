package com.sasnos.ravenutils.datagen.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.sasnos.ravenutils.util.EssentialsUtils.resourceLocation;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RavenUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("item/"+ ModBlockItems.STONE_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(),
                resourceLocation("block/stone_crafting_table"));

        withExistingParent("item/"+ ModBlockItems.STONE_ANVIL_STONE.get().getRegistryName().getPath(),
                resourceLocation("block/stone_anvil_stone"));
    }
}