package com.sasnos.ravenutils.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class StoneCraftingTable extends CraftingTableBlock {
  public StoneCraftingTable() {
    super(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.5F).sound(SoundType.STONE));
  }
}
