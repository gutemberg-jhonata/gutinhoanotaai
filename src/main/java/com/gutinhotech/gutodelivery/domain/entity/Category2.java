package com.gutinhotech.gutodelivery.domain.entity;

import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class Category2 {
    private String id;
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    
    private Category2(
        final String id, 
        final String name, 
        final OffsetDateTime createdAt, 
        final OffsetDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Category2 newCategory(final String aName) {
        final var now = OffsetDateTime.now();
        return new Category2("1", aName, now, null);
    }

}
