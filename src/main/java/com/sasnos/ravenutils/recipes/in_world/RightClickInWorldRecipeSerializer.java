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
    public RightClickInWorldRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        Ingredient input = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "ingredient"));
        BlockIngredient blockInput = BlockIngredient.deserialize(JSONUtils.getAsJsonObject(json, "blockIngredient"));

        NonNullList<ItemStack> outputs = NonNullList.create();
        JsonArray array = JSONUtils.getAsJsonArray(json, "result");
        for (JsonElement element : array) {
            JsonObject jsonObject = (JsonObject) element;
            outputs.add(new ItemStack(JSONUtils.getAsItem(jsonObject, "item"),
                    JSONUtils.getAsInt(jsonObject, "count")));
        }
        return new RightClickInWorldRecipe(recipeId, input, blockInput, outputs);
    }

    @Nullable
    @Override
    public RightClickInWorldRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        Ingredient input = Ingredient.fromNetwork(buffer);
        BlockIngredient blockInput = BlockIngredient.read(buffer);
        int size = buffer.readVarInt();
        NonNullList<ItemStack> output = NonNullList.create();
        for (int i = 0; i < size; i++) {
            output.add(buffer.readItem());
        }
        return new RightClickInWorldRecipe(recipeId, input, blockInput, output);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, RightClickInWorldRecipe recipe) {
        recipe.getIngredients().get(0).toNetwork(buffer);
        recipe.getBlocks().toNetwork(buffer);
        buffer.writeVarInt(recipe.getOutput().size());
        for (ItemStack stack : recipe.getOutput()) {
            buffer.writeItem(stack);
        }
    }
}
