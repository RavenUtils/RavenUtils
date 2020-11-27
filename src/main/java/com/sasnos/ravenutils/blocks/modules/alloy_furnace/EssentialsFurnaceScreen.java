package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.screens.EssentialsCommonMachineScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class EssentialsFurnaceScreen extends EssentialsCommonMachineScreen<EssentialsAlloyFurnaceBlockContainer> {

  private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/container/alloy_furnace.png");

  public EssentialsFurnaceScreen(EssentialsAlloyFurnaceBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
    this.minecraft.getTextureManager().bindTexture(getGUI());
    int left = this.guiLeft;
    int right = this.guiTop;
    this.blit(matrixStack, left, right, 0, 0, this.xSize, this.ySize);
    if (this.container.isBurning()) {
      int k = this.container.getBurnLeftScaled();
      this.blit(matrixStack, left + 45, right + 36 + 12 - k, 176, 12 - k, 14, k + 1);
    }

    int l = this.container.getCookProgressionScaled();
    this.blit(matrixStack, left + 84, right + 34, 176, 14, l + 1, 16);
  }

  @NotNull
  @Override
  protected ResourceLocation getGUI() {
    return GUI;
  }
}
