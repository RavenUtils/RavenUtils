package com.sasnos.ravenutils.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.api.screens.EssentialsCommonScreen;
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
  protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
    this.minecraft.getTextureManager().bindTexture(getGUI());
    this.blit(matrixStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize + 80);
  }

  @Override
  protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
    this.font.func_243248_b(matrixStack, this.title, (float) this.titleX, (float) this.titleY, 4210752);
    switch (container.getBag()) {
      case CLOTH:
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float) this.playerInventoryTitleX, (float) this.ySize - 110, 4210752);
        break;
      case LEATHER:
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float) this.playerInventoryTitleX, (float) this.ySize - 75, 4210752);
        break;
    }

  }

  @Override
  protected ResourceLocation getGUI() {
    return EssentialsUtils.resourceLocation("textures/gui/container/" + container.getBag().getGuiName() + ".png");
  }
}
