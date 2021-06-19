package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.sasnos.ravenutils.utils.tags.EssentialsTags.Blocks.*;

public class EssentialsBlockTags extends BlockTagsProvider {

  public EssentialsBlockTags(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
    super(dataGenerator, modId, existingFileHelper);
  }

  @Override
  protected void addTags() {
    tag(ores).add(
        ModBlocks.COPPER_ORE.get(),
        ModBlocks.TIN_ORE.get(),
        ModBlocks.ZINC_ORE.get(),
        ModBlocks.SILVER_ORE.get(),
        ModBlocks.LEAD_ORE.get(),
        ModBlocks.MYTHERINE_ORE.get(),
        ModBlocks.RAVEN_EYE_ORE.get(),
        ModBlocks.SULFUR_ORE.get(),
        ModBlocks.BLACK_COAL_ORE.get(),
        ModBlocks.SALT_ORE.get()
    );

    tag(requireTool)
        .addTag(BlockTags.LOGS);

    tag(saplings).add(ModBlocks.CRIMWOOD_SAPLING.get());
    tag(small_flowers).add(ModBlocks.CRIMLEAF.get());

    tag(flower_pots).add(
        ModBlocks.POTTED_CRIMWOOD_SAPLING.get(),
        ModBlocks.POTTED_CRIMLEAF.get()
    );

    tag(BlockTags.WOODEN_FENCES)
        .add(ModBlocks.CRIMWOOD_FENCE.get());

    tag(Tags.Blocks.FENCE_GATES_WOODEN)
        .add(ModBlocks.CRIMWOOD_FENCE_GATE.get());

    tag(BlockTags.WALLS)
        .add(ModBlocks.MUD_BRICK_WALL.get());

    tag(crimwood_logs).add(
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_LOG_STRIPPED.get()
    );

    tag(non_flammable_wood).add(
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

    tag(BlockTags.LOGS).add(ModBlocks.CRIMWOOD_LOG.get());

    tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.CRIMWOOD_FENCE_GATE.get());
    tag(leaves).add(ModBlocks.CRIMWOOD_LEAVES.get());
    tag(planks).add(ModBlocks.CRIMWOOD_PLANKS.get());
    tag(wooden_buttons).add(ModBlocks.CRIMWOOD_BUTTON.get());
    tag(wooden_doors).add(ModBlocks.CRIMWOOD_DOOR.get());
    tag(wooden_fences).add(ModBlocks.CRIMWOOD_FENCE.get());
    tag(wooden_pressure_plates).add(ModBlocks.CRIMWOOD_PRESSURE_PLATE.get());
    tag(wooden_slabs).add(ModBlocks.CRIMWOOD_SLAB.get());
    tag(wooden_stairs).add(ModBlocks.CRIMWOOD_STAIRS.get());
    tag(wooden_trapdoors).add(ModBlocks.CRIMWOOD_TRAPDOOR.get());

    tag(infiniburn_overworld).add(
        ModBlocks.CRIMWOOD.get(),
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_LOG_STRIPPED.get(),
        ModBlocks.CRIMWOOD_PLANKS.get()
    );
  }
}
