package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.screens.EssentialsCommonMachineScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class AlloyFurnaceScreen extends EssentialsCommonMachineScreen<AlloyFurnaceBlockContainer> {

  private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/container/alloy_furnace.png");

  public AlloyFurnaceScreen(AlloyFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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

  @Override
  protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
    this.font.func_243248_b(matrixStack, this.title, (float)this.titleX, (float)this.titleY, 4210752);
    this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float)this.playerInventoryTitleX, (float)this.ySize-94, 4210752);
  }
}
