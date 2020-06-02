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

import static com.google.common.base.Preconditions.checkState;

import java.util.Collection;
import java.util.Optional;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockSoundGroup;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import me.i509.fabric.spunbric.SpunbricTranslation;

@Mixin(value = Block.class, priority = 999)
public abstract class BlockMixin_API implements BlockType {
    @Shadow public abstract net.minecraft.block.BlockState shadow$getDefaultState();
    @Shadow public abstract StateManager<Block, net.minecraft.block.BlockState> shadow$getStateManager();
    @Shadow public abstract Item shadow$asItem();
    @Shadow @Final @org.spongepowered.asm.mixin.Mutable protected boolean randomTicks;
    @Shadow @Final protected net.minecraft.sound.BlockSoundGroup soundGroup;

    // BlockType

    @Shadow public abstract String shadow$getTranslationKey();

    @Override
    public Optional<ItemType> getItem() {
        final Item item = this.shadow$asItem();

        if (item == Items.AIR) {
            return Optional.empty();
        }

        return Optional.ofNullable((ItemType) item);
    }

    @Override
    public boolean doesUpdateRandomly() {
        return this.randomTicks;
    }

    @Override
    public void setUpdateRandomly(boolean updateRandomly) {
        this.randomTicks = updateRandomly;
    }

    @Override
    public BlockSoundGroup getSoundGroup() {
        return (BlockSoundGroup) this.soundGroup;
    }

    // CatalogType

    @Override
    public CatalogKey getKey() {
        final Identifier id = Registry.BLOCK.getId((Block) (Object) this);
        checkState(id != null, "Attempted to access the id before the Block is registered.");

        return (CatalogKey) (Object) id;
    }

    // StateContainer

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ImmutableList<BlockState> getValidStates() {
        return (ImmutableList) this.shadow$getStateManager().getStates();
    }

    @Override
    public BlockState getDefaultState() {
        return (BlockState) this.shadow$getDefaultState();
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection<StateProperty<?>> getStateProperties() {
        return (Collection) this.shadow$getStateManager().getProperties();
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Optional<StateProperty<?>> getStatePropertyByName(String name) {
        return Optional.ofNullable((StateProperty) this.shadow$getStateManager().getProperty(name));
    }

    // Translatable

    @Override
    public Translation getTranslation() {
        return new SpunbricTranslation(this.shadow$getTranslationKey());
    }
}
