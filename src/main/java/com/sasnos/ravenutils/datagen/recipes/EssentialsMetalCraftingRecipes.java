package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;

public class EssentialsMetalCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsMetalCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // nuggets to ingot
    ShapedRecipeBuilder.shapedRecipe(ModItems.COPPER_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.COPPER_NUGGET.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.TIN_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.TIN_NUGGET.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.ZINC_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.ZINC_NUGGET.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.SILVER_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.SILVER_NUGGET.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.LEAD_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.LEAD_NUGGET.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRONZE_NUGGET.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.BRASS_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRASS_NUGGET.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.STEEL_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.STEEL_NUGGET.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.MYTHERINE_INGOT.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.MYTHERINE_NUGGET.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // ingot to nuggets
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COPPER_NUGGET.get(), 9)
        .addIngredient(ModItems.COPPER_INGOT.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.TIN_NUGGET.get(), 9)
        .addIngredient(ModItems.TIN_INGOT.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.ZINC_NUGGET.get(), 9)
        .addIngredient(ModItems.ZINC_INGOT.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_NUGGET.get(), 9)
        .addIngredient(ModItems.SILVER_INGOT.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEAD_NUGGET.get(), 9)
        .addIngredient(ModItems.LEAD_INGOT.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRONZE_NUGGET.get(), 9)
        .addIngredient(ModItems.BRONZE_INGOT.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRASS_NUGGET.get(), 9)
        .addIngredient(ModItems.BRASS_INGOT.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.STEEL_NUGGET.get(), 9)
        .addIngredient(ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MYTHERINE_NUGGET.get(), 9)
        .addIngredient(ModItems.MYTHERINE_INGOT.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_nuggets_from_crafting");

    // ingots to block
    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.COPPER_INGOT.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.TIN_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.TIN_INGOT.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.ZINC_INGOT.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.SILVER_INGOT.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.LEAD_INGOT.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRONZE_INGOT.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.BRASS_INGOT.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .patternLine("xxx")
        .patternLine("xxx")
        .patternLine("xxx")
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    // block to ingots
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.COPPER_INGOT.get(), 9)
        .addIngredient(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .addCriterion("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .build(consumer, "copper_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.TIN_INGOT.get(), 9)
        .addIngredient(ModBlockItems.TIN_BLOCK_ITEM.get())
        .addCriterion("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .build(consumer, "tin_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.ZINC_INGOT.get(), 9)
        .addIngredient(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .addCriterion("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .build(consumer, "zinc_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_INGOT.get(), 9)
        .addIngredient(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .addCriterion("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .build(consumer, "silver_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEAD_INGOT.get(), 9)
        .addIngredient(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .addCriterion("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .build(consumer, "lead_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRONZE_INGOT.get(), 9)
        .addIngredient(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer, "bronze_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.BRASS_INGOT.get(), 9)
        .addIngredient(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .addCriterion("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .build(consumer, "brass_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.STEEL_INGOT.get(), 9)
        .addIngredient(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer, "steel_ingots_from_block");

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.MYTHERINE_INGOT.get(), 9)
        .addIngredient(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .addCriterion("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer, "mytherine_ingots_from_block");

    // custom tools
    // copper
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.COPPER_SHOVEL.get())
        .patternLine("i")
        .patternLine("#")
        .patternLine("#")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.COPPER_AXE.get())
        .patternLine("ii")
        .patternLine("i#")
        .patternLine(" #")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.COPPER_PICKAXE.get())
        .patternLine("iii")
        .patternLine(" # ")
        .patternLine(" # ")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.COPPER_HOE.get())
        .patternLine("ii")
        .patternLine(" #")
        .patternLine(" #")
        .key('i', ModItems.COPPER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .build(consumer);

    // bronze
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BRONZE_SHOVEL.get())
        .patternLine("i")
        .patternLine("#")
        .patternLine("#")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BRONZE_AXE.get())
        .patternLine("ii")
        .patternLine("i#")
        .patternLine(" #")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BRONZE_PICKAXE.get())
        .patternLine("iii")
        .patternLine(" # ")
        .patternLine(" # ")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.BRONZE_HOE.get())
        .patternLine("ii")
        .patternLine(" #")
        .patternLine(" #")
        .key('i', ModItems.BRONZE_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .build(consumer);

    // silver
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SILVER_SHOVEL.get())
        .patternLine("i")
        .patternLine("#")
        .patternLine("#")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SILVER_AXE.get())
        .patternLine("ii")
        .patternLine("i#")
        .patternLine(" #")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SILVER_PICKAXE.get())
        .patternLine("iii")
        .patternLine(" # ")
        .patternLine(" # ")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SILVER_HOE.get())
        .patternLine("ii")
        .patternLine(" #")
        .patternLine(" #")
        .key('i', ModItems.SILVER_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .build(consumer);

    // steel
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.STEEL_SHOVEL.get())
        .patternLine("i")
        .patternLine("#")
        .patternLine("#")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.STEEL_AXE.get())
        .patternLine("ii")
        .patternLine("i#")
        .patternLine(" #")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.STEEL_PICKAXE.get())
        .patternLine("iii")
        .patternLine(" # ")
        .patternLine(" # ")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.STEEL_HOE.get())
        .patternLine("ii")
        .patternLine(" #")
        .patternLine(" #")
        .key('i', ModItems.STEEL_INGOT.get())
        .key('#', Tags.Items.RODS_WOODEN)
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .build(consumer);

    // mytherine
    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_SHOVEL.get())
        .patternLine("oco")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_SHOVEL)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_AXE.get())
        .patternLine("oco")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_AXE)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_PICKAXE.get())
        .patternLine("oco")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_PICKAXE)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.MYTHERINE_HOE.get())
        .patternLine("oco")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_HOE)
        .key('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .addCriterion("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .build(consumer);
  }
}
