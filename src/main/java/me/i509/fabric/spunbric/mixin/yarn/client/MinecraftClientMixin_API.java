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

package me.i509.fabric.spunbric.mixin.yarn.client;

import java.util.Optional;

import javax.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.api.Client;
import org.spongepowered.api.client.LocalServer;
import org.spongepowered.api.entity.living.player.client.LocalPlayer;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.world.client.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.integrated.IntegratedServer;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin_API implements Client {
    @Shadow protected abstract Thread shadow$getThread();
    @Shadow public abstract IntegratedServer shadow$getServer();

    @Override
    public Optional<LocalPlayer> getPlayer() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<LocalServer> getServer() {
        return Optional.ofNullable((LocalServer) this.shadow$getServer());
    }

    @Override
    public Optional<ClientWorld> getWorld() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Scheduler getScheduler() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean onMainThread() {
        return this.shadow$getThread() == Thread.currentThread();
    }
}
