package com.sasnos.ravenutils.utils.tags;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TagsUpdatedEvent;

import java.util.function.Consumer;

public class EssentialsTags {

  private static boolean tagsLoaded = false;

  public static void init() {
//        Blocks.init();
//        Items.init();
    Fluids.init();
    Consumer<TagsUpdatedEvent.VanillaTagTypes> onTagsLoaded = (event) -> tagsLoaded = true;
    MinecraftForge.EVENT_BUS.addListener(onTagsLoaded);
  }

  public static boolean tagsLoaded() {
    return tagsLoaded;
  }

  public static class Blocks {
    public static void init() {
    }

    public static final ITag.INamedTag<Block> ores = BlockTags.makeWrapperTag("forge:ore");
    public static final ITag.INamedTag<Block> non_flammable_wood = BlockTags.makeWrapperTag("forge:non_flammable_wood");
    public static final ITag.INamedTag<Block> fence_gates = BlockTags.makeWrapperTag("forge:fence_gates");
    public static final ITag.INamedTag<Block> flower_pots = BlockTags.makeWrapperTag("forge:flower_pots");
    public static final ITag.INamedTag<Block> infiniburn_overworld = BlockTags.makeWrapperTag("forge:infiniburn_overworld");
    public static final ITag.INamedTag<Block> crimwood_logs = BlockTags.makeWrapperTag(RavenUtils.MOD_ID+":crimwood");
    public static final ITag.INamedTag<Block> leaves = BlockTags.makeWrapperTag("forge:leaves");
    public static final ITag.INamedTag<Block> planks = BlockTags.makeWrapperTag("forge:planks");
    public static final ITag.INamedTag<Block> saplings = BlockTags.makeWrapperTag("forge:saplings");
    public static final ITag.INamedTag<Block> small_flowers = BlockTags.makeWrapperTag("forge:small_flowers");
    public static final ITag.INamedTag<Block> wooden_buttons = BlockTags.makeWrapperTag("forge:wooden_buttons");
    public static final ITag.INamedTag<Block> wooden_doors = BlockTags.makeWrapperTag("forge:wooden_doors");
    public static final ITag.INamedTag<Block> wooden_fences = BlockTags.makeWrapperTag("forge:wooden_fences");
    public static final ITag.INamedTag<Block> wooden_pressure_plates = BlockTags.makeWrapperTag("forge:wooden_pressure_plates");
    public static final ITag.INamedTag<Block> wooden_slabs = BlockTags.makeWrapperTag("forge:wooden_slabs");
    public static final ITag.INamedTag<Block> wooden_stairs = BlockTags.makeWrapperTag("forge:wooden_stairs");
    public static final ITag.INamedTag<Block> wooden_trapdoors = BlockTags.makeWrapperTag("forge:wooden_trapdoors");

    public static final ITag.INamedTag<Block> mud_wall = BlockTags.makeWrapperTag(RavenUtils.MOD_ID+":mud_wall");
  }

  public static class Items {
    private static void init() {
    }

    // blockitems
    public static final ITag.INamedTag<Item> ores = ItemTags.makeWrapperTag("forge:ore");
    public static final ITag.INamedTag<Item> non_flammable_wood = ItemTags.makeWrapperTag("forge:non_flammable_wood");
    public static final ITag.INamedTag<Item> crimwood_logs = ItemTags.makeWrapperTag("ravenutils:crimwood_logs");
    public static final ITag.INamedTag<Item> fence_gates = ItemTags.makeWrapperTag("forge:fence_gates");
    public static final ITag.INamedTag<Item> leaves = ItemTags.makeWrapperTag("forge:leaves");
    public static final ITag.INamedTag<Item> planks = ItemTags.makeWrapperTag("forge:planks");
    public static final ITag.INamedTag<Item> saplings = ItemTags.makeWrapperTag("forge:saplings");
    public static final ITag.INamedTag<Item> small_flowers = ItemTags.makeWrapperTag("forge:small_flowers");
    public static final ITag.INamedTag<Item> wooden_buttons = ItemTags.makeWrapperTag("forge:wooden_buttons");
    public static final ITag.INamedTag<Item> wooden_doors = ItemTags.makeWrapperTag("forge:wooden_doors");
    public static final ITag.INamedTag<Item> wooden_fences = ItemTags.makeWrapperTag("forge:wooden_fences");
    public static final ITag.INamedTag<Item> wooden_pressure_plates = ItemTags.makeWrapperTag("forge:wooden_pressure_plates");
    public static final ITag.INamedTag<Item> wooden_slabs = ItemTags.makeWrapperTag("forge:wooden_slabs");
    public static final ITag.INamedTag<Item> wooden_stairs = ItemTags.makeWrapperTag("forge:wooden_stairs");
    public static final ITag.INamedTag<Item> wooden_trapdoors = ItemTags.makeWrapperTag("forge:wooden_trapdoors");

    // items
    public static final ITag.INamedTag<Item> hammers = ItemTags.makeWrapperTag("forge:tools/hammers");
    public static final ITag.INamedTag<Item> chisels = ItemTags.makeWrapperTag("forge:tools/chisels");
    public static final ITag.INamedTag<Item> knives = ItemTags.makeWrapperTag("forge:tools/knives");
    public static final ITag.INamedTag<Item> mortars = ItemTags.makeWrapperTag("forge:tools/mortars");
    public static final ITag.INamedTag<Item> sewing_needles = ItemTags.makeWrapperTag("forge:tools/sewing_needles");
    public static final ITag.INamedTag<Item> axes = ItemTags.makeWrapperTag("forge:tools/axes");
    public static final ITag.INamedTag<Item> books = ItemTags.makeWrapperTag("forge:books");
    public static final ITag.INamedTag<Item> grasses_tall = ItemTags.makeWrapperTag("forge:grasses/tall");
    public static final ITag.INamedTag<Item> slimeballs = ItemTags.makeWrapperTag("forge:slimeballs");
    public static final ITag.INamedTag<Item> raw_meat = ItemTags.makeWrapperTag("forge:meat/raw");
    public static final ITag.INamedTag<Item> flours = ItemTags.makeWrapperTag("forge:flours");
    public static final ITag.INamedTag<Item> salts = ItemTags.makeWrapperTag("forge:salts");
    public static final ITag.INamedTag<Item> boats = ItemTags.makeWrapperTag("forge:boats");
    public static final ITag.INamedTag<Item> coals = ItemTags.makeWrapperTag("minecraft:coals");
    public static final ITag.INamedTag<Item> coals_stone = ItemTags.makeWrapperTag("forge:coals/stone");
    public static final ITag.INamedTag<Item> coals_wood = ItemTags.makeWrapperTag("forge:coals/wood");
    public static final ITag.INamedTag<Item> strings = ItemTags.makeWrapperTag("forge:string");
    public static final ITag.INamedTag<Item> barks = ItemTags.makeWrapperTag("forge:barks");
    public static final ITag.INamedTag<Item> rods_metal = ItemTags.makeWrapperTag("forge:rods/metal");

    public static ITag.INamedTag<Item> buckets = ItemTags.makeWrapperTag("forge:buckets");
    public static ITag.INamedTag<Item> buckets_water = ItemTags.makeWrapperTag("forge:buckets/water");
    public static ITag.INamedTag<Item> buckets_lava = ItemTags.makeWrapperTag("forge:buckets/lava");
    public static ITag.INamedTag<Item> buckets_milk = ItemTags.makeWrapperTag("forge:buckets/milk");
    public static ITag.INamedTag<Item> buckets_limewater = ItemTags.makeWrapperTag("forge:buckets/limewater");
    public static ITag.INamedTag<Item> buckets_tannin = ItemTags.makeWrapperTag("forge:buckets/tannin");

    public static final ITag.INamedTag<Item> buckets_burnable = ItemTags.makeWrapperTag("buckets_burnable");
    public static final ITag.INamedTag<Item> fireStarter = ItemTags.makeWrapperTag(RavenUtils.MOD_ID+":fire_starter");
  }

  public static class Fluids {
    private static void init() {
    }

    @SuppressWarnings("WeakerAccess")
    public static final Tags.IOptionalNamedTag<Fluid> MILK = FluidTags.createOptional(new ResourceLocation("forge:milk"));
  }
}
