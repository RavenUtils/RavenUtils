package com.sasnos.ravenutils.datagen.recipes;

import com.sasnos.ravenutils.datagen.tags.EssentialsItemTags;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;

import java.util.function.Consumer;

public class EssentialsRecipe extends RecipeProvider {

  public EssentialsRecipe(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

    new EssentialsCraftingRecipes(consumer);
    new EssentialsCookingRecipes(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.SALT.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .setGroup("grinding")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModFoodItems.WHEAT_FLOUR.get(), 2)
        .addIngredient(Items.WHEAT)
        .addIngredient(ModToolItems.MORTAR_AND_PESTLE.get())
        .addCriterion("has_mortar_and_pestle", hasItem(ModToolItems.MORTAR_AND_PESTLE.get()))
        .setGroup("grinding")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModFoodItems.DOUGH.get())
        .addIngredient(ModFoodItems.WHEAT_FLOUR.get())
        .addIngredient(ModFoodItems.WHEAT_FLOUR.get())
        .addIngredient(ModItems.SALT.get())
        .addIngredient(Items.WATER_BUCKET)
        .addCriterion("has_wheat_flour", hasItem(ModFoodItems.WHEAT_FLOUR.get()))
        .setGroup("cooking")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(ModItems.HIDE_CURED.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModItems.COARSE_SALT.get())
        .addIngredient(ModItems.HIDE_FRESH.get())
        .addCriterion("has_hide_fresh", hasItem(ModItems.HIDE_FRESH.get()))
        .setGroup("hide_processing")
        .build(consumer);

    ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
        .addIngredient(Items.STONE)
        .addIngredient(EssentialsItemTags.hammers)
        .addCriterion("has_hammer", hasItem(EssentialsItemTags.hammers))
        .setGroup("hammers")
        .build(consumer);

    ShapedRecipeBuilder.shapedRecipe(ModArmorItems.MYTHERINE_CHESTPLATE.get()) //TODO: change Item for now it is a test
        .patternLine("oxo")
        .patternLine("xtx")
        .patternLine("oxo")
        .key('o', Items.OBSIDIAN)
        .key('x', ModItems.MYTHERINE_INGOT.get())
        .key('t', Items.NETHERITE_CHESTPLATE)
        .addCriterion("has_netherite_chestplate", hasItem(Items.NETHERITE_CHESTPLATE))
        .build(consumer);

    CookingRecipeBuilder.smeltingRecipe(
        Ingredient.fromItems(Items.LADDER),
        ModItems.ASH.get(),
        0.1f,
        60)
        .addCriterion("has_ladder", hasItem(Items.LADDER))
        .build(consumer);

    CookingRecipeBuilder.blastingRecipe(
        Ingredient.fromItems(ModBlockItems.MYTHERINE_ORE_ITEM.get()),
        ModItems.MYTHERINE_NUGGET.get(),
        0.1f,
        800)
        .addCriterion("has_raven_ore", hasItem(ModBlockItems.MYTHERINE_ORE_ITEM.get()))
        .build(consumer);

    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        600,
        IRecipeSerializer.CAMPFIRE_COOKING)
        .addCriterion("has_bushmeat", hasItem(ModFoodItems.BUSHMEAT.get()))
        .build(consumer);

    CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModFoodItems.BUSHMEAT.get()),
        ModFoodItems.COOKED_BUSHMEAT.get(),
        0.35f,
        100,
        IRecipeSerializer.SMOKING);


  }

  //expose the protected internal methods so i can use tem in external classes
  public static ICriterionInstance externalHasItem(Item item) {
    return hasItem(item);
  }

  public static ICriterionInstance externalHasItem(ITag<Item> tagItem) {
    return hasItem(tagItem);
  }
}
