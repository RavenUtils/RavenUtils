package com.sasnos.ravenutils.api.data_generation.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sasnos.ravenutils.init.ModRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class DryRackRecipeBuilder {

    private final Ingredient input;
    private final int count;
    private final int timer;
    private final IItemProvider output;
    private Advancement.Builder advancementBuilder = Advancement.Builder.builder();

    private DryRackRecipeBuilder(Ingredient input, int count, int timer, IItemProvider output) {
        this.input = input;
        this.count = count;
        this.timer = timer;
        this.output = output;
    }

    public DryRackRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
        this.advancementBuilder.withCriterion(name, criterionIn);
        return this;
    }

    public void build(Consumer<IFinishedRecipe> consumer) {
        this.build(consumer, ForgeRegistries.ITEMS.getKey(output.asItem()));
    }

    public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id) {
        validate(id);
        this.advancementBuilder
                .withParentId(new ResourceLocation("recipes/root"))
                .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(id))
                .withRewards(AdvancementRewards.Builder.recipe(id))
                .withRequirementsStrategy(IRequirementsStrategy.OR);
        ResourceLocation advancementId = new ResourceLocation(id.getNamespace(), "recipes/" + this.output.asItem().getGroup().getPath() + "/" + id.getPath());
        createRecipe(consumer, id, advancementId);
    }

    private void createRecipe(Consumer<IFinishedRecipe> consumer, ResourceLocation id, ResourceLocation advancementsId) {
        consumer.accept(new Result(id, this.output, this.count, this.input,
                timer, this.advancementBuilder, advancementsId));
    }

    private void validate(ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining alloy recipe " + id);
        }
    }

    protected static class Result implements IFinishedRecipe {

        private final ResourceLocation id;
        private final IItemProvider result;
        private final int count;
        private final Ingredient input;
        private final int timer;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(
                ResourceLocation id,
                IItemProvider result,
                int count,
                Ingredient input,
                int timer,
                Advancement.Builder advancementBuilder,
                ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.count = count;
            this.input = input;
            this.timer = timer;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            JsonElement ingredients = this.input.serialize();
            if (ingredients.isJsonArray()) {
                JsonArray ingredientArray = JSONUtils.getJsonArray(ingredients, null);
                final int[] i = {0};
                ingredientArray.forEach(jsonElement -> {
                    jsonElement.getAsJsonObject().addProperty("count", this.input.getMatchingStacks()[i[0]].getCount());
                    i[0]++;
                });
            }

            json.add("ingredient", ingredients);
            JsonObject resultJson = new JsonObject();
            resultJson.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result.asItem()).toString());
            if (this.count > 1) {
                resultJson.addProperty("count", this.count);
            }
            json.add("result", resultJson);

            json.addProperty("timer", timer);
        }

        @Override
        public ResourceLocation getID() {
            return id;
        }

        @Override
        public IRecipeSerializer<?> getSerializer() {
            return ModRecipes.DRY_RACK_RECIPE_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject getAdvancementJson() {
            return advancementBuilder.serialize();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementID() {
            return advancementId;
        }
    }

}
