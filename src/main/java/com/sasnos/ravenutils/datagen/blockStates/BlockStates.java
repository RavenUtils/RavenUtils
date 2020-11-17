package com.sasnos.ravenutils.datagen.blockStates;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

import static com.sasnos.ravenutils.util.Utils.resourceLocation;

public class BlockStates extends BlockStateProvider {

  public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, RavenUtils.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {

    BlockModelBuilder crimleaf = models().cross("crimleaf",
        resourceLocation("blocks/crimleaf"));
    simpleBlock(ModBlocks.CRIMLEAF.get(), crimleaf);

    // BlockModelBuilder pottedCrimleaf = models().cubeAll("potted_crimleaf",
    //     resourceLocation("blocks/potted_crimleaf"));
    // simpleBlock(ModBlocks.POTTED_CRIMLEAF.get(), pottedCrimleaf);

    BlockModelBuilder crimwood = models().cubeAll("crimwood",
        resourceLocation("blocks/crimwood_log"));
    simpleBlock(ModBlocks.CRIMWOOD.get(), crimwood);

    // models().cubeAll("crimwood_button",
    // resourceLocation("crimwood_button"));

    // models().cubeAll("crimwood_door",
    // resourceLocation("crimwood_door"));

    // models().cubeAll("crimwood_fence",
    // resourceLocation("crimwood_fence"));

    // models().fenceGate("crimwood_fence_gate",
    // resourceLocation("crimwood_fence_gate"));

    BlockModelBuilder crimwoodLeaves = models().cubeAll("crimwood_leaves",
        resourceLocation("blocks/crimwood_leaves"));
    simpleBlock(ModBlocks.CRIMWOOD_LEAVES.get(), crimwoodLeaves);

    BlockModelBuilder crimwoodLog = models().cubeBottomTop("crimwood_log",
        resourceLocation("blocks/crimwood_log"),
        resourceLocation("blocks/crimwood_log_top"),
        resourceLocation("blocks/crimwood_log_top"));
    simpleBlock(ModBlocks.CRIMWOOD_LOG.get(), crimwoodLog);

    BlockModelBuilder crimwoodPlanks = models().cubeAll("crimwood_planks",
        resourceLocation("blocks/crimwood_planks"));
    simpleBlock(ModBlocks.CRIMWOOD_PLANKS.get(), crimwoodPlanks);

    // models().cubeAll("crimwood_pressure_plate",
    // resourceLocation("crimwood_pressure_plate"));

    BlockModelBuilder crimwoodSapling = models().cross("crimwood_sapling",
        resourceLocation("blocks/crimwood_sapling"));
    simpleBlock(ModBlocks.CRIMWOOD_SAPLING.get(), crimwoodSapling);

    // BlockModelBuilder pottedCrimleaf = models().cubeAll("potted_crimwood_sapling",
    //     resourceLocation("blocks/potted_crimwood_sapling"));
    // simpleBlock(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), pottedCrimwoodSapling);

    // models().cubeAll("crimwood_sign",
    // resourceLocation("crimwood_sign"));

    // models().slab("crimwood_slab",
    // resourceLocation("crimwood_slab"),
    // resourceLocation("crimwood_slab_bottom"),
    // resourceLocation("crimwood_slap_top"));

    BlockModelBuilder fossilDirt = models().cubeAll("fossil_dirt",
        resourceLocation("blocks/fossil_dirt"));
    simpleBlock(ModBlocks.FOSSIL_DIRT.get(), fossilDirt);

    BlockModelBuilder fossilOre = models().cubeAll("fossil_ore",
        resourceLocation("blocks/fossil_ore"));
    simpleBlock(ModBlocks.FOSSIL_ORE.get(), fossilOre);

    BlockModelBuilder limestone = models().cubeAll("limestone",
        resourceLocation("blocks/limestone"));
    simpleBlock(ModBlocks.LIMESTONE.get(), limestone);

    BlockModelBuilder sulfurOre = models().cubeAll("sulfur_ore",
        resourceLocation("blocks/sulfur_ore"));
    simpleBlock(ModBlocks.SULFUR_ORE.get(), sulfurOre);

    BlockModelBuilder resinBlock = models().cubeAll("resin_block",
        resourceLocation("blocks/resin_block"));
    simpleBlock(ModBlocks.RESIN_BLOCK.get(), resinBlock);

    BlockModelBuilder saltOre = models().cubeAll("salt_ore",
        resourceLocation("blocks/salt_ore"));
    simpleBlock(ModBlocks.SALT_ORE.get(), saltOre);

    BlockModelBuilder saltBlock = models().cubeAll("salt_block",
        resourceLocation("blocks/salt_block"));
    simpleBlock(ModBlocks.SALT_BLOCK.get(), saltBlock);

    BlockModelBuilder blackCoalOre = models().cubeAll("black_coal_ore",
        resourceLocation("blocks/black_coal_ore"));
    simpleBlock(ModBlocks.BLACK_COAL_ORE.get(), blackCoalOre);

    BlockModelBuilder blackCoalBlock = models().cubeAll("black_coal_block",
        resourceLocation("blocks/black_coal_block"));
    simpleBlock(ModBlocks.BLACK_COAL_BLOCK.get(), blackCoalBlock);

    BlockModelBuilder ravenEyeOre = models().cubeAll("raven_eye_ore",
        resourceLocation("blocks/raven_eye_ore"));
    simpleBlock(ModBlocks.RAVEN_EYE_ORE.get(), ravenEyeOre);

    BlockModelBuilder ravenEyeBlock = models().cubeAll("raven_eye_block",
        resourceLocation("blocks/raven_eye_block"));
    simpleBlock(ModBlocks.RAVEN_EYE_BLOCK.get(), ravenEyeBlock);

    BlockModelBuilder copperOre = models().cubeAll("copper_ore",
        resourceLocation("blocks/copper_ore"));
    simpleBlock(ModBlocks.COPPER_ORE.get(), copperOre);

    BlockModelBuilder copperBlock = models().cubeAll("copper_block",
        resourceLocation("blocks/copper_block"));
    simpleBlock(ModBlocks.COPPER_BLOCK.get(), copperBlock);

    BlockModelBuilder tinOre = models().cubeAll("tin_ore",
        resourceLocation("blocks/tin_ore"));
    simpleBlock(ModBlocks.TIN_ORE.get(), tinOre);

    BlockModelBuilder tinBlock = models().cubeAll("tin_block",
        resourceLocation("blocks/tin_block"));
    simpleBlock(ModBlocks.TIN_BLOCK.get(), tinBlock);

    BlockModelBuilder zincOre = models().cubeAll("zinc_ore",
        resourceLocation("blocks/zinc_ore"));
    simpleBlock(ModBlocks.ZINC_ORE.get(), zincOre);

    BlockModelBuilder zincBlock = models().cubeAll("zinc_block",
        resourceLocation("blocks/zinc_block"));
    simpleBlock(ModBlocks.ZINC_BLOCK.get(), zincBlock);

    BlockModelBuilder bronzeBlock = models().cubeAll("bronze_block",
        resourceLocation("blocks/bronze_block"));
    simpleBlock(ModBlocks.BRONZE_BLOCK.get(), bronzeBlock);

    BlockModelBuilder brassBlock = models().cubeAll("brass_block",
        resourceLocation("blocks/brass_block"));
    simpleBlock(ModBlocks.BRASS_BLOCK.get(), brassBlock);

    BlockModelBuilder silverOre = models().cubeAll("silver_ore",
        resourceLocation("blocks/silver_ore"));
    simpleBlock(ModBlocks.SILVER_ORE.get(), silverOre);

    BlockModelBuilder silverBlock = models().cubeAll("silver_block",
        resourceLocation("blocks/silver_block"));
    simpleBlock(ModBlocks.SILVER_BLOCK.get(), silverBlock);

    BlockModelBuilder leadOre = models().cubeAll("lead_ore",
        resourceLocation("blocks/lead_ore"));
    simpleBlock(ModBlocks.LEAD_ORE.get(), leadOre);

    BlockModelBuilder leadBlock = models().cubeAll("lead_block",
        resourceLocation("blocks/lead_block"));
    simpleBlock(ModBlocks.LEAD_BLOCK.get(), leadBlock);

    BlockModelBuilder steelBlock = models().cubeAll("steel_block",
        resourceLocation("blocks/steel_block"));
    simpleBlock(ModBlocks.STEEL_BLOCK.get(), steelBlock);

    BlockModelBuilder mytherineOre = models().cubeAll("mytherine_ore",
        resourceLocation("blocks/mytherine_ore"));
    simpleBlock(ModBlocks.MYTHERINE_ORE.get(), mytherineOre);

    BlockModelBuilder mytherineBlock = models().cubeAll("mytherine_block",
        resourceLocation("blocks/mytherine_block"));
    simpleBlock(ModBlocks.MYTHERINE_BLOCK.get(), mytherineBlock);

    BlockModelBuilder stoneAnvilStone =
        models().withExistingParent("stone_anvil_stone", new ResourceLocation("anvil"))
            .texture("stone", new ResourceLocation("block/stone"));
    simpleBlock(ModBlocks.STONE_ANVIL_STONE.get(), stoneAnvilStone);

    // todo add mill with and without millstone, with and without hand crank
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
