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

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Stage;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

import net.minecraft.server.MinecraftServer;

public abstract class AbstractSpunbricMod {
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer("spunbric")
            .orElseThrow(() -> new RuntimeException("Unable to get Spunbric's mod container."));
    private static final Logger LOGGER = LogManager.getLogger("Spunbric");
    private static final boolean IS_DEVELOPMENT = FabricLoader.getInstance().isDevelopmentEnvironment();
    private static AbstractSpunbricMod instance;

    protected AbstractSpunbricMod() {
        AbstractSpunbricMod.instance = this;
    }

    public static AbstractSpunbricMod getInstance() {
        return AbstractSpunbricMod.instance;
    }

    public static Logger getLogger() {
        return AbstractSpunbricMod.LOGGER;
    }

    protected final void onInitialize() {
        final Stage stage = SpunbricGuice.getInjectorStage(AbstractSpunbricMod.IS_DEVELOPMENT ? Stage.DEVELOPMENT : Stage.PRODUCTION);
        AbstractSpunbricMod.LOGGER.debug("Creating injector in stage '{}'", stage);

        Guice.createInjector(stage, this.createModule());
    }

    @Nullable
    public abstract MinecraftServer getServer();

    protected abstract Module createModule();
}
