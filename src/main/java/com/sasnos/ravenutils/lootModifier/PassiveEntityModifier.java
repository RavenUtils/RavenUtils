package com.sasnos.ravenutils.lootModifier;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class PassiveEntityModifier extends LootModifier {

  public int minHide;
  public int maxHide;
  public Item meat;
  public int minMeat;
  public int maxMeat;
  public int minTallow;
  public int maxTallow;
  public int minBone;
  public int maxBone;
  public NonNullList<AdditionalItems> additional;

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  public PassiveEntityModifier(
      ILootCondition[] conditionsIn,
      int minHideIn, int maxHideIn,
      Item meatIn, int minMeatIn, int maxMeatIn,
      int minTallowIn, int maxTallowIn,
      int minBoneIn, int maxBoneIn,
      NonNullList<AdditionalItems> additionalIN) {
    super(conditionsIn);
    this.minHide = minHideIn;
    this.maxHide = maxHideIn;
    this.meat = meatIn;
    this.minMeat = minMeatIn;
    this.maxMeat = maxMeatIn;
    this.minTallow = minTallowIn;
    this.maxTallow = maxTallowIn;
    this.minBone = minBoneIn;
    this.maxBone = maxBoneIn;
    this.additional = additionalIN;
  }

  @Override
  protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

    int looting = context.getLootingModifier();

    if (maxHide > 0) {
      int sum = context.getRandom().ints(minHide, maxHide).findFirst().getAsInt() + looting;
      generatedLoot.add(new ItemStack(ModItems.FRESH_HIDE.get(), sum));
    }

    if (meat != null) {
      int sum = context.getRandom().ints(minMeat, maxMeat).findFirst().getAsInt() + looting;
      generatedLoot.add(new ItemStack(meat, sum));
    }

    if (maxTallow > 0) {
      int sum = context.getRandom().ints(minTallow, maxTallow).findFirst().getAsInt() + looting;
      generatedLoot.add(new ItemStack(ModItems.TALLOW.get(), sum));
    }

    if (maxBone > 0) {
      int sum = context.getRandom().ints(minBone, maxBone).findFirst().getAsInt() + looting;
      generatedLoot.add(new ItemStack(Items.BONE, sum));
    }

    for (AdditionalItems add : additional) {
      int rand = context.getRandom().nextInt(100);
      if (rand <= add.change) {
        int sum = context.getRandom().ints(add.minItem, add.maxItem).findFirst().getAsInt();
        if (add.useLootEnchant) sum += looting;
        generatedLoot.add(new ItemStack(add.item, sum));
      }
    }

    return generatedLoot;
  }

  public static class Serializer extends GlobalLootModifierSerializer<PassiveEntityModifier> {

    @Override
    public PassiveEntityModifier read(ResourceLocation location, JsonObject json, ILootCondition[] ailootcondition) {
      int minHide = JSONUtils.getInt(json, "minHide");
      int maxHide = JSONUtils.getInt(json, "maxHide");
      int minTallow = JSONUtils.getInt(json, "minTallow");
      int maxTallow = JSONUtils.getInt(json, "maxTallow");
      int minMeat = JSONUtils.getInt(json, "minMeat");
      int maxMeat = JSONUtils.getInt(json, "maxMeat");
      Item meat = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(json, "meat")));
      int minBone = JSONUtils.getInt(json, "minBone");
      int maxBone = JSONUtils.getInt(json, "maxBone");
      JsonArray additionalJson = JSONUtils.getJsonArray(json, "additional");
      NonNullList<AdditionalItems> additional = NonNullList.create();

      for (int i = 0; i < additionalJson.size() - 1; i++) {
        JsonObject itemStack = additionalJson.get(i).getAsJsonObject();
        additional.add(
            new AdditionalItems(
                ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(
                        JSONUtils.getString(itemStack, "item"))),
                JSONUtils.getInt(itemStack, "minItem"),
                JSONUtils.getInt(itemStack, "maxItem"),
                JSONUtils.getInt(itemStack, "change"),
                JSONUtils.getBoolean(itemStack, "useLooting")
            )
        );
      }

      return new PassiveEntityModifier(ailootcondition, minHide, maxHide, meat, minMeat, maxMeat, minTallow, maxTallow, minBone, maxBone, additional);
    }

    @Override
    public JsonObject write(PassiveEntityModifier instance) {
      JsonObject json = makeConditions(instance.conditions);
      json.addProperty("minHide", instance.minHide);
      json.addProperty("maxHide", instance.maxHide);
      json.addProperty("minTallow", instance.minTallow);
      json.addProperty("maxTallow", instance.maxTallow);
      json.addProperty("minMeat", instance.minMeat);
      json.addProperty("maxMeat", instance.maxMeat);
      json.addProperty("meat", ForgeRegistries.ITEMS.getKey(instance.meat.getItem()).toString());
      json.addProperty("minBone", instance.minBone);
      json.addProperty("maxBone", instance.maxBone);
      JsonArray additional = new JsonArray();

      for (AdditionalItems additionalItem : instance.additional) {
        JsonObject itemstack = new JsonObject();
        itemstack.addProperty("item", ForgeRegistries.ITEMS.getKey(additionalItem.item).toString());
        itemstack.addProperty("minItem", additionalItem.minItem);
        itemstack.addProperty("maxItem", additionalItem.maxItem);
        itemstack.addProperty("change", additionalItem.change);
        itemstack.addProperty("useLooting", additionalItem.useLootEnchant);
        additional.add(itemstack);
      }
      json.add("additional", additional);

      return json;
    }

  }

  public static class AdditionalItems {
    public Item item;
    public int minItem;
    public int maxItem;
    public int change;
    public boolean useLootEnchant;

    public AdditionalItems(Item itemIN, int minItemIn, int maxItemIn, int changeIn, boolean useLootEnchantIn) {
      this.item = itemIN;
      this.minItem = minItemIn;
      this.maxItem = maxItemIn;
      this.change = changeIn;
      this.useLootEnchant = useLootEnchantIn;
    }
  }
}
