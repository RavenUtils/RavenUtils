package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

  /*
  @SubscribeEvent
  public static void smackFlintIntoShards(PlayerInteractEvent useFlint) {
    PlayerEntity player = useFlint.getPlayer();
    Item item = player.getHeldItemMainhand().getItem();
  }
  */

}
