package com.sasnos.ravenutils.blocks;

import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.tile_entities.AnvilContainerProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class StoneAnvil extends AnvilBlock {

  private static final Field name = ObfuscationReflectionHelper.findField(AnvilBlock.class, "containerName");

  public StoneAnvil() {
    super(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE)
        .strength(2.5F, 600.0F)
        .requiresCorrectToolForDrops()
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.STONE)
    );
    name.setAccessible(true);
  }

  @Nullable
  public static BlockState damage(BlockState state) {
    if (state.is(ModBlocks.STONE_ANVIL_STONE.get())) {
      return ModBlocks.CHIPPED_STONE_ANVIL_STONE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    } else if (state.is(ModBlocks.CHIPPED_STONE_ANVIL_STONE.get())) {
      return ModBlocks.DAMAGED_STONE_ANVIL_STONE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    }

    if (state.is(ModBlocks.STONE_ANVIL_ANDESITE.get())) {
      return ModBlocks.CHIPPED_STONE_ANVIL_ANDESITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    } else if (state.is(ModBlocks.CHIPPED_STONE_ANVIL_ANDESITE.get())) {
      return ModBlocks.DAMAGED_STONE_ANVIL_ANDESITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    }

    if (state.is(ModBlocks.STONE_ANVIL_DIORITE.get())) {
      return ModBlocks.CHIPPED_STONE_ANVIL_DIORITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    } else if (state.is(ModBlocks.CHIPPED_STONE_ANVIL_DIORITE.get())) {
      return ModBlocks.DAMAGED_STONE_ANVIL_DIORITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    }

    if (state.is(ModBlocks.STONE_ANVIL_GRANITE.get())) {
      return ModBlocks.CHIPPED_STONE_ANVIL_GRANITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    } else if (state.is(ModBlocks.CHIPPED_STONE_ANVIL_GRANITE.get())) {
      return ModBlocks.DAMAGED_STONE_ANVIL_GRANITE.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
    }
    return null;
  }

  @Override
  public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (worldIn.isClientSide) {
      return ActionResultType.SUCCESS;
    } else {
      ITextComponent containerName = null;
      try {
        containerName = (ITextComponent) name.get(this);
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      NetworkHooks.openGui((ServerPlayerEntity) player, new AnvilContainerProvider(containerName));
      player.awardStat(Stats.INTERACT_WITH_ANVIL);
      return ActionResultType.CONSUME;
    }
  }


}
