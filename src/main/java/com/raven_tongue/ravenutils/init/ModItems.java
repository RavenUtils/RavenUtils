package com.raven_tongue.ravenutils.init;

import com.raven_tongue.ravenutils.RavenUtils;
import com.raven_tongue.ravenutils.blocks.BlockItemBase;
import com.raven_tongue.ravenutils.blocks.CrimwoodLeaves;
import com.raven_tongue.ravenutils.items.Ashes;
import com.raven_tongue.ravenutils.items.Hammer;
import com.raven_tongue.ravenutils.items.ItemBase;
import com.raven_tongue.ravenutils.util.enums.ModArmorMaterial;
import com.raven_tongue.ravenutils.util.enums.ModItemTier;
import net.minecraft.block.Block;
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

  // Foods
  // public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple", PoisonApple::new);

  // do not consume container?
  // public static final Item MILK_BUCKET = register("milk_bucket", new MilkBucketItem((new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(ItemGroup.MISC)));

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

  public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer", Hammer::new);
  public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer", Hammer::new);

  // fix textures
  // public static final RegistryObject<ShieldItem> RAVENINE_SHIELD = ITEMS.register("ravenine_shield", RavenineShield::new);

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
  public static final RegistryObject<Item> CRIMLEAF_ITEM = ITEMS.register("crimleaf",
      () -> new BlockItemBase(ModBlocks.CRIMLEAF.get()));

  public static final RegistryObject<Item> CRIMWOOD_SAPLING_ITEM = ITEMS.register("crimwood_sapling",
      () -> new BlockItemBase(ModBlocks.CRIMWOOD_SAPLING.get()));
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
}