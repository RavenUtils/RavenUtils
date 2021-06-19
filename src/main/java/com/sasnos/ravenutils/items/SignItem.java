package com.sasnos.ravenutils.items;

import com.sasnos.ravenutils.screen.SignScreenCaller;
import com.sasnos.ravenutils.tile_entities.SignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import net.minecraft.item.Item.Properties;

public class SignItem extends WallOrFloorItem {

  public SignItem(Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
    super(floorBlockIn, wallBlockIn, propertiesIn);
  }

  protected boolean updateCustomBlockEntityTag(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
    boolean flag = super.updateCustomBlockEntityTag(pos, worldIn, player, stack, state);
    SignTileEntity tile = (SignTileEntity) worldIn.getBlockEntity(pos);
    tile.setAllowedPlayerEditor(player);
    if (worldIn.isClientSide && !flag) {
      SignScreenCaller.openSignScreen(tile);
    }

    return flag;
  }

  @Override
  public String getDescriptionId() {
    return getOrCreateDescriptionId();
  }
}
