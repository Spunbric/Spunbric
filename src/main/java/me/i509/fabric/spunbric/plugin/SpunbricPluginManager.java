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

package me.i509.fabric.spunbric.plugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import net.fabricmc.loader.api.ModContainer;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

public class SpunbricPluginManager implements PluginManager {
    private final Map<ModContainer, PluginContainer> pluginContainersByMod = new HashMap<>();
    private final Map<PluginContainer, ModContainer> modContainersByPlugin = new HashMap<>();

    @Override
    public Optional<PluginContainer> fromInstance(Object instance) {
        if (instance instanceof ModContainer) { // If a mod container is passed, use that to get the plugin containers
            return Optional.ofNullable(this.pluginContainersByMod.get(instance));
        }

        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<PluginContainer> getPlugin(String id) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean isLoaded(String id) {
        throw new AssertionError("Implement Me");
    }
}
