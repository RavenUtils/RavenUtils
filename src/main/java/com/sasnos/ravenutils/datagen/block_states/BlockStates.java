package com.sasnos.ravenutils.datagen.block_states;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.data_generation.blocks.EssentialsBlockStates;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends EssentialsBlockStates {

  public BlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, RavenUtils.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {

    // berry bushes
    // todo move berry bushes to Cuisine module
    BlockModelBuilder blueberryBush0 = models().cross("blueberry_bush0", mcLoc("block/sweet_berry_bush_stage0"));
    BlockModelBuilder blueberryBush1 = models().cross("blueberry_bush1", mcLoc("block/sweet_berry_bush_stage1"));
    BlockModelBuilder blueberryBush2 = models().cross("blueberry_bush2", modLoc("blocks/bush_blueberry_stage2"));
    BlockModelBuilder blueberryBush3 = models().cross("blueberry_bush3", modLoc("blocks/bush_blueberry_stage3"));
    generateBlockStatesForBlock(ModBlocks.BLUEBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)) {
        case 0:
          return blueberryBush0;
        case 1:
          return blueberryBush1;
        case 2:
          return blueberryBush2;
        case 3:
          return blueberryBush3;
        default:
          return blueberryBush0;
      }
    });

    BlockModelBuilder elderberryBush0 = models().cross("elderberry_bush0", mcLoc("block/sweet_berry_bush_stage0"));
    BlockModelBuilder elderberryBush1 = models().cross("elderberry_bush1", mcLoc("block/sweet_berry_bush_stage1"));
    BlockModelBuilder elderberryBush2 = models().cross("elderberry_bush2", modLoc("blocks/bush_elderberry_stage2"));
    BlockModelBuilder elderberryBush3 = models().cross("elderberry_bush3", modLoc("blocks/bush_elderberry_stage3"));
    generateBlockStatesForBlock(ModBlocks.ELDERBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)) {
        case 0:
          return elderberryBush0;
        case 1:
          return elderberryBush1;
        case 2:
          return elderberryBush2;
        case 3:
          return elderberryBush3;
        default:
          return elderberryBush0;
      }
    });

    BlockModelBuilder raspberryBush0 = models().cross("raspberry_bush0", mcLoc("block/sweet_berry_bush_stage0"));
    BlockModelBuilder raspberryBush1 = models().cross("raspberry_bush1", mcLoc("block/sweet_berry_bush_stage1"));
    BlockModelBuilder raspberryBush2 = models().cross("raspberry_bush2", modLoc("blocks/bush_raspberry_stage2"));
    BlockModelBuilder raspberryBush3 = models().cross("raspberry_bush3", modLoc("blocks/bush_raspberry_stage3"));
    generateBlockStatesForBlock(ModBlocks.RASPBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)) {
        case 0:
          return raspberryBush0;
        case 1:
          return raspberryBush1;
        case 2:
          return raspberryBush2;
        case 3:
          return raspberryBush3;
        default:
          return raspberryBush0;
      }
    });

    BlockModelBuilder blackberryBush0 = models().cross("blackberry_bush0", mcLoc("block/sweet_berry_bush_stage0"));
    BlockModelBuilder blackberryBush1 = models().cross("blackberry_bush1", mcLoc("block/sweet_berry_bush_stage1"));
    BlockModelBuilder blackberryBush2 = models().cross("blackberry_bush2", modLoc("blocks/bush_blackberry_stage2"));
    BlockModelBuilder blackberryBush3 = models().cross("blackberry_bush3", modLoc("blocks/bush_blackberry_stage3"));
    generateBlockStatesForBlock(ModBlocks.BLACKBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)) {
        case 0:
          return blackberryBush0;
        case 1:
          return blackberryBush1;
        case 2:
          return blackberryBush2;
        case 3:
          return blackberryBush3;
        default:
          return blackberryBush0;
      }
    });

    BlockModelBuilder gooseberryBush0 = models().cross("gooseberry_bush0", mcLoc("block/sweet_berry_bush_stage0"));
    BlockModelBuilder gooseberryBush1 = models().cross("gooseberry_bush1", mcLoc("block/sweet_berry_bush_stage1"));
    BlockModelBuilder gooseberryBush2 = models().cross("gooseberry_bush2", modLoc("blocks/bush_gooseberry_stage2"));
    BlockModelBuilder gooseberryBush3 = models().cross("gooseberry_bush3", modLoc("blocks/bush_gooseberry_stage3"));
    generateBlockStatesForBlock(ModBlocks.GOOSEBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)) {
        case 0:
          return gooseberryBush0;
        case 1:
          return gooseberryBush1;
        case 2:
          return gooseberryBush2;
        case 3:
          return gooseberryBush3;
        default:
          return gooseberryBush0;
      }
    });

    // crimwood blocks
    BlockModelBuilder crimwood = models().cubeAll("crimwood", modLoc("blocks/crimwood_log"));
    simpleBlock(ModBlocks.CRIMWOOD.get(), crimwood);

    axisBlock(ModBlocks.CRIMWOOD_LOG.get(), modLoc("blocks/crimwood_log"), modLoc("blocks/crimwood_log_top"));

    BlockModelBuilder crimwoodButton = models().withExistingParent("crimwood_button", mcLoc("block/button"))
        .texture("texture", modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodButtonPressed = models().withExistingParent("crimwood_button_pressed", mcLoc("block/button_pressed"))
        .texture("texture", modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodButtonInventory = models().withExistingParent("crimwood_button_inventory", mcLoc("block/button_inventory"))
        .texture("texture", modLoc("blocks/crimwood_planks"));

    horizontalFaceBlock(ModBlocks.CRIMWOOD_BUTTON.get(), blockState
        -> (blockState.get(BlockStateProperties.POWERED)) ? crimwoodButtonPressed : crimwoodButton, 180);

    doorBlock(ModBlocks.CRIMWOOD_DOOR.get(),
        modLoc("blocks/crimwood_door_bottom"),
        modLoc("blocks/crimwood_door_top"));

    BlockModelBuilder crimwoodFenceInventory = models().fenceInventory("crimwood_fence_inventory", modLoc("blocks/crimwood_planks"));

    fenceBlock(ModBlocks.CRIMWOOD_FENCE.get(), modLoc("blocks/crimwood_planks"));

    fenceGateBlock(ModBlocks.CRIMWOOD_FENCE_GATE.get(), modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodLeaves = models().cubeAll("crimwood_leaves", modLoc("blocks/crimwood_leaves"));
    simpleBlock(ModBlocks.CRIMWOOD_LEAVES.get(), crimwoodLeaves);

    BlockModelBuilder crimwoodPlanks = models().cubeAll("crimwood_planks", modLoc("blocks/crimwood_planks"));
    simpleBlock(ModBlocks.CRIMWOOD_PLANKS.get(), crimwoodPlanks);

    /* BlockModelBuilder crimwoodSign = models().cubeAll("crimwood_sign", modLoc("blocks/crimwood_planks"));
    simpleBlock(ModBlocks.CRIMWOOD_SIGN.get(), crimwoodSign); */

    BlockModelBuilder crimwoodPressurePlate = models()
        .withExistingParent("crimwood_pressure_plate", mcLoc("block/pressure_plate_up"))
        .texture("texture", modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodPressurePlateDown = models()
        .withExistingParent("crimwood_pressure_plate_down", mcLoc("block/pressure_plate_down"))
        .texture("texture", modLoc("blocks/crimwood_planks"));

    generateBlockStatesForBlock(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(), blockState
        -> (blockState.get(BlockStateProperties.POWERED)) ? crimwoodPressurePlateDown : crimwoodPressurePlate);

    BlockModelBuilder crimwoodTrapDoor = models().trapdoorOrientableBottom("crimwood_trap_door", modLoc("blocks/crimwood_trapdoor"));

    BlockModelBuilder crimwoodTrapDoorTop = models().trapdoorOrientableTop("crimwood_trap_door_top", modLoc("blocks/crimwood_trapdoor"));

    BlockModelBuilder crimwoodTrapDoorOpen = models().trapdoorOrientableOpen("crimwood_trap_door_open", modLoc("blocks/crimwood_trapdoor"));

    trapdoorBlock(ModBlocks.CRIMWOOD_TRAPDOOR.get(), crimwoodTrapDoor, crimwoodTrapDoorTop, crimwoodTrapDoorOpen, true);

    stairsBlock(ModBlocks.CRIMWOOD_STAIRS.get(), modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodSlab = models().slab("crimwood_slab",
        modLoc("blocks/crimwood_planks"), modLoc("blocks/crimwood_planks"), modLoc("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodSlabTop = models().slabTop("crimwood_slab_top",
        modLoc("blocks/crimwood_planks"), modLoc("blocks/crimwood_planks"), modLoc("blocks/crimwood_planks"));

    slabBlock(ModBlocks.CRIMWOOD_SLAB.get(), crimwoodSlab, crimwoodSlabTop, crimwoodPlanks);

    // flowers/ saplings
    BlockModelBuilder crimwoodSapling = models().cross("crimwood_sapling", modLoc("blocks/crimwood_sapling"));
    simpleBlock(ModBlocks.CRIMWOOD_SAPLING.get(), crimwoodSapling);

    BlockModelBuilder crimwoodPottedSapling = models()
        .withExistingParent("potted_crimwood_sapling", mcLoc("block/flower_pot_cross"))
        .texture("plant", modLoc("blocks/crimwood_sapling"));

    simpleBlock(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), crimwoodPottedSapling);

    BlockModelBuilder crimwoodPottedLeaf = models()
        .withExistingParent("potted_crimleaf", mcLoc("block/flower_pot_cross"))
        .texture("plant", modLoc("blocks/crimleaf"));

    simpleBlock(ModBlocks.POTTED_CRIMLEAF.get(), crimwoodPottedLeaf);

    // mud blocks
    BlockModelBuilder mudBlock = models().cubeAll("mud_block", modLoc("blocks/mud_block"));
    simpleBlock(ModBlocks.MUD_BLOCK.get(), mudBlock);

    BlockModelBuilder mudBricks = models().cubeAll("mud_bricks", modLoc("blocks/mud_bricks"));
    simpleBlock(ModBlocks.MUD_BRICKS.get(), mudBricks);

    BlockModelBuilder mudBrickSlab = models().slab("mud_brick_slab",
        modLoc("blocks/mud_bricks"), modLoc("blocks/mud_bricks"), modLoc("blocks/mud_bricks"));

    BlockModelBuilder mudBrickSlabTop = models().slabTop("mud_brick_slab_top",
        modLoc("blocks/mud_bricks"), modLoc("blocks/mud_bricks"), modLoc("blocks/mud_bricks"));

    slabBlock(ModBlocks.MUD_BRICK_SLAB.get(), mudBrickSlab, mudBrickSlabTop, mudBricks);

    stairsBlock(ModBlocks.MUD_BRICK_STAIRS.get(), modLoc("blocks/mud_bricks"));

    BlockModelBuilder mudBrickWallInventory = models().wallInventory("mud_brick_wall_inventory", modLoc("blocks/mud_bricks"));

    wallBlock(ModBlocks.MUD_BRICK_WALL.get(), modLoc("blocks/mud_bricks"));

    // blocks & ores
    BlockModelBuilder fossilDirt = models().cubeAll("fossil_dirt", modLoc("blocks/fossil_dirt"));
    simpleBlock(ModBlocks.FOSSIL_DIRT.get(), fossilDirt);

    BlockModelBuilder fossilOre = models().cubeAll("fossil_ore", modLoc("blocks/fossil_ore"));
    simpleBlock(ModBlocks.FOSSIL_ORE.get(), fossilOre);

    BlockModelBuilder limestone = models().cubeAll("limestone", modLoc("blocks/limestone"));
    simpleBlock(ModBlocks.LIMESTONE_BLOCK.get(), limestone);

    BlockModelBuilder sulfurOre = models().cubeAll("sulfur_ore", modLoc("blocks/sulfur_ore"));
    simpleBlock(ModBlocks.SULFUR_ORE.get(), sulfurOre);

    BlockModelBuilder resinBlock = models().cubeAll("resin_block", modLoc("blocks/resin_block"));
    simpleBlock(ModBlocks.RESIN_BLOCK.get(), resinBlock);

    BlockModelBuilder gelatinBlock = models().cubeAll("gelatin_block", modLoc("blocks/gelatin_block"));
    simpleBlock(ModBlocks.GELATIN_BLOCK.get(), gelatinBlock);

    BlockModelBuilder saltOre = models().cubeAll("salt_ore", modLoc("blocks/salt_ore"));
    simpleBlock(ModBlocks.SALT_ORE.get(), saltOre);

    BlockModelBuilder saltBlock = models().cubeAll("salt_block", modLoc("blocks/salt_block"));
    simpleBlock(ModBlocks.SALT_BLOCK.get(), saltBlock);

    BlockModelBuilder blackCoalOre = models().cubeAll("black_coal_ore", modLoc("blocks/black_coal_ore"));
    simpleBlock(ModBlocks.BLACK_COAL_ORE.get(), blackCoalOre);

    BlockModelBuilder blackCoalBlock = models().cubeAll("black_coal_block", modLoc("blocks/black_coal_block"));
    simpleBlock(ModBlocks.BLACK_COAL_BLOCK.get(), blackCoalBlock);

    BlockModelBuilder peatBlock = models().cubeAll("peat_block", modLoc("blocks/peat_block"));
    simpleBlock(ModBlocks.PEAT_BLOCK.get(), peatBlock);

    BlockModelBuilder ravenEyeOre = models().cubeAll("raven_eye_ore", modLoc("blocks/raven_eye_ore"));
    simpleBlock(ModBlocks.RAVEN_EYE_ORE.get(), ravenEyeOre);

    BlockModelBuilder ravenEyeBlock = models().cubeAll("raven_eye_block", modLoc("blocks/raven_eye_block"));
    simpleBlock(ModBlocks.RAVEN_EYE_BLOCK.get(), ravenEyeBlock);

    BlockModelBuilder copperOre = models().cubeAll("copper_ore", modLoc("blocks/copper_ore"));
    simpleBlock(ModBlocks.COPPER_ORE.get(), copperOre);

    BlockModelBuilder copperBlock = models().cubeAll("copper_block", modLoc("blocks/copper_block"));
    simpleBlock(ModBlocks.COPPER_BLOCK.get(), copperBlock);

    BlockModelBuilder tinOre = models().cubeAll("tin_ore", modLoc("blocks/tin_ore"));
    simpleBlock(ModBlocks.TIN_ORE.get(), tinOre);

    BlockModelBuilder tinBlock = models().cubeAll("tin_block", modLoc("blocks/tin_block"));
    simpleBlock(ModBlocks.TIN_BLOCK.get(), tinBlock);

    BlockModelBuilder zincOre = models().cubeAll("zinc_ore", modLoc("blocks/zinc_ore"));
    simpleBlock(ModBlocks.ZINC_ORE.get(), zincOre);

    BlockModelBuilder zincBlock = models().cubeAll("zinc_block", modLoc("blocks/zinc_block"));
    simpleBlock(ModBlocks.ZINC_BLOCK.get(), zincBlock);

    BlockModelBuilder bronzeBlock = models().cubeAll("bronze_block", modLoc("blocks/bronze_block"));
    simpleBlock(ModBlocks.BRONZE_BLOCK.get(), bronzeBlock);

    BlockModelBuilder brassBlock = models().cubeAll("brass_block", modLoc("blocks/brass_block"));
    simpleBlock(ModBlocks.BRASS_BLOCK.get(), brassBlock);

    BlockModelBuilder silverOre = models().cubeAll("silver_ore", modLoc("blocks/silver_ore"));
    simpleBlock(ModBlocks.SILVER_ORE.get(), silverOre);

    BlockModelBuilder silverBlock = models().cubeAll("silver_block", modLoc("blocks/silver_block"));
    simpleBlock(ModBlocks.SILVER_BLOCK.get(), silverBlock);

    BlockModelBuilder leadOre = models().cubeAll("lead_ore", modLoc("blocks/lead_ore"));
    simpleBlock(ModBlocks.LEAD_ORE.get(), leadOre);

    BlockModelBuilder leadBlock = models().cubeAll("lead_block", modLoc("blocks/lead_block"));
    simpleBlock(ModBlocks.LEAD_BLOCK.get(), leadBlock);

    BlockModelBuilder steelBlock = models().cubeAll("steel_block", modLoc("blocks/steel_block"));
    simpleBlock(ModBlocks.STEEL_BLOCK.get(), steelBlock);

    BlockModelBuilder mytherineOre = models().cubeAll("mytherine_ore", modLoc("blocks/mytherine_ore"));
    simpleBlock(ModBlocks.MYTHERINE_ORE.get(), mytherineOre);

    BlockModelBuilder mytherineBlock = models().cubeAll("mytherine_block", modLoc("blocks/mytherine_block"));
    simpleBlock(ModBlocks.MYTHERINE_BLOCK.get(), mytherineBlock);

    // functional blocks
    // alloy furnace
    BlockModelBuilder alloyFurnace = models().withExistingParent("alloy_furnace_off", EssentialsUtils.resourceLocation("block/alloy_furnace"))
        .texture("3", "blocks/alloy_furnace");

    BlockModelBuilder alloyFurnaceOn = models().withExistingParent("alloy_furnace_on", EssentialsUtils.resourceLocation("block/alloy_furnace"))
        .texture("3", "blocks/alloy_furnace_lit");

    orientedBlock(AlloyFurnaceInit.ALLOY_FURNACE.get(), blockState -> blockState.get(BlockStateProperties.LIT) ? alloyFurnaceOn : alloyFurnace);

    // todo adjust!
    /*// barrel
    BlockModelBuilder barrelOpen = models().withExistingParent("barrel_open", EssentialsUtils.resourceLocation("block/barrel"))
        .texture("3", "blocks/barrel_open");

    BlockModelBuilder barrelLid = models().withExistingParent("barrel_lid", EssentialsUtils.resourceLocation("block/barrel"))
        .texture("3", "blocks/barrel_lid");
    orientedBlock(ModBlocks.BARREL.get(), blockState -> barrelOpen);

    // drying rack
    BlockModelBuilder dryingRack = models().withExistingParent("drying_rack", EssentialsUtils.resourceLocation("block/drying_rack"))
        .texture("1", "blocks/drying_rack");
    orientedBlock(ModBlocks.DRYING_RACK.get(), blockState -> dryingRack);

    // hand mill
    BlockModelBuilder handMill = models().withExistingParent("hand_mill", EssentialsUtils.resourceLocation("block/hand_mill"))
        .texture("4", "blocks/hand_mill");
    orientedBlock(HandMillInit.HAND_MILL.get(), blockState -> handMill);
    */

    // stone anvils
    // stone
    BlockModelBuilder stoneAnvilStone = models().withExistingParent("stone_anvil_stone", mcLoc("block/template_anvil"))
        .texture("body", modLoc("blocks/anvil_stone"))
        .texture("particle", modLoc("blocks/anvil_stone"))
        .texture("top", modLoc("blocks/anvil_top_stone"));
    horizontalBlock(ModBlocks.STONE_ANVIL_STONE.get(), stoneAnvilStone);

    BlockModelBuilder damagedStoneAnvilStone = models().withExistingParent("damaged_anvil_stone", modLoc("stone_anvil_stone"))
        .texture("top", modLoc("blocks/damaged_anvil_top_stone"));
    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_STONE.get(), damagedStoneAnvilStone);

    BlockModelBuilder chippedStoneAnvilStone = models().withExistingParent("damaged_anvil_stone", modLoc("stone_anvil_stone"))
        .texture("top", modLoc("blocks/chipped_anvil_top_stone"));
    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_STONE.get(), chippedStoneAnvilStone);

    // andesite
    BlockModelBuilder stoneAnvilAndesite = models().withExistingParent("stone_anvil_andesite", mcLoc("block/template_anvil"))
        .texture("body", modLoc("blocks/anvil_andesite"))
        .texture("particle", modLoc("blocks/anvil_andesite"))
        .texture("top", modLoc("blocks/anvil_top_andesite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_ANDESITE.get(), stoneAnvilAndesite);

    BlockModelBuilder damagedStoneAnvilAndesite = models().withExistingParent("damaged_anvil_andesite", modLoc("stone_anvil_andesite"))
        .texture("top", modLoc("blocks/damaged_anvil_top_andesite"));
    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_ANDESITE.get(), damagedStoneAnvilAndesite);

    BlockModelBuilder chippedStoneAnvilAndesite = models().withExistingParent("damaged_anvil_andesite", modLoc("stone_anvil_andesite"))
        .texture("top", modLoc("blocks/chipped_anvil_top_andesite"));
    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_ANDESITE.get(), chippedStoneAnvilAndesite);

    // diorite
    BlockModelBuilder stoneAnvilDiorite = models().withExistingParent("stone_anvil_diorite", mcLoc("block/template_anvil"))
        .texture("body", modLoc("blocks/anvil_diorite"))
        .texture("particle", modLoc("blocks/anvil_diorite"))
        .texture("top", modLoc("blocks/anvil_top_diorite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_DIORITE.get(), stoneAnvilDiorite);

    BlockModelBuilder damagedStoneAnvilDiorite = models().withExistingParent("damaged_anvil_diorite", modLoc("stone_anvil_diorite"))
        .texture("top", modLoc("blocks/damaged_anvil_top_diorite"));
    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_DIORITE.get(), damagedStoneAnvilDiorite);

    BlockModelBuilder chippedStoneAnvilDiorite = models().withExistingParent("damaged_anvil_diorite", modLoc("stone_anvil_diorite"))
        .texture("top", modLoc("blocks/chipped_anvil_top_diorite"));
    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_DIORITE.get(), chippedStoneAnvilDiorite);

    // granite
    BlockModelBuilder stoneAnvilGranite = models().withExistingParent("stone_anvil_granite", mcLoc("block/template_anvil"))
        .texture("body", modLoc("blocks/anvil_granite"))
        .texture("particle", modLoc("blocks/anvil_granite"))
        .texture("top", modLoc("blocks/anvil_top_granite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_GRANITE.get(), stoneAnvilGranite);

    BlockModelBuilder damagedStoneAnvilGranite = models().withExistingParent("damaged_anvil_granite", modLoc("stone_anvil_granite"))
        .texture("top", modLoc("blocks/damaged_anvil_top_granite"));
    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_GRANITE.get(), damagedStoneAnvilGranite);

    BlockModelBuilder chippedStoneAnvilGranite = models().withExistingParent("damaged_anvil_granite", modLoc("stone_anvil_granite"))
        .texture("top", modLoc("blocks/chipped_anvil_top_granite"));
    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_GRANITE.get(), chippedStoneAnvilGranite);

    BlockModelBuilder stone_crafting_table = models().cube("stone_crafting_table", mcLoc("block/cobblestone"),
        modLoc("blocks/stone_crafting_table_top"), modLoc("blocks/stone_crafting_table_front"),
        modLoc("blocks/stone_crafting_table_side"), modLoc("blocks/stone_crafting_table_side"),
        modLoc("blocks/stone_crafting_table_front")).texture("particle", mcLoc("block/cobblestone"));
    simpleBlock(ModBlocks.STONE_CRAFTING_TABLE.get(), stone_crafting_table);

    // misc
    BlockModelBuilder crimleaf = models().cross("crimleaf", modLoc("blocks/crimleaf"));
    simpleBlock(ModBlocks.CRIMLEAF.get(), crimleaf);
  }
}
