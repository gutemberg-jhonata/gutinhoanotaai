package com.gutinhotech.gutodelivery.domain.entity;

import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class Category2 extends AggregateRoot<CategoryID> {
    private final String name;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;

    private Category2(
        final CategoryID anId, 
        final String aName, 
        final OffsetDateTime aCreatedAt, 
        final OffsetDateTime aUpdatedAt
    ) {
        super(anId);
        this.name = aName;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
    }

    public static Category2 newCategory(final String aName) {
        final var id = CategoryID.unique();
        final var now = OffsetDateTime.now();
        return new Category2(id, aName, now, null);
    }

}
