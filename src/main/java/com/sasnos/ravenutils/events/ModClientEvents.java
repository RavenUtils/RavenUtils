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

  public static void onItemUseFinished(LivingEntityUseItemEvent.Finish event){
    if(event.getEntityLiving() instanceof PlayerEntity){
      PlayerEntity player = (PlayerEntity) event.getEntityLiving();
      if(event.getItem().getItem() == Items.PORKCHOP){
        Random rand = new Random();
        float change = rand.nextFloat();
        if(change <= 0.5f){
          player.addPotionEffect(new EffectInstance(Effects.POISON, 200, 1));
        }
        change = rand.nextFloat();
        if(change <= 0.6f){
          player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300, 2));
        }
        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 400, 2));
      }
    }
  }

  /*
  // player action jump with item
  @SubscribeEvent
  public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
    LivingEntity player = event.getEntityLiving();
    // event.getRegistry().register(new LimewaterFluid.Flowing().setRegistryName("limewater_flowing"));
    // event.getRegistry().register(new LimewaterFluid.Source().setRegistryName("limewater"));

    // event.getRegistry().register(new TanninFluid.Flowing().setRegistryName("tannin_flowing"));
    // event.getRegistry().register(new TanninFluid.Source().setRegistryName("tannin"));
  }
}
