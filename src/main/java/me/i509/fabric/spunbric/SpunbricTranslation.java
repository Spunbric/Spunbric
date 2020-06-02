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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Locale;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.text.translation.Translation;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Language;

public class SpunbricTranslation implements Translation {
    private final String id;

    public SpunbricTranslation(String id) {
        this.id = checkNotNull(id, "id");
    }

    public SpunbricTranslation(TranslatableText text) {
        this(text.getKey());
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String get(Locale locale) {
        // TODO: Locale?
        return Language.getInstance().translate(this.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass() || !(obj instanceof SpunbricTranslation)) {
            return false;
        }
        final SpunbricTranslation other = (SpunbricTranslation) obj;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .toString();
    }
}
