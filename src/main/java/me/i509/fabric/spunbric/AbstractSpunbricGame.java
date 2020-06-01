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

import java.nio.file.Path;
import java.util.Locale;

import org.spongepowered.api.Game;
import org.spongepowered.api.GameState;
import org.spongepowered.api.Server;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.scheduler.Scheduler;

import net.minecraft.server.MinecraftServer;

public abstract class AbstractSpunbricGame implements Game {
    @Override
    public GameState getState() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Scheduler getAsyncScheduler() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Path getGameDirectory() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Server getServer() {
        final MinecraftServer server = AbstractSpunbricMod.getInstance().getServer();

        if (server != null) {
            return (Server) server;
        }

        throw new IllegalStateException("Server is not available");
    }

    @Override
    public boolean isServerAvailable() {
        return AbstractSpunbricMod.getInstance().getServer() != null;
    }

    @Override
    public SystemSubject getSystemSubject() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Locale getLocale(String locale) {
        throw new AssertionError("Implement Me");
    }
}
