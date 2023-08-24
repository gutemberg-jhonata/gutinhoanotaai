package com.gutinhotech.gutodelivery.domain.entity;

import java.util.Objects;

import com.gutinhotech.gutodelivery.domain.validation.ValidationHandler;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Entity<ID extends Identifier> {
    
    protected final ID id;

    public Entity(final ID id) {
        Objects.requireNonNull(id, "id is required");
        this.id = id;
    }

    public abstract void validate(ValidationHandler handler);

}
