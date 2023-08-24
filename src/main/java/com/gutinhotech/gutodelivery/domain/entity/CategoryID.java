package com.gutinhotech.gutodelivery.domain.entity;

import java.util.Objects;
import java.util.UUID;

import com.gutinhotech.gutodelivery.domain.Identifier;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class CategoryID extends Identifier {
    
    protected final String value;

    private CategoryID(final String aValue) {
        Objects.requireNonNull(aValue);
        this.value = aValue;
    }

    public static CategoryID unique() {
        return from(UUID.randomUUID());
    }

    public static CategoryID from(final String anId) {
        return new CategoryID(anId);
    }

    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString().toLowerCase());
    }

}
