package com.sasnos.ravenutils.datagen.blockStates;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

import static com.sasnos.ravenutils.util.Utils.RL;

public class BlockStates extends BlockStateProvider {

  public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, RavenUtils.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {

    BlockModelBuilder blackCoalBlock = models().cubeAll("black_coal_block",
        RL("blocks/black_coal_block"));
    simpleBlock(ModBlocks.BLACK_COAL_BLOCK.get(), blackCoalBlock);

    BlockModelBuilder blackCoalOre = models().cubeAll("black_coal_ore",
        RL("blocks/black_coal_ore"));
    simpleBlock(ModBlocks.BLACK_COAL_ORE.get(), blackCoalBlock);

    BlockModelBuilder crimleaf = models().cubeAll("crimleaf",
        RL("blocks/crimleaf"));
    simpleBlock(ModBlocks.CRIMLEAF.get(), crimleaf);

//    BlockModelBuilder pottedCrimleaf = models().cubeAll("potted_crimleaf",
//        RL("blocks/potted_crimleaf"));
//    simpleBlock(ModBlocks.POTTED_CRIMLEAF.get(), pottedCrimleaf);

    BlockModelBuilder crimwood = models().cubeAll("crimwood",
        RL("blocks/crimwood_log"));
    simpleBlock(ModBlocks.CRIMWOOD.get(), crimwood);

    // models().cubeAll("crimwood_button",
    // resourceLocation("crimwood_button"));

    // models().cubeAll("crimwood_door",
    // resourceLocation("crimwood_door"));

    // models().cubeAll("crimwood_fence",
    // resourceLocation("crimwood_fence"));

    // models().fenceGate("crimwood_fence_gate",
    // resourceLocation("crimwood_fence_gate"));

    BlockModelBuilder crimLeaves = models().cubeAll("crimwood_leaves",
        RL("blocks/crimwood_leaves"));
    simpleBlock(ModBlocks.CRIMWOOD_LEAVES.get(), crimLeaves);

    BlockModelBuilder crimLog = models().cubeBottomTop("crimwood_log",
        RL("blocks/crimwood_log"),
        RL("blocks/crimwood_log_top"),
        RL("blocks/crimwood_log_top"));
    simpleBlock(ModBlocks.CRIMWOOD_LOG.get(), crimLog);

    BlockModelBuilder crimplanks = models().cubeAll("crimwood_planks",
        RL("blocks/crimwood_planks"));
    simpleBlock(ModBlocks.CRIMWOOD_PLANKS.get(), crimplanks);

    // models().cubeAll("crimwood_pressure_plate",
    // resourceLocation("crimwood_pressure_plate"));

    BlockModelBuilder crimwoodSapling = models().cross("crimwood_sapling",
        RL("blocks/crimwood_sapling"));
    simpleBlock(ModBlocks.CRIMWOOD_SAPLING.get(), crimwoodSapling);

    // models().cubeAll("crimwood_sign",
    // resourceLocation("crimwood_sign"));

    // models().slab("crimwood_slab",
    // resourceLocation("crimwood_slab"),
    // resourceLocation("crimwood_slab_bottom"),
    // resourceLocation("crimwood_slap_top"));

    BlockModelBuilder fossil_dirt = models().cubeAll("fossil_dirt",
        RL("blocks/fossil_dirt"));
    simpleBlock(ModBlocks.FOSSIL_DIRT.get(), fossil_dirt);

    BlockModelBuilder fossil_ore = models().cubeAll("fossil_ore",
        RL("blocks/fossil_ore"));
    simpleBlock(ModBlocks.FOSSIL_ORE.get(), fossil_ore);

    BlockModelBuilder limestone = models().cubeAll("limestone",
        RL("blocks/limestone"));
    simpleBlock(ModBlocks.LIMESTONE.get(), limestone);

    BlockModelBuilder mytherineBlock = models().cubeAll("mytherine_block",
        RL("blocks/mytherine_block"));
    simpleBlock(ModBlocks.MYTHERINE_BLOCK.get(), mytherineBlock);

    BlockModelBuilder mytherine_ore = models().cubeAll("mytherine_ore",
        RL("blocks/mytherine_ore"));
    simpleBlock(ModBlocks.MYTHERINE_ORE.get(), mytherine_ore);

    BlockModelBuilder ravenEyeBlock = models().cubeAll("raven_eye_block",
        RL("blocks/raven_eye_block"));
    simpleBlock(ModBlocks.RAVEN_EYE_BLOCK.get(), ravenEyeBlock);

    BlockModelBuilder ravenEyeOre = models().cubeAll("raven_eye_ore",
        RL("blocks/raven_eye_ore"));
    simpleBlock(ModBlocks.RAVEN_EYE_ORE.get(), ravenEyeOre);

    BlockModelBuilder resin = models().cubeAll("resin_block",
        RL("blocks/resin_block"));
    simpleBlock(ModBlocks.RESIN_BLOCK.get(), resin);

    BlockModelBuilder saltBlock = models().cubeAll("salt_block",
        RL("blocks/salt_block"));
    simpleBlock(ModBlocks.SALT_BLOCK.get(), saltBlock);

    BlockModelBuilder saltOre = models().cubeAll("salt_ore",
        RL("blocks/salt_ore"));
    simpleBlock(ModBlocks.SALT_ORE.get(), saltOre);

    BlockModelBuilder silverBlock = models().cubeAll("silver_block",
        RL("blocks/silver_block"));
    simpleBlock(ModBlocks.SILVER_BLOCK.get(), silverBlock);

    BlockModelBuilder silverOre = models().cubeAll("silver_ore",
        RL("blocks/silver_ore"));
    simpleBlock(ModBlocks.SILVER_ORE.get(), silverOre);

    BlockModelBuilder leadBlock = models().cubeAll("lead_block",
        RL("blocks/lead_block"));
    simpleBlock(ModBlocks.LEAD_BLOCK.get(), leadBlock);

    BlockModelBuilder leadOre = models().cubeAll("lead_ore",
        RL("blocks/lead_ore"));
    simpleBlock(ModBlocks.LEAD_ORE.get(), leadOre);

    BlockModelBuilder steelBlock = models().cubeAll("steel_block",
        RL("blocks/steel_block"));
    simpleBlock(ModBlocks.STEEL_BLOCK.get(), steelBlock);

    BlockModelBuilder sulfurOre = models().cubeAll("sulfur_ore",
        RL("blocks/sulfur_ore"));
    simpleBlock(ModBlocks.SULFUR_ORE.get(), sulfurOre);

    BlockModelBuilder tinBlock = models().cubeAll("tin_block",
        RL("blocks/tin_block"));
    simpleBlock(ModBlocks.TIN_BLOCK.get(), tinBlock);

    BlockModelBuilder tinOre = models().cubeAll("tin_ore",
        RL("blocks/tin_ore"));
    simpleBlock(ModBlocks.TIN_ORE.get(), tinOre);

    BlockModelBuilder zincBlock = models().cubeAll("zinc_block",
        RL("blocks/zinc_block"));
    simpleBlock(ModBlocks.ZINC_BLOCK.get(), zincBlock);

    BlockModelBuilder zincOre = models().cubeAll("zinc_ore",
        RL("blocks/zinc_ore"));
    simpleBlock(ModBlocks.ZINC_ORE.get(), zincOre);

    BlockModelBuilder copperOre = models().cubeAll("copper_ore",
        RL("blocks/copper_ore"));
    simpleBlock(ModBlocks.COPPER_ORE.get(), copperOre);

    BlockModelBuilder copperBlock = models().cubeAll("copper_block",
        RL("blocks/copper_block"));
    simpleBlock(ModBlocks.COPPER_BLOCK.get(), copperBlock);

    BlockModelBuilder bronzeBlock = models().cubeAll("bronze_block",
        RL("blocks/bronze_block"));
    simpleBlock(ModBlocks.BRONZE_BLOCK.get(), bronzeBlock);

    BlockModelBuilder brassBlock = models().cubeAll("brass_block",
        RL("blocks/brass_block"));
    simpleBlock(ModBlocks.BRASS_BLOCK.get(), brassBlock);
  }

  public void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
    getVariantBuilder(block)
        .forAllStates(state -> {
          Direction dir = state.get(BlockStateProperties.FACING);
          return ConfiguredModel.builder()
              .modelFile(modelFunc.apply(state))
              .rotationX(dir.getAxis() == Direction.Axis.Y ? dir.getAxisDirection().getOffset() * -90 : 0)
              .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.getHorizontalIndex() + 2) % 4) * 90 : 0)
              .build();
        });
  }
}
