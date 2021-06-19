package com.sasnos.ravenutils.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import com.sasnos.ravenutils.init.ModArmorItems;
import com.sasnos.ravenutils.items.MytherineShieldModel;
import com.sasnos.ravenutils.utils.EssentialsUtils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.BannerTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.*;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ModItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
  private final MytherineShieldModel modelShield = new MytherineShieldModel();

  @Override
  public void renderByItem(ItemStack stack, TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
    Item item = stack.getItem();
    if (item instanceof BlockItem) {
      Block block = ((BlockItem) item).getBlock();
      if (item == ModArmorItems.MYTHERINE_SHIELD.get().getItem()) {
        boolean flag = stack.getTagElement("BlockEntityTag") != null;
        matrixStack.pushPose();
        matrixStack.scale(1.0F, -1.0F, -1.0F);
        RenderMaterial rendermaterial = flag
            ? new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, EssentialsUtils.resourceLocation("entity/shields/mytherine_shield_base"))
            : new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, EssentialsUtils.resourceLocation("entity/shields/mytherine_shield_base_nopattern"));
        IVertexBuilder ivertexbuilder = rendermaterial.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.modelShield.renderType(rendermaterial.atlasLocation()), true, stack.hasFoil()));
        this.modelShield.handle().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        if (flag) {
          List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.createPatterns(ShieldItem.getColor(stack), BannerTileEntity.getItemPatterns(stack));
          BannerTileEntityRenderer.renderPatterns(matrixStack, buffer, combinedLight, combinedOverlay, this.modelShield.plate(), rendermaterial, false, list, stack.hasFoil());
        } else {
          this.modelShield.plate().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStack.popPose();
      }
    }
  }
}
