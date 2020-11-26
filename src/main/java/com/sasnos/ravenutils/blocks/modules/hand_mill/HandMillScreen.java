package com.sasnos.ravenutils.blocks.modules.hand_mill;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.api.screens.EssentialsCommonScreen;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class HandMillScreen extends EssentialsCommonScreen<HandMillContainer> {

  public HandMillScreen(HandMillContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
    this.minecraft.getTextureManager().bindTexture(getGUI());
    this.blit(matrixStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize + 30);
  }

  @Override
  protected ResourceLocation getGUI() {
    return EssentialsUtils.resourceLocation("textures/gui/container/hand_mill.png");
  }
}
