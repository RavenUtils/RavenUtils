package com.sasnos.ravenutils.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.datafixers.util.Pair;
import com.sasnos.ravenutils.init.ModToolItems;
import com.sasnos.ravenutils.items.MytherineShieldModel;
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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ModItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
  private final MytherineShieldModel modelShield = new MytherineShieldModel();

  @Override
  public void func_239207_a_(ItemStack stack, TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
    Item item = stack.getItem();
    if (item instanceof BlockItem) {
      Block block = ((BlockItem) item).getBlock();
      if (item == ModToolItems.RAVENINE_SHIELD.get().getItem()) {
        boolean flag = stack.getChildTag("BlockEntityTag") != null;
        matrixStack.push();
        matrixStack.scale(1.0F, -1.0F, -1.0F);
        RenderMaterial rendermaterial = flag
            ? new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/shields/ravenine_shield_base"))
            : new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/shields/ravenine_shield_base_nopattern"));
        IVertexBuilder ivertexbuilder = rendermaterial.getSprite().wrapBuffer(ItemRenderer.getEntityGlintVertexBuilder(buffer, this.modelShield.getRenderType(rendermaterial.getAtlasLocation()), true, stack.hasEffect()));
        this.modelShield.func_228294_b_().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        if (flag) {
          List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.getPatternColorData(ShieldItem.getColor(stack), BannerTileEntity.getPatternData(stack));
          BannerTileEntityRenderer.func_241717_a_(matrixStack, buffer, combinedLight, combinedOverlay, this.modelShield.func_228293_a_(), rendermaterial, false, list, stack.hasEffect());
        } else {
          this.modelShield.func_228293_a_().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStack.pop();
      }
    }
  }
}
