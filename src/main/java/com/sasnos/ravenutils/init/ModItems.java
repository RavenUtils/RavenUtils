package com.sasnos.ravenutils.init;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.Ashes;
import com.sasnos.ravenutils.items.BlackCoal;
import com.sasnos.ravenutils.items.ItemBase;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
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

  public static final RegistryObject<Item> UNFIRED_CLAY_BUCKET = ITEMS.register("unfired_clay_bucket",
      () -> new Item(new Item.Properties().maxStackSize(16).group(RavenUtils.TAB)));

  public static final RegistryObject<Item> CRIMWOOD_BOAT = ITEMS.register("crimwood_boat",
      () -> new BoatItem(BoatEntity.Type.ACACIA, new Item.Properties().group(RavenUtils.TAB).isImmuneToFire()));
  public static final RegistryObject<Item> CRIMWOOD_SIGN_ITEM = ITEMS.register("crimwood_sign",
      () -> new SignItem((new Item.Properties()).group(RavenUtils.TAB), ModBlocks.CRIMWOOD_SIGN.get(), ModBlocks.CRIMWOOD_WALL_SIGN.get()));
}