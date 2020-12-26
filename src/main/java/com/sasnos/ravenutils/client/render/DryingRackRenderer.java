package com.sasnos.ravenutils.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sasnos.ravenutils.tile_entities.DryingRackTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class DryingRackRenderer extends TileEntityRenderer<DryingRackTileEntity> {

  public DryingRackRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
    super(rendererDispatcherIn);
  }

  @Override
  public void render(DryingRackTileEntity tileEntityIn, float partialTicks, @NotNull MatrixStack matrixStackIn, @NotNull IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
    LazyOptional<IItemHandler> cap = tileEntityIn.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
    if (cap.resolve().isPresent()) {
      IItemHandler itemHandler = cap.resolve().get();
      Direction facing = tileEntityIn.getBlockState().get(BlockStateProperties.FACING);

      int slots = itemHandler.getSlots();

      for (int i = 0; i < slots; i++) {
        ItemStack item = itemHandler.getStackInSlot(i);
        matrixStackIn.push();

        matrixStackIn.translate(getXForPosition(facing, i), 1.02f, getZForPosition(facing, i));

        matrixStackIn.scale(0.5f, 0.5f, 0.5f);
        matrixStackIn.rotate(new Quaternion(90f, 0, getRotationForFace(facing), true));
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        IBakedModel bakedModel = itemRenderer.getItemModelWithOverrides(item, tileEntityIn.getWorld(), null);
        itemRenderer.renderItem(item, ItemCameraTransforms.TransformType.FIXED, true,
            matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, bakedModel);
        matrixStackIn.pop();
      }
    }
  }

  private float getRotationForFace(Direction facing) {
    if (facing == Direction.NORTH) {
      return 0;
    } else if (facing == Direction.EAST) {
      return 90;
    } else if (facing == Direction.SOUTH) {
      return 180;
    } else if (facing == Direction.WEST) {
      return 270;
    }
    return 0;
  }

  private double getXForPosition(Direction facing, int slot) {
    if (facing == Direction.NORTH) {
      if (slot == 1 || slot == 3) return .25;
      if (slot == 0 || slot == 2) return .75;
    } else if (facing == Direction.EAST) {
      if (slot == 1 || slot == 0) return .30;
      if (slot == 3 || slot == 2) return .75;
    } else if (facing == Direction.SOUTH) {
      if (slot == 0 || slot == 2) return .25;
      if (slot == 1 || slot == 3) return .75;
    } else if (facing == Direction.WEST) {
      if (slot == 2 || slot == 3) return .25;
      if (slot == 0 || slot == 1) return .70;
    }
    return .25;
  }

  private double getZForPosition(Direction facing, int slot) {
    if (facing == Direction.NORTH) {
      if (slot == 0 || slot == 1) return .70;
      if (slot == 2 || slot == 3) return .25;
    } else if (facing == Direction.EAST) {
      if (slot == 1 || slot == 3) return .25;
      if (slot == 0 || slot == 2) return .75;
    } else if (facing == Direction.SOUTH) {
      if (slot == 0 || slot == 1) return .30;
      if (slot == 2 || slot == 3) return .75;
    } else if (facing == Direction.WEST) {
      if (slot == 1 || slot == 3) return .75;
      if (slot == 0 || slot == 2) return .25;
    }
    return 0.75;
  }
}
