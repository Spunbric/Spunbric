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

package me.i509.fabric.spunbric.world.biome;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.biome.VirtualBiomeType;

import me.i509.fabric.spunbric.util.SpunbricCatalogBuilder;

public final class SpunbricVirtualBiomeTypeBuilder extends SpunbricCatalogBuilder<VirtualBiomeType, VirtualBiomeType.Builder> implements VirtualBiomeType.Builder {

    private double temperature;
    private double humidity;
    private BiomeType persisted;

    public SpunbricVirtualBiomeTypeBuilder() {
        this.reset();
    }

    @Override
    public VirtualBiomeType.Builder temperature(double temp) {
        this.temperature = temp;
        return this;
    }

    @Override
    public VirtualBiomeType.Builder humidity(double humidity) {
        this.humidity = humidity;
        return this;
    }

    @Override
    public VirtualBiomeType.Builder persistedType(BiomeType biome) {
        checkNotNull(biome, "biome");
        checkArgument(!(biome instanceof VirtualBiomeType), "persisted type cannot be a virtual biome");
        this.persisted = biome;
        return this;
    }

    @Override
    protected VirtualBiomeType build(CatalogKey key) {
        checkNotNull(key, "key");
        checkNotNull(this.persisted, "persistedBiome");
        return new SpunbricVirtualBiomeType(this.key, this.temperature, this.humidity, this.persisted);
    }

    @Override
    public VirtualBiomeType.Builder reset() {
        super.reset();
        this.temperature = 0;
        this.humidity = 0;
        this.persisted = BiomeTypes.VOID.get();
        return this;
    }
}
