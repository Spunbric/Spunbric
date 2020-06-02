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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.spongepowered.api.item.merchant.VillagerRegistry;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.registry.BuilderRegistry;
import org.spongepowered.api.registry.CatalogRegistry;
import org.spongepowered.api.registry.FactoryRegistry;
import org.spongepowered.api.registry.GameRegistry;

@Singleton
public final class SpunbricGameRegistry implements GameRegistry {

    private final SpunbricCatalogRegistry catalogRegistry;
    private final SpunbricBuilderRegistry builderRegistry;
    private final SpunbricFactoryRegistry factoryRegistry;

    @Inject
    public SpunbricGameRegistry(final SpunbricCatalogRegistry catalogRegistry, final SpunbricBuilderRegistry builderRegistry,
        final SpunbricFactoryRegistry factoryRegistry) {
        this.catalogRegistry = catalogRegistry;
        this.builderRegistry = builderRegistry;
        this.factoryRegistry = factoryRegistry;
    }

    @Override
    public SpunbricCatalogRegistry getCatalogRegistry() {
        return this.catalogRegistry;
    }

    @Override
    public SpunbricBuilderRegistry getBuilderRegistry() {
        return this.builderRegistry;
    }

    @Override
    public SpunbricFactoryRegistry getFactoryRegistry() {
        return this.factoryRegistry;
    }

    @Override
    public RecipeRegistry getRecipeRegistry() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public VillagerRegistry getVillagerRegistry() {
        throw new AssertionError("Implement Me");
    }
}
