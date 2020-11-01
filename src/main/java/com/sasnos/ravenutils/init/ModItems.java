package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.BlockItemBase;
import com.sasnos.ravenutils.blocks.blockitems.BlackCoalBlockItem;
import com.sasnos.ravenutils.items.*;
import com.sasnos.ravenutils.util.enums.ModArmorMaterial;
import com.sasnos.ravenutils.util.enums.ModItemTier;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // Items
  public static final RegistryObject<Item> INK_BOTTLE = ITEMS.register("ink_bottle",
      () -> new Item(new Item.Properties().group(RavenUtils.TAB).maxStackSize(16)));
  public static final RegistryObject<Item> ASHES = ITEMS.register("ashes", Ashes::new);
  public static final RegistryObject<Item> RAVENINE_INGOT = ITEMS.register("ravenine_ingot", ItemBase::new);
  public static final RegistryObject<Item> RAVENINE_NUGGET = ITEMS.register("ravenine_nugget", ItemBase::new);
  public static final RegistryObject<Item> SALT = ITEMS.register("stone_salt", ItemBase::new);
  public static final RegistryObject<Item> TALLOW = ITEMS.register("tallow", ItemBase::new);
  public static final RegistryObject<Item> RESIN_DROP = ITEMS.register("resin_drop", ItemBase::new);
  public static final RegistryObject<Item> RESIN_BALL = ITEMS.register("resin_ball", ItemBase::new);
  public static final RegistryObject<Item> RAVEN_EYE_GEM = ITEMS.register("raven_eye_gem", ItemBase::new);
  public static final RegistryObject<Item> BLACK_COAL = ITEMS.register("black_coal", BlackCoal::new);
  public static final RegistryObject<Item> LIME = ITEMS.register("lime", ItemBase::new);
  public static final RegistryObject<Item> LEATHER_STRIP = ITEMS.register("leather_strip", ItemBase::new);

  // public static final RegistryObject<Item> LLAMA_PELT = ITEMS.register("llama_pelt", ItemBase::new);                 // Large pelt
  // public static final RegistryObject<Item> PANDA_PELT = ITEMS.register("panda_pelt", ItemBase::new);                 // Large pelt
  // public static final RegistryObject<Item> POLAR_BEAR_PELT = ITEMS.register("polar_bear_pelt", ItemBase::new);       // Large pelt
  // public static final RegistryObject<Item> WOLF_PELT = ITEMS.register("wolf_pelt", ItemBase::new);                   // Medium pelt
  // public static final RegistryObject<Item> RABBIT_PELT = ITEMS.register("rabbit_pelt", ItemBase::new);               // Small pelt
  // public static final RegistryObject<Item> FOX_PELT = ITEMS.register("fox_pelt", ItemBase::new);                     // Small pelt
  // public static final RegistryObject<Item> CAT_PELT = ITEMS.register("cat_pelt", ItemBase::new);                     // Small pelt
  // public static final RegistryObject<Item> OCELOT_PELT = ITEMS.register("ocelot_pelt", ItemBase::new);               // Small pelt

  // public static final RegistryObject<Item> COW_HIDE = ITEMS.register("cow_hide", ItemBase::new);                     // Large hide
  // public static final RegistryObject<Item> MOOSHROOM_HIDE = ITEMS.register("mooshroom_hide", ItemBase::new);         // Large hide
  // public static final RegistryObject<Item> HORSE_HIDE = ITEMS.register("horse_hide", ItemBase::new);                 // Large hide
  // public static final RegistryObject<Item> MULE_HIDE = ITEMS.register("mule_hide", ItemBase::new);                   // Large hide
  // public static final RegistryObject<Item> DONKEY_HIDE = ITEMS.register("donkey_hide", ItemBase::new);               // Large hide
  // public static final RegistryObject<Item> PIG_HIDE = ITEMS.register("pig_hide", ItemBase::new);                     // Medium hide
  // public static final RegistryObject<Item> SHEEP_HIDE = ITEMS.register("sheep_hide", ItemBase::new);                 // Medium hide

  // Hide + knife = scraped hide + gelatin
  // public static final RegistryObject<Item> LARGE_SCRAPED_HIDE = ITEMS.register("large_scraped_hide", ItemBase::new);
  // public static final RegistryObject<Item> MEDIUM_SCRAPED_HIDE = ITEMS.register("medium_scraped_hide", ItemBase::new);
  // public static final RegistryObject<Item> SMALL_SCRAPED_HIDE = ITEMS.register("small_scraped_hide", ItemBase::new);

  // Scraped hide + limewater barrel
  // public static final RegistryObject<Item> LARGE_LIMED_HIDE = ITEMS.register("large_limed_hide", ItemBase::new);
  // public static final RegistryObject<Item> MEDIUM_LIMED_HIDE = ITEMS.register("medium_limed_hide", ItemBase::new);
  // public static final RegistryObject<Item> SMALL_LIMED_HIDE = ITEMS.register("small_limed_hide", ItemBase::new);

  // Limed hide + tannin barrel
  // public static final RegistryObject<Item> LARGE_TANNED_HIDE = ITEMS.register("large_tanned_hide", ItemBase::new);
  // public static final RegistryObject<Item> MEDIUM_TANNED_HIDE = ITEMS.register("medium_tanned_hide", ItemBase::new);
  // public static final RegistryObject<Item> SMALL_TANNED_HIDE = ITEMS.register("small_tanned_hide", ItemBase::new);

  // Tanned hide + drying rack
  // public static final RegistryObject<Item> LARGE_LEATHER = ITEMS.register("large_leather", ItemBase::new); // grid -> 8 leather
  // public static final RegistryObject<Item> MEDIUM_LEATHER = ITEMS.register("medium_leather", ItemBase::new); // grid -> 4 leather
  // Small leather = Minecraft leather

  // Axe (rmb) on oak log = stripped log + bark
  // public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark", ItemBase::new);

  // public static final RegistryObject<Item> UNFIRED_CLAY_BUCKET = ITEMS.register("unfired_clay_bucket", UnfiredClayBucket::new);
  // public static final RegistryObject<Item> CLAY_BUCKET = ITEMS.register("clay_bucket", ClayBucket::new);
  // public static final RegistryObject<Item> WOOD_BUCKET = ITEMS.register("wood_bucket", WoodBucket::new);

  // public static final RegistryObject<Item> LIMEWATER_BUCKET = ITEMS.register("limewater_bucket", LimewaterBucket::new);
  // public static final RegistryObject<Item> TANNIN_BUCKET = ITEMS.register("tannin_bucket", TanninBucket::new);

  public static final RegistryObject<Item> CRIMWOOD_BOAT = ITEMS.register("crimwood_boat",
      () -> new BoatItem(BoatEntity.Type.ACACIA, new Item.Properties().group(RavenUtils.TAB).isImmuneToFire()));
  public static final RegistryObject<Item> CRIMWOOD_SIGN_ITEM = ITEMS.register("crimwood_sign",
      () -> new SignItem((new Item.Properties()).group(RavenUtils.TAB), ModBlocks.CRIMWOOD_SIGN.get(), ModBlocks.CRIMWOOD_WALL_SIGN.get()));

  // Foods
  public static final RegistryObject<Item> RED_MEAT = ITEMS.register("red_meat", RedMeat::new);
  public static final RegistryObject<Item> COOKED_RED_MEAT = ITEMS.register("cooked_red_meat", CookedRedMeat::new);
  public static final RegistryObject<Item> PORKCHOP = ITEMS.register("porkchop", Porkchop::new);
  public static final RegistryObject<Item> POULTRY = ITEMS.register("poultry", Poultry::new);
  public static final RegistryObject<Item> COOKED_POULTRY = ITEMS.register("cooked_poultry", CookedPoultry::new);
  public static final RegistryObject<Item> MUTTON = ITEMS.register("mutton", Mutton::new);
  public static final RegistryObject<Item> RABBIT_MEAT = ITEMS.register("rabbit", Rabbit::new);
  public static final RegistryObject<Item> BUSHMEAT = ITEMS.register("bushmeat", Bushmeat::new);
  public static final RegistryObject<Item> COOKED_BUSHMEAT = ITEMS.register("cooked_bushmeat", CookedBushmeat::new);

  // Tools
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

  public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
      () -> new Hammer(64));
  public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer",
      () -> new Hammer(1024));
  public static final RegistryObject<Item> IRON_KNIFE = ITEMS.register("iron_knife",
      () -> new Knife(64));
  public static final RegistryObject<Item> DIAMOND_KNIFE = ITEMS.register("diamond_knife",
      () -> new Knife(1024));
  public static final RegistryObject<ShieldItem> RAVENINE_SHIELD = ITEMS.register("ravenine_shield",
      () -> new ShieldItem(new Item.Properties().defaultMaxDamage(24000).group(RavenUtils.TAB)));

  // Armor
  public static final RegistryObject<ArmorItem> RAVENINE_HELMET = ITEMS.register("ravenine_helmet",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.HEAD, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_CHESTPLATE = ITEMS.register("ravenine_chestplate",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.CHEST, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_LEGGINGS = ITEMS.register("ravenine_leggings",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.LEGS, new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<ArmorItem> RAVENINE_BOOTS = ITEMS.register("ravenine_boots",
      () -> new ArmorItem(ModArmorMaterial.RAVENINE, EquipmentSlotType.FEET, new Item.Properties().group(RavenUtils.TAB)));

  // Block Items
  public static final RegistryObject<Item> RAVENINE_ORE_ITEM = ITEMS.register("ravenine_ore",
      () -> new BlockItemBase(ModBlocks.RAVENINE_ORE.get()));
  public static final RegistryObject<Item> RAVENINE_BLOCK_ITEM = ITEMS.register("ravenine_block",
      () -> new BlockItemBase(ModBlocks.RAVENINE_BLOCK.get()));
  public static final RegistryObject<Item> FOSSIL_ORE_ITEM = ITEMS.register("fossil_ore",
      () -> new BlockItemBase(ModBlocks.FOSSIL_ORE.get()));
  public static final RegistryObject<Item> FOSSIL_DIRT_ITEM = ITEMS.register("fossil_dirt",
      () -> new BlockItemBase(ModBlocks.FOSSIL_DIRT.get()));
  public static final RegistryObject<Item> RAVEN_EYE_ORE_ITEM = ITEMS.register("raven_eye_ore",
      () -> new BlockItemBase(ModBlocks.RAVEN_EYE_ORE.get()));
  public static final RegistryObject<Item> RAVEN_EYE_BLOCK_ITEM = ITEMS.register("raven_eye_block",
      () -> new BlockItemBase(ModBlocks.RAVEN_EYE_BLOCK.get()));
  public static final RegistryObject<Item> SALT_ORE_ITEM = ITEMS.register("salt_ore",
      () -> new BlockItemBase(ModBlocks.SALT_ORE.get()));
  public static final RegistryObject<Item> SALT_BLOCK_ITEM = ITEMS.register("salt_block",
      () -> new BlockItemBase(ModBlocks.SALT_BLOCK.get()));
  public static final RegistryObject<Item> BLACK_COAL_ORE_ITEM = ITEMS.register("black_coal_ore",
      () -> new BlockItemBase(ModBlocks.BLACK_COAL_ORE.get()));
  public static final RegistryObject<Item> BLACK_COAL_BLOCK_ITEM = ITEMS.register("black_coal_block",
      () -> new BlackCoalBlockItem(ModBlocks.BLACK_COAL_BLOCK.get(), new Item.Properties().group(RavenUtils.TAB)));
  public static final RegistryObject<Item> LIMESTONE_ITEM = ITEMS.register("limestone",
      () -> new BlockItemBase(ModBlocks.LIMESTONE.get()));
  public static final RegistryObject<Item> RESIN_BLOCK_ITEM = ITEMS.register("resin_block",
      () -> new BlockItemBase(ModBlocks.RESIN_BLOCK.get()));
  public static final RegistryObject<Item> CRIMLEAF_ITEM = ITEMS.register("crimleaf",
      () -> new BlockItemBase(ModBlocks.CRIMLEAF.get()));
  public static final RegistryObject<Item> CRIMWOOD_SAPLING_ITEM = ITEMS.register("crimwood_sapling",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SAPLING.get()));
  public static final RegistryObject<Item> CRIMWOOD_ITEM = ITEMS.register("crimwood",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD.get()));
  public static final RegistryObject<Item> CRIMWOOD_LOG_ITEM = ITEMS.register("crimwood_log",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LOG.get()));
  public static final RegistryObject<Item> CRIMWOOD_LEAVES_ITEM = ITEMS.register("crimwood_leaves",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_LEAVES.get()));
  public static final RegistryObject<Item> CRIMWOOD_PLANKS_ITEM = ITEMS.register("crimwood_planks",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_PLANKS.get()));
  public static final RegistryObject<Item> CRIMWOOD_STAIRS_ITEM = ITEMS.register("crimwood_stairs",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_STAIRS.get()));
  public static final RegistryObject<Item> CRIMWOOD_SLAB_ITEM = ITEMS.register("crimwood_slab",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SLAB.get()));
  public static final RegistryObject<Item> CRIMWOOD_DOOR_ITEM = ITEMS.register("crimwood_door",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_DOOR.get()));
  public static final RegistryObject<Item> CRIMWOOD_TRAPDOOR_ITEM = ITEMS.register("crimwood_trapdoor",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_TRAPDOOR.get()));
  public static final RegistryObject<Item> CRIMWOOD_PRESSURE_PLATE_ITEM = ITEMS.register("crimwood_pressure_plate",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get()));
  public static final RegistryObject<Item> CRIMWOOD_FENCE_ITEM = ITEMS.register("crimwood_fence",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_FENCE.get()));
  public static final RegistryObject<Item> CRIMWOOD_FENCE_GATE_ITEM = ITEMS.register("crimwood_fence_gate",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_FENCE_GATE.get()));
  public static final RegistryObject<Item> CRIMWOOD_BUTTON = ITEMS.register("crimwood_button",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_BUTTON.get()));
}