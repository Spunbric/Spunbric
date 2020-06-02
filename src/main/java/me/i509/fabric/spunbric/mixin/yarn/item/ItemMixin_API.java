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

package me.i509.fabric.spunbric.mixin.yarn.item;

import static com.google.common.base.Preconditions.checkState;

import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import me.i509.fabric.spunbric.SpunbricTranslation;

@Mixin(Item.class)
public abstract class ItemMixin_API implements ItemType {

    @Shadow public abstract int shadow$getMaxCount();
    @Shadow public abstract String shadow$getTranslationKey();

    @Nullable protected BlockType api$blockType = null;
    // ItemType

    @Override
    public Optional<BlockType> getBlock() {
        return Optional.ofNullable(this.api$blockType);
    }

    @Override
    public Optional<ItemType> getContainer() {
        return Optional.empty(); // TODO: Propagate to impls
    }

    @Override
    public int getMaxStackQuantity() {
        return this.shadow$getMaxCount();
    }

    // CatalogType

    @Override
    public CatalogKey getKey() {
        final Identifier id = Registry.ITEM.getId((Item) (Object) this);
        checkState(id != null, "Attempted to access the id before the Item is registered.");

        return (CatalogKey) (Object) id;
    }

    // Translatable

    @Override
    public Translation getTranslation() {
        return new SpunbricTranslation(this.shadow$getTranslationKey() + ".name");
    }
}
