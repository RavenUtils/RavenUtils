package com.sasnos.ravenutils.api.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

import java.util.Set;
import java.util.stream.Stream;

public class EssentialsWoodTypes extends WoodType {
    private static final Set<WoodType> VALUES = new ObjectArraySet<>();
    public static final WoodType CRIMWOOD = register(new EssentialsWoodTypes("crimwood"));


    protected EssentialsWoodTypes(String nameIn) {
        super(nameIn);
    }

    private static WoodType register(WoodType woodTypeIn) {
        VALUES.add(woodTypeIn);
        return woodTypeIn;
    }

    public static Stream<WoodType> getValues() {
        return VALUES.stream();
    }
}
