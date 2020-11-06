package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.fluids.LimewaterFluid;
import com.sasnos.ravenutils.fluids.TanninFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

  @SubscribeEvent
  public static void onFluidRegistry(RegistryEvent.Register<Fluid> event) {
    event.getRegistry().register(new LimewaterFluid.Flowing().setRegistryName("limewater_flowing"));
    event.getRegistry().register(new LimewaterFluid.Source().setRegistryName("limewater"));

    event.getRegistry().register(new TanninFluid.Flowing().setRegistryName("tannin_flowing"));
    event.getRegistry().register(new TanninFluid.Source().setRegistryName("tannin"));
  }

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
