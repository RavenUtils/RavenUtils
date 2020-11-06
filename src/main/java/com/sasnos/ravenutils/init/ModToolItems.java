package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.Bucket;
import com.sasnos.ravenutils.items.Hammer;
import com.sasnos.ravenutils.items.Knife;
import com.sasnos.ravenutils.util.enums.ModItemTier;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModToolItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // default tools
  public static final RegistryObject<SwordItem> RAVENINE_SWORD = ITEMS.register("ravenine_sword",
      () -> new SwordItem(ModItemTier.RAVENINE, 9, -3.4F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ShovelItem> RAVENINE_SHOVEL = ITEMS.register("ravenine_shovel",
      () -> new ShovelItem(ModItemTier.RAVENINE, 2, -2.8F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<AxeItem> RAVENINE_AXE = ITEMS.register("ravenine_axe",
      () -> new AxeItem(ModItemTier.RAVENINE, 5, -2.4F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<PickaxeItem> RAVENINE_PICKAXE = ITEMS.register("ravenine_pickaxe",
      () -> new PickaxeItem(ModItemTier.RAVENINE, 6, -2.0F, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<HoeItem> RAVENINE_HOE = ITEMS.register("ravenine_hoe",
      () -> new HoeItem(ModItemTier.RAVENINE, 1, -2.8F, new Item.Properties().group(RavenUtils.TAB)));

  // hammers & knives
  public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
      () -> new Hammer(64));
  public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer",
      () -> new Hammer(1024));
  public static final RegistryObject<Item> IRON_KNIFE = ITEMS.register("iron_knife",
      () -> new Knife(64));
  public static final RegistryObject<Item> DIAMOND_KNIFE = ITEMS.register("diamond_knife",
      () -> new Knife(1024));

  // @todo implement texture and item rendering (#Atlas #Stitching)
  public static final RegistryObject<ShieldItem> RAVENINE_SHIELD = ITEMS.register("ravenine_shield",
      () -> new ShieldItem(new Item.Properties().defaultMaxDamage(24000).group(RavenUtils.TAB)));
  //

  public static final RegistryObject<Item> LIMEWATER_BUCKET = ITEMS.register("limewater_bucket",
      () -> new BucketItem(() -> ModFluids.LIMEWATER, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
  public static final RegistryObject<Item> TANNIN_BUCKET = ITEMS.register("tannin_bucket",
      () -> new BucketItem(() -> ModFluids.TANNIN, (new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));

  // wooden buckets
  public static final RegistryObject<Item> WOOD_BUCKET = ITEMS.register("wood_bucket",
      () -> new BucketItem(() -> Fluids.EMPTY, (new Item.Properties()).maxStackSize(16).group(RavenUtils.TAB)));
  /*
  public static final RegistryObject<Item> WOOD_WATER_BUCKET = ITEMS.register("wood_water_bucket",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.WOOD_BUCKET.get(), 32));
  public static final RegistryObject<Item> WOOD_LIMEWATER_BUCKET = ITEMS.register("wood_limewater_bucket",
      () -> new Bucket(() -> ModFluids.LIMEWATER, ModToolItems.WOOD_BUCKET.get(), 32));
  public static final RegistryObject<Item> WOOD_TANNIN_BUCKET = ITEMS.register("wood_tannin_bucket",
      () -> new Bucket(() -> ModFluids.TANNIN, ModToolItems.WOOD_BUCKET.get(), 32));
  */

  // clay buckets
  public static final RegistryObject<Item> CLAY_BUCKET = ITEMS.register("clay_bucket",
      () -> new BucketItem(Fluids.EMPTY, (new Item.Properties()).maxStackSize(16).group(RavenUtils.TAB)));
  /*
  public static final RegistryObject<Item> CLAY_WATER_BUCKET = ITEMS.register("clay_water_bucket",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.CLAY_BUCKET.get(), 32));
  public static final RegistryObject<Item> CLAY_LIMEWATER_BUCKET = ITEMS.register("clay_limewater_bucket",
      () -> new Bucket(() -> ModFluids.LIMEWATER, ModToolItems.CLAY_BUCKET.get(), 32));
  public static final RegistryObject<Item> CLAY_TANNIN_BUCKET = ITEMS.register("clay_tannin_bucket",
      () -> new Bucket(() -> ModFluids.TANNIN, ModToolItems.CLAY_BUCKET.get(), 32));
  */
}
