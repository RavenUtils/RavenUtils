package com.sasnos.ravenutils.recipes.alloy_furnace;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sasnos.raven_api.recipes.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class AlloyFurnaceRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<AlloyFurnaceRecipe> {

  protected AlloyFurnaceRecipe createRecipe(ResourceLocation id, NonNullList<Material> input, ItemStack output, int time,
                                            ItemStack additionalOutput, float change) {
    return new AlloyFurnaceRecipe(id, input, output, time, additionalOutput, change);
  }

  @Override
  public AlloyFurnaceRecipe fromJson(ResourceLocation recipeId, JsonObject json) {

    ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "result"), true);
    JsonArray inputs = JSONUtils.getAsJsonArray(json, "materials");
    NonNullList<Material> input = NonNullList.create();
    for (int i = 0; i < inputs.size(); i++) {
      input.add(Material.deserialize(inputs.get(i).getAsJsonObject()));
    }
    int time = JSONUtils.getAsInt(json, "cookingtime");
    ItemStack additionalOutput = ItemStack.EMPTY;
    float change = 0;
    if (json.has("additional")) {
      JsonObject additional = JSONUtils.getAsJsonObject(json, "additional");
      additionalOutput = CraftingHelper.getItemStack(additional, true);
      change = JSONUtils.getAsFloat(additional, "change");
    }
    return createRecipe(recipeId, input, output, time, additionalOutput, change);
  }

  @Nullable
  @Override
  public AlloyFurnaceRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {

    int numMaterials = buffer.readVarInt();
    NonNullList<Material> input = NonNullList.create();
    for (int i = 0; i < numMaterials; i++) {
      input.add(Material.read(buffer));
    }
    ItemStack output = buffer.readItem();
    int time = buffer.readVarInt();
    ItemStack additionalOutput = buffer.readItem();
    float change = buffer.readFloat();
    return createRecipe(recipeId, input, output, time, additionalOutput, change);
  }

  @Override
  public void toNetwork(PacketBuffer buffer, AlloyFurnaceRecipe recipe) {

    buffer.writeVarInt(recipe.getIngredients().size());
    for (Material input : recipe.getInput()) {
      input.write(buffer);
    }
    buffer.writeItem(recipe.getResultItem());
    buffer.writeVarInt(recipe.getTimer());
    buffer.writeItem(recipe.getAdditionalResult());
    buffer.writeFloat(recipe.getAdditionalChance());
  }
}
