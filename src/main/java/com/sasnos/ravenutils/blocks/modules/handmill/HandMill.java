package com.sasnos.ravenutils.blocks.modules.handmill;

import com.sasnos.ravenutils.api.blocks.EssentialsMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

public class HandMill extends EssentialsMachineBlock {

    public HandMill() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
                .harvestTool(ToolType.PICKAXE)
                .hardnessAndResistance(1.2f)
                .harvestLevel(1));
    }


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return null;
    }
}
