package com.sasnos.ravenutils.blocks.modules.alloyfurnace;

import com.sasnos.ravenutils.RavenUtils;
import com.sasnos.ravenutils.api.screens.EssentialsMachineScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class EssentialsFurnaceScreen extends EssentialsMachineScreen<EssentialsAlloyFurnaceContainer> {

    private ResourceLocation GUI = new ResourceLocation(RavenUtils.MOD_ID, "textures/gui/metalage/alloy_furnace.png");

    public EssentialsFurnaceScreen(EssentialsAlloyFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @NotNull
    @Override
    protected ResourceLocation getGUI() {
        return GUI;
    }
}
