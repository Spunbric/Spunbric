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

package me.i509.fabric.spunbric.mixin.yarn.server;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.profile.GameProfileManager;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.world.server.WorldManager;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
@Implements(value = @Interface(iface = Server.class, prefix = "server$"))
public abstract class MinecraftServerMixin_API implements Server {
    @Override
    public ChunkLayout getChunkLayout() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public MessageChannel getBroadcastChannel() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void setBroadcastChannel(final MessageChannel channel) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<InetSocketAddress> getBoundAddress() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean hasWhitelist() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void setHasWhitelist(final boolean enabled) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean getOnlineMode() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public WorldManager getWorldManager() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Collection<Player> getOnlinePlayers() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<Player> getPlayer(UUID uniqueId) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<Player> getPlayer(String name) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Text getMotd() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public int getMaxPlayers() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public int getRunningTimeTicks() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public double getTicksPerSecond() {
        throw new AssertionError("Implement Me");
    }

    @Intrinsic
    public void server$shutdown() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void shutdown(final Text kickMessage) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public GameProfileManager getGameProfileManager() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<ResourcePack> getDefaultResourcePack() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<Scoreboard> getServerScoreboard() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getPlayerIdleTimeout() {
        throw new AssertionError("Implement Me");
    }

    @Intrinsic
    public void server$setPlayerIdleTimeout(int timeout) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Scheduler getScheduler() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean onMainThread() {
        throw new AssertionError("Implement Me");
    }
}
