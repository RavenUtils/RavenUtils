package com.sasnos.ravenutils.util.tags;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
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

    public static class Fluids {
        private static void init() {}
        @SuppressWarnings("WeakerAccess")
        public static final Tags.IOptionalNamedTag<Fluid> MILK = FluidTags.createOptional(new ResourceLocation("forge:milk"));
    }
}
