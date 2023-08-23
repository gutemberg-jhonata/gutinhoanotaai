package com.gutinhotech.gutodelivery.application.entity.output;

import java.time.OffsetDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryOutput {

    private UUID id;
    @Schema(example = "Snacks")
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
