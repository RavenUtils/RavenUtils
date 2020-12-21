package com.sasnos.ravenutils.utils;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class Materials {

    Material GROUND_STICK = (new MaterialsBuilder(MaterialColor.WOOD)).flammable().replaceable().build();
    Material GROUND_ROCK = (new MaterialsBuilder(MaterialColor.STONE)).replaceable().build();

    public class MaterialsBuilder {

        private PushReaction pushReaction = PushReaction.NORMAL;
        private boolean blocksMovement = true;
        private boolean canBurn;
        private boolean isLiquid;
        private boolean isReplaceable;
        private boolean isSolid = true;
        private final MaterialColor color;
        private boolean isOpaque = true;

        public MaterialsBuilder(MaterialColor color) {
            this.color = color;
        }

        public MaterialsBuilder liquid() {
            this.isLiquid = true;
            return this;
        }

        public MaterialsBuilder notSolid() {
            this.isSolid = false;
            return this;
        }

        public MaterialsBuilder doesNotBlockMovement() {
            this.blocksMovement = false;
            return this;
        }

        public MaterialsBuilder notOpaque() {
            this.isOpaque = false;
            return this;
        }

        protected MaterialsBuilder flammable() {
            this.canBurn = true;
            return this;
        }

        public MaterialsBuilder replaceable() {
            this.isReplaceable = true;
            return this;
        }

        protected MaterialsBuilder pushDestroys() {
            this.pushReaction = PushReaction.DESTROY;
            return this;
        }

        protected MaterialsBuilder pushBlocks() {
            this.pushReaction = PushReaction.BLOCK;
            return this;
        }

        public Material build() {
            return new Material(this.color, this.isLiquid, this.isSolid, this.blocksMovement, this.isOpaque, this.canBurn, this.isReplaceable, this.pushReaction);
        }
    }
}
