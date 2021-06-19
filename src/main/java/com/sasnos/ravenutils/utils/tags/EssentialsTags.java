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

    public static final ITag.INamedTag<Block> ores = BlockTags.bind("forge:ore");
    public static final ITag.INamedTag<Block> non_flammable_wood = BlockTags.bind("forge:non_flammable_wood");
    public static final ITag.INamedTag<Block> fence_gates = BlockTags.bind("forge:fence_gates");
    public static final ITag.INamedTag<Block> flower_pots = BlockTags.bind("forge:flower_pots");
    public static final ITag.INamedTag<Block> infiniburn_overworld = BlockTags.bind("forge:infiniburn_overworld");
    public static final ITag.INamedTag<Block> crimwood_logs = BlockTags.bind(RavenUtils.MOD_ID + ":crimwood");
    public static final ITag.INamedTag<Block> leaves = BlockTags.bind("forge:leaves");
    public static final ITag.INamedTag<Block> planks = BlockTags.bind("forge:planks");
    public static final ITag.INamedTag<Block> saplings = BlockTags.bind("forge:saplings");
    public static final ITag.INamedTag<Block> small_flowers = BlockTags.bind("forge:small_flowers");
    public static final ITag.INamedTag<Block> wooden_buttons = BlockTags.bind("forge:wooden_buttons");
    public static final ITag.INamedTag<Block> wooden_doors = BlockTags.bind("forge:wooden_doors");
    public static final ITag.INamedTag<Block> wooden_fences = BlockTags.bind("forge:wooden_fences");
    public static final ITag.INamedTag<Block> wooden_pressure_plates = BlockTags.bind("forge:wooden_pressure_plates");
    public static final ITag.INamedTag<Block> wooden_slabs = BlockTags.bind("forge:wooden_slabs");
    public static final ITag.INamedTag<Block> wooden_stairs = BlockTags.bind("forge:wooden_stairs");
    public static final ITag.INamedTag<Block> wooden_trapdoors = BlockTags.bind("forge:wooden_trapdoors");

    //public static final ITag.INamedTag<Block> mud_wall = BlockTags.makeWrapperTag(RavenUtils.MOD_ID + ":mud_wall");

    public static final ITag.INamedTag<Block> requireTool = BlockTags.bind(RavenUtils.MOD_ID + ":require_tool");
  }

  public static class Items {
    private static void init() {
    }

    // blockitems
    public static final ITag.INamedTag<Item> ores = ItemTags.bind("forge:ore");
    public static final ITag.INamedTag<Item> non_flammable_wood = ItemTags.bind("forge:non_flammable_wood");
    public static final ITag.INamedTag<Item> crimwood_logs = ItemTags.bind("ravenutils:crimwood_logs");
    public static final ITag.INamedTag<Item> fence_gates = ItemTags.bind("forge:fence_gates");
    public static final ITag.INamedTag<Item> leaves = ItemTags.bind("forge:leaves");
    public static final ITag.INamedTag<Item> planks = ItemTags.bind("forge:planks");
    public static final ITag.INamedTag<Item> saplings = ItemTags.bind("forge:saplings");
    public static final ITag.INamedTag<Item> small_flowers = ItemTags.bind("forge:small_flowers");
    public static final ITag.INamedTag<Item> wooden_buttons = ItemTags.bind("forge:wooden_buttons");
    public static final ITag.INamedTag<Item> wooden_doors = ItemTags.bind("forge:wooden_doors");
    public static final ITag.INamedTag<Item> wooden_fences = ItemTags.bind("forge:wooden_fences");
    public static final ITag.INamedTag<Item> wooden_pressure_plates = ItemTags.bind("forge:wooden_pressure_plates");
    public static final ITag.INamedTag<Item> wooden_slabs = ItemTags.bind("forge:wooden_slabs");
    public static final ITag.INamedTag<Item> wooden_stairs = ItemTags.bind("forge:wooden_stairs");
    public static final ITag.INamedTag<Item> wooden_trapdoors = ItemTags.bind("forge:wooden_trapdoors");

    // items
    public static final ITag.INamedTag<Item> hammers = ItemTags.bind("forge:tools/hammers");
    public static final ITag.INamedTag<Item> tongs = ItemTags.bind("forge:tools/tongs");
    public static final ITag.INamedTag<Item> handsaws = ItemTags.bind("forge:tools/handsaws");
    public static final ITag.INamedTag<Item> chisels = ItemTags.bind("forge:tools/chisels");
    public static final ITag.INamedTag<Item> knives = ItemTags.bind("forge:tools/knives");
    public static final ITag.INamedTag<Item> mortars = ItemTags.bind("forge:tools/mortars");
    public static final ITag.INamedTag<Item> sewing_needles = ItemTags.bind("forge:tools/sewing_needles");
    public static final ITag.INamedTag<Item> axes = ItemTags.bind("forge:tools/axes");
    public static final ITag.INamedTag<Item> fishing_rods = ItemTags.bind("forge:tools/fishing_rods");
    public static final ITag.INamedTag<Item> books = ItemTags.bind("forge:books");
    public static final ITag.INamedTag<Item> grasses_tall = ItemTags.bind("forge:grasses/tall");
    public static final ITag.INamedTag<Item> slimeballs = ItemTags.bind("forge:slimeballs");
    public static final ITag.INamedTag<Item> raw_meat = ItemTags.bind("forge:meat/raw");
    public static final ITag.INamedTag<Item> flours = ItemTags.bind("forge:flours");
    public static final ITag.INamedTag<Item> salts = ItemTags.bind("forge:salts");
    public static final ITag.INamedTag<Item> boats = ItemTags.bind("forge:boats");
    public static final ITag.INamedTag<Item> coals = ItemTags.bind("minecraft:coals");
    public static final ITag.INamedTag<Item> coals_stone = ItemTags.bind("forge:coals/stone");
    public static final ITag.INamedTag<Item> coals_wood = ItemTags.bind("forge:coals/wood");
    public static final ITag.INamedTag<Item> strings = ItemTags.bind("forge:string");
    public static final ITag.INamedTag<Item> barks = ItemTags.bind("forge:barks");
    public static final ITag.INamedTag<Item> rods_metal = ItemTags.bind("forge:rods/metal");
    public static final ITag.INamedTag<Item> rods_wood = ItemTags.bind("forge:rods/wooden");

    public static ITag.INamedTag<Item> buckets = ItemTags.bind("forge:buckets");
    public static ITag.INamedTag<Item> buckets_water = ItemTags.bind("forge:buckets/water");
    public static ITag.INamedTag<Item> buckets_lava = ItemTags.bind("forge:buckets/lava");
    public static ITag.INamedTag<Item> buckets_milk = ItemTags.bind("forge:buckets/milk");
    public static ITag.INamedTag<Item> buckets_limewater = ItemTags.bind("forge:buckets/limewater");
    public static ITag.INamedTag<Item> buckets_tannin = ItemTags.bind("forge:buckets/tannin");

    public static final ITag.INamedTag<Item> buckets_burnable = ItemTags.bind("buckets_burnable");
    public static final ITag.INamedTag<Item> fireStarter = ItemTags.bind(RavenUtils.MOD_ID + ":fire_starter");
  }

  public static class Fluids {
    private static void init() {
    }

    @SuppressWarnings("WeakerAccess")
    public static final Tags.IOptionalNamedTag<Fluid> milk = FluidTags.createOptional(new ResourceLocation("forge:milk"));
  }
}
