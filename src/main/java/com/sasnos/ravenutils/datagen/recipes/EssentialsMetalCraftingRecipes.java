package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;

public class EssentialsMetalCraftingRecipes extends EssentialsRecipeProvider {
  public EssentialsMetalCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {
    // nuggets to ingot
    ShapedRecipeBuilder.shaped(ModItems.COPPER_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.COPPER_NUGGET.get())
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.TIN_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.TIN_NUGGET.get())
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.ZINC_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.ZINC_NUGGET.get())
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.SILVER_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.SILVER_NUGGET.get())
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.LEAD_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.LEAD_NUGGET.get())
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.BRONZE_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.BRONZE_NUGGET.get())
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer, "bronze_ingot_from_nuggets");

    ShapedRecipeBuilder.shaped(ModItems.BRASS_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.BRASS_NUGGET.get())
        .unlockedBy("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.STEEL_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.STEEL_NUGGET.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.MYTHERINE_INGOT.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.MYTHERINE_NUGGET.get())
        .unlockedBy("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .save(consumer);

    // ingot to nuggets
    ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET.get(), 9)
        .requires(ModItems.COPPER_INGOT.get())
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer, "copper_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.TIN_NUGGET.get(), 9)
        .requires(ModItems.TIN_INGOT.get())
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer, "tin_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.ZINC_NUGGET.get(), 9)
        .requires(ModItems.ZINC_INGOT.get())
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.SILVER_NUGGET.get(), 9)
        .requires(ModItems.SILVER_INGOT.get())
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer, "silver_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.LEAD_NUGGET.get(), 9)
        .requires(ModItems.LEAD_INGOT.get())
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer, "lead_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.BRONZE_NUGGET.get(), 9)
        .requires(ModItems.BRONZE_INGOT.get())
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer, "bronze_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.BRASS_NUGGET.get(), 9)
        .requires(ModItems.BRASS_INGOT.get())
        .unlockedBy("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .save(consumer, "brass_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.STEEL_NUGGET.get(), 9)
        .requires(ModItems.STEEL_INGOT.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer, "steel_nuggets_from_ingot");

    ShapelessRecipeBuilder.shapeless(ModItems.MYTHERINE_NUGGET.get(), 9)
        .requires(ModItems.MYTHERINE_INGOT.get())
        .unlockedBy("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .save(consumer, "mytherine_nuggets_from_ingot");

    // ingots to block
    ShapedRecipeBuilder.shaped(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.COPPER_INGOT.get())
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.TIN_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.TIN_INGOT.get())
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.ZINC_INGOT.get())
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.SILVER_INGOT.get())
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.LEAD_INGOT.get())
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.BRONZE_INGOT.get())
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.BRASS_INGOT.get())
        .unlockedBy("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.STEEL_INGOT.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .pattern("xxx")
        .pattern("xxx")
        .pattern("xxx")
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .unlockedBy("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .save(consumer);

    // block to ingots
    ShapelessRecipeBuilder.shapeless(ModItems.COPPER_INGOT.get(), 9)
        .requires(ModBlockItems.COPPER_BLOCK_ITEM.get())
        .unlockedBy("has_copper_ore", hasItem(ModBlockItems.COPPER_ORE_ITEM.get()))
        .save(consumer, "copper_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.TIN_INGOT.get(), 9)
        .requires(ModBlockItems.TIN_BLOCK_ITEM.get())
        .unlockedBy("has_tin_ore", hasItem(ModBlockItems.TIN_ORE_ITEM.get()))
        .save(consumer, "tin_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.ZINC_INGOT.get(), 9)
        .requires(ModBlockItems.ZINC_BLOCK_ITEM.get())
        .unlockedBy("has_zinc_ore", hasItem(ModBlockItems.ZINC_ORE_ITEM.get()))
        .save(consumer, "zinc_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(), 9)
        .requires(ModBlockItems.SILVER_BLOCK_ITEM.get())
        .unlockedBy("has_silver_ore", hasItem(ModBlockItems.SILVER_ORE_ITEM.get()))
        .save(consumer, "silver_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.LEAD_INGOT.get(), 9)
        .requires(ModBlockItems.LEAD_BLOCK_ITEM.get())
        .unlockedBy("has_lead_ore", hasItem(ModBlockItems.LEAD_ORE_ITEM.get()))
        .save(consumer, "lead_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.BRONZE_INGOT.get(), 9)
        .requires(ModBlockItems.BRONZE_BLOCK_ITEM.get())
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer, "bronze_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.BRASS_INGOT.get(), 9)
        .requires(ModBlockItems.BRASS_BLOCK_ITEM.get())
        .unlockedBy("has_brass_ingot", hasItem(ModItems.BRASS_INGOT.get()))
        .save(consumer, "brass_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.STEEL_INGOT.get(), 9)
        .requires(ModBlockItems.STEEL_BLOCK_ITEM.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer, "steel_ingots_from_block");

    ShapelessRecipeBuilder.shapeless(ModItems.MYTHERINE_INGOT.get(), 9)
        .requires(ModBlockItems.MYTHERINE_BLOCK_ITEM.get())
        .unlockedBy("has_mytherine_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .save(consumer, "mytherine_ingots_from_block");

    // custom tools
    // copper
    ShapedRecipeBuilder.shaped(ModToolItems.COPPER_SHOVEL.get())
        .pattern("i")
        .pattern("#")
        .pattern("#")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.COPPER_AXE.get())
        .pattern("ii")
        .pattern("i#")
        .pattern(" #")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.COPPER_PICKAXE.get())
        .pattern("iii")
        .pattern(" # ")
        .pattern(" # ")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.COPPER_HOE.get())
        .pattern("ii")
        .pattern(" #")
        .pattern(" #")
        .define('i', ModItems.COPPER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_copper_ingot", hasItem(ModItems.COPPER_INGOT.get()))
        .save(consumer);

    // bronze
    ShapedRecipeBuilder.shaped(ModToolItems.BRONZE_SHOVEL.get())
        .pattern("i")
        .pattern("#")
        .pattern("#")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BRONZE_AXE.get())
        .pattern("ii")
        .pattern("i#")
        .pattern(" #")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BRONZE_PICKAXE.get())
        .pattern("iii")
        .pattern(" # ")
        .pattern(" # ")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.BRONZE_HOE.get())
        .pattern("ii")
        .pattern(" #")
        .pattern(" #")
        .define('i', ModItems.BRONZE_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_bronze_ingot", hasItem(ModItems.BRONZE_INGOT.get()))
        .save(consumer);

    // silver
    ShapedRecipeBuilder.shaped(ModToolItems.SILVER_SHOVEL.get())
        .pattern("i")
        .pattern("#")
        .pattern("#")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SILVER_AXE.get())
        .pattern("ii")
        .pattern("i#")
        .pattern(" #")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SILVER_PICKAXE.get())
        .pattern("iii")
        .pattern(" # ")
        .pattern(" # ")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SILVER_HOE.get())
        .pattern("ii")
        .pattern(" #")
        .pattern(" #")
        .define('i', ModItems.SILVER_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_silver_ingot", hasItem(ModItems.SILVER_INGOT.get()))
        .save(consumer);

    // steel
    ShapedRecipeBuilder.shaped(ModToolItems.STEEL_SHOVEL.get())
        .pattern("i")
        .pattern("#")
        .pattern("#")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.STEEL_AXE.get())
        .pattern("ii")
        .pattern("i#")
        .pattern(" #")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.STEEL_PICKAXE.get())
        .pattern("iii")
        .pattern(" # ")
        .pattern(" # ")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.STEEL_HOE.get())
        .pattern("ii")
        .pattern(" #")
        .pattern(" #")
        .define('i', ModItems.STEEL_INGOT.get())
        .define('#', rods_wood)
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .save(consumer);

    // mytherine
    ShapedRecipeBuilder.shaped(ModToolItems.MYTHERINE_SHOVEL.get())
        .pattern("oco")
        .pattern("xtx")
        .pattern("oxo")
        .define('o', Items.OBSIDIAN)
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('t', Items.NETHERITE_SHOVEL)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .unlockedBy("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.MYTHERINE_AXE.get())
        .pattern("oco")
        .pattern("xtx")
        .pattern("oxo")
        .define('o', Items.OBSIDIAN)
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('t', Items.NETHERITE_AXE)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .unlockedBy("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.MYTHERINE_PICKAXE.get())
        .pattern("oco")
        .pattern("xtx")
        .pattern("oxo")
        .define('o', Items.OBSIDIAN)
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('t', Items.NETHERITE_PICKAXE)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .unlockedBy("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.MYTHERINE_HOE.get())
        .pattern("oco")
        .pattern("xtx")
        .pattern("oxo")
        .define('o', Items.OBSIDIAN)
        .define('x', ModItems.MYTHERINE_INGOT.get())
        .define('t', Items.NETHERITE_HOE)
        .define('c', ModBlockItems.CRIMLEAF_ITEM.get())
        .unlockedBy("has_mytherine_ingot", hasItem(ModItems.MYTHERINE_INGOT.get()))
        .save(consumer);
  }
}
