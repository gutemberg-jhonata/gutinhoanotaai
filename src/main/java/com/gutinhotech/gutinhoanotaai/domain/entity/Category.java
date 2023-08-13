package com.gutinhotech.gutinhoanotaai.domain.entity;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Category {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    
    public Category(final String name) {
        Objects.requireNonNull(name);
        this.name = name;
        this.createdAt = OffsetDateTime.now();
    }

}
