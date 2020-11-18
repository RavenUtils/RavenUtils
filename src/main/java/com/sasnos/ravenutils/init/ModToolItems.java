package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.*;
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
  // todo move sword to Combat module
  public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
      () -> new SwordItem(ModItemTier.COPPER, 3, -2.4F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));
  public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
      () -> new ShovelItem(ModItemTier.COPPER, 1.5F, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));
  public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
      () -> new AxeItem(ModItemTier.COPPER, 7, -3.2F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));
  public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
      () -> new PickaxeItem(ModItemTier.COPPER, 1, -2.8F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));
  public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
      () -> new HoeItem(ModItemTier.COPPER, -1, -2F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));

  // bronze
  // todo move sword to Combat module
  public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
      () -> new SwordItem(ModItemTier.BRONZE, 2, -2.4F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
      () -> new ShovelItem(ModItemTier.BRONZE, 0.5F, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
      () -> new AxeItem(ModItemTier.BRONZE, 5, -3.1F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
      () -> new PickaxeItem(ModItemTier.BRONZE, 0, -2.8F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
      () -> new HoeItem(ModItemTier.BRONZE, -3, -1F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));

  // silver
  // todo move sword to Combat module
  public static final RegistryObject<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword",
      () -> new SwordItem(ModItemTier.SILVER, 1, -2.4F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<ShovelItem> SILVER_SHOVEL = ITEMS.register("silver_shovel",
      () -> new ShovelItem(ModItemTier.SILVER, -0.5F, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<AxeItem> SILVER_AXE = ITEMS.register("silver_axe",
      () -> new AxeItem(ModItemTier.SILVER, 4, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<PickaxeItem> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
      () -> new PickaxeItem(ModItemTier.SILVER, -1, -2.8F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<HoeItem> SILVER_HOE = ITEMS.register("silver_hoe",
      () -> new HoeItem(ModItemTier.SILVER, -2, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));

  // steel
  // todo move sword to Combat module
  public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
      () -> new SwordItem(ModItemTier.STEEL, 2, -2.4F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
      () -> new ShovelItem(ModItemTier.STEEL, 0.5F, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
      () -> new AxeItem(ModItemTier.STEEL, 4, -3F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
      () -> new PickaxeItem(ModItemTier.STEEL, 0, -0.8F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));
  public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
      () -> new HoeItem(ModItemTier.STEEL, -4, 0, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.UNCOMMON)));

  // mytherine
  // todo move sword to Combat module
  public static final RegistryObject<SwordItem> MYTHERINE_SWORD = ITEMS.register("mytherine_sword",
      () -> new SwordItem(ModItemTier.MYTHERINE, 9, 1.5F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.EPIC)));
  public static final RegistryObject<ShovelItem> MYTHERINE_SHOVEL = ITEMS.register("mytherine_shovel",
      () -> new ShovelItem(ModItemTier.MYTHERINE, 2, 0, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.EPIC)));
  public static final RegistryObject<AxeItem> MYTHERINE_AXE = ITEMS.register("mytherine_axe",
      () -> new AxeItem(ModItemTier.MYTHERINE, 5, 1, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.EPIC)));
  public static final RegistryObject<PickaxeItem> MYTHERINE_PICKAXE = ITEMS.register("mytherine_pickaxe",
      () -> new PickaxeItem(ModItemTier.MYTHERINE, 6, 2, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.EPIC)));
  public static final RegistryObject<HoeItem> MYTHERINE_HOE = ITEMS.register("mytherine_hoe",
      () -> new HoeItem(ModItemTier.MYTHERINE, 1, 0, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.EPIC)));

  // hammers & knives
  public static final RegistryObject<Item> HAMMER_STONE = ITEMS.register("hammer_stone",
      () -> new Hammer(64, Rarity.COMMON));
  public static final RegistryObject<Item> HAMMER_IRON = ITEMS.register("hammer_iron",
      () -> new Hammer(256, Rarity.COMMON));
  public static final RegistryObject<Item> HAMMER_OBSIDIAN = ITEMS.register("hammer_obsidian",
      () -> new Hammer(1024, Rarity.UNCOMMON));
  public static final RegistryObject<Item> KNIFE_FLINT = ITEMS.register("knife_flint",
      () -> new Knife(32, Rarity.COMMON));
  public static final RegistryObject<Item> KNIFE_IRON = ITEMS.register("knife_iron",
      () -> new Knife(64, Rarity.COMMON));
  public static final RegistryObject<Item> KNIFE_DIAMOND = ITEMS.register("knife_diamond",
      () -> new Knife(1024, Rarity.UNCOMMON));

  // @todo implement texture and item rendering (#Atlas #Stitching)
  public static final RegistryObject<ShieldItem> MYTHERINE_SHIELD = ITEMS.register("mytherine_shield",
      () -> new ShieldItem(new Item.Properties().defaultMaxDamage(24000).group(RavenUtils.TAB)));

  // @todo make Vanilla bucket (BUCKET_IRON below) breakable!
  public static final RegistryObject<Item> BUCKET_IRON_LIMEWATER = ITEMS.register("bucket_iron_limewater",
      () -> new BucketItem(ModFluids.LIMEWATER::get, (new Item.Properties())
          .containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
  public static final RegistryObject<Item> BUCKET_IRON_TANNIN = ITEMS.register("bucket_iron_tannin",
      () -> new BucketItem(ModFluids.TANNIN::get, (new Item.Properties())
          .containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));

  // wooden buckets
  public static final RegistryObject<Item> BUCKET_WOOD = ITEMS.register("bucket_wood",
      () -> new Bucket(() -> Fluids.EMPTY, ItemStack.EMPTY.getItem(), 32));
  public static final RegistryObject<Item> BUCKET_WOOD_WATER = ITEMS.register("bucket_wood_water",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.BUCKET_WOOD.get(), 32));
  public static final RegistryObject<Item> BUCKET_WOOD_LIMEWATER = ITEMS.register("bucket_wood_limewater",
      () -> new Bucket(ModFluids.LIMEWATER::get, ModToolItems.BUCKET_WOOD.get(), 32));
  public static final RegistryObject<Item> BUCKET_WOOD_TANNIN = ITEMS.register("bucket_wood_tannin",
      () -> new Bucket(ModFluids.TANNIN::get, ModToolItems.BUCKET_WOOD.get(), 32));

  // clay buckets
  public static final RegistryObject<Item> BUCKET_CLAY = ITEMS.register("bucket_clay",
      () -> new Bucket(() -> Fluids.EMPTY, ItemStack.EMPTY.getItem(), 32));
  public static final RegistryObject<Item> BUCKET_CLAY_WATER = ITEMS.register("bucket_clay_water",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.BUCKET_CLAY.get(), 64));
  public static final RegistryObject<Item> BUCKET_CLAY_LIMEWATER = ITEMS.register("bucket_clay_limewater",
      () -> new Bucket(ModFluids.LIMEWATER::get, ModToolItems.BUCKET_CLAY.get(), 64));
  public static final RegistryObject<Item> BUCKET_CLAY_TANNIN = ITEMS.register("bucket_clay_tannin",
      () -> new Bucket(ModFluids.TANNIN::get, ModToolItems.BUCKET_CLAY.get(), 64));

  // mytherine buckets
  public static final RegistryObject<Item> BUCKET_MYTHERINE = ITEMS.register("bucket_mytherine",
      () -> new BucketItem(() -> Fluids.EMPTY, (new Item.Properties()).maxStackSize(16).group(RavenUtils.TAB)));
  public static final RegistryObject<Item> BUCKET_MYTHERINE_WATER = ITEMS.register("bucket_mytherine_water",
      () -> new Bucket(() -> Fluids.WATER, ModToolItems.BUCKET_MYTHERINE.get(), 6400000));
  public static final RegistryObject<Item> BUCKET_MYTHERINE_LIMEWATER = ITEMS.register("bucket_mytherine_limewater",
      () -> new Bucket(ModFluids.LIMEWATER::get, ModToolItems.BUCKET_MYTHERINE.get(), 6400000));
  public static final RegistryObject<Item> BUCKET_MYTHERINE_TANNIN = ITEMS.register("bucket_mytherine_tannin",
      () -> new Bucket(ModFluids.TANNIN::get, ModToolItems.BUCKET_MYTHERINE.get(), 6400000));

  // shears (maxDmg iron: 238)
  public static final RegistryObject<ShearsItem> SHEARS_COPPER = ITEMS.register("shears_copper",
      () -> new ShearsItem(new Item.Properties().maxDamage(120).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_BRONZE = ITEMS.register("shears_bronze",
      () -> new ShearsItem(new Item.Properties().maxDamage(520).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_SILVER = ITEMS.register("shears_silver",
      () -> new ShearsItem(new Item.Properties().maxDamage(380).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_STEEL = ITEMS.register("shears_steel",
      () -> new ShearsItem(new Item.Properties().maxDamage(2048).group(RavenUtils.TAB)));

  public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
      () -> new MortarAndPestle(256));
  public static final RegistryObject<Item> FIRESTARTER = ITEMS.register("firestarter",
      () -> new Firestarter(6));
  public static final RegistryObject<Item> CHISEL_IRON = ITEMS.register("chisel_iron",
      () -> new Chisel(256));
  public static final RegistryObject<Item> CHISEL_STEEL = ITEMS.register("chisel_steel",
      () -> new Chisel(1024));
  public static final RegistryObject<Item> CHISEL_DIAMOND = ITEMS.register("chisel_diamond",
      () -> new Chisel(4096));
  public static final RegistryObject<Item> SOAP = ITEMS.register("soap",
      () -> new Soap(32));
  public static final RegistryObject<Item> SLEEPING_BAG = ITEMS.register("sleeping_bag",
      () -> new SleepingBag(128));
}
