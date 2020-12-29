package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.datagen.recipes.EssentialsRecipeProvider;
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
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_ITEM.get(), 3)
        .patternLine("##")
        .patternLine("##")
        .key('#', ModBlockItems.CRIMWOOD_LOG_ITEM.get())
        .addCriterion("has_crimwood", hasItem(ModBlockItems.CRIMWOOD_LOG_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModBlockItems.CRIMWOOD_BUTTON_ITEM.get())
        .addIngredient(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_DOOR_ITEM.get(), 3)
        .patternLine("##")
        .patternLine("##")
        .patternLine("##")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_FENCE_ITEM.get(), 3)
        .patternLine("W#W")
        .patternLine("W#W")
        .key('#', rods_wood)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get())
        .patternLine("#W#")
        .patternLine("#W#")
        .key('#', rods_wood)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get())
        .patternLine("##")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_STAIRS_ITEM.get(), 4)
        .patternLine("#  ")
        .patternLine("## ")
        .patternLine("###")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get(), 2)
        .patternLine("###")
        .patternLine("###")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    // mud
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MUD_BRICKS_ITEM.get())
        .patternLine(" m ")
        .patternLine("mcm")
        .patternLine(" m ")
        .key('m', ModItems.MUD_BRICK_DRIED.get())
        .key('c', Items.CLAY_BALL)
        .addCriterion("has_mud_brick_dried", hasItem(ModItems.MUD_BRICK_DRIED.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MUD_BRICK_SLAB_ITEM.get(), 6)
        .patternLine("###")
        .key('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .addCriterion("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MUD_BRICK_STAIRS_ITEM.get(), 4)
        .patternLine("#  ")
        .patternLine("## ")
        .patternLine("###")
        .key('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .addCriterion("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MUD_BRICK_WALL_ITEM.get(), 6)
        .patternLine("###")
        .patternLine("###")
        .key('#', ModBlockItems.MUD_BRICKS_ITEM.get())
        .addCriterion("has_mud_bricks", hasItem(ModBlockItems.MUD_BRICKS_ITEM.get()))
        .build(consumer);

    // miscellaneous
    ShapedRecipeBuilder.shapedRecipe(Blocks.BRICKS, 4)
        .patternLine(" b ")
        .patternLine("bgb")
        .patternLine(" b ")
        .key('b', Items.BRICK)
        .key('g', ModItems.GROUT.get())
        .addCriterion("has_brick", hasItem(Items.BRICK))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(Blocks.STONE_BRICKS, 4)
        .patternLine(" s ")
        .patternLine("sgs")
        .patternLine(" s ")
        .key('s', Items.STONE)
        .key('g', ModItems.GROUT.get())
        .addCriterion("has_stone", hasItem(Items.STONE))
        .build(consumer);
  }
}
