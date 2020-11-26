package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.api.blocks.EssentialsMachineBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class AlloyFurnace extends EssentialsMachineBlock {

  public AlloyFurnace() {
    super(AbstractBlock.Properties.from(Blocks.FURNACE));
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new AlloyFurnaceTileEntity();
  }

}
