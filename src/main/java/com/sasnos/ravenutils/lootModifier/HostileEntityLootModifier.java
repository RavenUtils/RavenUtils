package com.sasnos.ravenutils.lootModifier;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HostileEntityLootModifier extends MobLootModifier {

  NonNullList<AdditionalItems> loot;

  NonNullList<AdditionalItems> additionalLoot;

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  protected HostileEntityLootModifier(
      ILootCondition[] conditionsIn,
      NonNullList<AdditionalItems> loot,
      NonNullList<AdditionalItems> additionalLoot) {
    super(conditionsIn);
    this.loot = loot;
    this.additionalLoot = additionalLoot;
  }

  @NotNull
  @Override
  protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

    for (AdditionalItems loots : loot) {
      generatedLoot.removeIf(itemStack -> itemStack.getItem() == loots.item);
      float rand = context.getRandom().nextFloat();
      float change = loots.change;
      if (change > 1f) {
        change = 1f;
      }
      if (rand <= change) {
        ItemStack item = getItemStackWithLooting(context, loots.range, loots.item);
        generatedLoot.add(item);
      }
    }

    for (AdditionalItems add : additionalLoot) {
      generatedLoot.removeIf(itemStack -> itemStack.getItem() == add.item);
      float rand = context.getRandom().nextFloat();
      float change = add.change + Float.parseFloat("0." + context.getLootingModifier());
      if (change > 1f) {
        change = 1f;
      }
      if (rand <= change) {
        ItemStack item = getItemStackWithLooting(context, add.range, add.item);
        generatedLoot.add(item);
      }
    }
    return generatedLoot;
  }
}
