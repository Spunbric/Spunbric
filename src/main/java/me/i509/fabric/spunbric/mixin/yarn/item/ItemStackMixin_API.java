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

import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.item.Item;

import me.i509.fabric.spunbric.SpunbricTranslation;

@Mixin(net.minecraft.item.ItemStack.class)
@Implements(@Interface(iface = ItemStack.class, prefix = "apiStack$"))
public abstract class ItemStackMixin_API implements ItemStack {
    @Shadow public abstract Item shadow$getItem();
    @Shadow public abstract int shadow$getCount();
    @Shadow public abstract int shadow$getMaxCount();
    @Shadow public abstract boolean shadow$isEmpty();
    @Shadow public abstract void shadow$setCount(int count);
    @Shadow public abstract net.minecraft.item.ItemStack shadow$copy();

    @Override
    public ItemType getType() {
        return (ItemType) this.shadow$getItem();
    }

    @Override
    public int getQuantity() {
        return this.shadow$getCount();
    }

    @Override
    public void setQuantity(int quantity) throws IllegalArgumentException {
        this.shadow$setCount(quantity);
    }

    @Override
    public int getMaxStackQuantity() {
        return this.shadow$getMaxCount();
    }

    @Intrinsic
    public boolean apiStack$isEmpty() {
        return this.shadow$isEmpty();
    }

    public ItemStack apiStack$copy() {
        return (ItemStack) (Object) this.shadow$copy();
    }

    @Override
    public boolean equalTo(ItemStack that) {
        return net.minecraft.item.ItemStack.areItemsEqual(
                (net.minecraft.item.ItemStack) (Object) this,
                (net.minecraft.item.ItemStack) (Object) that
        );
    }

    @Override
    public ItemStackSnapshot createSnapshot() {
        throw new AssertionError("Implement Me");
    }

    // DataSerializable

    @Override
    public int getContentVersion() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public DataContainer toContainer() {
        throw new AssertionError("Implement Me");
    }

    // Translatable

    @Override
    public Translation getTranslation() {
        return new SpunbricTranslation(this.shadow$getItem().getTranslationKey((net.minecraft.item.ItemStack) (Object) this) + ".name");
    }
}
