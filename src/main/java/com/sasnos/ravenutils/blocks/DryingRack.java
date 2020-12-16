package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

public class DryingRack extends Block {

  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;


  public DryingRack() {
    super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
        .hardnessAndResistance(2.5F)
        .harvestTool(ToolType.AXE)
        .sound(SoundType.WOOD)
    );
  }


  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
