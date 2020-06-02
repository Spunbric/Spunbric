/*
 * The MIT License (MIT)
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) i509VCB <git@i509.me>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package me.i509.fabric.spunbric.mixin.yarn.block;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.Location;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;

import me.i509.fabric.spunbric.mixin.yarn.state.AbstractStateMixin_API;

@Mixin(net.minecraft.block.BlockState.class)
public abstract class BlockStateMixin_API extends AbstractStateMixin_API<BlockState, net.minecraft.block.BlockState> implements BlockState {
    @Shadow public abstract Block shadow$getBlock();
    @Shadow public abstract net.minecraft.fluid.FluidState shadow$getFluidState();

    @Override
    public BlockType getType() {
        return (BlockType) this.shadow$getBlock();
    }

    @Intrinsic
    public FluidState getFluidState() {
        // TODO: Fluids
        //return (FluidState) this.shadow$getFluidState();
        throw new AssertionError("Implement Me");
    }

    @Override
    public int getContentVersion() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public DataContainer toContainer() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public BlockSnapshot snapshotFor(Location location) {
        throw new AssertionError("Implement Me: Core");
    }
}
