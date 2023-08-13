package com.gutinhotech.gutinhoanotaai.api.entity.output;

import java.time.OffsetDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryOutput {

    private Long id;
    
    @EqualsAndHashCode.Include
    private String name;
    
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
