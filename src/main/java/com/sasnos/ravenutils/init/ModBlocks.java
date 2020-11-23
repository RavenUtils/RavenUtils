package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.blocks.EssentialsWoodTypes;
import com.sasnos.ravenutils.blocks.Barrel;
import com.sasnos.ravenutils.blocks.BlackCoalBlock;
import com.sasnos.ravenutils.blocks.BlackCoalOre;
import com.sasnos.ravenutils.blocks.BlueberryBush;
import com.sasnos.ravenutils.blocks.BrassBlock;
import com.sasnos.ravenutils.blocks.BronzeBlock;
import com.sasnos.ravenutils.blocks.CandleBlock;
import com.sasnos.ravenutils.blocks.CopperBlock;
import com.sasnos.ravenutils.blocks.CopperOre;
import com.sasnos.ravenutils.blocks.Crimleaf;
import com.sasnos.ravenutils.blocks.Crimwood;
import com.sasnos.ravenutils.blocks.CrimwoodButton;
import com.sasnos.ravenutils.blocks.CrimwoodDoor;
import com.sasnos.ravenutils.blocks.CrimwoodFence;
import com.sasnos.ravenutils.blocks.CrimwoodFenceGate;
import com.sasnos.ravenutils.blocks.CrimwoodLeaves;
import com.sasnos.ravenutils.blocks.CrimwoodLog;
import com.sasnos.ravenutils.blocks.CrimwoodPlanks;
import com.sasnos.ravenutils.blocks.CrimwoodPressurePlate;
import com.sasnos.ravenutils.blocks.CrimwoodSapling;
import com.sasnos.ravenutils.blocks.CrimwoodSignWall;
import com.sasnos.ravenutils.blocks.CrimwoodSlab;
import com.sasnos.ravenutils.blocks.CrimwoodStairs;
import com.sasnos.ravenutils.blocks.CrimwoodTrapdoor;
import com.sasnos.ravenutils.blocks.CrimwwodSignStanding;
import com.sasnos.ravenutils.blocks.DryingRack;
import com.sasnos.ravenutils.blocks.ElderberryBush;
import com.sasnos.ravenutils.blocks.FossilDirt;
import com.sasnos.ravenutils.blocks.FossilOre;
import com.sasnos.ravenutils.blocks.GelatinBlock;
import com.sasnos.ravenutils.blocks.LeadBlock;
import com.sasnos.ravenutils.blocks.LeadOre;
import com.sasnos.ravenutils.blocks.Limestone;
import com.sasnos.ravenutils.blocks.LimewaterBlock;
import com.sasnos.ravenutils.blocks.MytherineBlock;
import com.sasnos.ravenutils.blocks.MytherineOre;
import com.sasnos.ravenutils.blocks.PottedCrimleaf;
import com.sasnos.ravenutils.blocks.PottedCrimwoodSapling;
import com.sasnos.ravenutils.blocks.RavenEyeBlock;
import com.sasnos.ravenutils.blocks.RavenEyeOre;
import com.sasnos.ravenutils.blocks.ResinBlock;
import com.sasnos.ravenutils.blocks.SaltBlock;
import com.sasnos.ravenutils.blocks.SaltOre;
import com.sasnos.ravenutils.blocks.SilverBlock;
import com.sasnos.ravenutils.blocks.SilverOre;
import com.sasnos.ravenutils.blocks.SteelBlock;
import com.sasnos.ravenutils.blocks.StoneAnvil;
import com.sasnos.ravenutils.blocks.StoneCraftingTable;
import com.sasnos.ravenutils.blocks.SulfurOre;
import com.sasnos.ravenutils.blocks.TanninBlock;
import com.sasnos.ravenutils.blocks.TinBlock;
import com.sasnos.ravenutils.blocks.TinOre;
import com.sasnos.ravenutils.blocks.ZincBlock;
import com.sasnos.ravenutils.blocks.ZincOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
  public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone", Limestone::new);

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

  // fluid blocks
  public static final RegistryObject<Block> LIMEWATER_BLOCK = BLOCKS.register("limewater_block", LimewaterBlock::new);
  public static final RegistryObject<Block> TANNIN_BLOCK = BLOCKS.register("tannin_block", TanninBlock::new);

  // crimleaf
  public static final RegistryObject<Block> CRIMLEAF = BLOCKS.register("crimleaf", Crimleaf::new);
  public static final RegistryObject<Block> POTTED_CRIMLEAF = BLOCKS.register("potted_crimleaf", PottedCrimleaf::new);

  // crimwood
  public static final RegistryObject<Block> CRIMWOOD_SIGN = BLOCKS.register("crimwood_sign",
      () -> new CrimwwodSignStanding(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement()
          .hardnessAndResistance(1.0F).sound(SoundType.WOOD), EssentialsWoodTypes.CRIMWOOD));
  public static final RegistryObject<Block> CRIMWOOD_WALL_SIGN = BLOCKS.register("crimwood_wall_sign",
      () -> new CrimwoodSignWall(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement()
          .hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(ModBlocks.CRIMWOOD_SIGN.get()), EssentialsWoodTypes.CRIMWOOD));

  public static final RegistryObject<Block> POTTED_CRIMWOOD_SAPLING = BLOCKS.register("potted_crimwood_sapling", PottedCrimwoodSapling::new);
  public static final RegistryObject<Block> CRIMWOOD_SAPLING = BLOCKS.register("crimwood_sapling", CrimwoodSapling::new);
  public static final RegistryObject<Block> CRIMWOOD = BLOCKS.register("crimwood", Crimwood::new);
  public static final RegistryObject<Block> CRIMWOOD_LOG = BLOCKS.register("crimwood_log", CrimwoodLog::new);
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

  // berry bushes
  public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
      () -> new BlueberryBush(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
  public static final RegistryObject<Block> ELDERBERRY_BUSH = BLOCKS.register("elderberry_bush",
      () -> new ElderberryBush(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));

  // functional blocks
  public static final RegistryObject<Block> DRYING_RACK = BLOCKS.register("drying_rack",
      () -> new DryingRack(AbstractBlock.Properties.create(Material.WOOD)));

  public static final RegistryObject<Block> BARREL = BLOCKS.register("barrel",
      () -> new Barrel(AbstractBlock.Properties.create(Material.WOOD)));

  public static final RegistryObject<Block> STONE_CRAFTING_TABLE = BLOCKS.register("stone_crafting_table", StoneCraftingTable::new);

  // stone anvils
  public static final RegistryObject<Block> STONE_ANVIL_STONE = BLOCKS.register("stone_anvil_stone",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_STONE = BLOCKS.register("damaged_stone_anvil_stone",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_STONE = BLOCKS.register("chipped_stone_anvil_stone",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> STONE_ANVIL_GRANITE = BLOCKS.register("stone_anvil_granite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_GRANITE = BLOCKS.register("damaged_stone_anvil_granite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_GRANITE = BLOCKS.register("chipped_stone_anvil_granite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> STONE_ANVIL_ANDESITE = BLOCKS.register("stone_anvil_andesite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_ANDESITE = BLOCKS.register("damaged_stone_anvil_andesite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_ANDESITE = BLOCKS.register("chipped_stone_anvil_andesite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> STONE_ANVIL_DIORITE = BLOCKS.register("stone_anvil_diorite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> DAMAGED_STONE_ANVIL_DIORITE = BLOCKS.register("damaged_stone_anvil_diorite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  public static final RegistryObject<Block> CHIPPED_STONE_ANVIL_DIORITE = BLOCKS.register("chipped_stone_anvil_diorite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  // mill
  // public static final RegistryObject<Block> HAND_MILL = BLOCKS.register("hand_mill", CLASS::new);
  // public static final RegistryObject<Block> MILLSTONE = BLOCKS.register("millstone", CLASS::new);
}
