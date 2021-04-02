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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;

import net.minecraft.item.Item.Properties;

public class SignItem extends WallOrFloorItem {

  public SignItem(Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
    super(floorBlockIn, wallBlockIn, propertiesIn);
  }

  protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
    boolean flag = super.onBlockPlaced(pos, worldIn, player, stack, state);
    SignTileEntity tile = (SignTileEntity) worldIn.getTileEntity(pos);
    tile.setPlayer(player);
    if (worldIn.isRemote && !flag) {
      DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> new SignScreenCaller(tile));
    }

    return flag;
  }

  @Override
  public String getTranslationKey() {
    return getDefaultTranslationKey();
  }
}
