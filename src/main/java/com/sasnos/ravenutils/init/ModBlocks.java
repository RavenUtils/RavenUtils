package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.*;
import com.sasnos.ravenutils.blocks.crimwood.*;
import com.sasnos.ravenutils.blocks.mud.*;
import com.sasnos.ravenutils.blocks.ores.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RavenUtils.MOD_ID);

  // ores
  public static final RegistryObject<Block> MYTHERINE_ORE = BLOCKS.register("mytherine_ore", MytherineOre::new);
  public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
  public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", TinOre::new);
  public static final RegistryObject<Block> ZINC_ORE = BLOCKS.register("zinc_ore", ZincOre::new);
  public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOre::new);
  public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", LeadOre::new);
  public static final RegistryObject<Block> SULFUR_ORE = BLOCKS.register("sulfur_ore", SulfurOre::new);
  public static final RegistryObject<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", FossilOre::new);
  public static final RegistryObject<Block> FOSSIL_DIRT = BLOCKS.register("fossil_dirt", FossilDirt::new);
  public static final RegistryObject<Block> RAVEN_EYE_ORE = BLOCKS.register("raven_eye_ore", RavenEyeOre::new);
  public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore", SaltOre::new);
  public static final RegistryObject<Block> BLACK_COAL_ORE = BLOCKS.register("black_coal_ore", BlackCoalOre::new);
  public static final RegistryObject<Block> LIMESTONE_BLOCK = BLOCKS.register("limestone_block", LimestoneBlock::new);
  public static final RegistryObject<Block> PEAT_BLOCK = BLOCKS.register("peat_block", PeatBlock::new);

  // blocks
  public static final RegistryObject<Block> MYTHERINE_BLOCK = BLOCKS.register("mytherine_block", MytherineBlock::new);
  public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
  public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", TinBlock::new);
  public static final RegistryObject<Block> ZINC_BLOCK = BLOCKS.register("zinc_block", ZincBlock::new);
  public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", BronzeBlock::new);
  public static final RegistryObject<Block> BRASS_BLOCK = BLOCKS.register("brass_block", BrassBlock::new);
  public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", SilverBlock::new);
  public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", LeadBlock::new);
  public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", SteelBlock::new);
  public static final RegistryObject<Block> RAVEN_EYE_BLOCK = BLOCKS.register("raven_eye_block", RavenEyeBlock::new);
  public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block", SaltBlock::new);
  public static final RegistryObject<Block> BLACK_COAL_BLOCK = BLOCKS.register("black_coal_block", BlackCoalBlock::new);
  public static final RegistryObject<Block> RESIN_BLOCK = BLOCKS.register("resin_block", ResinBlock::new);
  public static final RegistryObject<Block> GELATIN_BLOCK = BLOCKS.register("gelatin_block", GelatinBlock::new);
  public static final RegistryObject<Block> CANDLE = BLOCKS.register("candle", CandleBlock::new);
  public static final RegistryObject<Block> STICK_GROUND = BLOCKS.register("stick_ground", StickGroundBlock::new);
  public static final RegistryObject<Block> STONE_GROUND = BLOCKS.register("stone_ground", StoneGroundBlock::new);

  // fluid blocks
  public static final RegistryObject<Block> LIMEWATER_BLOCK = BLOCKS.register("limewater_block", LimewaterBlock::new);
  public static final RegistryObject<Block> TANNIN_BLOCK = BLOCKS.register("tannin_block", TanninBlock::new);

  // crimleaf
  public static final RegistryObject<Block> CRIMLEAF = BLOCKS.register("crimleaf", Crimleaf::new);
  public static final RegistryObject<Block> POTTED_CRIMLEAF = BLOCKS.register("potted_crimleaf",
      () -> new FlowerPotBlock(
          () -> (FlowerPotBlock) Blocks.FLOWER_POT, CRIMLEAF::get, AbstractBlock.Properties.from(Blocks.FLOWER_POT)
      )
  );

  // crimwood
  /* public static final RegistryObject<Block> CRIMWOOD_SIGN = BLOCKS.register("crimwood_sign",
      () -> new CrimwwodSignStanding(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement()
          .hardnessAndResistance(1.0F).sound(SoundType.WOOD), EssentialsWoodTypes.CRIMWOOD));
  public static final RegistryObject<Block> CRIMWOOD_WALL_SIGN = BLOCKS.register("crimwood_wall_sign",
      () -> new CrimwoodSignWall(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement()
          .hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(ModBlocks.CRIMWOOD_SIGN.get()), EssentialsWoodTypes.CRIMWOOD));
  */

  public static final RegistryObject<Block> CRIMWOOD_SAPLING = BLOCKS.register("crimwood_sapling", CrimwoodSapling::new);
  public static final RegistryObject<Block> POTTED_CRIMWOOD_SAPLING = BLOCKS.register("potted_crimwood_sapling",
      () -> new FlowerPotBlock(
          () -> (FlowerPotBlock) Blocks.FLOWER_POT, CRIMWOOD_SAPLING::get, AbstractBlock.Properties.from(Blocks.FLOWER_POT)
      )
  );
  public static final RegistryObject<Block> CRIMWOOD = BLOCKS.register("crimwood", Crimwood::new);
  public static final RegistryObject<RotatedPillarBlock> CRIMWOOD_LOG = BLOCKS.register("crimwood_log", CrimwoodLog::new);
  public static final RegistryObject<RotatedPillarBlock> CRIMWOOD_LOG_STRIPPED = BLOCKS.register("crimwood_log_stripped", CrimwoodLogStripped::new);
  public static final RegistryObject<Block> CRIMWOOD_LEAVES = BLOCKS.register("crimwood_leaves", CrimwoodLeaves::new);
  public static final RegistryObject<Block> CRIMWOOD_PLANKS = BLOCKS.register("crimwood_planks", CrimwoodPlanks::new);
  public static final RegistryObject<StairsBlock> CRIMWOOD_STAIRS = BLOCKS.register("crimwood_stairs", CrimwoodStairs::new);
  public static final RegistryObject<SlabBlock> CRIMWOOD_SLAB = BLOCKS.register("crimwood_slab", CrimwoodSlab::new);
  public static final RegistryObject<DoorBlock> CRIMWOOD_DOOR = BLOCKS.register("crimwood_door", CrimwoodDoor::new);
  public static final RegistryObject<TrapDoorBlock> CRIMWOOD_TRAPDOOR = BLOCKS.register("crimwood_trapdoor", CrimwoodTrapdoor::new);
  public static final RegistryObject<Block> CRIMWOOD_PRESSURE_PLATE = BLOCKS.register("crimwood_pressure_plate", CrimwoodPressurePlate::new);
  public static final RegistryObject<FenceBlock> CRIMWOOD_FENCE = BLOCKS.register("crimwood_fence", CrimwoodFence::new);
  public static final RegistryObject<FenceGateBlock> CRIMWOOD_FENCE_GATE = BLOCKS.register("crimwood_fence_gate", CrimwoodFenceGate::new);
  public static final RegistryObject<Block> CRIMWOOD_BUTTON = BLOCKS.register("crimwood_button", CrimwoodButton::new);

  // mud
  public static final RegistryObject<Block> MUD_BLOCK = BLOCKS.register("mud_block", MudBlock::new);
  public static final RegistryObject<Block> MUD_BRICKS = BLOCKS.register("mud_bricks", MudBricks::new);
  public static final RegistryObject<StairsBlock> MUD_BRICK_STAIRS = BLOCKS.register("mud_brick_stairs", MudBrickStairs::new);
  public static final RegistryObject<SlabBlock> MUD_BRICK_SLAB = BLOCKS.register("mud_brick_slab", MudBrickSlab::new);
  public static final RegistryObject<WallBlock> MUD_BRICK_WALL = BLOCKS.register("mud_brick_wall", MudBrickWall::new);

  // berry bushes
  // todo move berry bushes to Cuisine module
  public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", BlueberryBush::new);
  public static final RegistryObject<Block> ELDERBERRY_BUSH = BLOCKS.register("elderberry_bush", ElderberryBush::new);
  public static final RegistryObject<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush", RaspberryBush::new);
  public static final RegistryObject<Block> BLACKBERRY_BUSH = BLOCKS.register("blackberry_bush", BlackberryBush::new);
  public static final RegistryObject<Block> GOOSEBERRY_BUSH = BLOCKS.register("gooseberry_bush", GooseberryBush::new);

  // functional blocks
  public static final RegistryObject<Block> DRYING_RACK = BLOCKS.register("drying_rack", DryingRack::new);

  public static final RegistryObject<Block> BARREL = BLOCKS.register("barrel", Barrel::new);

  // public static final RegistryObject<Block> POTTERY_TABLE = BLOCKS.register("pottery_table", PotteryTable::new);

  public static final RegistryObject<Block> STONE_CRAFTING_TABLE = BLOCKS.register("stone_crafting_table", StoneCraftingTable::new);

  public static final RegistryObject<Block> FISH_TRAP = BLOCKS.register("fish_trap", FishTrap::new);
  // public static final RegistryObject<Block> ANIMAL_TRAP = BLOCKS.register("animal_trap", AnimalTrap::new);

  // stone anvils
  public static final RegistryObject<Block> STONE_ANVIL_STONE = BLOCKS.register("stone_anvil_stone", StoneAnvil::new);
  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_STONE = BLOCKS.register("damaged_stone_anvil_stone", StoneAnvil::new);
  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_STONE = BLOCKS.register("chipped_stone_anvil_stone", StoneAnvil::new);

  public static final RegistryObject<Block> STONE_ANVIL_GRANITE = BLOCKS.register("stone_anvil_granite", StoneAnvil::new);
  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_GRANITE = BLOCKS.register("damaged_stone_anvil_granite", StoneAnvil::new);
  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_GRANITE = BLOCKS.register("chipped_stone_anvil_granite", StoneAnvil::new);

  public static final RegistryObject<Block> STONE_ANVIL_ANDESITE = BLOCKS.register("stone_anvil_andesite", StoneAnvil::new);
  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_ANDESITE = BLOCKS.register("damaged_stone_anvil_andesite", StoneAnvil::new);
  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_ANDESITE = BLOCKS.register("chipped_stone_anvil_andesite", StoneAnvil::new);

  public static final RegistryObject<Block> STONE_ANVIL_DIORITE = BLOCKS.register("stone_anvil_diorite", StoneAnvil::new);
  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_DIORITE = BLOCKS.register("damaged_stone_anvil_diorite", StoneAnvil::new);
  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_DIORITE = BLOCKS.register("chipped_stone_anvil_diorite", StoneAnvil::new);

  // miscellaneous
}
