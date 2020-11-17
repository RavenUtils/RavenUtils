package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.block.EssentialsWoodTypes;
import com.sasnos.ravenutils.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
  public static final RegistryObject<Block> CRIMWOOD_STAIRS = BLOCKS.register("crimwood_stairs", CrimwoodStairs::new);
  public static final RegistryObject<Block> CRIMWOOD_SLAB = BLOCKS.register("crimwood_slab", CrimwoodSlab::new);
  public static final RegistryObject<Block> CRIMWOOD_DOOR = BLOCKS.register("crimwood_door", CrimwoodDoor::new);
  public static final RegistryObject<Block> CRIMWOOD_TRAPDOOR = BLOCKS.register("crimwood_trapdoor", CrimwoodTrapdoor::new);
  public static final RegistryObject<Block> CRIMWOOD_PRESSURE_PLATE = BLOCKS.register("crimwood_pressure_plate", CrimwoodPressurePlate::new);
  public static final RegistryObject<Block> CRIMWOOD_FENCE = BLOCKS.register("crimwood_fence", CrimwoodFence::new);
  public static final RegistryObject<Block> CRIMWOOD_FENCE_GATE = BLOCKS.register("crimwood_fence_gate", CrimwoodFenceGate::new);
  public static final RegistryObject<Block> CRIMWOOD_BUTTON = BLOCKS.register("crimwood_button", CrimwoodButton::new);

  public static final RegistryObject<Block> DRYING_RAG = BLOCKS.register("drying_rag",
          () -> new DryingRag(AbstractBlock.Properties.create(Material.WOOD)));

  public static final RegistryObject<Block> BARREL = BLOCKS.register("barrel",
          () -> new Barrel(AbstractBlock.Properties.create(Material.WOOD)));

  public static final RegistryObject<Block> STONE_CRAFTING_TABLE = BLOCKS.register("stone_crafting_table", StoneCraftingTable::new);

  // stone anvils
  public static final RegistryObject<Block> STONE_ANVIL_STONE = BLOCKS.register("stone_anvil_stone",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));
  public static final RegistryObject<Block> STONE_ANVIL_GRANITE = BLOCKS.register("stone_anvil_granite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));
  public static final RegistryObject<Block> STONE_ANVIL_ANDESITE = BLOCKS.register("stone_anvil_andesite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));
  public static final RegistryObject<Block> STONE_ANVIL_DIORITE = BLOCKS.register("stone_anvil_diorite",
      () -> new StoneAnvil(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool()
          .hardnessAndResistance(2.5F, 600.0F).sound(SoundType.STONE)));

  // mill
  // public static final RegistryObject<Block> HAND_MILL = BLOCKS.register("hand_mill", CLASS::new);
  // public static final RegistryObject<Block> MILLSTONE = BLOCKS.register("millstone", CLASS::new);
}
