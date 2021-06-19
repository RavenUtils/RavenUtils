package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.raven_api.screens.EssentialsCommonMachineScreen;
import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class AlloyFurnaceScreen extends EssentialsCommonMachineScreen<AlloyFurnaceContainer> {

  private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/container/alloy_furnace.png");

  public AlloyFurnaceScreen(AlloyFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
    this.minecraft.getTextureManager().bind(getGUI());
    int left = this.leftPos;
    int right = this.topPos;
    this.blit(matrixStack, left, right, 0, 0, this.imageWidth, this.imageHeight);
    if (this.menu.isBurning()) {
      int k = this.menu.getBurnLeftScaled();
      this.blit(matrixStack, left + 45, right + 36 + 12 - k, 176, 12 - k, 14, k + 1);
    }

    int l = this.menu.getCookProgressionScaled();
    this.blit(matrixStack, left + 84, right + 34, 176, 14, l + 1, 16);
  }

  @Override
  protected void renderLabels(MatrixStack matrixStack, int x, int y) {
    this.font.draw(matrixStack, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
    this.font.draw(matrixStack, this.inventory.getDisplayName(), (float) this.inventoryLabelX, (float) this.imageHeight - 94, 4210752);
  }

  @NotNull
  @Override
  protected ResourceLocation getGUI() {
    return GUI;
  }
}
