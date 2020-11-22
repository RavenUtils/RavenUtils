package com.sasnos.ravenutils.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;

public class ChimneyExit extends Block implements IChimney{

    public ChimneyExit(Properties properties) {
        super(properties);
    }

    @Override
    public void updateBlock(IWorld worldIn, BlockState facingState) {

    }
}
