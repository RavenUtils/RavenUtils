package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.raven_api.datagen.recipes.EssentialsRecipeProvider;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItem;
import static com.sasnos.ravenutils.datagen.recipes.EssentialsRecipe.hasItemTag;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.chisels;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.hammers;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.rods_wood;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.tongs;

public class EssentialsHammerRecipes extends EssentialsRecipeProvider {
  public EssentialsHammerRecipes(Consumer<IFinishedRecipe> consumer) {
    super(consumer);
  }

  @Override
  public void init() {

    ShapelessRecipeBuilder.shapeless(ModItems.FLINT_SHARD.get(), 2)
        .requires(Items.FLINT)
        .requires(hammers)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .save(consumer, "flint_shard_with_hammer");

    ShapelessRecipeBuilder.shapeless(Items.COBBLESTONE)
        .requires(Items.STONE)
        .requires(hammers)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .save(consumer, "cobblestone_with_hammer");

    ShapelessRecipeBuilder.shapeless(Items.GRAVEL)
        .requires(Items.COBBLESTONE)
        .requires(hammers)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(Items.SAND)
        .requires(Items.GRAVEL)
        .requires(hammers)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(ModItems.LIME.get(), 4)
        .requires(ModBlockItems.LIMESTONE_BLOCK_ITEM.get())
        .requires(hammers)
        .unlockedBy("has_hammer", hasItemTag(hammers))
        .save(consumer);

    ShapedRecipeBuilder.shaped(Items.GLASS_PANE, 8)
        .pattern(" ch")
        .pattern(" # ")
        .define('c', chisels)
        .define('h', hammers)
        .define('#', Items.GLASS)
        .unlockedBy("has_glass", hasItem(Items.GLASS))
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SEWING_NEEDLE_IRON.get())
        .pattern("ih")
        .define('h', hammers)
        .define('i', Items.IRON_NUGGET)
        .unlockedBy("has_iron_nugget", hasItem(Items.IRON_NUGGET))
        .group("sewing_needles")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModToolItems.SEWING_NEEDLE_STEEL.get())
        .pattern("ih")
        .define('h', hammers)
        .define('i', ModItems.STEEL_NUGGET.get())
        .unlockedBy("has_steel_nugget", hasItem(ModItems.STEEL_NUGGET.get()))
        .group("sewing_needles")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.METAL_ROD_IRON.get())
        .pattern("th")
        .pattern("i ")
        .define('t', tongs)
        .define('h', hammers)
        .define('i', Items.IRON_INGOT)
        .unlockedBy("has_iron_ingot", hasItem(Items.IRON_INGOT))
        .group("metal_rods")
        .save(consumer);

    ShapedRecipeBuilder.shaped(ModItems.METAL_ROD_STEEL.get())
        .pattern("th")
        .pattern("i ")
        .define('t', tongs)
        .define('h', hammers)
        .define('i', ModItems.STEEL_INGOT.get())
        .unlockedBy("has_steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
        .group("metal_rods")
        .save(consumer);

    ShapelessRecipeBuilder.shapeless(HandMillInit.MILLSTONE_ITEM.get(), 1)
        .requires(Items.STONE_SLAB)
        .requires(rods_wood)
        .requires(hammers)
        .requires(chisels)
        .unlockedBy("has_stone_slab", hasItem(Items.STONE_SLAB))
        .save(consumer);

    ShapedRecipeBuilder.shaped(HandMillInit.HAND_MILL_ITEM.get())
        .pattern("hSc")
        .pattern("s s")
        .pattern("sss")
        .define('h', hammers)
        .define('c', chisels)
        .define('s', Items.COBBLESTONE)
        .define('S', rods_wood)
        .unlockedBy("has_cobblestone", hasItem(Items.COBBLESTONE))
        .save(consumer);

  }
}
