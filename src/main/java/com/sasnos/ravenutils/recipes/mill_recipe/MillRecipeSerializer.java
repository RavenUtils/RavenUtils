package com.sasnos.ravenutils.recipes.mill_recipe;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class MillRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<MillRecipe> {

  @Override
  public MillRecipe read(ResourceLocation recipeId, JsonObject json) {
    ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "result"), true);
    Ingredient inputs = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
    int timer = JSONUtils.getInt(json, "timer");
    float additionalDropChance = JSONUtils.getFloat(json, "additionalDropChance");
    ItemStack additionalOutput = ItemStack.EMPTY;
    float change = 0;
    if (json.has("additional")) {
      JsonObject additional = JSONUtils.getJsonObject(json, "additional");
      additionalOutput = CraftingHelper.getItemStack(additional, true);
      change = JSONUtils.getFloat(additional, "change");
    }

    return new MillRecipe(recipeId, timer, inputs, additionalDropChance, output, additionalOutput, change);
  }

  @Override
  public void write(PacketBuffer buffer, MillRecipe recipe) {
    buffer.writeVarInt(recipe.getIngredients().size());
    recipe.getIngredients().get(0).write(buffer);
    buffer.writeItemStack(recipe.getRecipeOutput());
    buffer.writeFloat(recipe.getAdditionalDropChange());
    buffer.writeVarInt(recipe.getTimer());
    buffer.writeItemStack(recipe.getAdditionalResult());
    buffer.writeFloat(recipe.getAdditionalChance());
  }

  @Nullable
  @Override
  public MillRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
    Ingredient input = Ingredient.read(buffer);
    ItemStack output = buffer.readItemStack();
    float additionalDropChance = buffer.readFloat();
    int time = buffer.readVarInt();
    ItemStack additionalOutput = buffer.readItemStack();
    float change = buffer.readFloat();
    return new MillRecipe(recipeId, time, input, additionalDropChance, output, additionalOutput, change);
  }

}
