package com.sasnos.ravenutils.api.data_generation.recipes;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public abstract class FinishedRecipe implements IFinishedRecipe {
    protected final   ResourceLocation id;
    protected final Advancement.Builder advancementBuilder;
    protected final ResourceLocation advancementId;

    protected FinishedRecipe(ResourceLocation id, Advancement.Builder advancementBuilder, ResourceLocation advancementId) {
        this.id = id;
        this.advancementBuilder = advancementBuilder;
        this.advancementId = advancementId;
    }

    @Override
    public ResourceLocation getID() {
        return id;
    }


    @Nullable
    @Override
    public JsonObject getAdvancementJson() {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getAdvancementID() {
        return null;
    }
}
