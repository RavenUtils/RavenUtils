package com.sasnos.ravenutils.blocks.modules.hand_mill;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class MillStoneTileEntity extends TileEntity {

  private int damage;

  private int maxDamage;

  public MillStoneTileEntity() {
    super(HandMillInit.MILLSTONE_TILE_ENTITY.get());
  }

  public void setDamage(int maxDamage, int damage) {
    this.maxDamage = maxDamage;
    this.damage = damage;
  }

  /**
   * @return if Damage is greater then maxDamage
   */
  public boolean addDamage() {
    damage = damage + 1;

    return damage > maxDamage;
  }

  @Override
  public CompoundNBT save(CompoundNBT compound) {
    compound.putInt("maxDamage", maxDamage);
    compound.putInt("damage", damage);
    return super.save(compound);
  }

  @Override
  public void load(BlockState state, CompoundNBT nbt) {
    maxDamage = nbt.getInt("maxDamage");
    damage = nbt.getInt("damage");
    super.load(state, nbt);
  }
}
