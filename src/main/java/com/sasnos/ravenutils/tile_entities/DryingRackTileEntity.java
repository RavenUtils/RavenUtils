package com.sasnos.ravenutils.tile_entities;

import com.sasnos.ravenutils.api.tile_entities.EssentialsRecipeTileEntity;
import com.sasnos.ravenutils.init.ModTileEntities;
import com.sasnos.ravenutils.recipes.drying_rack.DryingRackRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Set;

public class DryingRackTileEntity extends EssentialsRecipeTileEntity<DryingRackRecipe> implements ITickableTileEntity {

  HashMap<Integer, DryingObject> slotTimer = new HashMap<>(4);

  public DryingRackTileEntity() {
    super(ModTileEntities.DRYING_RACK_TILE_ENTITIES.get(), DryingRackRecipe.DRYING_RACK_RECIPE_TYPE);
  }

  @Override
  protected ItemStackHandler createHandler() {
    return new ItemStackHandler(4) {
      @Override
      protected void onContentsChanged(int slot) {
        slotTimer.put(slot, null);
        markDirty();
      }

      @Override
      public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (getAllRecipeInputsAsItems(type, world).contains(stack.getItem()) || getAllRecipeOutputAsItems(type, world).contains(stack.getItem()))
          return true;
        return super.isItemValid(slot, stack);
      }

      @NotNull
      @Override
      public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (!isItemValid(slot, stack)) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }

      @NotNull
      @Override
      public ItemStack extractItem(int slot, int amount, boolean simulate) {
        ItemStack result = super.extractItem(slot, amount, simulate);
        DryingRackRecipe recipe = getRecipeFromOutput(result);
        if (!simulate && recipe != null) {
          int recipeResult = recipe.getOutput().get(0).getCount();
          float xp = recipe.getXp();
          int resultCount = result.getCount();
          int count = resultCount / recipeResult;
          BlockPos pos = DryingRackTileEntity.this.pos;
          splitAndSpawnExperience(DryingRackTileEntity.this.world, pos, count, xp);
        }
        return result;
      }

      @Override
      public int getSlotLimit(int slot) {
        return 1;
      }
    };
  }

  private void handleUpdate() {
    if (world != null) {
      world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
    }
  }

  @Override
  protected DryingRackRecipe getRecipe(ItemStack stack) {
    Set<IRecipe<?>> recipes = findRecipeByType(type, this.world);
    for (IRecipe<?> recipe : recipes) {
      if (!(recipe instanceof DryingRackRecipe)) continue;
      DryingRackRecipe barrelRecipe = (DryingRackRecipe) recipe;
      if (barrelRecipe.getIngredients().get(0).test(stack)) {
        return barrelRecipe;
      }
    }
    return null;
  }

  @Override
  public DryingRackRecipe getRecipeFromOutput(ItemStack result) {
    Set<IRecipe<?>> recipes = findRecipeByType(type, this.world);
    for (IRecipe<?> recipe : recipes) {
      if (!(recipe instanceof DryingRackRecipe)) continue;
      DryingRackRecipe barrelRecipe = (DryingRackRecipe) recipe;
      if (ItemStack.areItemsEqual(barrelRecipe.getOutput().get(0), result)) {
        return barrelRecipe;
      }
    }
    return null;
  }

  @Override
  public void read(BlockState state, CompoundNBT nbt) {
    ListNBT tagList = nbt.getList("slots", Constants.NBT.TAG_COMPOUND);
    tagList.forEach(inbt -> {
      CompoundNBT nbti = ((CompoundNBT) inbt);
      slotTimer.put(nbti.getInt("Slot"), DryingObject.deserialize(nbti));
    });
    super.read(state, nbt);
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    Set<Integer> keys = slotTimer.keySet();
    ListNBT nbtTagList = new ListNBT();
    for (Integer slot : keys) {
      DryingObject obj = slotTimer.get(slot);
      if (obj == null) continue;
      obj.serialize(nbtTagList, slot);
    }
    compound.put("slots", nbtTagList);
    return super.write(compound);
  }

  @Override
  public @NotNull CompoundNBT getUpdateTag() {
    CompoundNBT nbt = super.getUpdateTag();
    nbt.put("inv", itemHandler.serializeNBT());
    return nbt;
  }

  @Override
  public void handleUpdateTag(BlockState state, CompoundNBT tag) {
    itemHandler.deserializeNBT(tag);
  }

  @Nullable
  @Override
  public SUpdateTileEntityPacket getUpdatePacket() {
    return new SUpdateTileEntityPacket(pos, -1, itemHandler.serializeNBT());
  }

  @Override
  public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
    itemHandler.deserializeNBT(pkt.getNbtCompound());
  }

  @Override
  public void tick() {

    assert world != null;
    if (!world.isRemote) {
      slotTimer.forEach((integer, dryingObject) -> {
        DryingRackRecipe recipe = getRecipe(itemHandler.getStackInSlot(integer));
        if (recipe == null) return;
        if (dryingObject == null) {
          slotTimer.put(integer, new DryingObject(itemHandler.getStackInSlot(0), 0, recipe.getTimer()));
          markDirty();
          return;
        }
        if (dryingObject.tick()) {
          handleRecipeForSlot(integer, recipe);
          markDirty();
        }
      });
    }
  }

  @Override
  public void markDirty() {
    super.markDirty();
    handleUpdate();
  }

  private void handleRecipeForSlot(Integer slot, DryingRackRecipe recipe) {
    if (recipe == null) return;
    itemHandler.extractItem(slot, 1, false);
    itemHandler.insertItem(slot, recipe.getOutput().get(0).copy(), false);
  }

  private static class DryingObject {
    private final ItemStack item;
    private final int cookingTimeTotal;
    private int cookingTime;

    public DryingObject(ItemStack item, int cookingTime, int cookingTimeTotal) {
      this.item = item;
      this.cookingTime = cookingTime;
      this.cookingTimeTotal = cookingTimeTotal;
    }

    public static DryingObject deserialize(CompoundNBT nbt) {
      ItemStack item = ItemStack.read(nbt);
      int cookingTime = nbt.getInt("cookingTime");
      int cookingTimeTotal = nbt.getInt("cookingTimeTotal");
      return new DryingObject(item, cookingTime, cookingTimeTotal);
    }

    public boolean tick() {
      cookingTime++;
      return cookingTime >= cookingTimeTotal;
    }

    public void serialize(ListNBT nbt, int slot) {
      CompoundNBT itemTag = new CompoundNBT();
      itemTag.putInt("Slot", slot);
      item.write(itemTag);
      itemTag.putInt("cookingTime", cookingTime);
      itemTag.putInt("cookingTimeTotal", cookingTimeTotal);
      nbt.add(itemTag);
    }
  }
}
