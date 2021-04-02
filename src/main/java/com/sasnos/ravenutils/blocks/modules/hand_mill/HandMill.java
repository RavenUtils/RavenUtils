package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.sasnos.raven_api.blocks.EssentialsMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.AbstractBlock.Properties;

public class HandMill extends EssentialsMachineBlock {

  public HandMill() {
    super(Properties.create(Material.ROCK, MaterialColor.STONE)
        .harvestTool(ToolType.PICKAXE)
        .hardnessAndResistance(1.2f));
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new HandMillTileEntity();
  }

  @Override
  protected boolean isItemToStartBurning(ItemStack item) {
    return false;
  }
}
