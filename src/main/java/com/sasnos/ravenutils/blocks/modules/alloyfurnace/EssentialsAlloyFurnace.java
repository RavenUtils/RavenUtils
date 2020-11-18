package com.sasnos.ravenutils.blocks.modules.alloyfurnace;

import com.sasnos.ravenutils.api.block.EssentialsMachineBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

public class EssentialsAlloyFurnace extends EssentialsMachineBlock {

  public EssentialsAlloyFurnace() {
    super(AbstractBlock.Properties.from(Blocks.FURNACE));
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new EssentialsFurnaceTileEntity();
  }
}
