package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.containers.BagContainer;
import com.sasnos.ravenutils.inventories.BagInventory;
import com.sasnos.ravenutils.utils.enums.Bags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import net.minecraft.item.Item.Properties;

public class Bag extends Item {

  private Bags bag;

  public Bag(Properties properties, Bags bag) {
    super(properties.group(RavenUtils.TAB));
    this.bag = bag;
  }

  @Nullable
  @Override
  public CompoundNBT getShareTag(ItemStack stack) {
    if (!stack.hasTag()) {
      return null;
    }
    final CompoundNBT compound = stack.getTag().copy();
    compound.remove("Items");
    if (compound.isEmpty()) {
      return null;
    }
    return compound;
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
    final ItemStack stack = player.getHeldItem(hand);
    if (!world.isRemote && player instanceof ServerPlayerEntity) {
      open((ServerPlayerEntity) player, stack, hand == Hand.MAIN_HAND ? player.inventory.currentItem : -1);
    }
    return new ActionResult<>(ActionResultType.SUCCESS, stack);
  }

  public void open(ServerPlayerEntity player, ItemStack stack, int selectedSlot) {
    NetworkHooks.openGui(player, new SimpleNamedContainerProvider((id, playerInventory, openPlayer) -> {
      return new BagContainer(id, playerInventory, new BagInventory(stack, bag.getInventorySize()), bag, selectedSlot);
    }, stack.getDisplayName()), buffer -> {
      buffer.writeEnumValue(bag);
      buffer.writeVarInt(selectedSlot);
    });
  }

  @Override
  public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
    return !ItemStack.areItemsEqual(oldStack, newStack);
  }

  @Override
  public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
    return !(player.openContainer instanceof BagContainer);
  }
}
