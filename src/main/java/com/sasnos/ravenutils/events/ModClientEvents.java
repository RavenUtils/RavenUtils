package com.sasnos.ravenutils.events;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.utils.tags.EssentialsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RavenUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void stopDrop(PlayerEvent.HarvestCheck event){
        BlockState state = event.getTargetBlock();
        if (state.isIn(EssentialsTags.Blocks.requireTool)){
            PlayerEntity player = event.getPlayer();
            int itemSlot = player.inventory.currentItem;
            ItemStack stack = player.inventory.getStackInSlot(itemSlot);
            if(stack == ItemStack.EMPTY || !stack.getItem().canHarvestBlock(state)){
                event.setCanHarvest(false);
            }
        }
    }

  // todo implement getting Flitn Shards from FLint on Overworld Stone
  @SubscribeEvent
  public static void smackFlintIntoShards(PlayerInteractEvent.RightClickBlock useFlint) {
        World world = useFlint.getWorld();
        if(world.isRemote) return;
      BlockState blockState = world.getBlockState(useFlint.getPos());
        Block block = blockState.getBlock();


        if(!(block == Blocks.STONE ||
                block == Blocks.ANDESITE ||
                block == Blocks.DIORITE ||
                block == Blocks.GRANITE ||
                block == Blocks.OBSIDIAN)) return;


        PlayerEntity player = useFlint.getPlayer();
        ItemStack item = player.getHeldItem(useFlint.getHand());
        if(item.getItem() == Items.FLINT){
            item.shrink(1);
            BlockPos pos = useFlint.getPos().offset(player.getHorizontalFacing().getOpposite());
            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FLINT_SHARD.get(), 2));
        }
  }

}
