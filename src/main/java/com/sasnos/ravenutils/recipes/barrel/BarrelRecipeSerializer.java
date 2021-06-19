package com.sasnos.ravenutils.recipes.barrel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class BarrelRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<BarrelRecipe> {
  @Override
  public BarrelRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
    JsonArray outputs = JSONUtils.getAsJsonArray(json, "outputs");
    ItemStack itemOutput = ItemStack.EMPTY;
    Fluid fluidOutput = Fluids.EMPTY;
    for (JsonElement element : outputs) {
      if (JSONUtils.isValidNode((JsonObject) element, "item")) {
        itemOutput = new ItemStack(JSONUtils.getAsItem((JsonObject) element, "item"), JSONUtils.getAsInt((JsonObject) element, "count"));
      }

      if (JSONUtils.isValidNode((JsonObject) element, "fluid")) {
        fluidOutput = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(JSONUtils.getAsString((JsonObject) element, "fluid")));
      }
    }

    FluidStack fluidInput = FluidStack.EMPTY;
    Ingredient itemInput = Ingredient.EMPTY;
    JsonArray inputs = JSONUtils.getAsJsonArray(json, "inputs");
    for (JsonElement element : inputs) {
      if (JSONUtils.isValidNode((JsonObject) element, "fluid")) {
        Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(JSONUtils.getAsString((JsonObject) element, "fluid")));
        fluidInput = new FluidStack(fluid, JSONUtils.getAsInt((JsonObject) element, "count"));
      } else {
        itemInput = Ingredient.fromJson(element);
      }
    }

    boolean lidClosed = JSONUtils.getAsBoolean(json, "litClosed");
    int timer = JSONUtils.getAsInt(json, "timer");

    return new BarrelRecipe(recipeId, itemInput, fluidInput, itemOutput, fluidOutput, lidClosed, timer);
  }

    @Nullable
    @Override
    public BarrelRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItem();
        Fluid outputFluid = buffer.readFluidStack().getFluid();
        Ingredient input = Ingredient.fromNetwork(buffer);
        FluidStack inputFluid = buffer.readFluidStack();
        boolean lid = buffer.readBoolean();
        int timer = buffer.readVarInt();
        return new BarrelRecipe(recipeId, input, inputFluid, output, outputFluid, lid, timer);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, BarrelRecipe recipe) {
        buffer.writeItem(recipe.getOutput().get(0));
        buffer.writeFluidStack(new FluidStack(recipe.getFluidOutput(), 2));
        recipe.getIngredients().get(0).toNetwork(buffer);
        buffer.writeFluidStack(recipe.getFluidInput());
        buffer.writeBoolean(recipe.isLidClosed());
        buffer.writeVarInt(recipe.getTimer());
    }
}
