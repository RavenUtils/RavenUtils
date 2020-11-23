package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.utils.EssentialsFluidBucketWrapper;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class BaseBucketItem extends Item {

  /**
   * Tag name for fluid in a bucket
   */
  private static final String TAG_FLUID = "fluid";

  protected Supplier<Item> milkBucket;

  public BaseBucketItem(Properties properties, @org.jetbrains.annotations.Nullable Supplier<Item> milkBucket) {
    super(properties.group(RavenUtils.TAB));
    this.milkBucket = milkBucket;
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return false;
  }

  /* Item methods */

  @Override
  public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
    return new EssentialsFluidBucketWrapper(stack);
  }

  /* Bucket handling */

  @Override
  public boolean hasContainerItem(ItemStack stack) {
    return !hasFluid(stack) && super.hasContainerItem(stack);
  }

  // TODO: perhaps separate filled and empty?
  @Override
  public ItemStack getContainerItem(ItemStack stack) {
    if (!hasFluid(stack)) {
      return ItemStack.EMPTY;
    }

    return super.getContainerItem(stack);
  }

  /**
   * Gets the empty bucket, based on the player's abilities
   *
   * @param stack  Filled bucket
   * @param player Player placer
   * @return Empty bucket, may be the original stack
   */
  protected static ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
    ItemStack emptyBucket = ((BaseBucketItem) stack.getItem()).withFluid(stack, Fluids.EMPTY);
    if (emptyBucket.isDamageable())
      emptyBucket.damageItem(stack.getDamage() + 1, player,
              playerEntity -> playerEntity.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1f, 1f));
    return !player.isCreative() ? emptyBucket : stack;
  }

  /**
   * Fills a bucket stack with the given fluid
   *
   * @param originalStack List of empty buckets
   * @param player        Player instance
   * @param newBucket     Filled bucket stack
   * @return Stack of buckets
   */
  protected static ItemStack updateBucket(ItemStack originalStack, PlayerEntity player, ItemStack newBucket) {
    // shrink the stack
    if (player.isCreative()) {
      return originalStack;
    }

    if (newBucket.isDamageable())
      newBucket.setDamage(originalStack.getDamage());

    originalStack.shrink(1);
    // fill with fluid
    if (originalStack.isEmpty()) {
      return newBucket;
    }

    addItem(player, newBucket);
    return originalStack;
  }

  /**
   * Adds an item to the player inventory, dropping if there is no space
   *
   * @param player Player instance
   * @param stack  Stack to add
   */
  protected static void addItem(PlayerEntity player, ItemStack stack) {
    if (!player.inventory.addItemStackToInventory(stack)) {
      player.dropItem(stack, false);
    }
  }

  /* Fluid handling */

  /**
   * Returns whether a bucket has fluid. Note the fluid may still be null if
   * true due to milk buckets
   */
  protected boolean hasFluid(ItemStack container) {
    return getFluid(container) != Fluids.EMPTY;
  }

  /**
   * Gets the fluid from the given clay bucket container
   *
   * @param stack Bucket stack
   * @return Fluid contained in the container
   */
  public Fluid getFluid(ItemStack stack) {
    CompoundNBT tags = stack.getTag();
    if (tags != null) {
      Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(tags.getString(TAG_FLUID)));
      return fluid == null ? Fluids.EMPTY : fluid;
    }

    return Fluids.EMPTY;
  }

  /**
   * Returns the stack with the specified fluid
   *
   * @param stack
   * @param fluid Fluid for the bucket
   * @return Clay bucket containing the given fluid
   */
  public ItemStack withFluid(ItemStack stack, Fluid fluid) {
    // special case milk: returns the metadata version
    if (isMilk(fluid)) {
      return withMilk();
    }

    Item bucket;
    if (getContainerItem(stack) == ItemStack.EMPTY) {
      bucket = this;
    } else {
      bucket = getContainerItem(stack).getItem();
    }

    // return
    return setFluid(new ItemStack(bucket), fluid);
  }

  /**
   * Checks if the given fluid is milk. May give inaccurate results before tags are loaded.
   *
   * @param fluid Fluid to check
   * @return True if the fluid is milk
   */
  protected static boolean isMilk(Fluid fluid) {
    return EssentialsTags.tagsLoaded() && EssentialsTags.Fluids.MILK.contains(fluid);
  }


  /**
   * Gets the bucket with milk based on the given cracked status
   *
   * @return Stack with milk
   */
  protected ItemStack withMilk() {
    return new ItemStack(milkBucket.get());
  }

  /**
   * Sets the fluid for the given stack
   *
   * @param stack Item stack instance
   * @param fluid Fluid instance
   * @return Modified stack
   */
  protected static ItemStack setFluid(ItemStack stack, Fluid fluid) {
    stack.getOrCreateTag().putString(TAG_FLUID, Objects.requireNonNull(fluid.getRegistryName()).toString());
    return stack;
  }

  /**
   * Gets a string variant name for the given stack
   *
   * @param stack Stack instance to check
   * @return String variant name
   */
  public static String getSubtype(ItemStack stack) {
    if (stack.hasTag()) {
      assert stack.getTag() != null;
      return stack.getTag().getString(TAG_FLUID);
    }
    return "";
  }
}
