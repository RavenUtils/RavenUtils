package com.sasnos.ravenutils.networking;

import com.sasnos.ravenutils.client.SafeClientCall;
import com.sasnos.ravenutils.tile_entities.BarrelTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncTeWithItemHandler {

  private final ItemStack item;
  private final FluidStack fluid;
  private final BlockPos pos;

  public SyncTeWithItemHandler(PacketBuffer buf) {
    item = buf.readItemStack();
    fluid = buf.readFluidStack();
    pos = buf.readBlockPos();

  }

  public SyncTeWithItemHandler(ItemStack item, FluidStack fluid, BlockPos pos) {
    this.item = item;
    this.fluid = fluid;
    this.pos = pos;

  }

  public static boolean handle(SyncTeWithItemHandler syncTeWithItemHandler, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      World world = DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> SafeClientCall::getClientWorld);
      TileEntity te = world.getTileEntity(syncTeWithItemHandler.pos);
      if (te instanceof BarrelTileEntity) {
        ((BarrelTileEntity) te).update(syncTeWithItemHandler.item, syncTeWithItemHandler.fluid);

      }
    });
    return true;
  }

  public void toBuf(PacketBuffer packetBuffer) {
    packetBuffer.writeItemStack(item);
    packetBuffer.writeFluidStack(fluid);
    packetBuffer.writeBlockPos(pos);
  }

}
