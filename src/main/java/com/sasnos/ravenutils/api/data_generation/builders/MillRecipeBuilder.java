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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class MillRecipeBuilder {
    private IItemProvider output;
    private final Ingredient input;
    private final int count;
    private final float change;
    private final int timer;
    private ItemStack additionalResult;
    private float additionalChange;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
    private String group;

    private MillRecipeBuilder(Ingredient input, int count, int timer, IItemProvider output, float additionalDropChange){
        this.input = input;
        this.count = count;
        this.timer = timer;
        this.output = output;
        this.change = additionalDropChange;
    }

    public static MillRecipeBuilder millRecipe(Ingredient input, int count, int timer, IItemProvider output, float additionalDropChange) {
        return new MillRecipeBuilder(input, count, timer, output, additionalDropChange);
    }

    public MillRecipeBuilder setAdditionalOutput(ItemStack additionalOutput, float additionalChange){
        this.additionalResult = additionalOutput;
        this.additionalChange = additionalChange;
        return this;
    }

    public MillRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
        this.advancementBuilder.withCriterion(name, criterionIn);
        return this;
    }

    public MillRecipeBuilder setGroup(String groupIn) {
        this.group = groupIn;
        return this;
    }

    public void build(Consumer<IFinishedRecipe> consumerIn) {
        this.build(consumerIn, ForgeRegistries.ITEMS.getKey(this.output.asItem()));
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id) {
        this.validate(id);
        this.advancementBuilder
                .withParentId(new ResourceLocation("recipes/root"))
                .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(id))
                .withRewards(AdvancementRewards.Builder.recipe(id))
                .withRequirementsStrategy(IRequirementsStrategy.OR);
        ResourceLocation advancementId = new ResourceLocation(id.getNamespace(), "recipes/" + this.output.asItem().getGroup().getPath() + "/" + id.getPath());
        consumerIn.accept(createFinishedRecipe(
                id,
                this.group == null ? "" : this.group,
                this.output, this.count, this.input,
                timer, this.advancementBuilder, change,
                advancementId, additionalResult.getItem(), additionalResult.getCount(), additionalChange));
    }

    protected IFinishedRecipe createFinishedRecipe(
            ResourceLocation id, String group, IItemProvider result,
            int count, Ingredient input, int timer,
            Advancement.Builder advancementBuilder, float change, ResourceLocation advancementId, Item additionalResult,
            int additionalCounter, float additionalChange) {
        return
                new Result(id, group, result,
                        count, input, timer, change,
                        advancementBuilder, advancementId, additionalResult,
                        additionalCounter, additionalChange);
    }

    private void validate(ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining alloy recipe " + id);
        }
        if(change > 1){
            throw new IllegalStateException("The additionalDropChange can not be grater then 1");
        }
    }

    protected static class Result implements IFinishedRecipe {

        public final ResourceLocation id;
        private IItemProvider output;
        private final Ingredient input;
        private final int count;
        private final float change;
        private final int timer;
        private Item additionalResult;
        private int additionalCounter;
        private float additionalChange;
        private String group;
        public final Advancement.Builder advBuilder;
        public final ResourceLocation advancmentId;




        Result(
                ResourceLocation id,
                String group,
                IItemProvider result,
                int count,
                Ingredient input,
                int timer,
                float change, Advancement.Builder advancementBuilder,
                ResourceLocation advancementId,
                Item additionalResult,
                int additionalCounter,
                float additionalChange) {
            this.id = id;
            this.group = group;
            this.output = result;
            this.input = input;
            this.count = count;
            this.timer = timer;
            this.change = change;
            this.advBuilder = advancementBuilder;
            this.advancmentId = advancementId;
            this.additionalResult = additionalResult;
            this.additionalCounter = additionalCounter;
            this.additionalChange = additionalChange;
        }

        @Override
        public void serialize(JsonObject json) {

            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonElement ingredients = this.input.serialize();
            if(ingredients.isJsonArray()){
                JsonArray ingredientArray = JSONUtils.getJsonArray(ingredients, null);
                final int[] i = {0};
                ingredientArray.forEach(jsonElement -> {
                    jsonElement.getAsJsonObject().addProperty("count", this.input.getMatchingStacks()[i[0]].getCount());
                    i[0]++;
                });
            }

            json.add("ingredient", ingredients);

            JsonObject resultJson = new JsonObject();
            resultJson.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output.asItem()).toString());
            if (this.count > 1) {
                resultJson.addProperty("count", this.count);
            }
            json.add("result", resultJson);
            json.addProperty("additionalDropChange", change);
            if (additionalResult != null) {
                JsonObject additionalResult = new JsonObject();
                additionalResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.additionalResult).toString());
                if (additionalCounter > 1) {
                    additionalResult.addProperty("count", additionalCounter);
                }
                additionalResult.addProperty("change", additionalChange);
                json.add("additional", additionalResult);
            }
            json.addProperty("timer", timer);
        }

        @Override
        public ResourceLocation getID() {
            return id;
        }

        @Override
        public IRecipeSerializer<?> getSerializer() {
            return ModRecipes.MILL_RECIPE_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject getAdvancementJson() {
            return advBuilder.serialize();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementID() {
            return advancmentId;
        }
    }
}
