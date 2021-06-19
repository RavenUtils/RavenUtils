package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlockItems;
import com.sasnos.ravenutils.init.ModFoodItems;
import com.sasnos.ravenutils.init.ModItems;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Items.*;

public class EssentialsItemTags extends ItemTagsProvider {

  public EssentialsItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(dataGenerator, blockTagProvider, RavenUtils.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags() {
    tag(hammers).add(
        ModToolItems.HAMMER_OBSIDIAN.get(),
        ModToolItems.HAMMER_IRON.get(),
        ModToolItems.HAMMER_STONE.get()
    );

    tag(tongs).add(
        ModToolItems.TONGS_WOOD.get(),
        ModToolItems.TONGS_IRON.get(),
        ModToolItems.TONGS_STEEL.get()
    );

    tag(handsaws).add(
        ModToolItems.HANDSAW_IRON.get(),
        ModToolItems.HANDSAW_STEEL.get()
    );

    tag(chisels).add(
        ModToolItems.CHISEL_IRON.get(),
        ModToolItems.CHISEL_STEEL.get(),
        ModToolItems.CHISEL_DIAMOND.get()
    );

    tag(knives).add(
        ModToolItems.KNIFE_FLINT.get(),
        ModToolItems.KNIFE_IRON.get(),
        ModToolItems.KNIFE_STEEL.get()
    );

    tag(mortars).add(
        ModToolItems.MORTAR_WOOD.get(),
        ModToolItems.MORTAR_STONE.get()
    );

    tag(sewing_needles).add(
        ModToolItems.SEWING_NEEDLE_BONE.get(),
        ModToolItems.SEWING_NEEDLE_IRON.get(),
        ModToolItems.SEWING_NEEDLE_STEEL.get()
    );

    tag(buckets).add(
        Items.BUCKET,
        ModToolItems.BUCKET_CLAY.get(),
        ModToolItems.BUCKET_WOOD.get(),
        ModToolItems.BUCKET_CRIMWOOD.get()
    );

    // todo add custom variants (wood, clay, crimwood)
    tag(buckets_water).add(
        Items.WATER_BUCKET
    );

    // todo add custom variants (wood, clay, crimwood)
    tag(buckets_lava).add(
        Items.LAVA_BUCKET
    );

    tag(buckets_milk).add(
        Items.MILK_BUCKET,
        ModToolItems.BUCKET_WOOD_MILK.get(),
        ModToolItems.BUCKET_CLAY_MILK.get(),
        ModToolItems.BUCKET_CRIMWOOD_MILK.get()
    );

    // todo add custom variants (wood, clay, crimwood)
    tag(buckets_limewater).add(
        ModToolItems.BUCKET_IRON_LIMEWATER.get()
    );

    // todo add custom variants (wood, clay, crimwood)
    tag(buckets_tannin).add(
        ModToolItems.BUCKET_IRON_TANNIN.get()
    );

    tag(axes).add(
        ModToolItems.FLINT_AXE.get(),
        Items.STONE_AXE,
        Items.IRON_AXE,
        Items.GOLDEN_AXE,
        Items.DIAMOND_AXE,
        Items.NETHERITE_AXE,
        ModToolItems.COPPER_AXE.get(),
        ModToolItems.BRONZE_AXE.get(),
        ModToolItems.SILVER_AXE.get(),
        ModToolItems.STEEL_AXE.get(),
        ModToolItems.MYTHERINE_AXE.get()
    );

    tag(fishing_rods).add(
        Items.FISHING_ROD
    );

    tag(books).add(
        Items.BOOK,
        Items.WRITABLE_BOOK,
        Items.WRITTEN_BOOK
    );

    tag(grasses_tall).add(
        Items.SUGAR_CANE,
        Items.BAMBOO
    );

    tag(slimeballs).add(
        ModItems.RESIN_BALL.get()
    );

    tag(raw_meat).add(
        Items.BEEF,
        Items.RABBIT,
        Items.MUTTON,
        Items.PORKCHOP,
        Items.CHICKEN,
        ModFoodItems.BUSHMEAT.get()
    );

    tag(flours).add(
        ModFoodItems.WHEAT_FLOUR.get()
    );

    tag(strings).add(
        ModItems.PLANT_TWINE.get()
    );

    tag(salts).add(
        ModItems.SALT.get()
    );

    tag(coals_stone).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL
    );

    tag(coals_wood).add(
        Items.CHARCOAL
    );

    tag(coals).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL,
        Items.CHARCOAL
    );

    tag(ores).add(
        ModBlockItems.COPPER_ORE_ITEM.get(),
        ModBlockItems.TIN_ORE_ITEM.get(),
        ModBlockItems.ZINC_ORE_ITEM.get(),
        ModBlockItems.SILVER_ORE_ITEM.get(),
        ModBlockItems.LEAD_ORE_ITEM.get(),
        ModBlockItems.MYTHERINE_ORE_ITEM.get(),
        ModBlockItems.FOSSIL_ROCK_ITEM.get(),
        ModBlockItems.RAVEN_EYE_ORE_ITEM.get(),
        ModBlockItems.SULFUR_ORE_ITEM.get(),
        ModBlockItems.BLACK_COAL_ORE_ITEM.get(),
        ModBlockItems.SALT_ORE_ITEM.get()
    );

    tag(barks).add(
        ModItems.BARK_ACACIA.get(),
        ModItems.BARK_BIRCH.get(),
        ModItems.BARK_CRIMSON_STEM.get(),
        ModItems.BARK_CRIMWOOD.get(),
        ModItems.BARK_DARK_OAK.get(),
        ModItems.BARK_JUNGLE.get(),
        ModItems.BARK_OAK.get(),
        ModItems.BARK_SPRUCE.get(),
        ModItems.BARK_WARPED_STEM.get()
    );

    tag(rods_metal).add(
        ModItems.METAL_ROD_IRON.get(),
        ModItems.METAL_ROD_STEEL.get()
    );

    tag(saplings).add(
        Items.ACACIA_SAPLING,
        Items.BIRCH_SAPLING,
        Items.DARK_OAK_SAPLING,
        Items.JUNGLE_SAPLING,
        Items.OAK_SAPLING,
        Items.SPRUCE_SAPLING,
        ModBlockItems.CRIMWOOD_SAPLING_ITEM.get()
    );

    tag(small_flowers).add(ModBlockItems.CRIMLEAF_ITEM.get());

    tag(non_flammable_wood).add(
        ModBlockItems.CRIMWOOD_SAPLING_ITEM.get(),
        ModBlockItems.CRIMWOOD_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_ITEM.get(),
        ModBlockItems.CRIMWOOD_PLANKS_ITEM.get(),
        ModBlockItems.CRIMWOOD_DOOR_ITEM.get(),
        ModBlockItems.CRIMWOOD_FENCE_ITEM.get(),
        ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get(),
        ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get(),
        ModBlockItems.CRIMWOOD_SLAB_ITEM.get(),
        ModBlockItems.CRIMWOOD_STAIRS_ITEM.get(),
        ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get(),
        ModBlockItems.CRIMWOOD_BUTTON_ITEM.get()
    );

    tag(crimwood_logs).add(
        ModBlockItems.CRIMWOOD_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_STRIPPED_ITEM.get(),
        ModBlockItems.CRIMWOOD_STRIPPED_ITEM.get()
    );

    tag(buckets_burnable).add(
        ModToolItems.BUCKET_WOOD.get(),
        ModToolItems.BUCKET_CLAY.get()
    );

    tag(fence_gates).add(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get());
    tag(leaves).add(ModBlockItems.CRIMWOOD_LEAVES_ITEM.get());
    tag(planks).add(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get());
    tag(wooden_buttons).add(ModBlockItems.CRIMWOOD_BUTTON_ITEM.get());
    tag(wooden_doors).add(ModBlockItems.CRIMWOOD_DOOR_ITEM.get());
    tag(wooden_fences).add(ModBlockItems.CRIMWOOD_FENCE_ITEM.get());
    tag(wooden_pressure_plates).add(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get());
    tag(wooden_slabs).add(ModBlockItems.CRIMWOOD_SLAB_ITEM.get());
    tag(wooden_stairs).add(ModBlockItems.CRIMWOOD_STAIRS_ITEM.get());
    tag(wooden_trapdoors).add(ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get());

    tag(fireStarter).add(Items.FLINT_AND_STEEL, ModToolItems.FIRESTARTER.get());
  }
}
