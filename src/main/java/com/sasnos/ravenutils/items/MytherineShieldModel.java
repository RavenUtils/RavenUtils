package com.sasnos.ravenutils.items;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MytherineShieldModel extends Model {
  private final ModelRenderer plate;
  private final ModelRenderer handle;

  public MytherineShieldModel() {
    super(RenderType::entitySolid);
    this.texWidth = 64;
    this.texHeight = 64;
    this.plate = new ModelRenderer(this, 0, 0);
    this.plate.addBox(-6.0F, -11.0F, -2.0F, 12.0F, 22.0F, 1.0F, 0.0F);
    this.handle = new ModelRenderer(this, 26, 0);
    this.handle.addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F, 0.0F);
  }

  public ModelRenderer plate() {
    return this.plate;
  }

  public ModelRenderer handle() {
    return this.handle;
  }

  @Override
  public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
    this.plate.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    this.handle.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
  }
}