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

public class BarrelRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<BarrelRecipe>{
    @Override
    public BarrelRecipe read(ResourceLocation recipeId, JsonObject json) {
        JsonArray outputs = JSONUtils.getJsonArray(json, "outputs");
        ItemStack itemOutput = ItemStack.EMPTY;
        Fluid fluidOutput = Fluids.EMPTY;
        for (JsonElement element : outputs){
            if(JSONUtils.hasField((JsonObject) element, "item")){
                itemOutput = new ItemStack(JSONUtils.getItem((JsonObject)element, "item"), JSONUtils.getInt((JsonObject)element, "count"));
            }

            if(JSONUtils.hasField((JsonObject) element, "fluid")){
                fluidOutput = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(JSONUtils.getString((JsonObject)element, "fluid")));
            }
        }

        FluidStack fluidInput = FluidStack.EMPTY;
        Ingredient itemInput = Ingredient.EMPTY;
        JsonArray inputs = JSONUtils.getJsonArray(json, "inputs");
        for (JsonElement element : inputs){
            if(JSONUtils.hasField((JsonObject) element, "fluid")){
                Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(JSONUtils.getString((JsonObject)element, "fluid")));
                fluidInput = new FluidStack(fluid, JSONUtils.getInt((JsonObject)element, "count"));
            }
            else {
                itemInput = Ingredient.deserialize(element);
            }
        }

        boolean lidClosed = JSONUtils.getBoolean(json, "litClosed");
        int timer = JSONUtils.getInt(json, "timer");

        return new BarrelRecipe(recipeId, itemInput, fluidInput, itemOutput, fluidOutput, lidClosed, timer);
    }

    @Nullable
    @Override
    public BarrelRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        return null;
    }

    @Override
    public void write(PacketBuffer buffer, BarrelRecipe recipe) {

    }
}
