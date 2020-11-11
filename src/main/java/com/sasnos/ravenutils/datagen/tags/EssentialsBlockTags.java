package com.sasnos.ravenutils.datagen.tags;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class EssentialsBlockTags extends BlockTagsProvider {

    public EssentialsBlockTags(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, RavenUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(BlockTags.makeWrapperTag("forge:ore"))
                .add(ModBlocks.COPPER_ORE.get(), ModBlocks.TIN_ORE.get(), ModBlocks.BLACK_COAL_ORE.get(),
                        ModBlocks.MYTHERINE_ORE.get(), ModBlocks.SILVER_ORE.get(), ModBlocks.SULFUR_ORE.get(),
                        ModBlocks.FOSSIL_ORE.get(), ModBlocks.RAVEN_EYE_ORE.get(), ModBlocks.SALT_ORE.get());
    }
}
