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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

@Singleton
public class SpunbricPlatform implements Platform {
    protected final Map<String, Object> platformMap = new SpunbricPlatform.PlatformMap();
    private final MinecraftVersion minecraftVersion;

    @Inject
    public SpunbricPlatform(PluginManager pluginManager, MinecraftVersion version) {
        this.minecraftVersion = checkNotNull(version);

        // TODO: Populate platform map
    }

    @Override
    public Type getType() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER ? Type.SERVER : Type.CLIENT;
    }

    @Override
    public Type getExecutionType() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public PluginContainer getContainer(Component component) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public MinecraftVersion getMinecraftVersion() {
        return this.minecraftVersion;
    }

    @Override
    public Map<String, Object> asMap() {
        return this.platformMap;
    }

    static final class PlatformMap extends HashMap<String, Object> {
        private static final long serialVersionUID = 7022397614988467398L;

        @Override
        public Object put(String key, Object value) {
            checkArgument(!this.containsKey(key), "Cannot set the value of the existing key %s", key);
            return super.put(key, value);
        }
    }
}
