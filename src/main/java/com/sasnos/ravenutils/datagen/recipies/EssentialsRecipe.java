package com.sasnos.ravenutils.datagen.recipies;

import com.sasnos.ravenutils.datagen.tags.EssentialItemTags;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class EssentialsRecipe extends RecipeProvider {

    public EssentialsRecipe(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(Items.COBBLESTONE)
                .addIngredient(Items.STONE)
                .addIngredient(EssentialItemTags.hammer)
                .addCriterion("has_hammer", hasItem(EssentialItemTags.hammer))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModArmorItems.RAVENINE_CHESTPLATE.get()) //TODO: change Item for now it is a test
                .patternLine("oxo")
                .patternLine("xtx")
                .patternLine("oxo")
                .key('o', Items.OBSIDIAN)
                .key('x', ModItems.RAVENINE_INGOT.get())
                .key('t', Items.NETHERITE_CHESTPLATE)
                .addCriterion("has_netherite_chestplate", hasItem(Items.NETHERITE_CHESTPLATE))
                .build(consumer);

        CookingRecipeBuilder.smeltingRecipe(
                Ingredient.fromItems(Items.LADDER),
                ModItems.ASHES.get(),
                0.1f,
                60)
                .addCriterion("has_ladder", hasItem(Items.LADDER))
                .build(consumer);

        CookingRecipeBuilder.blastingRecipe(
                Ingredient.fromItems(ModBlockItems.RAVENINE_ORE_ITEM.get()),
                ModItems.RAVENINE_NUGGET.get(),
                0.1f,
                800)
                .addCriterion("has_raven_ore", hasItem(ModBlockItems.RAVENINE_ORE_ITEM.get()))
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
}
