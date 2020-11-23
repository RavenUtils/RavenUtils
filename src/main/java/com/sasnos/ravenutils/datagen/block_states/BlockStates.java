package com.sasnos.ravenutils.datagen.block_states;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.data_generation.blocks.EssentialsBlockStates;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.sasnos.ravenutils.utils.EssentialsUtils.resourceLocation;

public class BlockStates extends EssentialsBlockStates {

  public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, RavenUtils.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {

    // berry bushes
     BlockModelBuilder blueberryBush0 = models().cross("blueberry_bush0",
         resourceLocation("blocks/berry_bush_stage0"));

     BlockModelBuilder blueberryBush1 = models().cross("blueberry_bush1",
         resourceLocation("blocks/berry_bush_stage1"));

     BlockModelBuilder blueberryBush2 = models().cross("blueberry_bush2",
         resourceLocation("blocks/bush_blueberry_stage2"));

     BlockModelBuilder blueberryBush3 = models().cross("blueberry_bush3",
         resourceLocation("blocks/bush_blueberry_stage3"));

     generateBlockStatesForBlock(ModBlocks.BLUEBERRY_BUSH.get(), blockState -> {
       switch (blockState.get(BlockStateProperties.AGE_0_3)){
         case 0:
           return blueberryBush0;
         case 1:
           return blueberryBush1;
         case 2:
           return blueberryBush2;
         case 3:
           return blueberryBush3;
         default:
           return null;
       }
     });

     BlockModelBuilder elderberryBush0 = models().cross("elderberry_bush0",
         resourceLocation("blocks/berry_bush_stage0"));

     BlockModelBuilder elderberryBush1 = models().cross("elderberry_bush1",
         resourceLocation("blocks/berry_bush_stage1"));

     BlockModelBuilder elderberryBush2 = models().cross("elderberry_bush2",
         resourceLocation("blocks/bush_elderberry_stage2"));

     BlockModelBuilder elderberryBush3 = models().cross("elderberry_bush3",
         resourceLocation("blocks/bush_elderberry_stage3"));

     generateBlockStatesForBlock(ModBlocks.ELDERBERRY_BUSH.get(), blockState -> {
       switch (blockState.get(BlockStateProperties.AGE_0_3)){
         case 0:
           return elderberryBush0;
         case 1:
           return elderberryBush1;
         case 2:
           return elderberryBush2;
         case 3:
           return elderberryBush3;
         default:
           return null;
       }
     });

    BlockModelBuilder raspberryBush0 = models().cross("raspberry_bush0",
        resourceLocation("blocks/berry_bush_stage0"));

    BlockModelBuilder raspberryBush1 = models().cross("raspberry_bush1",
        resourceLocation("blocks/berry_bush_stage1"));

    BlockModelBuilder raspberryBush2 = models().cross("raspberry_bush2",
        resourceLocation("blocks/bush_raspberry_stage2"));

    BlockModelBuilder raspberryBush3 = models().cross("raspberry_bush3",
        resourceLocation("blocks/bush_raspberry_stage3"));

    generateBlockStatesForBlock(ModBlocks.RASPBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)){
        case 0:
          return raspberryBush0;
        case 1:
          return raspberryBush1;
        case 2:
          return raspberryBush2;
        case 3:
          return raspberryBush3;
        default:
          return null;
      }
    });

    BlockModelBuilder blackberryBush0 = models().cross("blackberry_bush0",
        resourceLocation("blocks/berry_bush_stage0"));

    BlockModelBuilder blackberryBush1 = models().cross("blackberry_bush1",
        resourceLocation("blocks/berry_bush_stage1"));

    BlockModelBuilder blackberryBush2 = models().cross("blackberry_bush2",
        resourceLocation("blocks/bush_blackberry_stage2"));

    BlockModelBuilder blackberryBush3 = models().cross("blackberry_bush3",
        resourceLocation("blocks/bush_blackberry_stage3"));

    generateBlockStatesForBlock(ModBlocks.BLACKBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)){
        case 0:
          return blackberryBush0;
        case 1:
          return blackberryBush1;
        case 2:
          return blackberryBush2;
        case 3:
          return blackberryBush3;
        default:
          return null;
      }
    });

    BlockModelBuilder gooseberryBush0 = models().cross("gooseberry_bush0",
        resourceLocation("blocks/berry_bush_stage0"));

    BlockModelBuilder gooseberryBush1 = models().cross("gooseberry_bush1",
        resourceLocation("blocks/berry_bush_stage1"));

    BlockModelBuilder gooseberryBush2 = models().cross("gooseberry_bush2",
        resourceLocation("blocks/bush_gooseberry_stage2"));

    BlockModelBuilder gooseberryBush3 = models().cross("gooseberry_bush3",
        resourceLocation("blocks/bush_gooseberry_stage3"));

    generateBlockStatesForBlock(ModBlocks.GOOSEBERRY_BUSH.get(), blockState -> {
      switch (blockState.get(BlockStateProperties.AGE_0_3)){
        case 0:
          return gooseberryBush0;
        case 1:
          return gooseberryBush1;
        case 2:
          return gooseberryBush2;
        case 3:
          return gooseberryBush3;
        default:
          return null;
      }
    });

    // more
    BlockModelBuilder crimleaf = models().cross("crimleaf",
        resourceLocation("blocks/crimleaf"));
    simpleBlock(ModBlocks.CRIMLEAF.get(), crimleaf);

    BlockModelBuilder crimwood = models().cubeAll("crimwood",
        resourceLocation("blocks/crimwood_log"));
    simpleBlock(ModBlocks.CRIMWOOD.get(), crimwood);

     BlockModelBuilder crimwoodButton = models().withExistingParent("crimwood_button", mcLoc("block/button"))
             .texture("texture", resourceLocation("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodButtonPressed = models().withExistingParent("crimwood_button_pressed", mcLoc("block/button_pressed"))
            .texture("texture", resourceLocation("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodButtonInentory = models().withExistingParent("crimwood_button_inventory", mcLoc("block/button_inventory"))
            .texture("texture", resourceLocation("blocks/crimwood_planks"));

    directionalBlock(ModBlocks.CRIMWOOD_BUTTON.get(), blockState -> {
      if(blockState.get(BlockStateProperties.POWERED)){
        return crimwoodButtonPressed;
      }
      else {
        return crimwoodButton;
      }
    });

    doorBlock(ModBlocks.CRIMWOOD_DOOR.get(),
            resourceLocation("blocks/crimwood_door_bottom"),
            resourceLocation("blocks/crimwood_door_top"));

    BlockModelBuilder crimwwoodFenceInventory = models().fenceInventory("crimwood_fence_inventory",
            resourceLocation("blocks/crimwood_planks"));

    fenceBlock(ModBlocks.CRIMWOOD_FENCE.get(), resourceLocation("blocks/crimwood_planks"));

    fenceGateBlock(ModBlocks.CRIMWOOD_FENCE_GATE.get(), resourceLocation("blocks/crimwood_planks"));

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

    BlockModelBuilder crimwoodPressurePlate = models()
            .withExistingParent("crimwood_pressure_plate", mcLoc("block/pressure_plate_up"))
            .texture("texture", resourceLocation("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodPressurePlateDown = models()
            .withExistingParent("crimwood_pressure_plate_down", mcLoc("block/pressure_plate_down"))
            .texture("texture", resourceLocation("blocks/crimwood_planks"));

    generateBlockStatesForBlock(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(), blockState -> {
      if (blockState.get(BlockStateProperties.POWERED)){
        return crimwoodPressurePlateDown;
      }
      else {
        return crimwoodPressurePlate;
      }
    });

    BlockModelBuilder crimwoodTrapDoor = models().trapdoorOrientableBottom("crimwood_trap_door",
            resourceLocation("blocks/crimwood_trapdoor"));

    BlockModelBuilder crimwoodTrapDoorTop = models().trapdoorOrientableTop("crimwood_trap_door_top",
            resourceLocation("blocks/crimwood_trapdoor"));

    BlockModelBuilder crimwoodTrapDoorOpen = models().trapdoorOrientableOpen("crimwood_trap_door_open",
            resourceLocation("blocks/crimwood_trapdoor"));

    trapdoorBlock(ModBlocks.CRIMWOOD_TRAPDOOR.get(), crimwoodTrapDoor, crimwoodTrapDoorTop, crimwoodTrapDoorOpen, true);

    stairsBlock(ModBlocks.CRIMWOOD_STAIRS.get(), resourceLocation("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodSapling = models().cross("crimwood_sapling",
        resourceLocation("blocks/crimwood_sapling"));
    simpleBlock(ModBlocks.CRIMWOOD_SAPLING.get(), crimwoodSapling);

    BlockModelBuilder crimwoodPottedSapling = models()
            .withExistingParent("potted_crimwood_sapling", mcLoc("block/flower_pot_cross"))
            .texture("plant", resourceLocation("blocks/crimwood_sapling"));

    simpleBlock(ModBlocks.POTTED_CRIMWOOD_SAPLING.get(), crimwoodPottedSapling);

    BlockModelBuilder crimwoodPottedLeaf = models()
            .withExistingParent("potted_crimwood_sapling", mcLoc("block/flower_pot_cross"))
            .texture("plant", resourceLocation("blocks/crimleaf"));

    simpleBlock(ModBlocks.POTTED_CRIMLEAF.get(), crimwoodPottedLeaf);

     BlockModelBuilder crimwoodSlab = models().slab("crimwood_slab",
         resourceLocation("blocks/crimwood_planks"),
         resourceLocation("blocks/crimwood_planks"),
         resourceLocation("blocks/crimwood_planks"));

    BlockModelBuilder crimwoodSlabTop = models().slabTop("crimwood_slab_top",
            resourceLocation("blocks/crimwood_planks"),
            resourceLocation("blocks/crimwood_planks"),
            resourceLocation("blocks/crimwood_planks"));

    slabBlock(ModBlocks.CRIMWOOD_SLAB.get(), crimwoodSlab, crimwoodSlabTop, crimwoodPlanks);



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

    BlockModelBuilder gelatinBlock = models().cubeAll("gelatin_block",
        resourceLocation("blocks/gelatin_block"));
    simpleBlock(ModBlocks.GELATIN_BLOCK.get(), gelatinBlock);

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

    // stone anvils
    // stone
    BlockModelBuilder stoneAnvilStone = models().withExistingParent("stone_anvil_stone", mcLoc("block/template_anvil"))
        .texture("body", resourceLocation("blocks/anvil_stone"))
        .texture("top", resourceLocation("blocks/anvil_top_stone"));
    horizontalBlock(ModBlocks.STONE_ANVIL_STONE.get(), stoneAnvilStone);

    BlockModelBuilder damagedStoneAnvilStone = models().withExistingParent("damaged_anvil_stone", resourceLocation("stone_anvil_stone"))
        .texture("top", resourceLocation("blocks/damaged_anvil_top_stone"));

    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_STONE.get(), damagedStoneAnvilStone);

    BlockModelBuilder chippedStoneAnvilStone = models().withExistingParent("damaged_anvil_stone", resourceLocation("stone_anvil_stone"))
        .texture("top", resourceLocation("blocks/chipped_anvil_top_stone"));

    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_STONE.get(), chippedStoneAnvilStone);

    // andesite
    BlockModelBuilder stoneAnvilAndesite = models().withExistingParent("stone_anvil_andesite", mcLoc("block/template_anvil"))
        .texture("body", resourceLocation("blocks/anvil_andesite"))
        .texture("top", resourceLocation("blocks/anvil_top_andesite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_ANDESITE.get(), stoneAnvilAndesite);

    BlockModelBuilder damagedStoneAnvilAndesite = models().withExistingParent("damaged_anvil_andesite", resourceLocation("stone_anvil_andesite"))
        .texture("top", resourceLocation("blocks/damaged_anvil_top_andesite"));

    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_ANDESITE.get(), damagedStoneAnvilAndesite);

    BlockModelBuilder chippedStoneAnvilAndesite = models().withExistingParent("damaged_anvil_andesite", resourceLocation("stone_anvil_andesite"))
        .texture("top", resourceLocation("blocks/chipped_anvil_top_andesite"));

    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_ANDESITE.get(), chippedStoneAnvilAndesite);

    // diorite
    BlockModelBuilder stoneAnvilDiorite = models().withExistingParent("stone_anvil_diorite", mcLoc("block/template_anvil"))
        .texture("body", resourceLocation("blocks/anvil_diorite"))
        .texture("top", resourceLocation("blocks/anvil_top_diorite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_DIORITE.get(), stoneAnvilDiorite);

    BlockModelBuilder damagedStoneAnvilDiorite = models().withExistingParent("damaged_anvil_diorite", resourceLocation("stone_anvil_diorite"))
        .texture("top", resourceLocation("blocks/damaged_anvil_top_diorite"));

    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_DIORITE.get(), damagedStoneAnvilDiorite);

    BlockModelBuilder chippedStoneAnvilDiorite = models().withExistingParent("damaged_anvil_diorite", resourceLocation("stone_anvil_diorite"))
        .texture("top", resourceLocation("blocks/chipped_anvil_top_diorite"));

    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_DIORITE.get(), chippedStoneAnvilDiorite);

    // granite
    BlockModelBuilder stoneAnvilGranite = models().withExistingParent("stone_anvil_granite", mcLoc("block/template_anvil"))
        .texture("body", resourceLocation("blocks/anvil_granite"))
        .texture("top", resourceLocation("blocks/anvil_top_granite"));
    horizontalBlock(ModBlocks.STONE_ANVIL_GRANITE.get(), stoneAnvilGranite);

    BlockModelBuilder damagedStoneAnvilGranite = models().withExistingParent("damaged_anvil_granite", resourceLocation("stone_anvil_granite"))
        .texture("top", resourceLocation("blocks/damaged_anvil_top_granite"));

    horizontalBlock(ModBlocks.DAMAGED_STONE_ANVIL_GRANITE.get(), damagedStoneAnvilGranite);

    BlockModelBuilder chippedStoneAnvilGranite = models().withExistingParent("damaged_anvil_granite", resourceLocation("stone_anvil_granite"))
        .texture("top", resourceLocation("blocks/chipped_anvil_top_granite"));

    horizontalBlock(ModBlocks.CHIPPED_STONE_ANVIL_GRANITE.get(), chippedStoneAnvilGranite);

    BlockModelBuilder stone_crafting_table =
        models().cube("stone_crafting_table",
            mcLoc("block/cobblestone"),
            resourceLocation("blocks/stone_crafting_table_top"),
            resourceLocation("blocks/stone_crafting_table_front"),
            resourceLocation("blocks/stone_crafting_table_side"),
            resourceLocation("blocks/stone_crafting_table_side"),
            resourceLocation("blocks/stone_crafting_table_front"))
            .texture("particles", mcLoc("block/cobblestone"));

    simpleBlock(ModBlocks.STONE_CRAFTING_TABLE.get(), stone_crafting_table);


    // todo add MPS mill with/ without millstone
  }


}
