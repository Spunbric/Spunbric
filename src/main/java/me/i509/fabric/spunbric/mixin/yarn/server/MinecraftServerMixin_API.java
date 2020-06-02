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

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.ImmutableList;
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
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.util.math.MathHelper;

import me.i509.fabric.spunbric.world.storage.SpunbricChunkLayout;

@Mixin(MinecraftServer.class)
@Implements(value = @Interface(iface = Server.class, prefix = "server$"))
public abstract class MinecraftServerMixin_API implements Server {
    @Shadow public abstract Thread shadow$getThread();
    @Shadow public abstract void shadow$stop(boolean bl);
    @Shadow public abstract int shadow$getTicks();
    @Shadow public abstract PlayerManager shadow$getPlayerManager();
    @Shadow public abstract boolean shadow$isOnlineMode();
    @Shadow public abstract int shadow$getPlayerIdleTimeout();
    @Shadow public abstract void shadow$setPlayerIdleTimeout(int playerIdleTimeout);
    @Shadow @Final public long[] lastTickLengths;

    // TODO: Scheduler, Scoreboard, ProfileManager, MessageChannel
    //private MessageChannel api$broadcastChannel = MessageChannel.toPlayersAndServer();

    @Override
    public ChunkLayout getChunkLayout() {
        return SpunbricChunkLayout.INSTANCE;
    }

    @Override
    public MessageChannel getBroadcastChannel() {
        //return this.api$broadcastChannel;
        throw new AssertionError("Implement Me"); // TODO
    }

    @Override
    public void setBroadcastChannel(final MessageChannel channel) {
        //this.api$broadcastChannel = checkNotNull(channel, "channel");
        throw new AssertionError("Implement Me"); // TODO
    }

    @Override
    public Optional<InetSocketAddress> getBoundAddress() {
        return Optional.empty();
    }

    @Override
    public boolean hasWhitelist() {
        return this.shadow$getPlayerManager().isWhitelistEnabled();
    }

    @Override
    public void setHasWhitelist(final boolean enabled) {
        this.shadow$getPlayerManager().setWhitelistEnabled(enabled);
    }

    @Override
    public boolean getOnlineMode() {
        return this.shadow$isOnlineMode();
    }

    @Override
    public WorldManager getWorldManager() {
        throw new AssertionError("Implement Me");
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection<Player> getOnlinePlayers() {
        if (this.shadow$getPlayerManager() == null || this.shadow$getPlayerManager().getPlayerList() == null) {
            return ImmutableList.of();
        }

        return ImmutableList.copyOf((List) this.shadow$getPlayerManager().getPlayerList());
    }

    @Override
    public Optional<Player> getPlayer(UUID uniqueId) {
        if (this.shadow$getPlayerManager() == null) {
            return Optional.empty();
        }

        return Optional.ofNullable((Player) this.shadow$getPlayerManager().getPlayer(uniqueId));
    }

    @Override
    public Optional<Player> getPlayer(String name) {
        if (this.shadow$getPlayerManager() == null) {
            return Optional.empty();
        }

        return Optional.ofNullable((Player) this.shadow$getPlayerManager().getPlayer(name));
    }

    @Override
    public Text getMotd() {
        // TODO
        throw new AssertionError("Implement Me");
    }

    @Override
    public int getMaxPlayers() {
        if (this.shadow$getPlayerManager() == null) {
            return 0;
        }

        return this.shadow$getPlayerManager().getMaxPlayerCount();
    }

    @Override
    public int getRunningTimeTicks() {
        return this.shadow$getTicks();
    }

    @Override
    public double getTicksPerSecond() {
        final double nanoSPerTick = MathHelper.average(this.lastTickLengths);
        // Cap at 20 TPS
        return 1000 / Math.max(50, nanoSPerTick / 1000000);
    }

    @Intrinsic
    public void server$shutdown() {
        this.shadow$stop(false);
    }

    @Override
    public void shutdown(final Text kickMessage) {
        // TODO - Text
        throw new AssertionError("Implement Me");
    }

    @Override
    public GameProfileManager getGameProfileManager() {
        // TODO
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<ResourcePack> getDefaultResourcePack() {
        // TODO
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<Scoreboard> getServerScoreboard() {
        // TODO
        throw new AssertionError("Implement Me");
    }

    @Intrinsic
    public int server$getPlayerIdleTimeout() {
        return this.shadow$getPlayerIdleTimeout();
    }

    @Intrinsic
    public void server$setPlayerIdleTimeout(int timeout) {
        this.shadow$setPlayerIdleTimeout(timeout);
    }

    @Override
    public Scheduler getScheduler() {
        // TODO
        throw new AssertionError("Implement Me");
    }

    @Override
    public boolean onMainThread() {
        return this.shadow$getThread() == Thread.currentThread();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
