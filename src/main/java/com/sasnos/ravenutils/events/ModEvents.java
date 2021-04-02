package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.inventories.BagItemHandlerProvider;
import com.sasnos.ravenutils.items.Bag;
import com.sasnos.ravenutils.recipes.in_world.RightClickInWorldRecipe;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
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
  
  // todo implement getting Flitn Shards from FLint on Overworld Stone

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
