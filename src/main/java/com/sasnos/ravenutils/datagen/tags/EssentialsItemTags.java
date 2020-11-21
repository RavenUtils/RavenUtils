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
  protected void registerTags() {
    getOrCreateBuilder(hammers).add(
        ModToolItems.HAMMER_OBSIDIAN.get(),
        ModToolItems.HAMMER_IRON.get(),
        ModToolItems.HAMMER_STONE.get()
    );

    getOrCreateBuilder(chisels).add(
        ModToolItems.CHISEL_IRON.get(),
        ModToolItems.CHISEL_STEEL.get(),
        ModToolItems.CHISEL_DIAMOND.get()
    );

    getOrCreateBuilder(knives).add(
        ModToolItems.KNIFE_FLINT.get(),
        ModToolItems.KNIFE_IRON.get(),
        ModToolItems.KNIFE_DIAMOND.get()
    );

    getOrCreateBuilder(sewing_needles).add(
        ModToolItems.SEWING_NEEDLE_BONE.get(),
        ModToolItems.SEWING_NEEDLE_IRON.get()
    );

    getOrCreateBuilder(buckets).add(
        Items.BUCKET,
        ModToolItems.BUCKET_CLAY.get(),
        ModToolItems.BUCKET_WOOD.get(),
        ModToolItems.BUCKET_CRIMWOOD.get()
    );

    // todo custom variants (wood, clay, crimwood)
    getOrCreateBuilder(water_buckets).add(
        Items.WATER_BUCKET
    );

    // todo custom variants (wood, clay, crimwood)
    getOrCreateBuilder(milk_buckets).add(
        Items.MILK_BUCKET
    );

    // todo crimwood variant
    getOrCreateBuilder(lava_buckets).add(
        Items.LAVA_BUCKET
    );

    getOrCreateBuilder(axes).add(
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

    getOrCreateBuilder(books).add(
        Items.BOOK,
        Items.WRITABLE_BOOK,
        Items.WRITTEN_BOOK
    );

    getOrCreateBuilder(grasses_tall).add(
        Items.SUGAR_CANE,
        Items.BAMBOO
    );

    getOrCreateBuilder(slimeballs).add(ModItems.RESIN_BALL.get());

    getOrCreateBuilder(raw_meat).add(
        Items.BEEF,
        Items.RABBIT,
        Items.MUTTON,
        Items.PORKCHOP,
        Items.CHICKEN,
        ModFoodItems.BUSHMEAT.get()
    );

    getOrCreateBuilder(flours).add(
        ModFoodItems.WHEAT_FLOUR.get()
    );

    getOrCreateBuilder(strings).add(ModItems.PLANT_TWINE.get());
    getOrCreateBuilder(salts).add(ModItems.SALT.get());

    getOrCreateBuilder(coals_stone).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL
    );

    getOrCreateBuilder(coals_wood).add(
        Items.CHARCOAL
    );

    getOrCreateBuilder(coals).add(
        ModItems.BLACK_COAL.get(),
        Items.COAL,
        Items.CHARCOAL
    );

    getOrCreateBuilder(ores).add(
        ModBlockItems.COPPER_ORE_ITEM.get(),
        ModBlockItems.TIN_ORE_ITEM.get(),
        ModBlockItems.ZINC_ORE_ITEM.get(),
        ModBlockItems.SILVER_ORE_ITEM.get(),
        ModBlockItems.LEAD_ORE_ITEM.get(),
        ModBlockItems.MYTHERINE_ORE_ITEM.get(),
        ModBlockItems.FOSSIL_ORE_ITEM.get(),
        ModBlockItems.RAVEN_EYE_ORE_ITEM.get(),
        ModBlockItems.SULFUR_ORE_ITEM.get(),
        ModBlockItems.BLACK_COAL_ORE_ITEM.get(),
        ModBlockItems.SALT_ORE_ITEM.get()
    );

    getOrCreateBuilder(saplings).add(ModBlockItems.CRIMWOOD_SAPLING_ITEM.get());
    getOrCreateBuilder(small_flowers).add(ModBlockItems.CRIMLEAF_ITEM.get());

    getOrCreateBuilder(non_flammable_wood).add(
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

    getOrCreateBuilder(crimwood_logs).add(
        ModBlockItems.CRIMWOOD_ITEM.get(),
        ModBlockItems.CRIMWOOD_LOG_ITEM.get()
    );

    getOrCreateBuilder(burnableBuckets).add(
            ModToolItems.BUCKET_WOOD.get(),
            ModToolItems.BUCKET_CLAY.get()
    );

    getOrCreateBuilder(fence_gates).add(ModBlockItems.CRIMWOOD_FENCE_GATE_ITEM.get());
    getOrCreateBuilder(leaves).add(ModBlockItems.CRIMWOOD_LEAVES_ITEM.get());
    getOrCreateBuilder(planks).add(ModBlockItems.CRIMWOOD_PLANKS_ITEM.get());
    getOrCreateBuilder(wooden_buttons).add(ModBlockItems.CRIMWOOD_BUTTON_ITEM.get());
    getOrCreateBuilder(wooden_doors).add(ModBlockItems.CRIMWOOD_DOOR_ITEM.get());
    getOrCreateBuilder(wooden_fences).add(ModBlockItems.CRIMWOOD_FENCE_ITEM.get());
    getOrCreateBuilder(wooden_pressure_plates).add(ModBlockItems.CRIMWOOD_PRESSURE_PLATE_ITEM.get());
    getOrCreateBuilder(wooden_slabs).add(ModBlockItems.CRIMWOOD_SLAB_ITEM.get());
    getOrCreateBuilder(wooden_stairs).add(ModBlockItems.CRIMWOOD_STAIRS_ITEM.get());
    getOrCreateBuilder(wooden_trapdoors).add(ModBlockItems.CRIMWOOD_TRAPDOOR_ITEM.get());

    getOrCreateBuilder(boats).add(ModItems.CRIMWOOD_BOAT.get());
  }
}
