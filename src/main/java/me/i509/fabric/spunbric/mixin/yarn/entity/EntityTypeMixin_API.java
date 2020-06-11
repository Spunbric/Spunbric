package me.i509.fabric.spunbric.mixin.yarn.entity;

import static com.google.common.base.Preconditions.checkState;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import me.i509.fabric.spunbric.SpunbricTranslation;

@Mixin(net.minecraft.entity.EntityType.class)
public abstract class EntityTypeMixin_API implements EntityType {
    @Shadow public abstract String shadow$getTranslationKey();

    private Translation api$translation;

    @Override
    public CatalogKey getKey() {
        final Identifier id = Registry.ENTITY_TYPE.getId((net.minecraft.entity.EntityType) (Object) this);
        checkState(id != null, "Attempted to access the id before the EntityType is registered.");

        return (CatalogKey) (Object) id;
    }

    @Override
    public Translation getTranslation() {
        if (this.api$translation == null) {
            this.api$translation = new SpunbricTranslation(this.shadow$getTranslationKey());
        }

        return this.api$translation;
    }
}
