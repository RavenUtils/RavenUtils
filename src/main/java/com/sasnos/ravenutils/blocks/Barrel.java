package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class Barrel extends Block {

  public static BooleanProperty HAS_LID = BlockStateProperties.OPEN;

  public Barrel(Properties properties) {
    super(properties);
  }

}
