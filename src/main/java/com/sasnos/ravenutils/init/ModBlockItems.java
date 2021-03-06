package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.BlockItemBase;
import com.sasnos.ravenutils.blocks.block_items.BlackCoalBlockItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  public static final RegistryObject<Item> FOSSIL_DIRT_ITEM = ITEMS.register("fossil_dirt",
      () -> new BlockItemBase(ModBlocks.FOSSIL_DIRT.get()));
  public static final RegistryObject<Item> SALT_ORE_ITEM = ITEMS.register("salt_ore",
      () -> new BlockItemBase(ModBlocks.SALT_ORE.get()));
  public static final RegistryObject<Item> SALT_BLOCK_ITEM = ITEMS.register("salt_block",
      () -> new BlockItemBase(ModBlocks.SALT_BLOCK.get()));
  public static final RegistryObject<Item> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore",
      () -> new BlockItemBase(ModBlocks.SULFUR_ORE.get()));
  public static final RegistryObject<Item> BLACK_COAL_ORE_ITEM = ITEMS.register("black_coal_ore",
      () -> new BlockItemBase(ModBlocks.BLACK_COAL_ORE.get()));
  public static final RegistryObject<Item> BLACK_COAL_BLOCK_ITEM = ITEMS.register("black_coal_block",
      () -> new BlackCoalBlockItem(ModBlocks.BLACK_COAL_BLOCK.get(), new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<Item> LIMESTONE_ITEM = ITEMS.register("limestone",
      () -> new BlockItemBase(ModBlocks.LIMESTONE.get()));
  public static final RegistryObject<Item> RAVEN_EYE_ORE_ITEM = ITEMS.register("raven_eye_ore",
      () -> new BlockItemBase(ModBlocks.RAVEN_EYE_ORE.get()));
  public static final RegistryObject<Item> RAVEN_EYE_BLOCK_ITEM = ITEMS.register("raven_eye_block",
      () -> new BlockItemBase(ModBlocks.RAVEN_EYE_BLOCK.get()));
  public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore",
      () -> new BlockItemBase(ModBlocks.COPPER_ORE.get()));
  public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block",
      () -> new BlockItemBase(ModBlocks.COPPER_BLOCK.get()));
  public static final RegistryObject<Item> TIN_ORE_ITEM = ITEMS.register("tin_ore",
      () -> new BlockItemBase(ModBlocks.TIN_ORE.get()));
  public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block",
      () -> new BlockItemBase(ModBlocks.TIN_BLOCK.get()));
  public static final RegistryObject<Item> ZINC_ORE_ITEM = ITEMS.register("zinc_ore",
      () -> new BlockItemBase(ModBlocks.ZINC_ORE.get()));
  public static final RegistryObject<Item> ZINC_BLOCK_ITEM = ITEMS.register("zinc_block",
      () -> new BlockItemBase(ModBlocks.ZINC_BLOCK.get()));
  public static final RegistryObject<Item> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block",
      () -> new BlockItemBase(ModBlocks.BRONZE_BLOCK.get()));
  public static final RegistryObject<Item> BRASS_BLOCK_ITEM = ITEMS.register("brass_block",
      () -> new BlockItemBase(ModBlocks.BRASS_BLOCK.get()));
  public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore",
      () -> new BlockItemBase(ModBlocks.SILVER_ORE.get()));
  public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block",
      () -> new BlockItemBase(ModBlocks.SILVER_BLOCK.get()));
  public static final RegistryObject<Item> LEAD_ORE_ITEM = ITEMS.register("lead_ore",
      () -> new BlockItemBase(ModBlocks.LEAD_ORE.get()));
  public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("lead_block",
      () -> new BlockItemBase(ModBlocks.LEAD_BLOCK.get()));
  public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",
      () -> new BlockItemBase(ModBlocks.STEEL_BLOCK.get()));
  public static final RegistryObject<Item> FOSSIL_ORE_ITEM = ITEMS.register("fossil_ore",
      () -> new BlockItemBase(ModBlocks.FOSSIL_ORE.get()));
  public static final RegistryObject<Item> MYTHERINE_ORE_ITEM = ITEMS.register("mytherine_ore",
      () -> new BlockItemBase(ModBlocks.MYTHERINE_ORE.get()));
  public static final RegistryObject<Item> MYTHERINE_BLOCK_ITEM = ITEMS.register("mytherine_block",
      () -> new BlockItemBase(ModBlocks.MYTHERINE_BLOCK.get()));
  public static final RegistryObject<Item> RESIN_BLOCK_ITEM = ITEMS.register("resin_block",
      () -> new BlockItemBase(ModBlocks.RESIN_BLOCK.get()));
  public static final RegistryObject<Item> GELATIN_BLOCK_ITEM = ITEMS.register("gelatin_block",
      () -> new BlockItemBase(ModBlocks.GELATIN_BLOCK.get()));

  public static final RegistryObject<Item> CRIMLEAF_ITEM = ITEMS.register("crimleaf",
      () -> new BlockItemBase(ModBlocks.CRIMLEAF.get()));
  public static final RegistryObject<Item> CRIMWOOD_SAPLING_ITEM = ITEMS.register("crimwood_sapling",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SAPLING.get()));

  public static final RegistryObject<Item> CRIMWOOD_ITEM = ITEMS.register("crimwood",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD.get()));
  public static final RegistryObject<Item> CRIMWOOD_LOG_ITEM = ITEMS.register("crimwood_log",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LOG.get()));
  public static final RegistryObject<Item> CRIMWOOD_LEAVES_ITEM = ITEMS.register("crimwood_leaves",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LEAVES.get()));
  public static final RegistryObject<Item> CRIMWOOD_PLANKS_ITEM = ITEMS.register("crimwood_planks",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_PLANKS.get()));
  public static final RegistryObject<Item> CRIMWOOD_STAIRS_ITEM = ITEMS.register("crimwood_stairs",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_STAIRS.get()));
  public static final RegistryObject<Item> CRIMWOOD_SLAB_ITEM = ITEMS.register("crimwood_slab",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SLAB.get()));
  public static final RegistryObject<Item> CRIMWOOD_DOOR_ITEM = ITEMS.register("crimwood_door",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_DOOR.get()));
  public static final RegistryObject<Item> CRIMWOOD_TRAPDOOR_ITEM = ITEMS.register("crimwood_trapdoor",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_TRAPDOOR.get()));
  public static final RegistryObject<Item> CRIMWOOD_PRESSURE_PLATE_ITEM = ITEMS.register("crimwood_pressure_plate",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get()));
  public static final RegistryObject<Item> CRIMWOOD_FENCE_ITEM = ITEMS.register("crimwood_fence",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_FENCE.get()));
  public static final RegistryObject<Item> CRIMWOOD_FENCE_GATE_ITEM = ITEMS.register("crimwood_fence_gate",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_FENCE_GATE.get()));
  public static final RegistryObject<Item> CRIMWOOD_BUTTON_ITEM = ITEMS.register("crimwood_button",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_BUTTON.get()));

  public static final RegistryObject<Item> CANDLE_ITEM = ITEMS.register("candle",
      () -> new BlockItemBase(ModBlocks.CANDLE.get()));

  public static final RegistryObject<Item> STONE_CRAFTING_TABLE_ITEM = ITEMS.register("stone_crafting_table",
      () -> new BlockItemBase(ModBlocks.STONE_CRAFTING_TABLE.get()));

  public static final RegistryObject<BlockItem> STONE_ANVIL_STONE_ITEM = ITEMS.register("stone_anvil_stone",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_STONE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_GRANITE_ITEM = ITEMS.register("stone_anvil_granite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_GRANITE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_ANDESITE_ITEM = ITEMS.register("stone_anvil_andesite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_ANDESITE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_DIORITE_ITEM = ITEMS.register("stone_anvil_diorite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_DIORITE.get()));
}