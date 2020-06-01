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

import java.util.Optional;

import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKey;

public class SpunbricCauseStackManager implements CauseStackManager {
    @Override
    public Cause getCurrentCause() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public EventContext getCurrentContext() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public CauseStackManager pushCause(Object obj) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Object popCause() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void popCauses(int n) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public Object peekCause() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public StackFrame pushCauseFrame() {
        throw new AssertionError("Implement Me");
    }

    @Override
    public void popCauseFrame(StackFrame handle) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> CauseStackManager addContext(EventContextKey<T> key, T value) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> Optional<T> getContext(EventContextKey<T> key) {
        throw new AssertionError("Implement Me");
    }

    @Override
    public <T> Optional<T> removeContext(EventContextKey<T> key) {
        throw new AssertionError("Implement Me");
    }
}
