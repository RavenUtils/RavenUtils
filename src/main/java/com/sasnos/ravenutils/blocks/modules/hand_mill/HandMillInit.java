package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.BlockItemBase;
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

public class HandMillInit {

  public static final RegistryObject<Block> HAND_MILL = ModBlocks.BLOCKS.register("hand_mill", HandMill::new);
  public static final RegistryObject<Item> HAND_MILL_ITEM = ModBlockItems.ITEMS.register("hand_mill",
      () -> new BlockItemBase(HAND_MILL.get()));

  public static final RegistryObject<Block> MILLSTONE = ModBlocks.BLOCKS.register("mill_stone", Millstone::new);
  public static final RegistryObject<Item> MILLSTONE_ITEM = ModBlockItems.ITEMS.register("mill_stone",
      () -> new BlockItem(MILLSTONE.get(), new Item.Properties().group(RavenUtils.TAB).maxDamage(20)));

  public static final RegistryObject<TileEntityType<HandMillTileEntity>> HAND_MILL_TILE_ENTITY = ModTileEntities.TILE_ENTITY.register("hand_mill",
      () -> TileEntityType.Builder
          .create(HandMillTileEntity::new, HAND_MILL.get())
          .build(null));

  public static final RegistryObject<TileEntityType<HandMillTileEntity>> MILLSTONE_TILE_ENTITY = ModTileEntities.TILE_ENTITY.register("mill_stone",
      () -> TileEntityType.Builder
          .create(HandMillTileEntity::new, MILLSTONE.get())
          .build(null));

  public static final RegistryObject<ContainerType<HandMillContainer>> HAND_MILL_CONTAINER = ModContainer.CONTAINER_TYPES.register("hand_mill",
      () -> IForgeContainerType.create(
          HandMillContainer::new));
}
