package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;

public class EssentialsBuildingBlocksRecipes extends EssentialsRecipeProvider {
  public EssentialsBuildingBlocksRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // crimwood blocks
    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_ITEM.get(), 3)
        .pattern("##")
        .pattern("##")
        .define('#', ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .unlockedBy("has_crimwood", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModBlockItems.CRIMWOOD_BUTTON_ITEM.get())
        .requires(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_DOOR_ITEM.get(), 3)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .define('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_FENCE_ITEM.get(), 3)
        .pattern("W#W")
        .pattern("W#W")
        .define('#', rods_wood)
        .define('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get())
        .pattern("#W#")
        .pattern("#W#")
        .define('#', rods_wood)
        .define('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get())
        .pattern("##")
        .define('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_STAIRS_ITEM.get(), 4)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .define('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get(), 2)
        .pattern("###")
        .pattern("###")
        .define('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .unlockedBy("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .save(consumer);

    // mud
    ShapedRecipeBuilder.shaped(ModBlockItems.MUD_BRICKS_ITEM.get())
        .pattern(" m ")
        .pattern("mcm")
        .pattern(" m ")
        .define('m', ModItems.MUD_BRICK_DRIED.get())
        .define('c', Items.CLAY_BALL)
        .unlockedBy("has_mud_brick_dried", hasItem(ModItems.MUD_BRICK_DRIED.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.MUD_BRICK_SLAB_ITEM.get(), 6)
        .pattern("###")
        .define('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .unlockedBy("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.MUD_BRICK_STAIRS_ITEM.get(), 4)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .define('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .unlockedBy("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.MUD_BRICK_WALL_ITEM.get(), 6)
        .pattern("###")
        .pattern("###")
        .define('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .unlockedBy("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .save(consumer);

    // miscellaneous
    ShapedRecipeBuilder.shaped(Blocks.BRICKS, 4)
        .pattern(" b ")
        .pattern("bgb")
        .pattern(" b ")
        .define('b', Items.BRICK)
        .define('g', ModItems.GROUT.get())
        .unlockedBy("has_brick", hasItem(Items.BRICK))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Blocks.STONE_BRICKS, 4)
        .pattern(" s ")
        .pattern("sgs")
        .pattern(" s ")
        .define('s', Items.STONE)
        .define('g', ModItems.GROUT.get())
        .unlockedBy("has_stone", hasItem(Items.STONE))
        .save(consumer);
  }
}
