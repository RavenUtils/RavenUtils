package com.sasnos.ravenutils.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.raven_api.screens.EssentialsCommonScreen;
import com.sasnos.ravenutils.containers.BagContainer;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BagScreen extends EssentialsCommonScreen<BagContainer> {


  public BagScreen(BagContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
    this.minecraft.getTextureManager().bind(getGUI());
    this.blit(matrixStack, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight + 80);
  }

  @Override
  protected void renderLabels(MatrixStack matrixStack, int x, int y) {
    this.font.draw(matrixStack, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
    switch (menu.getBag()) {
      case CLOTH:
        this.font.draw(matrixStack, this.inventory.getDisplayName(), (float) this.inventoryLabelX, (float) this.imageHeight - 110, 4210752);
        break;
      case LEATHER:
        this.font.draw(matrixStack, this.inventory.getDisplayName(), (float) this.inventoryLabelX, (float) this.imageHeight - 75, 4210752);
        break;
    }

  }

  @Override
  protected ResourceLocation getGUI() {
    return EssentialsUtils.resourceLocation("textures/gui/container/" + menu.getBag().getGuiName() + ".png");
  }
}
