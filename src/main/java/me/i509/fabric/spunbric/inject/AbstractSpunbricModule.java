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

package me.i509.fabric.spunbric.inject;

import com.google.inject.PrivateModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.registry.GameRegistry;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;
import org.spongepowered.api.world.TeleportHelper;

import me.i509.fabric.spunbric.AbstractSpunbricGame;
import me.i509.fabric.spunbric.AbstractSpunbricMod;
import me.i509.fabric.spunbric.asset.SpunbricAssetManager;
import me.i509.fabric.spunbric.event.SpunbricCauseStackManager;
import me.i509.fabric.spunbric.SpunbricChannelRegistrar;
import me.i509.fabric.spunbric.command.SpunbricCommandManager;
import me.i509.fabric.spunbric.config.SpunbricConfigManager;
import me.i509.fabric.spunbric.data.SpunbricDataManager;
import me.i509.fabric.spunbric.event.SpunbricEventManager;
import me.i509.fabric.spunbric.registry.SpunbricGameRegistry;
import me.i509.fabric.spunbric.SpunbricImpl;
import me.i509.fabric.spunbric.config.SpunbricMetricsConfigManager;
import me.i509.fabric.spunbric.SpunbricPlatform;
import me.i509.fabric.spunbric.plugin.SpunbricPluginManager;
import me.i509.fabric.spunbric.SpunbricScheduler;
import me.i509.fabric.spunbric.SpunbricServiceManager;
import me.i509.fabric.spunbric.SpunbricTeleportHelper;

public abstract class AbstractSpunbricModule extends PrivateModule {
    @Override
    protected void configure() {
        this.bindAndExpose(Game.class).to(AbstractSpunbricGame.class);
        this.bindAndExpose(MinecraftVersion.class).toInstance(SpunbricImpl.MINECRAFT_VERSION);

        this.bindAndExpose(ServiceManager.class).to(SpunbricServiceManager.class);
        this.bindAndExpose(AssetManager.class).to(SpunbricAssetManager.class);
        this.bindAndExpose(GameRegistry.class).to(SpunbricGameRegistry.class);
        this.bindAndExpose(TeleportHelper.class).to(SpunbricTeleportHelper.class);
        this.bindAndExpose(Scheduler.class).to(SpunbricScheduler.class);
        this.bindAndExpose(CommandManager.class).to(SpunbricCommandManager.class);
        this.bindAndExpose(DataManager.class).to(SpunbricDataManager.class);
        this.bindAndExpose(ConfigManager.class).to(SpunbricConfigManager.class);
        this.bindAndExpose(CauseStackManager.class).to(SpunbricCauseStackManager.class);
        this.bindAndExpose(MetricsConfigManager.class).to(SpunbricMetricsConfigManager.class);

        this.bindAndExpose(Platform.class).to(SpunbricPlatform.class);
        this.bindAndExpose(PluginManager.class).to(SpunbricPluginManager.class);
        this.bindAndExpose(EventManager.class).to(SpunbricEventManager.class);
        this.bindAndExpose(ChannelRegistrar.class).to(SpunbricChannelRegistrar.class);

        this.bind(Logger.class).toInstance(AbstractSpunbricMod.getLogger());
        this.bind(org.slf4j.Logger.class).toInstance(LoggerFactory.getLogger(AbstractSpunbricMod.getLogger().getName()));

        this.requestStaticInjection(SpunbricImpl.class);
        this.requestStaticInjection(Sponge.class);
        this.requestInjection(AbstractSpunbricMod.getInstance());
    }

    protected <T> AnnotatedBindingBuilder<T> bindAndExpose(final Class<T> type) {
        this.expose(type);
        return this.bind(type);
    }
}
