package com.raven_tongue.ravenutils.events;

import com.raven_tongue.ravenutils.RavenUtils;
import com.raven_tongue.ravenutils.init.ModBlocks;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TestClientEvents {

  /*
  // player action jump with item
  @SubscribeEvent
  public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
    LivingEntity player = event.getEntityLiving();

    if (player.getHeldItemMainhand().getItem() == Items.STICK) {
      RavenUtils.LOGGER.info("Player jumped with a stick in hand");
      World world = player.getEntityWorld();
      world.setBlockState(player.func_233580_cy_().add(0, -1, 0), ModBlocks.DRY_DIRT.get().getDefaultState());
    }
  }

  // player attacks cow = bad
  @SubscribeEvent
  public static void onDamageCow(AttackEntityEvent event) {
    PlayerEntity player = event.getPlayer();
    Entity target = event.getTarget();

    if (target instanceof CowEntity) {
      player.attackEntityFrom(DamageSource.CACTUS, 1.0F);
    }
  }

  // disable crafting
  @SubscribeEvent
  public static void onOpenCraftingTable(GuiOpenEvent event) {
    if (event.isCancelable() && event.getGui() instanceof CraftingScreen) {
      event.setCanceled(true);
      RavenUtils.LOGGER.info("Someone tried to craft in Minecraft...");
    }
  }
  */
}
