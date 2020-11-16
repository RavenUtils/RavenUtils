package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.*;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class EssentialsItemTags extends ItemTagsProvider {

  // blockitems
  public static ITag.INamedTag<Item> ores = ItemTags.makeWrapperTag("forge:ore");
  public static ITag.INamedTag<Item> non_flammable_wood = ItemTags.makeWrapperTag("forge:non_flammable_wood");
  public static ITag.INamedTag<Item> crimwood_logs = ItemTags.makeWrapperTag("ravenutils:crimwood_logs");
  public static ITag.INamedTag<Item> fence_gates = ItemTags.makeWrapperTag("forge:fence_gates");
  public static ITag.INamedTag<Item> leaves = ItemTags.makeWrapperTag("forge:leaves");
  public static ITag.INamedTag<Item> planks = ItemTags.makeWrapperTag("forge:planks");
  public static ITag.INamedTag<Item> saplings = ItemTags.makeWrapperTag("forge:saplings");
  public static ITag.INamedTag<Item> small_flowers = ItemTags.makeWrapperTag("forge:small_flowers");
  public static ITag.INamedTag<Item> wooden_buttons = ItemTags.makeWrapperTag("forge:wooden_buttons");
  public static ITag.INamedTag<Item> wooden_doors = ItemTags.makeWrapperTag("forge:wooden_doors");
  public static ITag.INamedTag<Item> wooden_fences = ItemTags.makeWrapperTag("forge:wooden_fences");
  public static ITag.INamedTag<Item> wooden_pressure_plates = ItemTags.makeWrapperTag("forge:wooden_pressure_plates");
  public static ITag.INamedTag<Item> wooden_slabs = ItemTags.makeWrapperTag("forge:wooden_slabs");
  public static ITag.INamedTag<Item> wooden_stairs = ItemTags.makeWrapperTag("forge:wooden_stairs");
  public static ITag.INamedTag<Item> wooden_trapdoors = ItemTags.makeWrapperTag("forge:wooden_trapdoors");

  // items
  public static ITag.INamedTag<Item> hammers = ItemTags.makeWrapperTag("forge:tools/hammers");
  public static ITag.INamedTag<Item> knives = ItemTags.makeWrapperTag("forge:tools/knives");
  public static ITag.INamedTag<Item> axes = ItemTags.makeWrapperTag("forge:tools/axes");
  public static ITag.INamedTag<Item> books = ItemTags.makeWrapperTag("forge:books");
  public static ITag.INamedTag<Item> grasses_tall = ItemTags.makeWrapperTag("forge:grasses/tall");
  public static ITag.INamedTag<Item> slimeballs = ItemTags.makeWrapperTag("forge:slimeballs");
  public static ITag.INamedTag<Item> raw_meat = ItemTags.makeWrapperTag("forge:meat/raw");
  public static ITag.INamedTag<Item> salts = ItemTags.makeWrapperTag("forge:salts");
  public static ITag.INamedTag<Item> boats = ItemTags.makeWrapperTag("forge:boats");
  public static ITag.INamedTag<Item> coals = ItemTags.makeWrapperTag("forge:coals");
  public static ITag.INamedTag<Item> coals_stone = ItemTags.makeWrapperTag("forge:coals/stone");
  public static ITag.INamedTag<Item> coals_wood = ItemTags.makeWrapperTag("forge:coals/wood");
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

    getOrCreateBuilder(axes).add(
        Items.STONE_AXE,
        Items.IRON_AXE,
        Items.GOLDEN_AXE,
        Items.DIAMOND_AXE,
        Items.NETHERITE_AXE,
        ModToolItems.COPPER_AXE.get(),
        ModToolItems.BRONZE_AXE.get(),
        ModToolItems.SILVER_AXE.get(),
        ModToolItems.STEEL_AXE.get(),
        ModToolItems.MYTHERINE_AXE.get()
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

    getOrCreateBuilder(raw_meat).add(
        Items.BEEF,
        Items.RABBIT,
        Items.MUTTON,
        Items.PORKCHOP,
        Items.CHICKEN,
        ModFoodItems.BUSHMEAT.get()
    );

    getOrCreateBuilder(strings).add(ModItems.PLANT_TWINE.get());
    getOrCreateBuilder(salts).add(ModItems.STONE_SALT.get());

    getOrCreateBuilder(coals_stone).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL
    );

    getOrCreateBuilder(coals_wood).add(
        Items.CHARCOAL
    );

    getOrCreateBuilder(coals).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL,
        Items.CHARCOAL
    );

    getOrCreateBuilder(ores).add(
        ModBlockItems.COPPER_ORE_ITEM.get(),
        ModBlockItems.TIN_ORE_ITEM.get(),
        ModBlockItems.ZINC_ORE_ITEM.get(),
        ModBlockItems.SILVER_ORE_ITEM.get(),
        ModBlockItems.LEAD_ORE_ITEM.get(),
        ModBlockItems.MYTHERINE_ORE_ITEM.get(),
        ModBlockItems.FOSSIL_ORE_ITEM.get(),
        ModBlockItems.RAVEN_EYE_ORE_ITEM.get(),
        ModBlockItems.SULFUR_ORE_ITEM.get(),
        ModBlockItems.BLACK_COAL_ORE_ITEM.get(),
        ModBlockItems.SALT_ORE_ITEM.get()
    );

    getOrCreateBuilder(saplings).add(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get());
    getOrCreateBuilder(small_flowers).add(ModBlockItems.CRIMLEAF_ITEM.get());

    getOrCreateBuilder(non_flammable_wood).add(
        ModBlockItems.CRIMWOOD_SAPLING_ITEM.get(),
        ModBlockItems.CRIMWOOD_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_ITEM.get(),
        ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()
        // ModBlockItems.CRIMWOOD_DOOR_ITEM.get(),
        // ModBlockItems.CRIMWOOD_FENCE_ITEM.get(),
        // ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get(),
        // ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get(),
        // ModBlockItems.CRIMWOOD_SLAB_ITEM.get(),
        // ModBlockItems.CRIMWOOD_STAIRS_ITEM.get(),
        // ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get(),
        // ModBlockItems.CRIMWOOD_BUTTON_ITEM.get()
    );

    getOrCreateBuilder(crimwood_logs).add(
        ModBlockItems.CRIMWOOD_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_ITEM.get()
    );

    // getOrCreateBuilder(fence_gates).add(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get());
    getOrCreateBuilder(leaves).add(ModBlockItems.CRIMWOOD_LEAVES_ITEM.get());
    getOrCreateBuilder(planks).add(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get());
    // getOrCreateBuilder(wooden_buttons).add(ModBlockItems.CRIMWOOD_BUTTON_ITEM.get());
    // getOrCreateBuilder(wooden_doors).add(ModBlockItems.CRIMWOOD_DOOR_ITEM.get());
    // getOrCreateBuilder(wooden_fences).add(ModBlockItems.CRIMWOOD_FENCE_ITEM.get());
    // getOrCreateBuilder(wooden_pressure_plates).add(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get());
    // getOrCreateBuilder(wooden_slabs).add(ModBlockItems.CRIMWOOD_SLAB_ITEM.get());
    // getOrCreateBuilder(wooden_stairs).add(ModBlockItems.CRIMWOOD_STAIRS_ITEM.get());
    // getOrCreateBuilder(wooden_trapdoors).add(ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get());

    getOrCreateBuilder(boats).add(ModItems.CRIMWOOD_BOAT.get());
  }
}
