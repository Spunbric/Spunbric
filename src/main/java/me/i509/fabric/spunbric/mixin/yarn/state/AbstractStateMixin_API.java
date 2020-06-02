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

package me.i509.fabric.spunbric.mixin.yarn.state;

import java.util.Optional;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.state.State;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.util.Cycleable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.state.AbstractState;
import net.minecraft.state.property.Property;

/**
 *
 * @param <S> The sponge state type
 * @param <C> The vanilla state type
 */
@Mixin(AbstractState.class)
public abstract class AbstractStateMixin_API<S extends State<S>, C> implements State<S> { // Can't extend StateMixin_API, otherwise Mixin fails
    @Shadow public abstract <T extends Comparable<T>> boolean shadow$contains(Property<T> property);
    @Shadow public abstract <T extends Comparable<T>> boolean contains(Property<T> property);
    @Shadow public abstract <T extends Comparable<T>, V extends T> C shadow$with(Property<T> property, V value);
    @Shadow public abstract <T extends Comparable<T>> C shadow$cycle(Property<T> property);
    @Shadow public abstract <T extends Comparable<T>> T shadow$get(Property<T> property);

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> Optional<T> getStateProperty(StateProperty<T> stateProperty) {
        if (!this.shadow$contains((Property) stateProperty)) {
            return Optional.empty();
        }

        return Optional.of((T) this.shadow$get((Property) stateProperty));
    }

    @Override
    public Optional<StateProperty<?>> getStatePropertyByName(String name) {
        return this.getStateProperties().stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public <T extends Comparable<T>, V extends T> Optional<S> withStateProperty(StateProperty<T> stateProperty, V value) {
        if (!this.contains((Property) stateProperty)) {
            return Optional.empty();
        }

        return Optional.of((S) this.shadow$with((Property) stateProperty, value));
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public <T extends Comparable<T>> Optional<S> cycleStateProperty(StateProperty<T> stateProperty) {
        if (!this.contains((Property) stateProperty)) {
            return Optional.empty();
        }

        return Optional.of((S) this.shadow$cycle((Property<T>) stateProperty));
    }

    @Override
    public <T extends Cycleable<T>> Optional<S> cycleValue(Key<? extends Value<T>> key) {
        throw new AssertionError("Implement Me: Data API");
    }
}
