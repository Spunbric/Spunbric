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

package me.i509.fabric.spunbric;

import java.util.Optional;
import java.util.Set;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Platform;
import org.spongepowered.api.network.ChannelBinding;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.network.ChannelRegistrationException;
import org.spongepowered.api.plugin.PluginContainer;

public class SpunbricChannelRegistrar implements ChannelRegistrar {
    @Override
    public ChannelBinding.IndexedMessageChannel createChannel(PluginContainer plugin, CatalogKey channelKey) throws ChannelRegistrationException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public ChannelBinding.RawDataChannel createRawChannel(PluginContainer plugin, CatalogKey channelKey) throws ChannelRegistrationException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<ChannelBinding> getChannel(CatalogKey channelkey) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void unbindChannel(ChannelBinding channel) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Set<CatalogKey> getRegisteredChannels(Platform.Type side) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean isChannelAvailable(CatalogKey channelKey) {
        throw new AssertionError("Implement Me");
    }
}
