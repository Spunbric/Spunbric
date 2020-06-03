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

package me.i509.fabric.spunbric.mixin.yarn.enchantment;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Mixin(Enchantment.class)
@Implements(@Interface(iface = EnchantmentType.class, prefix = "enchantment$"))
public abstract class EnchantmentMixin_API implements EnchantmentType {
    @Shadow public abstract Enchantment.Weight shadow$getWeight();
    @Shadow public abstract boolean shadow$isTreasure();
    @Shadow public abstract boolean shadow$isCursed();
    @Shadow public abstract int shadow$getMinimumLevel();
    @Shadow public abstract int shadow$getMaximumLevel();
    @Shadow public abstract int shadow$getMaximumPower(int level);
    @Shadow public abstract int shadow$getMinimumPower(int level);

    @Nullable private Identifier api$id;

    @Override
    public int getWeight() {
        return this.shadow$getWeight().getWeight();
    }

    @Intrinsic
    public int enchantment$getMinimumLevel() {
        return this.shadow$getMinimumLevel();
    }

    @Intrinsic
    public int enchantment$getMaximumLevel() {
        return this.shadow$getMaximumLevel();
    }

    @Override
    public int getMinimumEnchantabilityForLevel(int level) {
        return this.shadow$getMinimumPower(level);
    }

    @Override
    public int getMaximumEnchantabilityForLevel(int level) {
        return this.shadow$getMaximumPower(level);
    }

    @Override
    public boolean canBeAppliedToStack(ItemStack stack) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean canBeAppliedByTable(ItemStack stack) {
        return this.canBeAppliedToStack(stack);
    }

    @Override
    public boolean isCompatibleWith(EnchantmentType enchantmentType) {
        throw new AssertionError("Implement Me");
    }

    @Intrinsic
    public boolean enchantment$isTreasure() {
        return this.shadow$isTreasure();
    }

    @Override
    public boolean isCurse() {
        return this.shadow$isCursed();
    }

    @Override
    public CatalogKey getKey() {
        if (this.api$id == null) {
            final Identifier id = Registry.ENCHANTMENT.getId((Enchantment) (Object) this);
            if (id != null) {
                this.api$id = id;
            }
        }

        return (CatalogKey) (Object) this.api$id;
    }

    @Override
    public Translation getTranslation() {
        throw new AssertionError("Implement Me: Stack in name?");
    }
}
