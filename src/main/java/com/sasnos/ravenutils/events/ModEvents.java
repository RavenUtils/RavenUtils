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

  @SubscribeEvent
  public static void stripBlock(BlockEvent.BlockToolInteractEvent event){
    if(event.getToolType() == ToolType.AXE && event.getState().matchesBlock(ModBlocks.CRIMWOOD_LOG.get())){
      event.setFinalState(ModBlocks.CRIMWOOD_LOG_STRIPPED.get().getDefaultState().with(BlockStateProperties.AXIS, event.getState().get(BlockStateProperties.AXIS)));
    }
  }

  @SubscribeEvent
  public static void onSleepEvent(PlayerSleepInBedEvent event){
    if(!(event.getPlayer() instanceof ServerPlayerEntity)) return;
    ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
    if(player.getHeldItemMainhand().getItem() == ModToolItems.BEDROLL.get()){
      BlockPos at = event.getPos();
      Direction direction = player.getHorizontalFacing();
      if (!player.isSleeping() && player.isAlive()) {
        if (!player.world.getDimensionType().isNatural()) {
          event.setResult(PlayerEntity.SleepResult.NOT_POSSIBLE_HERE);
        } else if (EssentialsUtils.isObstructed(player, at, direction)) {
          event.setResult(PlayerEntity.SleepResult.OBSTRUCTED);
        } else {
          player.func_242111_a(player.world.getDimensionKey(), at, player.rotationYaw, false, true);
          if (!net.minecraftforge.event.ForgeEventFactory.fireSleepingTimeCheck(player, event.getOptionalPos())) {
            event.setResult(PlayerEntity.SleepResult.NOT_POSSIBLE_NOW);
          } else {
            if (!player.isCreative()) {
              double d0 = 8.0D;
              double d1 = 5.0D;
              Vector3d vector3d = Vector3d.copyCenteredHorizontally(at);
              List<MonsterEntity> list = player.world.getEntitiesWithinAABB(MonsterEntity.class, new AxisAlignedBB(vector3d.getX() - 8.0D, vector3d.getY() - 5.0D, vector3d.getZ() - 8.0D, vector3d.getX() + 8.0D, vector3d.getY() + 5.0D, vector3d.getZ() + 8.0D), (p_241146_1_) -> {
                return p_241146_1_.func_230292_f_(player);
              });
              if (!list.isEmpty()) {
                event.setResult(PlayerEntity.SleepResult.NOT_SAFE);
              }
            }
            player.startSleeping(at);
            ((ServerWorld) player.world).updateAllPlayersSleepingFlag();
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
      Optional<BlockPos> pos = entity.getBedPosition();
      if(pos.isPresent()){
        if(pos.get().equals(event.getSleepingLocation()) &&
                entity.getHeldItemMainhand().getItem() == ModToolItems.BEDROLL.get()){
          event.setResult(Event.Result.ALLOW);
        }
      }
    }
  }

  @SubscribeEvent
  public static void onWakeUp(PlayerWakeUpEvent event){
    ItemStack item = event.getPlayer().getHeldItem(event.getPlayer().getActiveHand());
    if(item.getItem() == ModToolItems.BEDROLL.get()){
      item.attemptDamageItem(1, event.getPlayer().getRNG(), (ServerPlayerEntity) event.getPlayer());
    }
  }
  
  @SubscribeEvent
  public static void smackFlintIntoShards(PlayerInteractEvent.RightClickBlock useFlint) {
    World world = useFlint.getWorld();
    if (world.isRemote) return;
    BlockState blockState = world.getBlockState(useFlint.getPos());
    Block block = blockState.getBlock();

    PlayerEntity player = useFlint.getPlayer();
    ItemStack item = player.getHeldItem(useFlint.getHand());

    List<RightClickInWorldRecipe> recipes = world.getRecipeManager().getRecipesForType(RightClickInWorldRecipe.RIGHT_CLICK_IN_WORLD_RECIPE).stream()
            .filter(rightClickInWorldRecipe -> rightClickInWorldRecipe.matches(block, item))
            .collect(Collectors.toList());


    for (RightClickInWorldRecipe recipe : recipes) {
      if (item.isDamageable()) {
        item.attemptDamageItem(1, useFlint.getPlayer().getRNG(), (ServerPlayerEntity) player);
      } else {
        item.shrink(recipe.getIngredients().get(0).getMatchingStacks()[0].getCount());
      }

      BlockPos pos = useFlint.getPos().offset(player.getHorizontalFacing().getOpposite());
      for (ItemStack stack : recipe.getOutput())
        InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
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
