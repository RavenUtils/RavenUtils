package com.sasnos.ravenutils.recipies.alloyrecipie;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sasnos.ravenutils.api.recipes.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class AlloyRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<AlloyRecipe>{

    protected AlloyRecipe createRecipe(ResourceLocation id, NonNullList<Material> input, ItemStack output, int time){
        return new AlloyRecipe(id, input, output, time);
    }

    @Override
    public AlloyRecipe read(ResourceLocation recipeId, JsonObject json) {

        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "result"), true);
        JsonArray inputs = JSONUtils.getJsonArray(json, "ingredient");
        NonNullList<Material> input = NonNullList.create();
        for(int i = 0; i < inputs.size(); i++){
            input.add(Material.deserialize(inputs.get(i).getAsJsonObject()));
        }
        int time = JSONUtils.getInt(json, "cookingtime");
        return createRecipe(recipeId, input, output, time);
    }

    @Nullable
    @Override
    public AlloyRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

        int numMaterials = buffer.readVarInt();
        NonNullList<Material> input = NonNullList.create();
        for(int i=0; i< numMaterials; i++){
            input.add(Material.read(buffer));
        }
        ItemStack output = buffer.readItemStack();
        int time = buffer.readVarInt();
        return createRecipe(recipeId, input, output, time);
    }

    @Override
    public void write(PacketBuffer buffer, AlloyRecipe recipe) {

        buffer.writeVarInt(recipe.getIngredients().size());
        for(Material input : recipe.getInput()){
            input.write(buffer);
        }
        buffer.writeItemStack(recipe.getRecipeOutput());
        buffer.writeVarInt(recipe.getTimer());
    }
}
