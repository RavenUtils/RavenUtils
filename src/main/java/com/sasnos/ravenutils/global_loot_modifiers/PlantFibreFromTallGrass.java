package com.sasnos.ravenutils.global_loot_modifiers;

import com.google.gson.JsonObject;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantFibreFromTallGrass extends LootModifier {

  private int count;

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  public PlantFibreFromTallGrass(ILootCondition[] conditionsIn, int count) {
    super(conditionsIn);
    this.count = count;
  }

  @NotNull
  @Override
  protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
    generatedLoot.add(new ItemStack(ModItems.PLANT_FIBRE.get(), count));
    return generatedLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<PlantFibreFromTallGrass> {

    @Override
    public PlantFibreFromTallGrass read(ResourceLocation location, JsonObject object, ILootCondition[] condition) {
      return new PlantFibreFromTallGrass(condition, JSONUtils.getInt(object, "count"));
    }

    @Override
    public JsonObject write(PlantFibreFromTallGrass instance) {
      JsonObject jsonObject = makeConditions(instance.conditions);
      jsonObject.addProperty("count", instance.count);
      return jsonObject;
    }

  }
}
