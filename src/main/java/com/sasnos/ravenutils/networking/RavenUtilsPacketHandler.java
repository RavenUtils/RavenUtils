package com.sasnos.ravenutils.networking;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class RavenUtilsPacketHandler {
  private static int ID = 0;
  private static final String PROTOCOL_VERSION = "1";
  public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
      new ResourceLocation(RavenUtils.MOD_ID, "main"),
      () -> PROTOCOL_VERSION,
      PROTOCOL_VERSION::equals,
      PROTOCOL_VERSION::equals
  );

  public static void registerNetworkMessages() {
    INSTANCE.messageBuilder(SyncTeWithItemHandler.class, ID++)
        .encoder(SyncTeWithItemHandler::toBuf)
        .decoder(SyncTeWithItemHandler::new)
        .consumer(SyncTeWithItemHandler::handle)
        .add();
  }

}
