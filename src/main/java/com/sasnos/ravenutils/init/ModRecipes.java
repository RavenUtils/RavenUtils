package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.recipes.alloy_furnace.AlloyFurnaceRecipeSerializer;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipeSerializer;
import com.sasnos.ravenutils.recipes.drying_rack.DryingRackRecipeSerializer;
import com.sasnos.ravenutils.recipes.hand_mill_recipe.HandMillRecipeSerializer;
import com.sasnos.ravenutils.recipes.in_world.RightClickInWorldRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {

  public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(
          ForgeRegistries.RECIPE_SERIALIZERS, RavenUtils.MOD_ID
  );

  public static final RegistryObject<AlloyFurnaceRecipeSerializer> ALLOY_FURNACE_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("alloy_recipe", AlloyFurnaceRecipeSerializer::new);
  public static final RegistryObject<HandMillRecipeSerializer> HAND_MILL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("mill_recipe", HandMillRecipeSerializer::new);
  public static final RegistryObject<BarrelRecipeSerializer> BARREL_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("barrel_recipe", BarrelRecipeSerializer::new);
  public static final RegistryObject<DryingRackRecipeSerializer> DRYING_RACK_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("dry_rack", DryingRackRecipeSerializer::new);
  public static final RegistryObject<RightClickInWorldRecipeSerializer> RIGHT_CLICK_IN_WORLD_RECIPE_SERIALIZER = RECIPE_SERIALIZER.register("right_click", RightClickInWorldRecipeSerializer::new);
}
