package com.sasnos.ravenutils.datagen.lang;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class enUs extends LanguageProvider {

  public enUs(DataGenerator gen) {
    super(gen, RavenUtils.MOD_ID, "en_us");
  }

  @Override
  protected void addTranslations() {
    add(ModBlocks.STONE_ANVIL_STONE.get(), "Stone Anvil");
  }
}
