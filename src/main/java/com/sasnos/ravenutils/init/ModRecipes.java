package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.recipes.alloy_recipe.AlloyRecipeSerializer;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipeSerializer;
import com.sasnos.ravenutils.recipes.dry_rack.DryRackRecipeSerializer;
import com.sasnos.ravenutils.recipes.millrecipes.MillRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {

  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(
          ForgeRegistries.RECIPE_SERIALIZERS, RavenUtils.MOD_ID
  );

  public static final RegistryObject<AlloyRecipeSerializer> ALLOY_FURNACE_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("alloy_recipe", AlloyRecipeSerializer::new);
  public static final RegistryObject<MillRecipeSerializer> MILL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("mill_recipe", MillRecipeSerializer::new);
  public static final RegistryObject<BarrelRecipeSerializer> BARREL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("barrel_recipe", BarrelRecipeSerializer::new);
  public static final RegistryObject<DryRackRecipeSerializer> DRY_RACK_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("dry_rack", DryRackRecipeSerializer::new);

}
