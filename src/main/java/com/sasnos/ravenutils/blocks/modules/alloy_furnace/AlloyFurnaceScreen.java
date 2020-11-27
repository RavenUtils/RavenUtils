package com.sasnos.ravenutils.blocks.modules.alloy_furnace;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.screens.EssentialsCommonScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class AlloyFurnaceScreen extends EssentialsCommonScreen<AlloyFurnaceContainer> {

  private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/container/alloy_furnace.png");

  public AlloyFurnaceScreen(AlloyFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
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
