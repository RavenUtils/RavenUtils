package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModFoodItems;
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

public class EssentialsItemTags extends ItemTagsProvider {

  public static ITag.INamedTag<Item> hammers = ItemTags.makeWrapperTag("forge:tools/hammers");
  public static ITag.INamedTag<Item> knives = ItemTags.makeWrapperTag("forge:tools/knives");

  public static ITag.INamedTag<Item> books = ItemTags.makeWrapperTag("forge:books");
  public static ITag.INamedTag<Item> grasses_tall = ItemTags.makeWrapperTag("forge:grasses/tall");
  public static ITag.INamedTag<Item> slimeballs = ItemTags.makeWrapperTag("forge:slimeballs");

  public static ITag.INamedTag<Item> raw_red_meat = ItemTags.makeWrapperTag("forge:meat/raw_red_meat");
  public static ITag.INamedTag<Item> raw_poultry = ItemTags.makeWrapperTag("forge:meat/raw_poultry");
  public static ITag.INamedTag<Item> raw_meat = ItemTags.makeWrapperTag("forge:meat/raw");
  public static ITag.INamedTag<Item> salts = ItemTags.makeWrapperTag("forge:salts");

  public static ITag.INamedTag<Item> boats = ItemTags.makeWrapperTag("minecraft:boats");
  public static ITag.INamedTag<Item> coals = ItemTags.makeWrapperTag("minecraft:coals");
  public static ITag.INamedTag<Item> strings = ItemTags.makeWrapperTag("forge:string");

  public EssentialsItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
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

    getOrCreateBuilder(slimeballs).add(ModItems.RESIN_BALL.get());

    // getOrCreateBuilder(raw_red_meat).add(Items.BEEF);
    // getOrCreateBuilder(raw_poultry).add(ModFoodItems.POULTRY.get());
    getOrCreateBuilder(raw_meat).add(
        Items.BEEF,
        ModFoodItems.POULTRY.get(),
        Items.RABBIT,
        Items.MUTTON,
        Items.PORKCHOP,
        Items.CHICKEN,
        ModFoodItems.BUSHMEAT.get()
    );

    getOrCreateBuilder(strings).add(ModItems.PLANT_FIBRE.get());

    getOrCreateBuilder(salts).add(ModItems.STONE_SALT.get());

    getOrCreateBuilder(coals).add(ModItems.BLACK_COAL.get());

    getOrCreateBuilder(boats).add(ModItems.CRIMWOOD_BOAT.get());
  }
}
