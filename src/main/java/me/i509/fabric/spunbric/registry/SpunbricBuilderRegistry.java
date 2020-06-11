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

package me.i509.fabric.spunbric.registry;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.function.Supplier;

import com.google.inject.Singleton;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.registry.BuilderRegistry;
import org.spongepowered.api.registry.DuplicateRegistrationException;
import org.spongepowered.api.registry.UnknownTypeException;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.biome.VirtualBiomeType;

import me.i509.fabric.spunbric.world.biome.SpunbricVirtualBiomeTypeBuilder;

@Singleton
@SuppressWarnings("unchecked")
public class SpunbricBuilderRegistry implements BuilderRegistry {

    private final Map<Class<?>, Supplier<?>> builders;

    public SpunbricBuilderRegistry() {
        builders = new Object2ObjectArrayMap<>();
        this.registerDefaultBuilders(); // TODO: is this the right spot?
    }

    @Override
    public <T extends ResettableBuilder<?, ? super T>> T provideBuilder(Class<T> builderClass) throws UnknownTypeException {
        checkNotNull(builderClass);

        final Supplier<?> supplier = this.builders.get(builderClass);
        if (supplier == null) {
            throw new UnknownTypeException(String.format("Type '%s' has no builder registered!", builderClass));
        }

        return (T) supplier.get();
    }

    public <T> SpunbricBuilderRegistry register(final Class<T> builderClass, final Supplier<? extends T> supplier) {
        checkNotNull(builderClass);
        checkNotNull(supplier);

        if (this.builders.containsKey(builderClass)) {
            throw new DuplicateRegistrationException(String.format("Type '%s' has already been registered as a builder!", builderClass));
        }

        this.builders.put(builderClass, supplier);
        return this;
    }

    public void registerDefaultBuilders() {
        // TODO: Register all builders
        this
            .register(CatalogKey.Builder.class, SpunbricCatalogKeyBuilder::new)
            .register(VirtualBiomeType.Builder.class, SpunbricVirtualBiomeTypeBuilder::new);
    }
}
