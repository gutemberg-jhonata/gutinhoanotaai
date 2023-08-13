package com.gutinhotech.gutinhoanotaai.domain.entity;

import java.time.OffsetDateTime;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    private Long id;

    @EqualsAndHashCode.Include
    private String name;
        
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    
    public Category(final String name) {
        Objects.requireNonNull(name);
        this.name = name;
        this.createdAt = OffsetDateTime.now();
    }

}
