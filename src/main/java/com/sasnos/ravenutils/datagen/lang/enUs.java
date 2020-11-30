package com.sasnos.ravenutils.datagen.lang;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceInit;
import com.sasnos.ravenutils.blocks.modules.alloy_furnace.AlloyFurnaceTileEntity;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillInit;
import com.sasnos.ravenutils.blocks.modules.hand_mill.HandMillTileEntity;
import com.sasnos.ravenutils.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.LanguageProvider;

public class enUs extends LanguageProvider {

  public enUs(DataGenerator gen) {
    super(gen, RavenUtils.MOD_ID, "en_us");
  }

  @Override
  protected void addTranslations() {
    add(RavenUtils.TAB.getGroupName().getString(), "Raven Utils");

    // fluids
    add(ModFluids.LIMEWATER.get().getFluid().getAttributes().getTranslationKey(), "Limewater");
    add(ModFluids.TANNIN.get().getFluid().getAttributes().getTranslationKey(), "Tannin");

    // ore blocks
    add(ModBlocks.MYTHERINE_ORE.get(), "Mytherine Ore");
    add(ModBlocks.FOSSIL_ORE.get(), "Fossil Ore");
    add(ModBlocks.FOSSIL_DIRT.get(), "Fossil Dirt");
    add(ModBlocks.RAVEN_EYE_ORE.get(), "Raven Eye Ore");
    add(ModBlocks.SALT_ORE.get(), "Salt Ore");
    add(ModBlocks.BLACK_COAL_ORE.get(), "Black Coal Ore");
    add(ModBlocks.LIMESTONE_BLOCK.get(), "Limestone");
    add(ModBlocks.COPPER_ORE.get(), "Copper Ore");
    add(ModBlocks.TIN_ORE.get(), "Tin Ore");
    add(ModBlocks.ZINC_ORE.get(), "Zinc Ore");
    add(ModBlocks.SILVER_ORE.get(), "Silver Ore");
    add(ModBlocks.LEAD_ORE.get(), "Lead Ore");
    add(ModBlocks.SULFUR_ORE.get(), "Sulfur Ore");

    // material blocks
    add(ModBlocks.BLACK_COAL_BLOCK.get(), "Block of Black Coal");
    add(ModBlocks.SALT_BLOCK.get(), "Block of Salt");
    add(ModBlocks.RAVEN_EYE_BLOCK.get(), "Block of Raven Eye");
    add(ModBlocks.MYTHERINE_BLOCK.get(), "Block of Mytherine");
    add(ModBlocks.COPPER_BLOCK.get(), "Block of Copper");
    add(ModBlocks.TIN_BLOCK.get(), "Block of Tin");
    add(ModBlocks.ZINC_BLOCK.get(), "Block of Zinc");
    add(ModBlocks.BRONZE_BLOCK.get(), "Block of Bronze");
    add(ModBlocks.BRASS_BLOCK.get(), "Block of Brass");
    add(ModBlocks.SILVER_BLOCK.get(), "Block of Silver");
    add(ModBlocks.LEAD_BLOCK.get(), "Block of Lead");
    add(ModBlocks.STEEL_BLOCK.get(), "Block of Steel");
    add(ModBlocks.RESIN_BLOCK.get(), "Block of Resin");
    add(ModBlocks.GELATIN_BLOCK.get(), "Block of Gelatin");
    add(ModBlocks.PEAT_BLOCK.get(), "Block of Peat");

    // misc blocks
    add(ModBlocks.CANDLE.get(), "Candle");
    add(ModBlocks.STICK_GROUND.get(), "Stick");
    add(ModBlocks.STONE_GROUND.get(), "Stone");
    // add(ModBlocks.CHIMNEY.get(), "Chimney");
    // add(ModBlocks.CHIMNEY_END.get(), "Chimney End");

    // flowers & saplings
    add(ModBlocks.CRIMLEAF.get(), "Crimleaf");
    add(ModBlocks.CRIMWOOD_SAPLING.get(), "Crimwood Sapling");

    // crimwood blocks
    add(ModBlocks.CRIMWOOD.get(), "Crimwood");
    add(ModBlocks.CRIMWOOD_LOG.get(), "Crimwood Log");
    add(ModBlocks.CRIMWOOD_LOG_STRIPPED.get(), "Stripped Crimwood Log");
    add(ModBlocks.CRIMWOOD_LEAVES.get(), "Crimwood Leaves");
    add(ModBlocks.CRIMWOOD_PLANKS.get(), "Crimwood Planks");
    add(ModBlocks.CRIMWOOD_STAIRS.get(), "Crimwood Stairs");
    add(ModBlocks.CRIMWOOD_SLAB.get(), "Crimwood Slab");
    add(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(), "Crimwood Pressure Plate");
    add(ModBlocks.CRIMWOOD_TRAPDOOR.get(), "Crimwood Trapdoor");
    add(ModBlocks.CRIMWOOD_DOOR.get(), "Crimwood Door");
    add(ModBlocks.CRIMWOOD_FENCE.get(), "Crimwood Fence");
    add(ModBlocks.CRIMWOOD_FENCE_GATE.get(), "Crimwood Fence Gate");
    add(ModBlocks.CRIMWOOD_BUTTON.get(), "Crimwood Button");

    // mud blocks
    add(ModBlocks.MUD_BLOCK.get(), "Block of Mud");
    add(ModBlocks.MUD_BRICKS.get(), "Mud Bricks");
    add(ModBlocks.MUD_BRICK_SLAB.get(), "Mud Brick Slab");
    add(ModBlocks.MUD_BRICK_STAIRS.get(), "Mud Brick Stairs");
    add(ModBlocks.MUD_BRICK_WALL.get(), "Mud Brick Wall");

    // functional blocks
    add(ModBlocks.STONE_ANVIL_STONE.get(), "Stone Anvil");
    add(ModBlocks.STONE_ANVIL_GRANITE.get(), "Granite Anvil");
    add(ModBlocks.STONE_ANVIL_ANDESITE.get(), "Andesite Anvil");
    add(ModBlocks.STONE_ANVIL_DIORITE.get(), "Diorite Anvil");
    add(ModBlocks.STONE_CRAFTING_TABLE.get(), "Stone Crafting Table");
    add(ModBlocks.DRYING_RACK.get(), "Drying Rack");
    // add(ModBlocks.ITEM_SHELF.get(), "Item Shelf");
    // add(ModBlocks.POTION_SHELF.get(), "Potion Shelf");
    // add(ModBlocks.BOOK_SHELF.get(), "Book Shelf");
    add(ModBlocks.BARREL.get(), "Barrel");
    add(ModBlocks.FISH_TRAP.get(), "Fish Trap");
    // add(ModBlocks.ANIMAL_TRAP.get(), "Animal Trap");
    // add(ModBlocks.POTTERY_TABLE.get(), "Pottery Table");
    add(AlloyFurnaceInit.ALLOY_FURNACE.get(), "Alloy Furnace");
    add(AlloyFurnaceTileEntity.SCREEN_NAME, "Alloy Furnace");
    add(HandMillInit.HAND_MILL.get(), "Hand Mill");
    add(HandMillTileEntity.SCREEN_NAME, "Hand Mill");
    add(HandMillInit.MILLSTONE.get(), "Millstone");

    // food-related blocks
    add(ModBlocks.BLUEBERRY_BUSH.get(), "Blueberry Bush");
    add(ModBlocks.ELDERBERRY_BUSH.get(), "Elderberry Bush");
    add(ModBlocks.RASPBERRY_BUSH.get(), "Raspberry Bush");
    add(ModBlocks.BLACKBERRY_BUSH.get(), "Blackberry Bush");
    add(ModBlocks.GOOSEBERRY_BUSH.get(), "Gooseberry Bush");

    // misc blocks
    // add(ModBlocks.LARGE_FLOWER_POT.get(), "Large Flower Pot");

    // food(-related) items
    add(ModFoodItems.BUSHMEAT.get(), "Raw Bushmeat");
    add(ModFoodItems.COOKED_BUSHMEAT.get(), "Cooked Bushmeat");
    add(ModFoodItems.SQUID_MEAT.get(), "Raw Squid Meat");
    add(ModFoodItems.COOKED_SQUID_MEAT.get(), "Cooked Squid Meat");
    add(ModFoodItems.DUCK_EGG.get(), "Duck Egg");
    add(ModFoodItems.WHEAT_FLOUR.get(), "Wheat Flour");
    add(ModFoodItems.DOUGH.get(), "Dough");
    add(ModFoodItems.BLUEBERRIES.get(), "Blueberries");
    add(ModFoodItems.ELDERBERRIES.get(), "Elderberries");
    add(ModFoodItems.RASPBERRIES.get(), "Raspberries");
    add(ModFoodItems.BLACKBERRIES.get(), "Blackberries");
    add(ModFoodItems.GOOSEBERRIES.get(), "Gooseberries");

    // special items
    add(ModItems.COIN_COPPER.get(), "Copper Coin");
    add(ModItems.COIN_SILVER.get(), "Silver Coin");
    add(ModItems.COIN_GOLD.get(), "Gold Coin");

    // todo move swords and armor items to Combat module
    // tiered armor, weapons and tools
    // add(ModArmorItems.COPPER_HELMET.get(), "Copper Helmet");
    // add(ModArmorItems.COPPER_CHESTPLATE.get(), "Copper Chestplate");
    // add(ModArmorItems.COPPER_LEGGINGS.get(), "Copper Leggings");
    // add(ModArmorItems.COPPER_BOOTS.get(), "Copper Boots");
    // add(ModArmorItems.COPPER_SHIELD.get(), "Copper Shield");
    add(ModToolItems.COPPER_SWORD.get(), "Copper Sword");
    add(ModToolItems.COPPER_SHOVEL.get(), "Copper Shovel");
    add(ModToolItems.COPPER_AXE.get(), "Copper Axe");
    add(ModToolItems.COPPER_HOE.get(), "Copper Hoe");
    add(ModToolItems.COPPER_PICKAXE.get(), "Copper Pickaxe");
    add(ModToolItems.SHEARS_COPPER.get(), "Copper Shears");

    // add(ModArmorItems.BRONZE_HELMET.get(), "Bronze Helmet");
    // add(ModArmorItems.BRONZE_CHESTPLATE.get(), "Bronze Chestplate");
    // add(ModArmorItems.BRONZE_LEGGINGS.get(), "Bronze Leggings");
    // add(ModArmorItems.BRONZE_BOOTS.get(), "Bronze Boots");
    // add(ModArmorItems.BRONZE_SHIELD.get(), "Bronze Shield");
    add(ModToolItems.BRONZE_SWORD.get(), "Bronze Sword");
    add(ModToolItems.BRONZE_SHOVEL.get(), "Bronze Shovel");
    add(ModToolItems.BRONZE_AXE.get(), "Bronze Axe");
    add(ModToolItems.BRONZE_HOE.get(), "Bronze Hoe");
    add(ModToolItems.BRONZE_PICKAXE.get(), "Bronze Pickaxe");
    add(ModToolItems.SHEARS_BRONZE.get(), "Bronze Shears");

    // add(ModArmorItems.SILVER_HELMET.get(), "Silver Helmet");
    // add(ModArmorItems.SILVER_CHESTPLATE.get(), "Silver Chestplate");
    // add(ModArmorItems.SILVER_LEGGINGS.get(), "Silver Leggings");
    // add(ModArmorItems.SILVER_BOOTS.get(), "Silver Boots");
    // add(ModArmorItems.SILVER_SHIELD.get(), "Silver Shield");
    add(ModToolItems.SILVER_SWORD.get(), "Silver Sword");
    add(ModToolItems.SILVER_SHOVEL.get(), "Silver Shovel");
    add(ModToolItems.SILVER_AXE.get(), "Silver Axe");
    add(ModToolItems.SILVER_HOE.get(), "Silver Hoe");
    add(ModToolItems.SILVER_PICKAXE.get(), "Silver Pickaxe");
    add(ModToolItems.SHEARS_SILVER.get(), "Silver Shears");

    // add(ModArmorItems.STEEL_HELMET.get(), "Steel Helmet");
    // add(ModArmorItems.STEEL_CHESTPLATE.get(), "Steel Chestplate");
    // add(ModArmorItems.STEEL_LEGGINGS.get(), "Steel Leggings");
    // add(ModArmorItems.STEEL_BOOTS.get(), "Steel Boots");
    // add(ModArmorItems.STEEL_SHIELD.get(), "Steel Shield");
    add(ModToolItems.STEEL_SWORD.get(), "Steel Sword");
    add(ModToolItems.STEEL_SHOVEL.get(), "Steel Shovel");
    add(ModToolItems.STEEL_AXE.get(), "Steel Axe");
    add(ModToolItems.STEEL_HOE.get(), "Steel Hoe");
    add(ModToolItems.STEEL_PICKAXE.get(), "Steel Pickaxe");
    add(ModToolItems.SHEARS_STEEL.get(), "Steel Shears");

    add(ModArmorItems.MYTHERINE_HELMET.get(), "Mytherine Helmet");
    add(ModArmorItems.MYTHERINE_CHESTPLATE.get(), "Mytherine Chestplate");
    add(ModArmorItems.MYTHERINE_LEGGINGS.get(), "Mytherine Leggings");
    add(ModArmorItems.MYTHERINE_BOOTS.get(), "Mytherine Boots");
    // add(ModArmorItems.MYTHERINE_SHIELD.get(), "Mytherine Shield");
    add(ModToolItems.MYTHERINE_SWORD.get(), "Mytherine Sword");
    add(ModToolItems.MYTHERINE_SHOVEL.get(), "Mytherine Shovel");
    add(ModToolItems.MYTHERINE_AXE.get(), "Mytherine Axe");
    add(ModToolItems.MYTHERINE_HOE.get(), "Mytherine Hoe");
    add(ModToolItems.MYTHERINE_PICKAXE.get(), "Mytherine Pickaxe");

    // tools
    add(ModToolItems.HAMMER_STONE.get(), "Stone Hammer");
    add(ModToolItems.HAMMER_IRON.get(), "Iron Hammer");
    add(ModToolItems.HAMMER_OBSIDIAN.get(), "Obsidian Hammer");
    add(ModToolItems.CHISEL_IRON.get(), "Iron Chisel");
    add(ModToolItems.CHISEL_STEEL.get(), "Steel Chisel");
    add(ModToolItems.CHISEL_DIAMOND.get(), "Diamond Chisel");
    add(ModToolItems.KNIFE_FLINT.get(), "Flint Knife");
    add(ModToolItems.KNIFE_IRON.get(), "Iron Knife");
    add(ModToolItems.KNIFE_STEEL.get(), "Steel Knife");
    add(ModToolItems.BUCKET_WOOD.get(), "Wooden Bucket");
    add(ModToolItems.BUCKET_WOOD.get().getTranslationKey() + ".filled", "%s Wooden Bucket");
    add(ModToolItems.BUCKET_CLAY.get(), "Clay Bucket");
    add(ModToolItems.BUCKET_CLAY.get().getTranslationKey() + ".filled", "%s Clay Bucket");
    add(ModToolItems.BUCKET_CRIMWOOD.get(), "Crimwood Bucket");
    add(ModToolItems.BUCKET_CRIMWOOD.get().getTranslationKey() + ".filled", "%s Crimwood Bucket");
    // add(ModToolItems.BUCKET_IRON.get().getTranslationKey() + ".filled", "%s Iron Bucket");
    add(ModToolItems.BUCKET_IRON_LIMEWATER.get(), "Iron Limewater Bucket");
    add(ModToolItems.BUCKET_IRON_TANNIN.get(), "Iron Tannin Bucket");
    add(ModToolItems.MORTAR_WOOD.get(), "Wooden Mortar");
    add(ModToolItems.MORTAR_STONE.get(), "Stone Mortar");
    add(ModToolItems.FIRESTARTER.get(), "Firestarter");
    add(ModToolItems.SOAP.get(), "Soap");
    add(ModToolItems.SEWING_NEEDLE_BONE.get(), "Bone Sewing Needle");
    add(ModToolItems.SEWING_NEEDLE_IRON.get(), "Iron Sewing Needle");
    add(ModToolItems.SEWING_NEEDLE_STEEL.get(), "Steel Sewing Needle");
    add(ModToolItems.BAG_CLOTH.get(), "Cloth Bag");
    add(ModToolItems.BAG_LEATHER.get(), "Leather Bag");
    add(ModToolItems.BEDROLL.get(), "Bedroll");

    // metals
    add(ModItems.MYTHERINE_INGOT.get(), "Mytherine Ingot");
    add(ModItems.MYTHERINE_NUGGET.get(), "Mytherine Nugget");
    add(ModItems.COPPER_INGOT.get(), "Copper Ingot");
    add(ModItems.COPPER_NUGGET.get(), "Copper Nugget");
    add(ModItems.TIN_INGOT.get(), "Tin Ingot");
    add(ModItems.TIN_NUGGET.get(), "Tin Nugget");
    add(ModItems.ZINC_INGOT.get(), "Zinc Ingot");
    add(ModItems.ZINC_NUGGET.get(), "Zinc Nugget");
    add(ModItems.BRONZE_INGOT.get(), "Bronze Ingot");
    add(ModItems.BRONZE_NUGGET.get(), "Bronze Nugget");
    add(ModItems.BRASS_INGOT.get(), "Brass Ingot");
    add(ModItems.BRASS_NUGGET.get(), "Brass Nugget");
    add(ModItems.SILVER_INGOT.get(), "Silver Ingot");
    add(ModItems.SILVER_NUGGET.get(), "Silver Nugget");
    add(ModItems.LEAD_INGOT.get(), "Lead Ingot");
    add(ModItems.LEAD_NUGGET.get(), "Lead Nugget");
    add(ModItems.STEEL_INGOT.get(), "Steel Ingot");
    add(ModItems.STEEL_NUGGET.get(), "Steel Nugget");

    // crafting material
    add(ModItems.SALT.get(), "Salt");
    add(ModItems.GELATIN.get(), "Gelatin");

    add(Items.QUARTZ, "Quartz");

    add(ModItems.BARK_ACACIA.get(), "Acacia Bark");
    add(ModItems.BARK_BIRCH.get(), "Birch Bark");
    add(ModItems.BARK_CRIMSON_STEM.get(), "Crimson Stem Bark");
    add(ModItems.BARK_CRIMWOOD.get(), "Crimwood Bark");
    add(ModItems.BARK_DARK_OAK.get(), "Dark Oak Bark");
    add(ModItems.BARK_JUNGLE.get(), "Jungle Bark");
    add(ModItems.BARK_OAK.get(), "Oak Bark");
    add(ModItems.BARK_SPRUCE.get(), "Spruce Bark");
    add(ModItems.BARK_WARPED_STEM.get(), "Warped Stem Bark");

    add(ModItems.HIDE_FRESH.get(), "Fresh Hide");
    add(ModItems.HIDE_CURED.get(), "Cured Hide");
    add(ModItems.HIDE_SCRAPED.get(), "Scraped Hide");
    add(ModItems.HIDE_LIMED.get(), "Limed Hide");
    add(ModItems.HIDE_TANNED.get(), "Tanned Hide");

    add(ModItems.COARSE_SALT.get(), "Coarse Salt");
    add(ModItems.TALLOW.get(), "Tallow");
    add(ModItems.INK_BOTTLE.get(), "Ink Bottle");
    add(ModItems.BLOOD_BOTTLE.get(), "Blood Bottle");
    add(ModItems.ASH.get(), "Ash");
    add(ModItems.FLINT_SHARD.get(), "Flint Shard");

    add(ModItems.LEATHER_STRIP.get(), "Leather Strip");
    add(ModItems.RESIN_DROP.get(), "Resin Drop");
    add(ModItems.RESIN_BALL.get(), "Ball of Resin");
    add(ModItems.RAVEN_EYE_GEM.get(), "Raven Eye");
    add(ModItems.RAVEN_EYE_DUST.get(), "Raven Eye Dust");
    add(ModItems.LIME.get(), "Lime");
    add(ModItems.GROUT.get(), "Grout");
    add(ModItems.MUD_LUMP.get(), "Lump of Mud");
    add(ModItems.MUD_BRICK.get(), "Mud Brick");
    add(ModItems.MUD_BRICK_DRIED.get(), "Dried Mud Brick");
    add(ModItems.UNFIRED_BRICK.get(), "Unfired Brick");
    add(ModItems.SULFUR.get(), "Sulfur");
    add(ModItems.BLACK_COAL.get(), "Black Coal");
    add(ModItems.PEAT.get(), "Peat");
    add(ModItems.COAL_DUST.get(), "Coal Dust");
    add(ModItems.CHARCOAL_DUST.get(), "Charcoal Dust");
    add(ModItems.QUARTZ_SAND.get(), "Quartz Sand");
    add(ModItems.NITER.get(), "Niter");
    add(ModItems.SLAG.get(), "Slag");
    add(ModItems.PLANT_FIBRE.get(), "Plant Fibre");
    add(ModItems.DRIED_PLANT_FIBRE.get(), "Dried Plant Fibre");
    add(ModItems.PLANT_TWINE.get(), "Plant Twine");
    add(ModItems.CLOTH.get(), "Cloth");
    add(ModItems.SMALL_STONE.get(), "Small Stone");

    // miscellaneous
    add(ModItems.BUCKET_CLAY_UNFIRED.get(), "Unfired Clay Bucket");
    add(ModItems.UNFIRED_FLOWER_POT.get(), "Unfired Flower Pot");
    // add(ModItems.UNFIRED_LARGE_FLOWER_POT.get(), "Unfired Large Flower Pot");

    add(ModItems.CRIMWOOD_BOAT.get(), "Crimwood Boat");
    // add(ModItems.CRIMWOOD_SIGN.get(), "Crimwood Sign");
  }
}
