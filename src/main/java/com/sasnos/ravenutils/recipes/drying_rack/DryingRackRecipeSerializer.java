package com.sasnos.ravenutils.recipes.drying_rack;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class DryingRackRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<DryingRackRecipe> {
  @Override
  public DryingRackRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
    ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "result"), true);
    Ingredient inputs = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "ingredient"));
    int timer = JSONUtils.getAsInt(json, "timer");
    float xp = JSONUtils.getAsFloat(json, "xp", 0);
    return new DryingRackRecipe(recipeId, NonNullList.of(Ingredient.EMPTY, inputs), timer, NonNullList.of(ItemStack.EMPTY, output), xp);
  }

  @Override
  public void toNetwork(PacketBuffer buffer, DryingRackRecipe recipe) {
    buffer.writeItem(recipe.getOutput().get(0));
    recipe.getIngredients().get(0).toNetwork(buffer);
    buffer.writeInt(recipe.getTimer());
    buffer.writeFloat(recipe.getXp());
  }

  @Nullable
  @Override
  public DryingRackRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
    ItemStack output = buffer.readItem();
    Ingredient input = Ingredient.fromNetwork(buffer);
    int timer = buffer.readInt();
    float xp = buffer.readFloat();
    return new DryingRackRecipe(recipeId, NonNullList.of(Ingredient.EMPTY, input), timer, NonNullList.of(ItemStack.EMPTY, output), xp);
  }
}
