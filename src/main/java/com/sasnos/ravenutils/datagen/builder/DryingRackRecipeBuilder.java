package com.sasnos.ravenutils.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sasnos.raven_api.datagen.recipes.FinishedRecipe;
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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class DryingRackRecipeBuilder {

  private final Ingredient input;
  private final int count;
  private final int timer;
  private final IItemProvider output;
  private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
  private final float xp;

  public DryingRackRecipeBuilder(Ingredient input, int count, int timer, IItemProvider output, float xp) {
    if (input.isEmpty()) throw new IllegalArgumentException("Input must not be empty");
    if (timer < 1) throw new IllegalArgumentException("Timer must not be smaller than 1");
    if (input.getItems().length > 1) throw new IllegalStateException("Max 1 ingredient can be used");
    if (input.getItems()[0].getCount() > 1) throw new IllegalStateException("Max amount for input is 1");
    this.input = input;
    if (count > 1) throw new IllegalArgumentException("Output cannot be greater than 1");
    this.count = count;
    this.timer = timer;
    this.output = output;
    this.xp = xp;
  }

  public DryingRackRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
    this.advancementBuilder.addCriterion(name, criterionIn);
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
        .parent(new ResourceLocation("RavenApi/src/main/java/com/sasnos/raven_api/recipes/root"))
        .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
        .rewards(AdvancementRewards.Builder.recipe(id))
        .requirements(IRequirementsStrategy.OR);
    ResourceLocation advancementId = new ResourceLocation(id.getNamespace(), "RavenApi/src/main/java/com/sasnos/raven_api/recipes/" + Objects.requireNonNull(this.output.asItem().getItemCategory()).getRecipeFolderName() + "/" + id.getPath());
    createRecipe(consumer, id, advancementId);
  }

  private void createRecipe(Consumer<IFinishedRecipe> consumer, ResourceLocation id, ResourceLocation advancementsId) {
    consumer.accept(new Result(id, this.output, this.count, this.input,
        timer, xp, this.advancementBuilder, advancementsId));
  }

  private void validate(ResourceLocation id, boolean ignoreMCNames) {
    if (this.advancementBuilder.getCriteria().isEmpty()) {
      throw new IllegalStateException("No way of obtaining recipe " + id);
    }
    if (!ignoreMCNames && id.getNamespace().equals("minecraft") && ForgeRegistries.ITEMS.containsKey(id)) {
      throw new IllegalStateException("Change name of recipe to avoid problems with other mods for recipe " + id);
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
    public void serializeRecipeData(@NotNull JsonObject json) {
      JsonElement ingredients = this.input.toJson();
      if (ingredients.isJsonArray()) {
        JsonArray ingredientArray = JSONUtils.convertToJsonArray(ingredients, null);
        final int[] i = {0};
        ingredientArray.forEach(jsonElement -> {
          jsonElement.getAsJsonObject().addProperty("count", this.input.getItems()[i[0]].getCount());
          i[0]++;
        });
      }

      json.add("ingredient", ingredients);
      JsonObject resultJson = new JsonObject();
      resultJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.result.asItem())).toString());
      if (this.count > 1) {
        resultJson.addProperty("count", this.count);
      }
      json.add("result", resultJson);

      json.addProperty("timer", timer);
      json.addProperty("xp", xp);
    }

    @Override
    public @NotNull IRecipeSerializer<?> getType() {
      return ModRecipes.DRYING_RACK_RECIPE_SERIALIZER.get();
    }
  }

}