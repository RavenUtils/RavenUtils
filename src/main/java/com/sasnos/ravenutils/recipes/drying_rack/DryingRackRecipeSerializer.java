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
  public DryingRackRecipe read(ResourceLocation recipeId, JsonObject json) {
    ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "result"), true);
    Ingredient inputs = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
    int timer = JSONUtils.getInt(json, "timer");
    float xp = JSONUtils.getFloat(json, "xp", 0);
    return new DryingRackRecipe(recipeId, NonNullList.from(Ingredient.EMPTY, inputs), timer, NonNullList.from(ItemStack.EMPTY, output), xp);
  }

  @Override
  public void write(PacketBuffer buffer, DryingRackRecipe recipe) {
    buffer.writeItemStack(recipe.getOutput().get(0));
    recipe.getIngredients().get(0).write(buffer);
    buffer.writeInt(recipe.getTimer());
    buffer.writeFloat(recipe.getXp());
  }

  @Nullable
  @Override
  public DryingRackRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
    ItemStack output = buffer.readItemStack();
    Ingredient input = Ingredient.read(buffer);
    int timer = buffer.readInt();
    float xp = buffer.readFloat();
    return new DryingRackRecipe(recipeId, NonNullList.from(Ingredient.EMPTY, input), timer, NonNullList.from(ItemStack.EMPTY, output), xp);
  }
}
