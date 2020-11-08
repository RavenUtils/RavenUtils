package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class EssentialItemTags extends ItemTagsProvider {

    public static ITag.INamedTag<Item> hammer = ItemTags.makeWrapperTag("forge:tools/hammer");

    public EssentialItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, RavenUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(hammer).add(ModToolItems.OBSIDIAN_HAMMER.get(), ModToolItems.STONE_HAMMER.get());

    }
}
