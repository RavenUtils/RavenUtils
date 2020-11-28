package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.sasnos.ravenutils.blocks.BlockItemBase;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class HandMillInit {

    public static final RegistryObject<Block> HANDMILL = ModBlocks.BLOCKS.register("hand_mill", HandMill::new);

    public static final RegistryObject<Item> HANDMILL_ITEM = ModBlockItems.ITEMS.register("hand_mill", () -> new BlockItemBase(HANDMILL.get()));

    public static final RegistryObject<Block> MILLSTONE = ModBlocks.BLOCKS.register("mill_stone", MillStone::new);

    public static final RegistryObject<Item> MILLSTONE_ITEM = ModBlockItems.ITEMS.register("mill_stone", () -> new BlockItemBase(MILLSTONE.get()));

    public static final RegistryObject<TileEntityType<HandMillTileEntity>> HANDMILL_TILEENTITY =
            ModTileEntities.TILE_ENTITY.register("hand_mill",
                    () -> TileEntityType.Builder
                            .create(HandMillTileEntity::new, HANDMILL.get())
                            .build(null));

    public static final RegistryObject<ContainerType<HandMillContainer>> HANDMILL_CONTAINER =
            ModContainer.CONTAINERTYPES.register("hand_mill", () -> IForgeContainerType.create(
                    HandMillContainer::new));
}
