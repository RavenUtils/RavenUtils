package com.sasnos.ravenutils.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sasnos.ravenutils.blocks.Barrel;
import com.sasnos.ravenutils.tile_entities.BarrelTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import java.util.concurrent.atomic.AtomicReference;

public class BarrelRenderer extends TileEntityRenderer<BarrelTileEntity> {


  public BarrelRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
    super(rendererDispatcherIn);
  }

  private void add(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v, float red, float green, float blue, float alpha) {
    renderer.pos(stack.getLast().getMatrix(), x, y, z)
        .color(red, green, blue, alpha)
        .tex(u, v)
        .lightmap(240, 0)
        .normal(1, 0, 0)
        .endVertex();
  }

  @Override
  public void render(BarrelTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

    if (tileEntityIn.getBlockState().get(Barrel.HAS_LID)) return;
    AtomicReference<FluidStack> fluidRef = new AtomicReference<>();
    AtomicReference<ItemStack> item = new AtomicReference<>();
    AtomicReference<Integer> maxValue = new AtomicReference<>();
    BlockPos pos = tileEntityIn.getPos();

    tileEntityIn.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).ifPresent(iFluidHandler -> {
      fluidRef.set(iFluidHandler.getFluidInTank(0));
      maxValue.set(iFluidHandler.getTankCapacity(0));
    });
    tileEntityIn.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(
        iItemHandler ->
            item.set(iItemHandler.getStackInSlot(0)));

    FluidStack fluid = fluidRef.get();
    IVertexBuilder builder = bufferIn.getBuffer(RenderType.getTranslucent());

    double height = (((double) fluid.getAmount()) * .85) / ((double) maxValue.get());
    if (height == 0.0) height += .1;

    if (height == 1) height -= .01;

    float floatHeight = (float) height;

    if (!fluid.isEmpty()) {

      TextureAtlasSprite fluidShape = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE)
          .apply(fluid.getFluid().getAttributes().getStillTexture(fluid));


      int color = fluid.getFluid().getAttributes().getColor();

      float red = 1;
      float green = 1;
      float blue = 1;
      float alpha = 1;
      if (color != -1) {
        red = getRed(color);
        green = getGreen(color);
        blue = getBlue(color);
        alpha = getAlpha(color);
      }

      matrixStackIn.push();
      matrixStackIn.rotate(new Quaternion(0, 0, 0, true));
      add(builder, matrixStackIn, 0, floatHeight, 0, fluidShape.getMinU(), fluidShape.getMinV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 1, floatHeight, 0, fluidShape.getMaxU(), fluidShape.getMinV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 1, floatHeight, 1, fluidShape.getMaxU(), fluidShape.getMaxV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 0, floatHeight, 1, fluidShape.getMinU(), fluidShape.getMaxV(), red, green, blue, alpha);

      add(builder, matrixStackIn, 0, floatHeight, 1, fluidShape.getMinU(), fluidShape.getMaxV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 1, floatHeight, 1, fluidShape.getMaxU(), fluidShape.getMaxV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 1, floatHeight, 0, fluidShape.getMaxU(), fluidShape.getMinV(), red, green, blue, alpha);
      add(builder, matrixStackIn, 0, floatHeight, 0, fluidShape.getMinU(), fluidShape.getMinV(), red, green, blue, alpha);

      matrixStackIn.pop();
    }


    matrixStackIn.push();

    matrixStackIn.translate(.5, height, .5);
    matrixStackIn.rotate(new Quaternion(90f, 0, 0, true));
    ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
    IBakedModel bakedModel = itemRenderer.getItemModelWithOverrides(item.get(), tileEntityIn.getWorld(), null);
    itemRenderer.renderItem(item.get(), ItemCameraTransforms.TransformType.FIXED, true,
        matrixStackIn, bufferIn, 128, 0, bakedModel);
    matrixStackIn.pop();


  }

  public static float getRed(int color) {
    return (color >> 16 & 0xFF) / 255.0F;
  }

  public static float getGreen(int color) {
    return (color >> 8 & 0xFF) / 255.0F;
  }

  public static float getBlue(int color) {
    return (color & 0xFF) / 255.0F;
  }

  public static float getAlpha(int color) {
    return (color >> 24 & 0xFF) / 255.0F;
  }
}
