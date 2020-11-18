package com.sasnos.ravenutils.blocks.modules.alloyfurnace;

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

public class EssentialsAlloyFurnaceInit {
  public static final RegistryObject<Block> alloyFurnace =
      ModBlocks.BLOCKS.register("alloy_furnace", EssentialsAlloyFurnace::new);

  public static final RegistryObject<Item> alloyFurnaceItem =
      ModBlockItems.ITEMS.register("alloy_furnace", () -> new BlockItem(
          alloyFurnace.get(),
          new Item.Properties().group(RavenUtils.TAB)
      ));

  public static final RegistryObject<TileEntityType<EssentialsFurnaceTileEntity>> alloyFurnaceTileEntity =
      ModTileEntities.TILE_ENTITY.register("alloy_furnace",
          () -> TileEntityType.Builder
              .create(EssentialsFurnaceTileEntity::new, alloyFurnace.get())
              .build(null));

  public static final RegistryObject<ContainerType<EssentialsAlloyFurnaceContainer>> alloyFurnaceContainer =
      ModContainer.CONTAINERTYPES.register("alloy_furnace", () -> IForgeContainerType.create(
          EssentialsAlloyFurnaceContainer::new));
}
