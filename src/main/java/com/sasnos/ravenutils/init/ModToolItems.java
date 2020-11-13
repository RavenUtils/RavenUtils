package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.Bucket;
import com.sasnos.ravenutils.items.Hammer;
import com.sasnos.ravenutils.items.Knife;
import com.sasnos.ravenutils.items.MortarAndPestle;
import com.sasnos.ravenutils.util.enums.ModItemTier;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModToolItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // default tools
  // copper

  // bronze

  // silver

  // steel

  // mytherine
  // todo remove sword and add with Combat module
  public static final RegistryObject<SwordItem> MYTHERINE_SWORD = ITEMS.register("mytherine_sword",
      () -> new SwordItem(ModItemTier.MYTHERINE, 9, -3.4F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ShovelItem> MYTHERINE_SHOVEL = ITEMS.register("mytherine_shovel",
      () -> new ShovelItem(ModItemTier.MYTHERINE, 2, -2.8F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<AxeItem> MYTHERINE_AXE = ITEMS.register("mytherine_axe",
      () -> new AxeItem(ModItemTier.MYTHERINE, 5, -2.4F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<PickaxeItem> MYTHERINE_PICKAXE = ITEMS.register("mytherine_pickaxe",
      () -> new PickaxeItem(ModItemTier.MYTHERINE, 6, -2.0F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<HoeItem> MYTHERINE_HOE = ITEMS.register("mytherine_hoe",
      () -> new HoeItem(ModItemTier.MYTHERINE, 1, -2.8F, new Item.Properties().group(RavenUtils.TAB)));

  // hammers & knives
  public static final RegistryObject<Item> HAMMER_STONE = ITEMS.register("hammer_stone",
      () -> new Hammer(64));
  public static final RegistryObject<Item> HAMMER_IRON = ITEMS.register("hammer_iron",
      () -> new Hammer(256));
  public static final RegistryObject<Item> HAMMER_OBSIDIAN = ITEMS.register("hammer_obsidian",
      () -> new Hammer(1024));
  public static final RegistryObject<Item> KNIFE_FLINT = ITEMS.register("knife_flint",
      () -> new Knife(32));
  public static final RegistryObject<Item> KNIFE_IRON = ITEMS.register("knife_iron",
      () -> new Knife(64));
  public static final RegistryObject<Item> KNIFE_DIAMOND = ITEMS.register("knife_diamond",
      () -> new Knife(1024));

  // @todo implement texture and item rendering (#Atlas #Stitching)
  public static final RegistryObject<ShieldItem> MYTHERINE_SHIELD = ITEMS.register("mytherine_shield",
      () -> new ShieldItem(new Item.Properties().defaultMaxDamage(24000).group(RavenUtils.TAB)));

  // @todo make Vanilla bucket (BUCKET_IRON below) breakable!
  public static final RegistryObject<Item> BUCKET_IRON_LIMEWATER = ITEMS.register("bucket_iron_limewater",
      () -> new BucketItem(ModFluids.LIMEWATER::get, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
  public static final RegistryObject<Item> BUCKET_IRON_TANNIN = ITEMS.register("bucket_iron_tannin",
      () -> new BucketItem(ModFluids.TANNIN::get, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));

  // wooden buckets
  public static final RegistryObject<Item> BUCKET_WOOD = ITEMS.register("bucket_wood",
      () -> new BucketItem(() -> Fluids.EMPTY, (new Item.Properties()).maxStackSize(16).group(RavenUtils.TAB)));
  public static final RegistryObject<Item> BUCKET_WOOD_WATER = ITEMS.register("bucket_wood_water",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.BUCKET_WOOD.get(), 32));
  public static final RegistryObject<Item> BUCKET_WOOD_LIMEWATER = ITEMS.register("bucket_wood_limewater",
      () -> new Bucket(ModFluids.LIMEWATER::get, ModToolItems.BUCKET_WOOD.get(), 32));
  public static final RegistryObject<Item> BUCKET_WOOD_TANNIN = ITEMS.register("bucket_wood_tannin",
      () -> new Bucket(ModFluids.TANNIN::get, ModToolItems.BUCKET_WOOD.get(), 32));

  // clay buckets
  public static final RegistryObject<Item> BUCKET_CLAY = ITEMS.register("bucket_clay",
      () -> new BucketItem(() -> Fluids.EMPTY, (new Item.Properties()).maxStackSize(16).group(RavenUtils.TAB)));
  public static final RegistryObject<Item> BUCKET_CLAY_WATER = ITEMS.register("bucket_clay_water",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.BUCKET_CLAY.get(), 32));
  public static final RegistryObject<Item> BUCKET_CLAY_LIMEWATER = ITEMS.register("bucket_clay_limewater",
      () -> new Bucket(ModFluids.LIMEWATER::get, ModToolItems.BUCKET_CLAY.get(), 32));
  public static final RegistryObject<Item> BUCKET_CLAY_TANNIN = ITEMS.register("bucket_clay_tannin",
      () -> new Bucket(ModFluids.TANNIN::get, ModToolItems.BUCKET_CLAY.get(), 32));

  public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
      () -> new MortarAndPestle(256));
}
