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

import com.google.inject.Singleton;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.spongepowered.api.registry.DuplicateRegistrationException;
import org.spongepowered.api.registry.FactoryRegistry;
import org.spongepowered.api.registry.UnknownTypeException;

@Singleton
@SuppressWarnings("unchecked")
public class SpunbricFactoryRegistry implements FactoryRegistry {

    private final Map<Class<?>, Object> factories;

    public SpunbricFactoryRegistry() {
        this.factories = new Object2ObjectArrayMap<>();
    }

    @Override
    public <T> T provideFactory(Class<T> clazz) throws UnknownTypeException {
        checkNotNull(clazz);

        final Object duck = this.factories.get(clazz);
        if (duck == null) {
            throw new UnknownTypeException(String.format("Type '%s' has no factory registered!", clazz));
        }

        return (T) duck;
    }

    public <T> void registerFactory(Class<T> factoryClass, T factory) {
        checkNotNull(factoryClass);
        checkNotNull(factory);

        if (this.factories.containsKey(factoryClass)) {
            throw new DuplicateRegistrationException(String.format("Type '%s' has already been registered as a factory!"));
        }

        this.factories.put(factoryClass, factory);
    }

    public void registerDefaultFactories() {
        // TODO: Register factories
    }
}
