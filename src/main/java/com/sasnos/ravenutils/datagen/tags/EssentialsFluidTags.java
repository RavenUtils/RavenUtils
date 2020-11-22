package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class EssentialsFluidTags extends FluidTagsProvider {

    public EssentialsFluidTags(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, RavenUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(FluidTags.makeWrapperTag(FluidTags.WATER.getName().getPath()))
                .add(ModFluids.LIMEWATER.get(), ModFluids.TANNIN.get());
    }
}
