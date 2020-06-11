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

package me.i509.fabric.spunbric.mixin.yarn.village;

import static com.google.common.base.Preconditions.checkState;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Mixin(net.minecraft.village.VillagerType.class)
public interface VillagerTypeMixin_API extends VillagerType {
    @Override
    default CatalogKey getKey() {
        final Identifier id = Registry.VILLAGER_TYPE.getId((net.minecraft.village.VillagerType) (Object) this);
        checkState(id != null, "Attempted to access the id before the VillagerType is registered.");

        return (CatalogKey) (Object) id;
    }
}
