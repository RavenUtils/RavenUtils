package com.sasnos.ravenutils.global_loot_modifiers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdditionalDropsForBlocks extends LootModifier {

  private NonNullList<ItemStack> output;

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  public AdditionalDropsForBlocks(ILootCondition[] conditionsIn, NonNullList<ItemStack> outputs) {
    super(conditionsIn);
    this.output = outputs;
  }

  @NotNull
  @Override
  protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
    generatedLoot.addAll(output);
    return generatedLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<AdditionalDropsForBlocks> {

    @Override
    public AdditionalDropsForBlocks read(ResourceLocation location, JsonObject object, ILootCondition[] condition) {

      JsonArray array = JSONUtils.getAsJsonArray(object, "items");

      NonNullList<ItemStack> list = NonNullList.create();

      for (JsonElement json : array) {
        JsonObject jsonObject = (JsonObject) json;
        list.add(new ItemStack(JSONUtils.getAsItem(jsonObject, "item"), JSONUtils.getAsInt(jsonObject, "count")));
      }

      return new AdditionalDropsForBlocks(condition, list);
    }

    @Override
    public JsonObject write(AdditionalDropsForBlocks instance) {
      JsonObject jsonObject = makeConditions(instance.conditions);
      JsonArray array = new JsonArray();
      for (ItemStack stack : instance.output) {
        JsonObject jo = new JsonObject();
        jo.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
        jo.addProperty("count", stack.getCount());
        array.add(jo);
      }
      jsonObject.add("items", array);

      return jsonObject;
    }

  }
}
