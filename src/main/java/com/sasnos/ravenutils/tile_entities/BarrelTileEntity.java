package com.sasnos.ravenutils.tile_entities;

import com.sasnos.ravenutils.api.tile_entities.EssentialsRecipeTileEntity;
import com.sasnos.ravenutils.blocks.Barrel;
import com.sasnos.ravenutils.init.ModTileEntities;
import com.sasnos.ravenutils.networking.RavenUtilsPacketHandler;
import com.sasnos.ravenutils.networking.SyncTeWithItemHandler;
import com.sasnos.ravenutils.recipes.barrel.BarrelRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BarrelTileEntity extends EssentialsRecipeTileEntity<BarrelRecipe> implements ITickableTileEntity {

  protected int cookingTime;
  protected int cookingTimeTotal;
  private FluidTank fluidTank;
  private final LazyOptional<FluidTank> fluidHandler = LazyOptional.of(() -> fluidTank);

  public BarrelTileEntity() {
    super(ModTileEntities.BARREL_TILE_ENTITIES.get(), BarrelRecipe.BARREL_RECIPE_TYPE);
    fluidTank = new FluidTank(10000);
  }

  @Override
  protected ItemStackHandler createHandler() {
    return new ItemStackHandler(1) {
      @Override
      protected void onContentsChanged(int slot) {
        markDirty();
      }

      @Override
      public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (getAllRecipeInputsAsItems(type, world).contains(stack.getItem())) return true;

        return super.isItemValid(slot, stack);
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (!getAllRecipeInputsAsItems(type, world).contains(stack.getItem())) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  public void update(ItemStack item, FluidStack fluid) {
    itemHandler.setStackInSlot(0, item);
    fluidTank.setFluid(fluid);
  }

  public ItemStack getItem() {
    return itemHandler.getStackInSlot(0);
  }

  public FluidStack getFluid() {
    return fluidTank.getFluid();
  }

  @Override
  public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @NotNull Direction side) {
    if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
      return fluidHandler.cast();
    }

    return super.getCapability(cap, side);
  }

  @Override
  public void read(BlockState state, CompoundNBT nbt) {
    super.read(state, nbt);
    fluidTank.readFromNBT(nbt);
    cookingTime = nbt.getInt("cookingTime");
    cookingTimeTotal = nbt.getInt("cookingTimeTotal");
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    fluidTank.writeToNBT(compound);
    compound.putInt("cookingTime", cookingTime);
    compound.putInt("cookingTimeTotal", cookingTimeTotal);
    return super.write(compound);
  }

  @Override
  public void remove() {
    super.remove();
    fluidHandler.invalidate();
  }

  @Override
  public void tick() {

    boolean isDirty = false;

    if (fluidTank.getFluid().getFluid().getAttributes().getTemperature() > 1000) {
      itemHandler.extractItem(0, itemHandler.getStackInSlot(0).getCount(), false);
    }

    if (!world.isRemote) {
      BarrelRecipe recipe = getRecipe(itemHandler.getStackInSlot(0));
      if (hasRecipe(recipe)) {
        ++cookingTime;
        if (cookingTime == cookingTimeTotal) {
          cookingTime = 0;
          cookingTimeTotal = recipe.getTimer();
          handleRecipe(recipe);
          isDirty = true;
        }
        if (cookingTime > cookingTimeTotal) {
          cookingTime = 0;
        }
      }
    }
    if (isDirty) {
      markDirty();
    }
  }

  public void updateClient() {
    markDirty();
    RavenUtilsPacketHandler.INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> world.getChunkAt(pos)),
        new SyncTeWithItemHandler(itemHandler.getStackInSlot(0), fluidTank.getFluid(), pos));
  }

  private void handleRecipe(BarrelRecipe recipe) {
    if (hasRecipe(recipe)) {
      if (!recipe.getIngredients().get(0).test(ItemStack.EMPTY)) {
        itemHandler.getStackInSlot(0).shrink(recipe.getIngredients().get(0).getMatchingStacks()[0].getCount());
      }

      if (recipe.getFluidInput() != FluidStack.EMPTY) {
        fluidTank.drain(recipe.getFluidInput().getAmount(), IFluidHandler.FluidAction.EXECUTE);
      }

      if (recipe.getFluidOutput() != Fluids.EMPTY) {
        fluidTank.setFluid(new FluidStack(recipe.getFluidOutput(), fluidTank.getFluidAmount()));
      }

      if (recipe.getOutput().get(0) != ItemStack.EMPTY) {
        itemHandler.setStackInSlot(0, recipe.getOutput().get(0).copy());
      }
    }


  }

  @Override
  public CompoundNBT getUpdateTag() {
    CompoundNBT nbt = super.getUpdateTag();
    nbt.put("inv", itemHandler.serializeNBT());
    fluidTank.writeToNBT(nbt);
    return nbt;
  }

  @Override
  public void handleUpdateTag(BlockState state, CompoundNBT tag) {
    itemHandler.deserializeNBT(tag);
    fluidTank.readFromNBT(tag);
    super.handleUpdateTag(state, tag);
  }

  private boolean hasRecipe(BarrelRecipe recipe) {
    return recipe != null;
  }

  @Override
  public BarrelRecipe getRecipe(ItemStack stack) {
    Set<IRecipe<?>> recipes = findRecipeByType(type, this.world);
    BlockState blockState = world.getBlockState(pos);
    boolean open = blockState.get(Barrel.HAS_LID);
    for (IRecipe<?> recipe : recipes) {
      if (!(recipe instanceof BarrelRecipe)) continue;
      BarrelRecipe barrelRecipe = (BarrelRecipe) recipe;
      if (barrelRecipe.isLidClosed() == open &&
          barrelRecipe.getFluidInput().getFluid() == fluidTank.getFluid().getFluid() &&
          barrelRecipe.getFluidInput().getAmount() <= fluidTank.getFluidAmount() &&
          barrelRecipe.getIngredients().get(0).test(stack)) {
        return barrelRecipe;
      }
    }
    return null;
  }

  @Override
  public BarrelRecipe getRecipeFromOutput(ItemStack result) {
    Set<IRecipe<?>> recipes = findRecipeByType(type, this.world);
    BlockState blockState = world.getBlockState(pos);
    boolean open = blockState.get(Barrel.HAS_LID);
    for (IRecipe<?> recipe : recipes) {
      if (!(recipe instanceof BarrelRecipe)) continue;
      BarrelRecipe barrelRecipe = (BarrelRecipe) recipe;
      if (barrelRecipe.isLidClosed() == open &&
          barrelRecipe.getFluidInput().getFluid() == fluidTank.getFluid().getFluid() &&
          barrelRecipe.getFluidInput().getAmount() <= fluidTank.getFluidAmount() &&
          ItemStack.areItemStackTagsEqual(barrelRecipe.getOutput().get(0), result)) {
        return barrelRecipe;
      }
    }
    return null;
  }

  public void setCookingTimeTotal(int timer) {
    cookingTimeTotal = timer;
  }
}
