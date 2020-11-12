package com.sasnos.ravenutils.lootModifier;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sasnos.ravenutils.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraft.loot.functions.Smelt;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PassiveEntityLootModifier extends LootModifier {

  public RandomValueRange hideDropRange;
  public boolean applyLootingHide;
  public Item meat;
  public RandomValueRange meatDropRange;
  public boolean applyLootingMeat;
  public RandomValueRange tallowDropRange;
  public boolean applyLootingTallow;
  public RandomValueRange boneDropRange;
  public boolean applyLootingBone;
  public NonNullList<AdditionalItems> additional;

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  public PassiveEntityLootModifier(
      ILootCondition[] conditionsIn,
      RandomValueRange hideDropRangeIn, boolean applyLootHideIn,
      Item meatIn, RandomValueRange meatDropRangeIn, boolean applyLootMeatIn,
      RandomValueRange tallowDropRangeIn, boolean applyLootTallowIn,
      RandomValueRange boneDropRangeIn, boolean applyLootBoneIn,
      NonNullList<AdditionalItems> additionalIN) {
    super(conditionsIn);
    this.hideDropRange = hideDropRangeIn;
    this.applyLootingHide = applyLootHideIn;
    this.meat = meatIn;
    this.meatDropRange = meatDropRangeIn;
    this.applyLootingMeat = applyLootMeatIn;
    this.tallowDropRange = tallowDropRangeIn;
    this.applyLootingTallow = applyLootTallowIn;
    this.boneDropRange = boneDropRangeIn;
    this.applyLootingBone = applyLootBoneIn;
    this.additional = additionalIN;
  }

  @Override
  protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

    int looting = context.getLootingModifier();
    if (hideDropRange.getMax() > 0) {
      ItemStack item;
      if (applyLootingHide) {
        item = getItemStackWithLooting(context, hideDropRange, ModItems.FRESH_HIDE.get());
      } else {
        item = new ItemStack(ModItems.FRESH_HIDE.get(), hideDropRange.generateInt(context.getRandom()));
      }

      generatedLoot.add(item);
    }

    if (meat != null) {
      ItemStack item;
      Item contextMeat;
      Entity entity = context.get(LootParameters.THIS_ENTITY);
      if (entity.isBurning()) {
        Item tmpMeat = meat;
        contextMeat = ((Smelt) Smelt.func_215953_b().build()).doApply(new ItemStack(meat), context).getItem();
      } else {
        contextMeat = meat;
      }

      generatedLoot.removeIf(itemStack -> itemStack.getItem() == contextMeat);

      if (applyLootingMeat) {
        item = getItemStackWithLooting(context, meatDropRange, contextMeat);
      } else {
        item = new ItemStack(contextMeat, meatDropRange.generateInt(context.getRandom()));
      }
      generatedLoot.add(item);
    }

    if (tallowDropRange.getMax() > 0) {
      ItemStack item;
      if (applyLootingTallow) {
        item = getItemStackWithLooting(context, tallowDropRange, ModItems.TALLOW.get());
      } else {
        item = new ItemStack(ModItems.TALLOW.get(), tallowDropRange.generateInt(context.getRandom()));
      }

      generatedLoot.add(item);
    }

    if (boneDropRange.getMax() > 0) {
      ItemStack item;
      if (applyLootingBone) {
        item = getItemStackWithLooting(context, boneDropRange, Items.BONE);
      } else {
        item = new ItemStack(Items.BONE, boneDropRange.generateInt(context.getRandom()));
      }

      generatedLoot.add(item);
    }

    for (AdditionalItems add : additional) {
      generatedLoot.removeIf(itemStack -> itemStack.getItem() == add.item);
      float rand = context.getRandom().nextFloat();
      if (rand <= add.change) {
        int sum = context.getRandom().ints(add.minItem, add.maxItem + 1).findFirst().getAsInt();
        if (add.useLootEnchant) sum += looting;
        generatedLoot.add(new ItemStack(add.item, sum));
      }
    }

    return generatedLoot;
  }

  @NotNull
  private static ItemStack getItemStackWithLooting(LootContext context, RandomValueRange hideDropRange, Item loot) {
    LootingEnchantBonus leb = (LootingEnchantBonus) new LootingEnchantBonus.Builder(hideDropRange).func_216072_a((int) hideDropRange.getMax()).build();
    ItemStack item = leb.doApply(new ItemStack(loot), context);
    return item;
  }

  public static class Serializer extends GlobalLootModifierSerializer<PassiveEntityLootModifier> {

    @Override
    public PassiveEntityLootModifier read(ResourceLocation location, JsonObject json, ILootCondition[] ailootcondition) {
      int minHide = JSONUtils.getInt(json, "minHide");
      int maxHide = JSONUtils.getInt(json, "maxHide");
      boolean applyLootHide = JSONUtils.getBoolean(json, "applyLootHide");
      int minTallow = JSONUtils.getInt(json, "minTallow");
      int maxTallow = JSONUtils.getInt(json, "maxTallow");
      boolean applyLootTallow = JSONUtils.getBoolean(json, "applyLootTallow");
      int minMeat = JSONUtils.getInt(json, "minMeat");
      int maxMeat = JSONUtils.getInt(json, "maxMeat");
      Item meat = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(json, "meat")));
      boolean applyLootMeat = JSONUtils.getBoolean(json, "applyLootMeat");
      int minBone = JSONUtils.getInt(json, "minBone");
      int maxBone = JSONUtils.getInt(json, "maxBone");
      boolean applyLootBone = JSONUtils.getBoolean(json, "applyLootBone");
      JsonArray additionalJson = JSONUtils.getJsonArray(json, "additional");
      NonNullList<AdditionalItems> additional = NonNullList.create();

      RandomValueRange hideRange = new RandomValueRange(minHide, maxHide);
      RandomValueRange tallowRange = new RandomValueRange(minTallow, maxTallow);
      RandomValueRange meatRange = new RandomValueRange(minMeat, maxMeat);
      RandomValueRange boneRange = new RandomValueRange(minBone, maxBone);

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

      return new PassiveEntityLootModifier(
          ailootcondition,
          hideRange, applyLootHide,
          meat, meatRange, applyLootMeat,
          tallowRange, applyLootTallow,
          boneRange, applyLootBone,
          additional);
    }

    @Override
    public JsonObject write(PassiveEntityLootModifier instance) {
      JsonObject json = makeConditions(instance.conditions);

      json.addProperty("minHide", instance.hideDropRange.getMin());
      json.addProperty("maxHide", instance.hideDropRange.getMax());
      json.addProperty("applyLootHide", instance.applyLootingHide);
      json.addProperty("minTallow", instance.tallowDropRange.getMin());
      json.addProperty("maxTallow", instance.tallowDropRange.getMax());
      json.addProperty("applyLootTallow", instance.applyLootingTallow);
      json.addProperty("minMeat", instance.meatDropRange.getMin());
      json.addProperty("maxMeat", instance.meatDropRange.getMax());
      json.addProperty("meat", ForgeRegistries.ITEMS.getKey(instance.meat.getItem()).toString());
      json.addProperty("applyLootMeat", instance.applyLootingMeat);
      json.addProperty("minBone", instance.boneDropRange.getMin());
      json.addProperty("maxBone", instance.boneDropRange.getMax());
      json.addProperty("applyLootBone", instance.applyLootingBone);
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
    public float change;
    public boolean useLootEnchant;

    public AdditionalItems(Item itemIN, int minItemIn, int maxItemIn, float changeIn, boolean useLootEnchantIn) {
      this.item = itemIN;
      this.minItem = minItemIn;
      this.maxItem = maxItemIn;
      this.change = changeIn;
      this.useLootEnchant = useLootEnchantIn;
    }
  }
}
