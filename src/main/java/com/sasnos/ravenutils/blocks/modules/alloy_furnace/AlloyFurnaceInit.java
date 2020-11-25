package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModBlocks;
import com.sasnos.ravenutils.init.ModContainer;
import com.sasnos.ravenutils.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class AlloyFurnaceInit {
  public static final RegistryObject<Block> ALLOY_FURNACE =
      ModBlocks.BLOCKS.register("alloy_furnace", AlloyFurnace::new);

  public static final RegistryObject<Item> ALLOY_FURNACE_ITEM =
      ModBlockItems.ITEMS.register("alloy_furnace", () -> new BlockItem(
          ALLOY_FURNACE.get(),
          new Item.Properties().group(RavenUtils.TAB)
      ));

  public static final RegistryObject<TileEntityType<AlloyFurnaceTileEntity>> ALLOY_FURNACE_TILE_ENTITY =
      ModTileEntities.TILE_ENTITY.register("alloy_furnace",
          () -> TileEntityType.Builder
              .create(AlloyFurnaceTileEntity::new, ALLOY_FURNACE.get())
              .build(null));

  public static final RegistryObject<ContainerType<AlloyFurnaceContainer>> ALLOY_FURNACE_CONTAINER =
      ModContainer.CONTAINERTYPES.register("alloy_furnace", () -> IForgeContainerType.create(
          AlloyFurnaceContainer::new));
}
