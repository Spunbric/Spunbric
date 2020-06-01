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

package me.i509.fabric.spunbric.command;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.command.manager.CommandMapping;
import org.spongepowered.api.command.manager.FailedRegistrationException;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;

public class SpunbricCommandManager implements CommandManager {
    @Override
    public CommandResult process(String arguments) throws CommandException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Subject & MessageReceiver> CommandResult process(T subjectReceiver, String arguments) throws CommandException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public CommandResult process(Subject subject, MessageChannel channel, String arguments) throws CommandException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public List<String> suggest(String arguments) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T extends Subject & MessageReceiver> List<String> suggest(T subjectReceiver, String arguments) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public List<String> suggest(Subject subject, MessageChannel receiver, String arguments) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public CommandMapping register(PluginContainer container, Command command, String primaryAlias, String... secondaryAliases) throws FailedRegistrationException {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Optional<CommandMapping> unregister(CommandMapping mapping) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Collection<CommandMapping> unregisterAll(PluginContainer container) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        throw new AssertionError("Implement Me");
    }
}
