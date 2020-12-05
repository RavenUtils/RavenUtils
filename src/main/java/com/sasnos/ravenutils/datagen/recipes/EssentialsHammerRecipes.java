package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.api.data_generation.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
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
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.*;

public class EssentialsHammerRecipes extends EssentialsRecipeProvider {
  public EssentialsHammerRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.FLINT_SHARD.get(), 2)
        .addIngredient(Items.FLINT)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer, "flint_shard_with_hammer");

    ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
        .addIngredient(Items.STONE)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer, "cobblestone_with_hammer");

    ShapelessRecipeBuilder.shapelessRecipe(Items.GRAVEL)
        .addIngredient(Items.COBBLESTONE)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.SAND)
        .addIngredient(Items.GRAVEL)
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.LIME.get(), 4)
        .addIngredient(ModBlockItems.LIMESTONE_BLOCK_ITEM.get())
        .addIngredient(hammers)
        .addCriterion("has_hammer", hasItemTag(hammers))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(Items.GLASS_PANE, 8)
        .patternLine(" ch")
        .patternLine(" # ")
        .key('c', chisels)
        .key('h', hammers)
        .key('#', Items.GLASS)
        .addCriterion("has_glass", hasItem(Items.GLASS))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_IRON.get())
        .patternLine("ih")
        .key('h', hammers)
        .key('i', Items.IRON_NUGGET)
        .addCriterion("has_iron_nugget", hasItem(Items.IRON_NUGGET))
        .setGroup("sewing_needles")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModToolItems.SEWING_NEEDLE_STEEL.get())
        .patternLine("ih")
        .key('h', hammers)
        .key('i', ModItems.STEEL_NUGGET.get())
        .addCriterion("has_steel_nugget", hasItem(ModItems.STEEL_NUGGET.get()))
        .setGroup("sewing_needles")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.METAL_ROD_IRON.get())
        .patternLine("th")
        .patternLine("i ")
        .key('t', tongs)
        .key('h', hammers)
        .key('i', Items.IRON_INGOT)
        .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .setGroup("metal_rods")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModItems.METAL_ROD_STEEL.get())
        .patternLine("th")
        .patternLine("i ")
        .key('t', tongs)
        .key('h', hammers)
        .key('i', ModItems.STEEL_INGOT.get())
        .addCriterion("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .setGroup("metal_rods")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(HandMillInit.MILLSTONE_ITEM.get(), 1)
        .addIngredient(Items.STONE_SLAB)
        .addIngredient(Tags.Items.RODS_WOODEN)
        .addIngredient(hammers)
        .addIngredient(chisels)
        .addCriterion("has_stone_slab", hasItem(Items.STONE_SLAB))
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(HandMillInit.HAND_MILL_ITEM.get())
        .patternLine("hSc")
        .patternLine("s s")
        .patternLine("sss")
        .key('h', hammers)
        .key('c', chisels)
        .key('s', Items.COBBLESTONE)
        .key('S', Tags.Items.RODS_WOODEN)
        .addCriterion("has_cobblestone", hasItem(Items.COBBLESTONE))
        .build(consumer);

  }
}
