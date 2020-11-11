package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class EssentialsBlockTags extends BlockTagsProvider {

  public static ITag.INamedTag<Block> non_flammable_wood = BlockTags.makeWrapperTag("forge:non_flammable_wood");
  public static ITag.INamedTag<Block> fence_gates = BlockTags.makeWrapperTag("forge:fence_gates");
  public static ITag.INamedTag<Block> flower_pots = BlockTags.makeWrapperTag("forge:flower_pots");
  public static ITag.INamedTag<Block> infiniburn_overworld = BlockTags.makeWrapperTag("forge:infiniburn_overworld");
  public static ITag.INamedTag<Block> leaves = BlockTags.makeWrapperTag("forge:leaves");
  public static ITag.INamedTag<Block> planks = BlockTags.makeWrapperTag("forge:planks");
  public static ITag.INamedTag<Block> saplings = BlockTags.makeWrapperTag("forge:saplings");
  public static ITag.INamedTag<Block> small_flowers = BlockTags.makeWrapperTag("forge:small_flowers");
  public static ITag.INamedTag<Block> wooden_buttons = BlockTags.makeWrapperTag("forge:wooden_buttons");
  public static ITag.INamedTag<Block> wooden_doors = BlockTags.makeWrapperTag("forge:wooden_doors");
  public static ITag.INamedTag<Block> wooden_fences = BlockTags.makeWrapperTag("forge:wooden_fences");
  public static ITag.INamedTag<Block> wooden_pressure_plates = BlockTags.makeWrapperTag("forge:wooden_pressure_plates");
  public static ITag.INamedTag<Block> wooden_slabs = BlockTags.makeWrapperTag("forge:wooden_slabs");
  public static ITag.INamedTag<Block> wooden_stairs = BlockTags.makeWrapperTag("forge:wooden_stairs");
  public static ITag.INamedTag<Block> wooden_trapdoors = BlockTags.makeWrapperTag("forge:wooden_trapdoors");

  public EssentialsBlockTags(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
    super(dataGenerator, modId, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(non_flammable_wood).add(
        ModBlocks.CRIMWOOD_LOG.get(),
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
    getOrCreateBuilder(fence_gates).add( ModBlocks.CRIMWOOD_FENCE_GATE.get() );
    getOrCreateBuilder(flower_pots).add(
        ModBlocks.POTTED_CRIMWOOD_SAPLING.get(),
        ModBlocks.POTTED_CRIMLEAF.get()
    );
    getOrCreateBuilder(infiniburn_overworld).add(
        ModBlocks.CRIMWOOD.get(),
        ModBlocks.CRIMWOOD_LOG.get(),
        ModBlocks.CRIMWOOD_PLANKS.get()
    );
    getOrCreateBuilder(leaves).add( ModBlocks.CRIMWOOD_LEAVES.get() );
    getOrCreateBuilder(planks).add( ModBlocks.CRIMWOOD_PLANKS.get() );
    getOrCreateBuilder(saplings).add( ModBlocks.CRIMWOOD_SAPLING.get() );
    getOrCreateBuilder(small_flowers).add( ModBlocks.CRIMLEAF.get() );
    getOrCreateBuilder(wooden_buttons).add( ModBlocks.CRIMWOOD_BUTTON.get() );
    getOrCreateBuilder(wooden_doors).add( ModBlocks.CRIMWOOD_DOOR.get() );
    getOrCreateBuilder(wooden_fences).add( ModBlocks.CRIMWOOD_FENCE.get() );
    getOrCreateBuilder(wooden_pressure_plates).add( ModBlocks.CRIMWOOD_PRESSURE_PLATE.get() );
    getOrCreateBuilder(wooden_slabs).add( ModBlocks.CRIMWOOD_SLAB.get() );
    getOrCreateBuilder(wooden_stairs).add( ModBlocks.CRIMWOOD_STAIRS.get() );
    getOrCreateBuilder(wooden_trapdoors).add( ModBlocks.CRIMWOOD_TRAPDOOR.get() );
  }
}
