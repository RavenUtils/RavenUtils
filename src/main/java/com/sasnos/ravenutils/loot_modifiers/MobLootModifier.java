package com.sasnos.ravenutils.loot_modifiers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public abstract class MobLootModifier extends LootModifier {

  /**
   * Constructs a LootModifier.
   *
   * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
   */
  protected MobLootModifier(ILootCondition[] conditionsIn) {
    super(conditionsIn);
  }


  @NotNull
  protected static ItemStack getItemStackWithLooting(LootContext context, RandomValueRange hideDropRange, Item loot) {
    LootingEnchantBonus leb = (LootingEnchantBonus) new LootingEnchantBonus.Builder(hideDropRange).func_216072_a((int) hideDropRange.getMax()).build();
    ItemStack item = leb.doApply(new ItemStack(loot), context);
    return item;
  }

  public static class AdditionalItems {
    public Item item;
    public RandomValueRange range;
    public float change;
    public boolean useLootEnchant;

    public AdditionalItems(Item itemIN, RandomValueRange rangeIn, float changeIn, boolean useLootEnchantIn) {
      this.item = itemIN;
      this.range = rangeIn;
      this.change = changeIn;
      this.useLootEnchant = useLootEnchantIn;
    }
  }
}
