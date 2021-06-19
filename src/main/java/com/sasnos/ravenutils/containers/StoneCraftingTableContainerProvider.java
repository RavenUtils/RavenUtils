package com.sasnos.ravenutils.containers;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StoneCraftingTableContainerProvider implements INamedContainerProvider {

  private final World world;
  private final BlockPos pos;
  private BlockState state;

  public StoneCraftingTableContainerProvider(BlockState state, World worldIn, BlockPos pos) {
    this.state = state;
    this.world = worldIn;
    this.pos = pos;
  }

  @Override
  public ITextComponent getDisplayName() {
    return new TranslationTextComponent("container.crafting");
  }

  @Nullable
  @Override
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
    return new StoneCraftingTableContainer(p_createMenu_1_, p_createMenu_2_, IWorldPosCallable.create(world, pos));
  }
}
