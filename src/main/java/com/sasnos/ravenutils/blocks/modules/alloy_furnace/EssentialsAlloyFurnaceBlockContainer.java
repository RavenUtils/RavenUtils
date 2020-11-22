package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.api.containers.EssentialsMachineBlockContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class EssentialsAlloyFurnaceBlockContainer extends EssentialsMachineBlockContainer {

  public EssentialsAlloyFurnaceBlockContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
    this(windowId, playerInventory.player.world, extraData.readBlockPos(), playerInventory, playerInventory.player, new IntArray(4));
  }


  protected EssentialsAlloyFurnaceBlockContainer(int id, World world, BlockPos pos, PlayerInventory playerInventoryIn, PlayerEntity player, IIntArray furnaceData) {
    super(EssentialsAlloyFurnaceInit.alloyFurnaceContainer.get(), id, world, pos, playerInventoryIn, player, EssentialsAlloyFurnaceInit.alloyFurnace.get(), furnaceData);
  }

  @Override
  protected void addSlots() {
    tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
      addSlot(new SlotItemHandler(h, 0, 56, 17));
      addSlot(new SlotItemHandler(h, 1, 56, 53));
      addSlot(new SlotItemHandler(h, 2, 112, 31));
    });
    layoutPlayerInventorySlots(8, 84);
  }

  @Override
  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    return null;
  }
}
