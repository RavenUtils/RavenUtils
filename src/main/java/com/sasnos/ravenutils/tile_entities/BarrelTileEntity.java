package com.sasnos.ravenutils.tile_entities;

import com.sasnos.ravenutils.api.tile_entities.EssentialsRecipeTileEntity;
import com.sasnos.ravenutils.blocks.Barrel;
import com.sasnos.ravenutils.init.ModRecipes;
import com.sasnos.ravenutils.init.ModTileEntities;
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
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BarrelTileEntity extends EssentialsRecipeTileEntity<BarrelRecipe> implements ITickableTileEntity {

    private FluidTank fluidTank;

    private LazyOptional<FluidTank> fluidHandler = LazyOptional.of(() -> fluidTank);

    protected int cookingTime;
    protected int cookingTimeTotal;
    protected int recipeUsed;

    public BarrelTileEntity() {
        super(ModTileEntities.BARREL_TILE_ENTITIES.get(), ModRecipes.BARREL_RECIPE_TYPE);
        fluidTank = new FluidTank(10000);
    }

    @Override
    protected ItemStackHandler createHandler() {
        return new ItemStackHandler(1){
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
                if(!getAllRecipeInputsAsItems(ModRecipes.ALLOY_FURNACE_RECIPE_TYPE, world).contains(stack.getItem())){
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @NotNull Direction side) {
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
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
        recipeUsed = nbt.getInt("recipeUsed");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        fluidTank.writeToNBT(compound);
        compound.putInt("cookingTime", cookingTime);
        compound.putInt("cookingTimeTotal", cookingTimeTotal);
        compound.putInt("recipeUsed", recipeUsed);
        return super.write(compound);
    }

    @Override
    public void tick() {

        boolean isDirty = false;

        if(!world.isRemote){
            BarrelRecipe recipe = getRecipe(itemHandler.getStackInSlot(0));
            if(hasRecipe(recipe)){
                ++cookingTime;
                if (cookingTime == cookingTimeTotal) {
                    cookingTime = 0;
                    cookingTimeTotal = recipe.getTimer();
                    handleRecipe(recipe);
                    isDirty = true;
                }
            }
        }
        if(isDirty) markDirty();
    }

    private void handleRecipe(BarrelRecipe recipe) {
        if (hasRecipe(recipe)){
            if(!recipe.getIngredients().get(0).test(ItemStack.EMPTY)){
                itemHandler.getStackInSlot(0).shrink(recipe.getIngredients().get(0).getMatchingStacks()[0].getCount());
            }

            if(recipe.getFluidInput() != FluidStack.EMPTY){
                fluidTank.drain(recipe.getFluidInput().getAmount(), IFluidHandler.FluidAction.EXECUTE);
            }

            if (recipe.getFluidOutput() != Fluids.EMPTY){
                fluidTank.setFluid(new FluidStack(recipe.getFluidOutput(), fluidTank.getFluidAmount()));
            }

            if (recipe.getOutput().get(0) != ItemStack.EMPTY){
                itemHandler.setStackInSlot(0, recipe.getOutput().get(0).copy());
            }
        }


    }

    private boolean hasRecipe(BarrelRecipe recipe) {
        return recipe != null;
    }

    @Override
    protected BarrelRecipe getRecipe(ItemStack stack) {
        Set<IRecipe<?>> recipes = findRecipeByType(type, this.world);
        BlockState blockState = world.getBlockState(pos);
        boolean open = blockState.get(Barrel.HAS_LID);
        for (IRecipe<?> recipe : recipes){
            if(!(recipe instanceof BarrelRecipe)) continue;
            BarrelRecipe barrelRecipe = (BarrelRecipe) recipe;
            if (barrelRecipe.isLidClosed() == open &&
                barrelRecipe.getFluidInput().getFluid() == fluidTank.getFluid().getFluid() &&
                barrelRecipe.getFluidInput().getAmount() <= fluidTank.getFluidAmount() &&
                barrelRecipe.getIngredients().get(0).test(stack)){
                return barrelRecipe;
            }
        }
        return null;
    }
}
