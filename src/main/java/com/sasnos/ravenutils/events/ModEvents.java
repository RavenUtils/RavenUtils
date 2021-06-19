package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.inventories.BagItemHandlerProvider;
import com.sasnos.ravenutils.items.Bag;
import com.sasnos.ravenutils.recipes.in_world.RightClickInWorldRecipe;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

  @SubscribeEvent
  public static void stopDrop(PlayerEvent.HarvestCheck event) {
    BlockState state = event.getTargetBlock();
    if (state.is(EssentialsTags.Blocks.requireTool)) {
      PlayerEntity player = event.getPlayer();
      ItemStack stack = player.getMainHandItem();
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
    if (state.is(EssentialsTags.Blocks.requireTool)) {
      event.setCanceled(!state.canHarvestBlock(event.getWorld(), event.getPos(), event.getPlayer()));
    }
  }

  @SubscribeEvent
  public static void stripBlock(BlockEvent.BlockToolInteractEvent event){
    if(event.getToolType() == ToolType.AXE && event.getState().is(ModBlocks.CRIMWOOD_LOG.get())){
      event.setFinalState(ModBlocks.CRIMWOOD_LOG_STRIPPED.get().defaultBlockState().setValue(BlockStateProperties.AXIS, event.getState().getValue(BlockStateProperties.AXIS)));
    }
  }

  @SubscribeEvent
  public static void onSleepEvent(PlayerSleepInBedEvent event){
    if(!(event.getPlayer() instanceof ServerPlayerEntity)) return;
    ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
    if(player.getMainHandItem().getItem() == ModToolItems.BEDROLL.get()){
      BlockPos at = event.getPos();
      Direction direction = player.getDirection();
      if (!player.isSleeping() && player.isAlive()) {
        if (!player.level.dimensionType().natural()) {
          event.setResult(PlayerEntity.SleepResult.NOT_POSSIBLE_HERE);
        } else if (EssentialsUtils.isObstructed(player, at, direction)) {
          event.setResult(PlayerEntity.SleepResult.OBSTRUCTED);
        } else {
          player.setRespawnPosition(player.level.dimension(), at, player.yRot, false, true);
          if (!net.minecraftforge.event.ForgeEventFactory.fireSleepingTimeCheck(player, event.getOptionalPos())) {
            event.setResult(PlayerEntity.SleepResult.NOT_POSSIBLE_NOW);
          } else {
            if (!player.isCreative()) {
              double d0 = 8.0D;
              double d1 = 5.0D;
              Vector3d vector3d = Vector3d.atBottomCenterOf(at);
              List<MonsterEntity> list = player.level.getEntitiesOfClass(MonsterEntity.class, new AxisAlignedBB(vector3d.x() - 8.0D, vector3d.y() - 5.0D, vector3d.z() - 8.0D, vector3d.x() + 8.0D, vector3d.y() + 5.0D, vector3d.z() + 8.0D), (p_241146_1_) -> {
                return p_241146_1_.isPreventingPlayerRest(player);
              });
              if (!list.isEmpty()) {
                event.setResult(PlayerEntity.SleepResult.NOT_SAFE);
              }
            }
            player.startSleeping(at);
            ((ServerWorld) player.level).updateSleepingPlayerList();
            event.setResult(PlayerEntity.SleepResult.OTHER_PROBLEM);
          }
        }
      }
    }
  }

  @SubscribeEvent
  public static void isValidBed(SleepingLocationCheckEvent event){
    if(event.getEntityLiving() instanceof PlayerEntity){
      PlayerEntity entity = (PlayerEntity) event.getEntityLiving();
      Optional<BlockPos> pos = entity.getSleepingPos();
      if(pos.isPresent()){
        if(pos.get().equals(event.getSleepingLocation()) &&
                entity.getMainHandItem().getItem() == ModToolItems.BEDROLL.get()){
          event.setResult(Event.Result.ALLOW);
        }
      }
    }
  }

  @SubscribeEvent
  public static void onWakeUp(PlayerWakeUpEvent event){
    Hand hand = event.getPlayer().getUsedItemHand();
    if(hand != Hand.MAIN_HAND && hand != Hand.OFF_HAND) return;
    ItemStack item = event.getPlayer().getItemInHand(hand);
    if(item.getItem() == ModToolItems.BEDROLL.get()){
      item.hurt(1, event.getPlayer().getRandom(), (ServerPlayerEntity) event.getPlayer());
    }
  }
  
  @SubscribeEvent
  public static void smackFlintIntoShards(PlayerInteractEvent.RightClickBlock useFlint) {
    World world = useFlint.getWorld();
    if (world.isClientSide) return;
    BlockState blockState = world.getBlockState(useFlint.getPos());
    Block block = blockState.getBlock();

    PlayerEntity player = useFlint.getPlayer();
    ItemStack item = player.getItemInHand(useFlint.getHand());

    List<RightClickInWorldRecipe> recipes = world.getRecipeManager().getAllRecipesFor(RightClickInWorldRecipe.RIGHT_CLICK_IN_WORLD_RECIPE).stream()
            .filter(rightClickInWorldRecipe -> rightClickInWorldRecipe.matches(block, item))
            .collect(Collectors.toList());


    for (RightClickInWorldRecipe recipe : recipes) {
      if (item.isDamageableItem()) {
        item.hurt(1, useFlint.getPlayer().getRandom(), (ServerPlayerEntity) player);
      } else {
        item.shrink(recipe.getIngredients().get(0).getItems()[0].getCount());
      }

      BlockPos pos = useFlint.getPos().relative(player.getDirection().getOpposite());
      for (ItemStack stack : recipe.getOutput())
        InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    }
  }

  @SubscribeEvent
  public static void itemCapInit(AttachCapabilitiesEvent<ItemStack> e){
    if(e.getObject().getItem() == ModToolItems.BAG_CLOTH.get() || e.getObject().getItem() == ModToolItems.BAG_LEATHER.get()){
      Bag bag = ((Bag)e.getObject().getItem());
      BagItemHandlerProvider handler = new BagItemHandlerProvider(bag.getBagType());
      e.addCapability(new ResourceLocation(RavenUtils.MOD_ID, "baginventory"), handler);
      e.addListener(handler::invalidate);
    }
  }

}
