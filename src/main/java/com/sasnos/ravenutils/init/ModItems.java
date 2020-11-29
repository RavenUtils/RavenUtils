package com.sasnos.ravenutils.init;


import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.items.*;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RavenUtils.MOD_ID);

  // Items
  public static final RegistryObject<Item> INK_BOTTLE = ITEMS.register("ink_bottle",
      () -> new Item(new Item.Properties().group(RavenUtils.TAB).maxStackSize(16)));
  public static final RegistryObject<Item> BLOOD_BOTTLE = ITEMS.register("blood_bottle",
      () -> new Item(new Item.Properties().group(RavenUtils.TAB).maxStackSize(16)));
  public static final RegistryObject<Item> ASH = ITEMS.register("ash", Ash::new);
  public static final RegistryObject<Item> SLAG = ITEMS.register("slag", Slag::new);
  public static final RegistryObject<Item> MYTHERINE_INGOT = ITEMS.register("mytherine_ingot", ItemBase::new);
  public static final RegistryObject<Item> MYTHERINE_NUGGET = ITEMS.register("mytherine_nugget", ItemBase::new);
  public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ItemBase::new);
  public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", ItemBase::new);
  public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", ItemBase::new);
  public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", ItemBase::new);
  public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", ItemBase::new);
  public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", ItemBase::new);
  public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", ItemBase::new);
  public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", ItemBase::new);
  public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", ItemBase::new);
  public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", ItemBase::new);
  public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", ItemBase::new);
  public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", ItemBase::new);
  public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", ItemBase::new);
  public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", ItemBase::new);
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ItemBase::new);
  public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", ItemBase::new);
  public static final RegistryObject<Item> COARSE_SALT = ITEMS.register("coarse_salt", ItemBase::new);
  public static final RegistryObject<Item> SALT = ITEMS.register("salt", ItemBase::new);
  public static final RegistryObject<Item> TALLOW = ITEMS.register("tallow", ItemBase::new);
  public static final RegistryObject<Item> RESIN_DROP = ITEMS.register("resin_drop", ItemBase::new);
  public static final RegistryObject<Item> RESIN_BALL = ITEMS.register("resin_ball", ItemBase::new);
  public static final RegistryObject<Item> RAVEN_EYE_GEM = ITEMS.register("raven_eye_gem", ItemBase::new);
  public static final RegistryObject<Item> RAVEN_EYE_DUST = ITEMS.register("raven_eye_dust", ItemBase::new);
  public static final RegistryObject<Item> BLACK_COAL = ITEMS.register("black_coal", BlackCoal::new);
  public static final RegistryObject<Item> PEAT = ITEMS.register("peat", Peat::new);
  public static final RegistryObject<Item> MUD_LUMP = ITEMS.register("mud_lump", ItemBase::new);
  public static final RegistryObject<Item> LIME = ITEMS.register("lime", ItemBase::new);
  public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", ItemBase::new);
  public static final RegistryObject<Item> NITER = ITEMS.register("niter", ItemBase::new);
  public static final RegistryObject<Item> SMALL_STONE = ITEMS.register("small_stone", ItemBase::new);
  public static final RegistryObject<Item> LEATHER_STRIP = ITEMS.register("leather_strip", ItemBase::new);
  public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust", ItemBase::new);
  public static final RegistryObject<Item> CHARCOAL_DUST = ITEMS.register("charcoal_dust", ItemBase::new);
  public static final RegistryObject<Item> QUARTZ_SAND = ITEMS.register("quartz_sand", ItemBase::new);
  public static final RegistryObject<Item> CLOTH = ITEMS.register("cloth", ItemBase::new);
  public static final RegistryObject<Item> PLANT_FIBRE = ITEMS.register("plant_fibre", ItemBase::new);
  public static final RegistryObject<Item> DRIED_PLANT_FIBRE = ITEMS.register("dried_plant_fibre", ItemBase::new);
  public static final RegistryObject<Item> PLANT_TWINE = ITEMS.register("plant_twine", ItemBase::new);
  public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin", ItemBase::new);
  public static final RegistryObject<Item> FLINT_SHARD = ITEMS.register("flint_shard", ItemBase::new);

  public static final RegistryObject<Item> HIDE_FRESH = ITEMS.register("hide_fresh", ItemBase::new);
  public static final RegistryObject<Item> HIDE_CURED = ITEMS.register("hide_cured", ItemBase::new);
  public static final RegistryObject<Item> HIDE_SCRAPED = ITEMS.register("hide_scraped", ItemBase::new);
  public static final RegistryObject<Item> HIDE_LIMED = ITEMS.register("hide_limed", ItemBase::new);
  public static final RegistryObject<Item> HIDE_TANNED = ITEMS.register("hide_tanned", ItemBase::new);

  public static final RegistryObject<Item> BUCKET_CLAY_UNFIRED = ITEMS.register("bucket_clay_unfired",
      () -> new Item(new Item.Properties().maxStackSize(16).group(RavenUtils.TAB)));

  public static final RegistryObject<Item> COIN_COPPER = ITEMS.register("coin_copper", ItemBase::new);
  public static final RegistryObject<Item> COIN_SILVER = ITEMS.register("coin_silver", ItemBase::new);
  public static final RegistryObject<Item> COIN_GOLD = ITEMS.register("coin_gold", ItemBase::new);

  /* public static final RegistryObject<Item> CRIMWOOD_BOAT = ITEMS.register("crimwood_boat",
      () -> new BoatItem(BoatEntity.Type.ACACIA, new Item.Properties().group(RavenUtils.TAB).isImmuneToFire())); */

  /* public static final RegistryObject<Item> CRIMWOOD_SIGN = ITEMS.register("crimwood_sign",
      () -> new SignItem((new Item.Properties())
      .group(RavenUtils.TAB).isImmuneToFire(), ModBlocks.CRIMWOOD_SIGN.get(), ModBlocks.CRIMWOOD_WALL_SIGN.get()));
  */
}