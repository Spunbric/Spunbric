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

package me.i509.fabric.spunbric.data;

import java.util.Collection;
import java.util.Optional;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataHolderBuilder;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataContentUpdater;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.plugin.PluginContainer;

public class SpunbricDataManager implements DataManager {
    @Override
    public <T extends DataSerializable> void registerBuilder(Class<T> clazz, DataBuilder<T> builder) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataSerializable> void registerContentUpdater(Class<T> clazz, DataContentUpdater updater) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataSerializable> Optional<DataContentUpdater> getWrappedContentUpdater(Class<T> clazz, int fromVersion, int toVersion) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataSerializable> Optional<DataBuilder<T>> getBuilder(Class<T> clazz) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataSerializable> Optional<T> deserialize(Class<T> clazz, DataView dataView) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> void register(Class<T> holderClass, B builder) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void registerLegacyManipulatorIds(String legacyId, DataRegistration registration) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> Optional<B> getImmutableBuilder(Class<T> holderClass) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> Optional<DataTranslator<T>> getTranslator(Class<T> objectClass) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Collection<DataRegistration> getAllRegistrationsFor(PluginContainer container) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public DataContainer createContainer() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public DataContainer createContainer(DataView.SafetyMode safety) {
        throw new AssertionError("Implement Me");
    }
}
