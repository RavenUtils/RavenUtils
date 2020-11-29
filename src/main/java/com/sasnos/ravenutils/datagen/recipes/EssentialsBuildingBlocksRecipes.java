package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

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
        .key('#', Tags.Items.RODS_WOODEN)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get())
        .patternLine("#W#")
        .patternLine("#W#")
        .key('#', Tags.Items.RODS_WOODEN)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get())
        .patternLine("##")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.CRIMWOOD_SLAB_ITEM.get(), 6)
        .patternLine("###")
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

    /* ShapedRecipeBuilder.shapedRecipe(ModItems.CRIMWOOD_BOAT.get())
        .patternLine("# #")
        .patternLine("###")
        .key('#', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer); */

    /* ShapedRecipeBuilder.shapedRecipe(ModItems.CRIMWOOD_SIGN.get())
        .patternLine("WWW")
        .patternLine("WWW")
        .patternLine(" # ")
        .key('#', Tags.Items.RODS_WOODEN)
        .key('W', ModBlockItems.CRIMWOOD_PLANKS_ITEM.get())
        .addCriterion("has_crimwood_plank", hasItem(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get()))
        .build(consumer); */
  }
}
