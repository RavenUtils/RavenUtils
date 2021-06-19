package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.containers.BagContainer;
import com.sasnos.ravenutils.utils.enums.BagTypes;
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
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

import net.minecraft.item.Item.Properties;

public class Bag extends Item {

  private BagTypes bag;

  public Bag(Properties properties, BagTypes bag) {
    super(properties.tab(RavenUtils.TAB));
    this.bag = bag;
  }

  public BagTypes getBagType() {
    return bag;
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
  public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
    final ItemStack stack = player.getItemInHand(hand);
    if (!world.isClientSide) {
      LazyOptional<IItemHandler> bagItem = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
      int selectedSlot = hand == Hand.MAIN_HAND ? player.inventory.selected : -1;
      bagItem.ifPresent(iItemHandler -> {
        NetworkHooks.openGui((ServerPlayerEntity) player, new SimpleNamedContainerProvider(
                (id, playerInventory, openPlayer) -> new BagContainer(id, playerInventory, selectedSlot),
                        stack.getHoverName()),
                buffer -> {
          buffer.writeVarInt(selectedSlot);
        });
      });

    }
    return new ActionResult<>(ActionResultType.SUCCESS, stack);
  }

  @Override
  public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
    return !ItemStack.isSame(oldStack, newStack);
  }

  @Override
  public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
    return !(player.containerMenu instanceof BagContainer);
  }
}
