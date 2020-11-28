package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.containers.StoneCraftingTableContainerProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class StoneCraftingTable extends CraftingTableBlock {
  public StoneCraftingTable() {
    super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
        .hardnessAndResistance(2.5F)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.STONE)
    );
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (worldIn.isRemote) {
      return ActionResultType.SUCCESS;
    } else {
      NetworkHooks.openGui((ServerPlayerEntity) player, getContainer(state, worldIn, pos));
      player.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
      return ActionResultType.CONSUME;
    }
  }

  @Override
  public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
    return new StoneCraftingTableContainerProvider(state, worldIn, pos);
  }
}
