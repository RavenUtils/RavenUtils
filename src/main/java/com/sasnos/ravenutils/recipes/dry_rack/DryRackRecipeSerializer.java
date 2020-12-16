package com.sasnos.ravenutils.recipes.dry_rack;

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

public class DryRackRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<DryRackRecipe>{
    @Override
    public DryRackRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "result"), true);
        Ingredient inputs = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
        int timer = JSONUtils.getInt(json, "timer");
        return new DryRackRecipe(recipeId, NonNullList.from(Ingredient.EMPTY, inputs), timer, NonNullList.from(ItemStack.EMPTY, output));
    }

    @Override
    public void write(PacketBuffer buffer, DryRackRecipe recipe) {
        buffer.writeItemStack(recipe.getOutput().get(0));
        recipe.getIngredients().get(0).write(buffer);
        buffer.writeInt(recipe.getTimer());
    }

    @Nullable
    @Override
    public DryRackRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        Ingredient input = Ingredient.read(buffer);
        int timer = buffer.readInt();
        return new DryRackRecipe(recipeId, NonNullList.from(Ingredient.EMPTY, input), timer, NonNullList.from(ItemStack.EMPTY, output));
    }


}
