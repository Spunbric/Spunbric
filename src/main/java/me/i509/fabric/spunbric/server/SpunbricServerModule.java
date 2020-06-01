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

package me.i509.fabric.spunbric.server;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.api.Server;

import me.i509.fabric.spunbric.AbstractSpunbricGame;
import me.i509.fabric.spunbric.AbstractSpunbricMod;
import me.i509.fabric.spunbric.inject.AbstractSpunbricModule;

@Environment(EnvType.SERVER)
public class SpunbricServerModule extends AbstractSpunbricModule {
    @Override
    protected void configure() {
        super.configure();

        this.bind(Server.class).toInstance((Server) AbstractSpunbricMod.getInstance().getServer());
        this.bind(AbstractSpunbricGame.class).to(SpunbricServerGame.class);
    }
}
