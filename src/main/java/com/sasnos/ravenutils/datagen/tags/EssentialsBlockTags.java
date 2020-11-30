package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.flower_pots;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.infiniburn_overworld;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.leaves;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.non_flammable_wood;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.ores;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.crimwood_logs;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.planks;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.saplings;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.small_flowers;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_buttons;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_doors;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_fences;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_pressure_plates;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_slabs;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_stairs;
import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.wooden_trapdoors;

public class EssentialsBlockTags extends BlockTagsProvider {

  public EssentialsBlockTags(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
    super(dataGenerator, modId, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(ores).add(
        ModBlocks.COPPER_ORE.get(),
        ModBlocks.TIN_ORE.get(),
        ModBlocks.ZINC_ORE.get(),
        ModBlocks.SILVER_ORE.get(),
        ModBlocks.LEAD_ORE.get(),
        ModBlocks.MYTHERINE_ORE.get(),
        ModBlocks.FOSSIL_ORE.get(),
        ModBlocks.RAVEN_EYE_ORE.get(),
        ModBlocks.SULFUR_ORE.get(),
        ModBlocks.BLACK_COAL_ORE.get(),
        ModBlocks.SALT_ORE.get()
    );

    getOrCreateBuilder(saplings).add(ModBlocks.CRIMWOOD_SAPLING.get());
    getOrCreateBuilder(small_flowers).add(ModBlocks.CRIMLEAF.get());

    getOrCreateBuilder(flower_pots).add(
        ModBlocks.POTTED_CRIMWOOD_SAPLING.get(),
        ModBlocks.POTTED_CRIMLEAF.get()
    );

    getOrCreateBuilder(BlockTags.WOODEN_FENCES)
            .add(ModBlocks.CRIMWOOD_FENCE.get());

    getOrCreateBuilder(Tags.Blocks.FENCE_GATES_WOODEN)
            .add(ModBlocks.CRIMWOOD_FENCE_GATE.get());

    getOrCreateBuilder(BlockTags.WALLS)
            .add(ModBlocks.MUD_BRICK_WALL.get());

    getOrCreateBuilder(crimwood_logs).add(
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_LOG_STRIPPED.get()
    );

    getOrCreateBuilder(non_flammable_wood).add(
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_LOG_STRIPPED.get(),
        ModBlocks.CRIMWOOD_DOOR.get(),
        ModBlocks.CRIMWOOD_FENCE.get(),
        ModBlocks.CRIMWOOD_FENCE_GATE.get(),
        ModBlocks.CRIMWOOD_PLANKS.get(),
        ModBlocks.CRIMWOOD_PRESSURE_PLATE.get(),
        ModBlocks.CRIMWOOD_SAPLING.get(),
        ModBlocks.CRIMWOOD_SLAB.get(),
        ModBlocks.CRIMWOOD_STAIRS.get(),
        ModBlocks.CRIMWOOD_TRAPDOOR.get(),
        ModBlocks.CRIMWOOD_BUTTON.get(),
        ModBlocks.CRIMWOOD.get()
    );

    getOrCreateBuilder(BlockTags.LOGS).add(ModBlocks.CRIMWOOD_LOG.get());

    getOrCreateBuilder(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.CRIMWOOD_FENCE_GATE.get());
    getOrCreateBuilder(leaves).add(ModBlocks.CRIMWOOD_LEAVES.get());
    getOrCreateBuilder(planks).add(ModBlocks.CRIMWOOD_PLANKS.get());
    getOrCreateBuilder(wooden_buttons).add(ModBlocks.CRIMWOOD_BUTTON.get());
    getOrCreateBuilder(wooden_doors).add(ModBlocks.CRIMWOOD_DOOR.get());
    getOrCreateBuilder(wooden_fences).add(ModBlocks.CRIMWOOD_FENCE.get());
    getOrCreateBuilder(wooden_pressure_plates).add(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get());
    getOrCreateBuilder(wooden_slabs).add(ModBlocks.CRIMWOOD_SLAB.get());
    getOrCreateBuilder(wooden_stairs).add(ModBlocks.CRIMWOOD_STAIRS.get());
    getOrCreateBuilder(wooden_trapdoors).add(ModBlocks.CRIMWOOD_TRAPDOOR.get());

    getOrCreateBuilder(infiniburn_overworld).add(
        ModBlocks.CRIMWOOD.get(),
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_LOG_STRIPPED.get(),
        ModBlocks.CRIMWOOD_PLANKS.get()
    );
  }
}
