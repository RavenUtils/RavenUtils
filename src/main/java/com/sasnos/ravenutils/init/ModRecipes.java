package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.recipes.alloy_recipe.AlloyRecipe;
import com.sasnos.ravenutils.recipes.alloy_recipe.AlloyRecipeSerializer;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipe;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipeSerializer;
import com.sasnos.ravenutils.recipes.dry_rack.DryRackRecipe;
import com.sasnos.ravenutils.recipes.dry_rack.DryRackRecipeSerializer;
import com.sasnos.ravenutils.recipes.millrecipes.MillRecipe;
import com.sasnos.ravenutils.recipes.millrecipes.MillRecipeSerializer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {

  public static final IRecipeType<AlloyRecipe> ALLOY_FURNACE_RECIPE_TYPE =  registerType(AlloyRecipe.ALLOY_FURNACE);
  public static final IRecipeType<MillRecipe> MILL_RECIPE_TYPE = registerType(MillRecipe.MILL);
  public static final IRecipeType<BarrelRecipe> BARREL_RECIPE_TYPE = registerType(BarrelRecipe.BARREL);
  public static final IRecipeType<DryRackRecipe> DRY_RACK_RECIPE = registerType(DryRackRecipe.DRYRACK);

  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(
      ForgeRegistries.RECIPE_SERIALIZERS, RavenUtils.MOD_ID
  );

  public static final RegistryObject<AlloyRecipeSerializer> ALLOY_FURNACE_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("alloy_recipe", AlloyRecipeSerializer::new);
  public static final RegistryObject<MillRecipeSerializer> MILL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("mill_recipe", MillRecipeSerializer::new);
  public static final RegistryObject<BarrelRecipeSerializer> BARREL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("barrel_recipe", BarrelRecipeSerializer::new);
  public static final RegistryObject<DryRackRecipeSerializer> DRY_RACK_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("dry_rack", DryRackRecipeSerializer::new);
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
