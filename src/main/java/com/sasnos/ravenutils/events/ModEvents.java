package com.sasnos.ravenutils.events;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.networking.RavenUtilsPacketHandler;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

  @SubscribeEvent
  public static void stopDrop(PlayerEvent.HarvestCheck event) {
    BlockState state = event.getTargetBlock();
    if (state.isIn(EssentialsTags.Blocks.requireTool)) {
      PlayerEntity player = event.getPlayer();
      ItemStack stack = player.getHeldItemMainhand();
      ToolType tool = state.getHarvestTool();
      if (stack.isEmpty() || tool == null)
        event.setCanHarvest(false);

      int toolLevel = stack.getHarvestLevel(tool, player, state);
      if (toolLevel < 0)
        event.setCanHarvest(false);
      event.setCanHarvest(toolLevel >= state.getHarvestLevel());
    }
  }

  @SubscribeEvent
  public static void stopDestroy(BlockEvent.BreakEvent event) {
    BlockState state = event.getState();
    if (state.isIn(EssentialsTags.Blocks.requireTool)) {
      event.setCanceled(!state.canHarvestBlock(event.getWorld(), event.getPos(), event.getPlayer()));
    }
  }

  // todo implement getting Flitn Shards from FLint on Overworld Stone

  @SubscribeEvent
  public static void smackFlintIntoShards(PlayerInteractEvent.RightClickBlock useFlint) {
    World world = useFlint.getWorld();
    if (world.isRemote) return;
    BlockState blockState = world.getBlockState(useFlint.getPos());
    Block block = blockState.getBlock();

    if (!(block == Blocks.STONE ||
            block == Blocks.ANDESITE ||
            block == Blocks.DIORITE ||
            block == Blocks.GRANITE ||
            block == Blocks.OBSIDIAN)) return;

    PlayerEntity player = useFlint.getPlayer();
    ItemStack item = player.getHeldItem(useFlint.getHand());
    if (item.getItem() == Items.FLINT) {
      item.shrink(1);
      BlockPos pos = useFlint.getPos().offset(player.getHorizontalFacing().getOpposite());
      InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FLINT_SHARD.get(), 2));
    }
  }

  @SubscribeEvent
  private void setup(final FMLCommonSetupEvent event) {
    RavenUtilsPacketHandler.registerNetworkMessages();

    event.enqueueWork(() -> {
      try {
        Field saturation = ObfuscationReflectionHelper.findField(Food.class, "field_221471_b");
        Field effect = ObfuscationReflectionHelper.findField(Food.class, "field_221475_f");
        Field requireTool = ObfuscationReflectionHelper.findField(AbstractBlock.AbstractBlockState.class, "field_235706_j_");
        List<Pair<Supplier<EffectInstance>, Float>> effects = Lists.newArrayList();
        saturation.setAccessible(true);

        saturation.setFloat(Foods.PORKCHOP, 1.8f);
        saturation.setFloat(Foods.CHICKEN, 1.2f);
        saturation.setFloat(Foods.RABBIT, 1.8f);
        saturation.setFloat(Foods.MUTTON, 1.2f);
        saturation.setFloat(Foods.BEEF, 1.8f);

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.2f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.7f));
        effect.set(Foods.MUTTON, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.2f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.7f));
        effect.set(Foods.RABBIT, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 200, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 100, 1), 0.8f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 200, 2), 0.7f));
        effect.set(Foods.CHICKEN, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 1.0f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.5f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.6f));
        effect.set(Foods.PORKCHOP, effects);
        effects.clear();

        effects.add(Pair.of(() -> new EffectInstance(Effects.HUNGER, 400, 2), 0.5f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.POISON, 200, 1), 0.1f));
        effects.add(Pair.of(() -> new EffectInstance(Effects.NAUSEA, 300, 2), 0.3f));

        Field maxDamage = ObfuscationReflectionHelper.findField(Item.class, "field_77699_b");
        maxDamage.setAccessible(true);
        maxDamage.setInt(Items.BUCKET, 512);
        maxDamage.setInt(Items.MILK_BUCKET, 512);
        for (Fluid fluid : ForgeRegistries.FLUIDS.getValues()) {
          if (fluid.getFilledBucket() == Items.AIR) continue;
          maxDamage.setInt(fluid.getFilledBucket(), 512);
        }
        maxDamage.setAccessible(false);

        requireTool.setAccessible(true);
        for (Block block : EssentialsTags.Blocks.requireTool.getAllElements()) {
          requireTool.setBoolean(block, true);
        }

        Field isSolid = ObfuscationReflectionHelper.findField(AbstractBlock.AbstractBlockState.class, "field_235707_k_");
        Field canCollide = ObfuscationReflectionHelper.findField(AbstractBlock.class, "field_235688_at_");

        isSolid.setAccessible(true);
        canCollide.setAccessible(true);

        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
          if (block instanceof LeavesBlock) {
            isSolid.setBoolean(block, false);
            canCollide.setBoolean(block, false);
          }
        }

      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
