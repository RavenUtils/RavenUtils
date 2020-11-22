package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.screens.EssentialsCommonScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class EssentialsFurnaceScreen extends EssentialsCommonScreen<EssentialsAlloyFurnaceBlockContainer> {

  private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/container/alloy_furnace.png");

  public EssentialsFurnaceScreen(EssentialsAlloyFurnaceBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @NotNull
  @Override
  protected ResourceLocation getGUI() {
    return GUI;
  }
}
