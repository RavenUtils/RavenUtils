package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

  @SubscribeEvent
  public static void onItemUseFinished(LivingEntityUseItemEvent.Finish event) {
    if (event.getEntityLiving() instanceof PlayerEntity) {
      PlayerEntity player = (PlayerEntity) event.getEntityLiving();
      if (event.getItem().getItem() == Items.PORKCHOP) {
        Random rand = new Random();
        float change = rand.nextFloat();
        if (change <= 0.5f) {
          player.addPotionEffect(new EffectInstance(Effects.POISON, 200, 1));
        }
        change = rand.nextFloat();
        if (change <= 0.6f) {
          player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300, 2));
        }
        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 400, 2));
      }
    }
  }

  @SubscribeEvent
  public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event){
    if(!event.getWorld().isRemote && event.getHand() == Hand.MAIN_HAND){
      if(event.getItemStack() == ItemStack.EMPTY &&
              event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.GRASS_BLOCK){
        BlockPos pos = event.getPos();
        Random change = new Random();

        InventoryHelper.spawnItemStack(event.getWorld(), pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(Items.STICK));
        //new ItemEntity(event.getWorld(), pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(Items.STICK));
      }
    }

  }
}
