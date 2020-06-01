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

package me.i509.fabric.spunbric.event;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.plugin.PluginContainer;

public class SpunbricEventManager implements EventManager {
    @Override
    public void registerListeners(PluginContainer plugin, Object obj) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, boolean beforeModifications, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, boolean beforeModifications, EventListener<? super T> listener) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void unregisterListeners(Object obj) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void unregisterPluginListeners(PluginContainer plugin) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean post(Event event) {
        throw new AssertionError("Implement Me");
    }
}
