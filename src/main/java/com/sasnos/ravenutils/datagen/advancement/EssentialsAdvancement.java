package com.sasnos.ravenutils.datagen.advancement;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.datageneration.advancement.EssentialsAdvancementProvider;
import com.sasnos.ravenutils.init.ModToolItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class EssentialsAdvancement extends EssentialsAdvancementProvider {

  public EssentialsAdvancement(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerAdvancement(Consumer<Advancement> consumer) {
    Advancement.Builder.builder()
        .withDisplay(ModToolItems.BUCKET_WOOD.get(),
            new TranslationTextComponent("wood_clay_bucket_advancement"),
            new TranslationTextComponent("wood_clay_bucket_advancement_description"),
            null,
            FrameType.TASK,
            true,
            true,
            false)
        .withCriterion("has_wood_clay_bucket",
            InventoryChangeTrigger.Instance.forItems(ModToolItems.BUCKET_CLAY.get(),
                ModToolItems.BUCKET_WOOD.get()))
        .register(consumer, "wood_clay_bucket");
  }


  @Override
  public String getName() {
    return RavenUtils.MOD_ID + " Advancements";
  }
}
