package com.sasnos.ravenutils.recipes.hand_mill_recipe;

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

public class HandMillRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<HandMillRecipe> {

  @Override
  public HandMillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
    ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "result"), true);
    Ingredient inputs = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "ingredient"));
    int timer = JSONUtils.getAsInt(json, "timer");
    float additionalDropChance = JSONUtils.getAsFloat(json, "additionalDropChance");
    ItemStack additionalOutput = ItemStack.EMPTY;
    float change = 0;
    if (json.has("additional")) {
      JsonObject additional = JSONUtils.getAsJsonObject(json, "additional");
      additionalOutput = CraftingHelper.getItemStack(additional, true);
      change = JSONUtils.getAsFloat(additional, "change");
    }

    return new HandMillRecipe(recipeId, timer, inputs, additionalDropChance, output, additionalOutput, change);
  }

  @Override
  public void toNetwork(PacketBuffer buffer, HandMillRecipe recipe) {
    buffer.writeVarInt(recipe.getIngredients().size());
    recipe.getIngredients().get(0).toNetwork(buffer);
    buffer.writeItem(recipe.getResultItem());
    buffer.writeFloat(recipe.getAdditionalDropChange());
    buffer.writeVarInt(recipe.getTimer());
    buffer.writeItem(recipe.getAdditionalResult());
    buffer.writeFloat(recipe.getAdditionalChance());
  }

  @Nullable
  @Override
  public HandMillRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
    Ingredient input = Ingredient.fromNetwork(buffer);
    ItemStack output = buffer.readItem();
    float additionalDropChance = buffer.readFloat();
    int time = buffer.readVarInt();
    ItemStack additionalOutput = buffer.readItem();
    float change = buffer.readFloat();
    return new HandMillRecipe(recipeId, time, input, additionalDropChance, output, additionalOutput, change);
  }

}
