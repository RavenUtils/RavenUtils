package com.sasnos.ravenutils.blocks.crimwood;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.NotNull;

import net.minecraft.block.AbstractBlock.Properties;

public class CrimwoodLog extends RotatedPillarBlock {
  public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

  public CrimwoodLog() {
    super(Properties.create(Material.WOOD)
        .hardnessAndResistance(2.0F)
        .sound(SoundType.WOOD)
        .setRequiresTool()
        .harvestTool(ToolType.AXE)
    );
    this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
  }

  @Override
  public @NotNull BlockState rotate(BlockState state, Rotation rot) {
    switch (rot) {
      case COUNTERCLOCKWISE_90:
      case CLOCKWISE_90:
        switch ((Direction.Axis) state.get(AXIS)) {
          case X:
            return state.with(AXIS, Direction.Axis.Z);
          case Z:
            return state.with(AXIS, Direction.Axis.X);
          default:
            return state;
        }
      default:
        return state;
    }
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(AXIS);
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(AXIS, context.getFace().getAxis());
  }
}