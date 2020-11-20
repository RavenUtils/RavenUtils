package com.sasnos.ravenutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class StickAndStoneBlock extends Block {

    private Item dropItem;

    public StickAndStoneBlock(Properties properties, Item dropItemIn) {
        super(properties);
        this.dropItem = dropItemIn;
    }

    public Item getDropItem() {
        return dropItem;
    }
}
