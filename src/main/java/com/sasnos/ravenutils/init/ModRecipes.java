package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.recipes.alloyrecipie.AlloyRecipe;
import com.sasnos.ravenutils.recipes.alloyrecipie.AlloyRecipeSerializer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {

    public static final IRecipeType<AlloyRecipe> ALLOY_RECIPE_RECIPE_TYPE = registerType(AlloyRecipe.ALLOY_FURNACE);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(
            ForgeRegistries.RECIPE_SERIALIZERS, RavenUtils.MOD_ID
    );

    public static final RegistryObject<AlloyRecipeSerializer> ALLOY_RECIPE = RECIPE_SERIALIZER.register("alloy_recipe", AlloyRecipeSerializer::new);

    @SuppressWarnings("unchecked")
    private static <T extends IRecipeType<?>> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RegisterType<>());
    }

    private static class RegisterType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

}
