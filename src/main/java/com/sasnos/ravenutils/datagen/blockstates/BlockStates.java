package com.sasnos.ravenutils.datagen.blockstates;

import com.sasnos.ravenutils.RavenUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

import static com.sasnos.ravenutils.util.Utils.RL;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen,  ExistingFileHelper exFileHelper) {
        super(gen, RavenUtils.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        models().cubeAll("black_coal_block",
                RL("block/black_coal_block"));

        models().cubeAll("black_coal_ore",
                RL("block/black_coal_ore"));

        models().cubeAll("crimleaf", RL("crimleaf"));

        models().cubeAll("crimwood", RL("crimwood"));

        //models().cubeAll("crimwood_button", RL("crimwood_button"));

        //models().cubeAll("crimwood_door", RL("crimwood_door"));

        //models().cubeAll("crimwood_fence", RL("crimwood_fence"));

        //models().fenceGate("crimwood_fence_gate", RL("crimwood_fence_gate"));

        models().cubeAll("crimwood_leaves", RL("crimwoods_leaves"));

        models().cubeBottomTop("crimwood_log",
                RL("crimwood_log"),
                RL("crimwood_log_top"),
                RL("crimwood_log_top"));

        models().cubeAll("crimwood_planks", RL("crimwood_planks"));

        //models().cubeAll("crimwood_pressure_plate", RL("crimwood_pressure_plate"));

        models().cross("crimwood_sapling", RL("crimwood_sapling"));

        //models().cubeAll("crimwood_sign", RL("crimwood_sign"));

//        models().slab("crimwood_slab",
//                RL("crimwood_slab"),
//                RL("crimwood_slab_bottom"),
//                RL("crimwood_slap_top"));

        models().cubeAll("fossil_dirt", RL("fossil_dirt"));

        models().cubeAll("fossil_ore", RL("fossil_ore"));

        models().cubeAll("limestone", RL("limestone"));

    }


    public void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.get(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir.getAxis() == Direction.Axis.Y ?  dir.getAxisDirection().getOffset() * -90 : 0)
                            .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.getHorizontalIndex() + 2) % 4) * 90 : 0)
                            .build();
                });
    }
}
