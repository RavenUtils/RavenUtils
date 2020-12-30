package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.Bag;
import com.sasnos.ravenutils.items.Bedroll;
import com.sasnos.ravenutils.items.Bucket;
import com.sasnos.ravenutils.items.Chisel;
import com.sasnos.ravenutils.items.Firestarter;
import com.sasnos.ravenutils.items.Hammer;
import com.sasnos.ravenutils.items.Handsaw;
import com.sasnos.ravenutils.items.Knife;
import com.sasnos.ravenutils.items.MilkBucket;
import com.sasnos.ravenutils.items.Mortar;
import com.sasnos.ravenutils.items.SewingNeedle;
import com.sasnos.ravenutils.items.Soap;
import com.sasnos.ravenutils.items.Tongs;
import com.sasnos.ravenutils.utils.enums.Bags;
import com.sasnos.ravenutils.utils.enums.ModItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModToolItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  public static final DeferredRegister<Item> VANILLA_ITEM_OVERRIDE =
      DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

  // default tools
  public static final RegistryObject<Item> FLINT_AXE = ITEMS.register("flint_axe",
      () -> new AxeItem(ModItemTier.FLINT, 2, -5F, new Item.Properties()
          .group(RavenUtils.TAB).rarity(Rarity.COMMON)));

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

  // hammers
  public static final RegistryObject<Item> HAMMER_STONE = ITEMS.register("hammer_stone",
      () -> new Hammer(64, Rarity.COMMON, 1.5F, -3.0F, ItemTier.STONE));
  public static final RegistryObject<Item> HAMMER_IRON = ITEMS.register("hammer_iron",
      () -> new Hammer(256, Rarity.COMMON, 1.5F, -3.0F, ItemTier.IRON));
  public static final RegistryObject<Item> HAMMER_OBSIDIAN = ITEMS.register("hammer_obsidian",
      () -> new Hammer(1024, Rarity.UNCOMMON, 3, -2.4F, ItemTier.DIAMOND));

  // tongs
  public static final RegistryObject<Item> TONGS_WOOD = ITEMS.register("tongs_wooden",
      () -> new Tongs(32, Rarity.COMMON));
  public static final RegistryObject<Item> TONGS_IRON = ITEMS.register("tongs_iron",
      () -> new Tongs(256, Rarity.COMMON));
  public static final RegistryObject<Item> TONGS_STEEL = ITEMS.register("tongs_steel",
      () -> new Tongs(512, Rarity.UNCOMMON));

  // handsaws
  public static final RegistryObject<Item> HANDSAW_IRON = ITEMS.register("handsaw_iron",
      () -> new Handsaw(256, Rarity.COMMON));
  public static final RegistryObject<Item> HANDSAW_STEEL = ITEMS.register("handsaw_steel",
      () -> new Handsaw(512, Rarity.UNCOMMON));

  // knives
  public static final RegistryObject<Item> KNIFE_FLINT = ITEMS.register("knife_flint",
      () -> new Knife(32, Rarity.COMMON));
  public static final RegistryObject<Item> KNIFE_IRON = ITEMS.register("knife_iron",
      () -> new Knife(256, Rarity.COMMON));
  public static final RegistryObject<Item> KNIFE_STEEL = ITEMS.register("knife_steel",
      () -> new Knife(512, Rarity.UNCOMMON));

  // wooden buckets
  public static final RegistryObject<Item> BUCKET_WOOD = ITEMS.register("bucket_wood",
          () -> new Bucket(ItemStack.EMPTY.getItem(), 32, ModToolItems.BUCKET_WOOD_MILK));
  public static final RegistryObject<Item> BUCKET_WOOD_MILK = ITEMS.register("bucket_wood_milk",
          () -> new MilkBucket(ModToolItems.BUCKET_WOOD.get(), 32));

  // clay buckets
  public static final RegistryObject<Item> BUCKET_CLAY = ITEMS.register("bucket_clay",
          () -> new Bucket(ItemStack.EMPTY.getItem(), 64, ModToolItems.BUCKET_CLAY_MILK));
  public static final RegistryObject<Item> BUCKET_CLAY_MILK = ITEMS.register("bucket_clay_milk",
          () -> new MilkBucket(ModToolItems.BUCKET_CLAY.get(), 64));

  // crimwood buckets
  public static final RegistryObject<Item> BUCKET_CRIMWOOD = ITEMS.register("bucket_crimwood",
          () -> new Bucket(ItemStack.EMPTY.getItem(), 0, ModToolItems.BUCKET_CRIMWOOD_MILK));
  public static final RegistryObject<Item> BUCKET_CRIMWOOD_MILK = ITEMS.register("bucket_crimwood_milk",
          () -> new MilkBucket(ModToolItems.BUCKET_CRIMWOOD.get(), 0));

  // iron bucket (Vanilla override)
  //  public static final RegistryObject<Item> BUCKET_IRON = VANILLA_ITEM_OVERRIDE.register(Items.BUCKET.getRegistryName().getPath(),
  //      () -> new Bucket(ItemStack.EMPTY.getItem(), 512, ModToolItems.BUCKET_IRON_MILK::get));
  //  public static final RegistryObject<Item> BUCKET_IRON_MILK = VANILLA_ITEM_OVERRIDE.register(Items.MILK_BUCKET.getRegistryName().getPath(),
  //      () -> new MilkBucket(ModToolItems.BUCKET_IRON.get(), 512));


  public static final RegistryObject<Item> BUCKET_IRON_LIMEWATER = ITEMS.register("bucket_iron_limewater",
          () -> new BucketItem(ModFluids.LIMEWATER, (new Item.Properties())
                  .containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));
  public static final RegistryObject<Item> BUCKET_IRON_TANNIN = ITEMS.register("bucket_iron_tannin",
          () -> new BucketItem(ModFluids.TANNIN, (new Item.Properties())
                  .containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC)));

  // shears (maxDmg iron: 238)
  public static final RegistryObject<ShearsItem> SHEARS_COPPER = ITEMS.register("shears_copper",
      () -> new ShearsItem(new Item.Properties().maxDamage(120).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_BRONZE = ITEMS.register("shears_bronze",
      () -> new ShearsItem(new Item.Properties().maxDamage(520).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_SILVER = ITEMS.register("shears_silver",
      () -> new ShearsItem(new Item.Properties().maxDamage(380).group(RavenUtils.TAB)));
  public static final RegistryObject<ShearsItem> SHEARS_STEEL = ITEMS.register("shears_steel",
      () -> new ShearsItem(new Item.Properties().maxDamage(512).group(RavenUtils.TAB)));

  // mortars
  public static final RegistryObject<Item> MORTAR_WOOD = ITEMS.register("mortar_wood",
      () -> new Mortar(128));
  public static final RegistryObject<Item> MORTAR_STONE = ITEMS.register("mortar_stone",
      () -> new Mortar(512));

  // chisels
  public static final RegistryObject<Item> CHISEL_IRON = ITEMS.register("chisel_iron",
      () -> new Chisel(256));
  public static final RegistryObject<Item> CHISEL_STEEL = ITEMS.register("chisel_steel",
      () -> new Chisel(512));
  public static final RegistryObject<Item> CHISEL_DIAMOND = ITEMS.register("chisel_diamond",
      () -> new Chisel(2048));

  // sewing kits
  public static final RegistryObject<Item> SEWING_NEEDLE_BONE = ITEMS.register("sewing_needle_bone",
      () -> new SewingNeedle(64));
  public static final RegistryObject<Item> SEWING_NEEDLE_IRON = ITEMS.register("sewing_needle_iron",
      () -> new SewingNeedle(256));
  public static final RegistryObject<Item> SEWING_NEEDLE_STEEL = ITEMS.register("sewing_needle_steel",
      () -> new SewingNeedle(512));

  // bags
  public static final RegistryObject<Item> BAG_CLOTH = ITEMS.register("bag_cloth",
      () -> new Bag(new Item.Properties(), Bags.CLOTH));
  public static final RegistryObject<Item> BAG_LEATHER = ITEMS.register("bag_leather",
      () -> new Bag(new Item.Properties(), Bags.LEATHER));

  // miscellaneous
  public static final RegistryObject<Item> FIRESTARTER = ITEMS.register("firestarter",
      () -> new Firestarter(6));
  public static final RegistryObject<Item> SOAP = ITEMS.register("soap",
      () -> new Soap(32));
  public static final RegistryObject<Item> BEDROLL = ITEMS.register("bedroll",
      () -> new Bedroll(128));
}
