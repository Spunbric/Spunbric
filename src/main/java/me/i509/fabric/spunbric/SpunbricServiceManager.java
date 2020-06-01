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

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.ProviderRegistration;
import org.spongepowered.api.service.ProvisioningException;
import org.spongepowered.api.service.ServiceManager;

public class SpunbricServiceManager implements ServiceManager {
    @Override
    public <T> void setProvider(PluginContainer plugin, Class<T> service, T provider) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> Optional<T> provide(Class<T> service) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> Optional<ProviderRegistration<T>> getRegistration(Class<T> service) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        throw new AssertionError("Implement Me");
    }
}
