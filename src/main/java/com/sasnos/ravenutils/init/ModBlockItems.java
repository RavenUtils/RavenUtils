package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.BlockItemBase;
import com.sasnos.ravenutils.blocks.fuels.BlackCoalBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // blocks & ores
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
  public static final RegistryObject<Item> PEAT_BLOCK_ITEM = ITEMS.register("peat_block",
      () -> new BlackCoalBlockItem(ModBlocks.PEAT_BLOCK.get(), new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<Item> QUICKSAND_BLOCK_ITEM = ITEMS.register("quicksand_block",
      () -> new BlockItemBase(ModBlocks.QUICKSAND_BLOCK.get()));
  public static final RegistryObject<Item> LIMESTONE_BLOCK_ITEM = ITEMS.register("limestone_block",
      () -> new BlockItemBase(ModBlocks.LIMESTONE_BLOCK.get()));
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

  // vegetation
  public static final RegistryObject<Item> CRIMLEAF_ITEM = ITEMS.register("crimleaf",
      () -> new BlockItemBase(ModBlocks.CRIMLEAF.get()));
  public static final RegistryObject<Item> CRIMWOOD_SAPLING_ITEM = ITEMS.register("crimwood_sapling",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SAPLING.get()));
  public static final RegistryObject<Item> REEDS_ITEM = ITEMS.register("reeds",
      () -> new BlockItemBase(ModBlocks.REEDS.get()));

  // crimwood
  public static final RegistryObject<Item> CRIMWOOD_ITEM = ITEMS.register("crimwood",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD.get()));
  public static final RegistryObject<Item> CRIMWOOD_LOG_ITEM = ITEMS.register("crimwood_log",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LOG.get()));
  public static final RegistryObject<Item> CRIMWOOD_LOG_STRIPPED_ITEM = ITEMS.register("crimwood_log_stripped",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LOG_STRIPPED.get()));
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

  // mud
  public static final RegistryObject<Item> MUD_BLOCK_ITEM = ITEMS.register("mud_block",
      () -> new BlockItemBase(ModBlocks.MUD_BLOCK.get()));
  public static final RegistryObject<Item> MUD_BRICKS_ITEM = ITEMS.register("mud_bricks",
      () -> new BlockItemBase(ModBlocks.MUD_BRICKS.get()));
  public static final RegistryObject<Item> MUD_BRICK_SLAB_ITEM = ITEMS.register("mud_brick_slab",
      () -> new BlockItemBase(ModBlocks.MUD_BRICK_SLAB.get()));
  public static final RegistryObject<Item> MUD_BRICK_STAIRS_ITEM = ITEMS.register("mud_brick_stairs",
      () -> new BlockItemBase(ModBlocks.MUD_BRICK_STAIRS.get()));
  public static final RegistryObject<Item> MUD_BRICK_WALL_ITEM = ITEMS.register("mud_brick_wall",
      () -> new BlockItemBase(ModBlocks.MUD_BRICK_WALL.get()));

  // miscellaneous
  public static final RegistryObject<Item> CANDLE_ITEM = ITEMS.register("candle",
      () -> new BlockItemBase(ModBlocks.CANDLE.get()));
  public static final RegistryObject<Item> STICK_GROUND_ITEM = ITEMS.register("stick_ground",
      () -> new BlockItemBase(ModBlocks.STICK_GROUND.get()));
  public static final RegistryObject<Item> STONE_GROUND_ITEM = ITEMS.register("stone_ground",
      () -> new BlockItemBase(ModBlocks.STONE_GROUND.get()));

  // functional block(item)s
  public static final RegistryObject<Item> STONE_CRAFTING_TABLE_ITEM = ITEMS.register("stone_crafting_table",
      () -> new BlockItemBase(ModBlocks.STONE_CRAFTING_TABLE.get()));

  public static final RegistryObject<BlockItem> DRYING_RACK_ITEM = ITEMS.register("drying_rack",
      () -> new BlockItemBase(ModBlocks.DRYING_RACK.get()));

  public static final RegistryObject<BlockItem> BARREL_ITEM = ITEMS.register("barrel",
      () -> new BlockItemBase(ModBlocks.BARREL.get()));

  public static final RegistryObject<Item> FISH_TRAP_ITEM = ITEMS.register("fish_trap",
      () -> new BlockItemBase(ModBlocks.FISH_TRAP.get()));
  // public static final RegistryObject<Item> ANIMAL_TRAP_ITEM = ITEMS.register("animal_trap",
  //    () -> new BlockItemBase(ModBlocks.ANIMAL_TRAP.get()));

  // public static final RegistryObject<Item> CHIMNEY_ITEM = ITEMS.register("chimney",
  //    () -> new BlockItemBase(ModBlocks.CHIMNEY.get()));
  // public static final RegistryObject<Item> CHIMNEY_END_ITEM = ITEMS.register("chimney_end",
  //    () -> new BlockItemBase(ModBlocks.CHIMNEY_END.get()));

  // public static final RegistryObject<Item> ITEM_SHELF_ITEM = ITEMS.register("item_shelf",
  //    () -> new BlockItemBase(ModBlocks.ITEM_SHELF.get()));
  // public static final RegistryObject<Item> POTION_SHELF_ITEM = ITEMS.register("potion_shelf",
  //    () -> new BlockItemBase(ModBlocks.POTION_SHELF.get()));
  // public static final RegistryObject<Item> BOOK_SHELF_ITEM = ITEMS.register("book_shelf",
  //    () -> new BlockItemBase(ModBlocks.BOOK_SHELF.get()));

  public static final RegistryObject<BlockItem> STONE_ANVIL_STONE_ITEM = ITEMS.register("stone_anvil_stone",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_STONE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_GRANITE_ITEM = ITEMS.register("stone_anvil_granite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_GRANITE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_ANDESITE_ITEM = ITEMS.register("stone_anvil_andesite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_ANDESITE.get()));
  public static final RegistryObject<BlockItem> STONE_ANVIL_DIORITE_ITEM = ITEMS.register("stone_anvil_diorite",
      () -> new BlockItemBase(ModBlocks.STONE_ANVIL_DIORITE.get()));
}