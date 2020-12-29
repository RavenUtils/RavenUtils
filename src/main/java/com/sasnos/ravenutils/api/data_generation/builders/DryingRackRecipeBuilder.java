package com.sasnos.ravenutils.api.data_generation.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sasnos.ravenutils.api.data_generation.recipes.FinishedRecipe;
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

import java.util.function.Consumer;

public class DryingRackRecipeBuilder {

  private final Ingredient input;
  private final int count;
  private final int timer;
  private final IItemProvider output;
  private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
  private final float xp;

  public DryingRackRecipeBuilder(Ingredient input, int count, int timer, IItemProvider output, float xp) {
    if (input.hasNoMatchingItems()) throw new IllegalArgumentException("Input can not be Empty");
    if (timer < 1) throw new IllegalArgumentException("Timer can not be smaller then 1");
    if (input.getMatchingStacks().length > 1) throw new IllegalStateException("Max 1 Ingredient can be used");
    if (input.getMatchingStacks()[0].getCount() > 1) throw new IllegalStateException("Max amount for input is 1");
    this.input = input;
    if (count > 1) throw new IllegalArgumentException("Output can not be greater then 1");
    this.count = count;
    this.timer = timer;
    this.output = output;
    if (xp < 1) throw new IllegalArgumentException("xp under 1 do not drop");
    this.xp = xp;
  }

  public DryingRackRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
    this.advancementBuilder.withCriterion(name, criterionIn);
    return this;
  }

  public void build(Consumer<IFinishedRecipe> consumer) {
    build(consumer, false);
  }

  public void build(Consumer<IFinishedRecipe> consumer, boolean ignoreMcNames) {
    this.build(consumer, ForgeRegistries.ITEMS.getKey(output.asItem()), ignoreMcNames);
  }

  public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id) {
    this.build(consumer, id, false);
  }

  public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id, boolean ignoreMCNames) {
    validate(id, ignoreMCNames);
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
        timer, xp, this.advancementBuilder, advancementsId));
  }

  private void validate(ResourceLocation id, boolean ignoreMCNames) {
    if (this.advancementBuilder.getCriteria().isEmpty()) {
      throw new IllegalStateException("No way of obtaining alloy recipe " + id);
    }
    if (!ignoreMCNames && id.getNamespace().equals("minecraft") && ForgeRegistries.ITEMS.containsKey(id)) {
      throw new IllegalStateException("Change Name of Recipe to avoid Problems with other Mods for Recipe " + id);
    }
  }

  protected static class Result extends FinishedRecipe {

    private final IItemProvider result;
    private final int count;
    private final Ingredient input;
    private final int timer;
    private final float xp;

    public Result(
        ResourceLocation id,
        IItemProvider result,
        int count,
        Ingredient input,
        int timer,
        float xp, Advancement.Builder advancementBuilder,
        ResourceLocation advancementId) {
      super(id, advancementBuilder, advancementId);
      this.result = result;
      this.count = count;
      this.input = input;
      this.timer = timer;
      this.xp = xp;
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
      json.addProperty("xp", xp);
    }


    @Override
    public IRecipeSerializer<?> getSerializer() {
      return ModRecipes.DRYING_RACK_RECIPE_SERIALIZER.get();
    }
  }

}
