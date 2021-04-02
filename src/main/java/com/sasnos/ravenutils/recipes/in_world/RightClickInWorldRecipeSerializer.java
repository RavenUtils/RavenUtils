package com.sasnos.ravenutils.recipes.in_world;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sasnos.raven_api.utils.blockingridient.BlockIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class RightClickInWorldRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RightClickInWorldRecipe> {

    @Override
    public RightClickInWorldRecipe read(ResourceLocation recipeId, JsonObject json) {
        Ingredient input = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
        BlockIngredient blockInput = BlockIngredient.deserialize(JSONUtils.getJsonObject(json, "blockIngredient"));

        NonNullList<ItemStack> outputs = NonNullList.create();
        JsonArray array = JSONUtils.getJsonArray(json, "result");
        for (JsonElement element : array) {
            JsonObject jsonObject = (JsonObject) element;
            outputs.add(new ItemStack(JSONUtils.getItem(jsonObject, "item"),
                    JSONUtils.getInt(jsonObject, "count")));
        }
        return new RightClickInWorldRecipe(recipeId, input, blockInput, outputs);
    }

    @Nullable
    @Override
    public RightClickInWorldRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        Ingredient input = Ingredient.read(buffer);
        BlockIngredient blockInput = BlockIngredient.read(buffer);
        int size = buffer.readVarInt();
        NonNullList<ItemStack> output = NonNullList.create();
        for (int i = 0; i < size; i++) {
            output.add(buffer.readItemStack());
        }
        return new RightClickInWorldRecipe(recipeId, input, blockInput, output);
    }

    @Override
    public void write(PacketBuffer buffer, RightClickInWorldRecipe recipe) {
        recipe.getIngredients().get(0).write(buffer);
        recipe.getBlocks().write(buffer);
        buffer.writeVarInt(recipe.getOutput().size());
        for (ItemStack stack : recipe.getOutput()) {
            buffer.writeItemStack(stack);
        }
    }
}
