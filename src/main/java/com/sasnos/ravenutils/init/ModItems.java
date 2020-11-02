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

  public static final RegistryObject<Item> FRESH_HIDE = ITEMS.register("hide_fresh", ItemBase::new);
  public static final RegistryObject<Item> SCRAPED_HIDE = ITEMS.register("hide_scraped", ItemBase::new);
  public static final RegistryObject<Item> LIMED_HIDE = ITEMS.register("hide_limed", ItemBase::new);
  public static final RegistryObject<Item> TANNED_HIDE = ITEMS.register("hide_tanned", ItemBase::new);

  public static final RegistryObject<Item> UNFIRED_CLAY_BUCKET = ITEMS.register("unfired_clay_bucket",
      () -> new Item(new Item.Properties().maxStackSize(16).group(RavenUtils.TAB)));

  public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("coin_copper", ItemBase::new);
  public static final RegistryObject<Item> SILVER_COIN = ITEMS.register("coin_silver", ItemBase::new);
  public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("coin_gold", ItemBase::new);

  public static final RegistryObject<Item> CRIMWOOD_BOAT = ITEMS.register("crimwood_boat",
      () -> new BoatItem(BoatEntity.Type.ACACIA, new Item.Properties().group(RavenUtils.TAB).isImmuneToFire()));
  public static final RegistryObject<Item> CRIMWOOD_SIGN_ITEM = ITEMS.register("crimwood_sign",
      () -> new SignItem((new Item.Properties()).group(RavenUtils.TAB).isImmuneToFire(), ModBlocks.CRIMWOOD_SIGN.get(), ModBlocks.CRIMWOOD_WALL_SIGN.get()));
}