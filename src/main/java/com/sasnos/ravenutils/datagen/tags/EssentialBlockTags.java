package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class EssentialBlockTags extends ItemTagsProvider {

  public static ITag.INamedTag<Item> hammers = ItemTags.makeWrapperTag("forge:tools/hammers");
  public static ITag.INamedTag<Item> knives = ItemTags.makeWrapperTag("forge:tools/knives");
  public static ITag.INamedTag<Item> books = ItemTags.makeWrapperTag("forge:books");
  public static ITag.INamedTag<Item> grasses_tall = ItemTags.makeWrapperTag("forge:grasses/tall");
  public static ITag.INamedTag<Item> slimeballs = ItemTags.makeWrapperTag("forge:slimeballs");

  public EssentialBlockTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(dataGenerator, blockTagProvider, RavenUtils.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(hammers).add(
        ModToolItems.HAMMER_OBSIDIAN.get(),
        ModToolItems.HAMMER_IRON.get(),
        ModToolItems.HAMMER_STONE.get()
    );

    getOrCreateBuilder(knives).add(
        ModToolItems.KNIFE_FLINT.get(),
        ModToolItems.KNIFE_IRON.get(),
        ModToolItems.KNIFE_DIAMOND.get()
    );

    getOrCreateBuilder(books).add(
        Items.BOOK,
        Items.WRITABLE_BOOK,
        Items.WRITTEN_BOOK
    );

    getOrCreateBuilder(grasses_tall).add(
        Items.SUGAR_CANE,
        Items.BAMBOO
    );

    getOrCreateBuilder(slimeballs).add(
        ModItems.RESIN_BALL.get()
    );
  }
}
