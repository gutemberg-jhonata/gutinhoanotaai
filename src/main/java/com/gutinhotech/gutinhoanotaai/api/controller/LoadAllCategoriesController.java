package com.gutinhotech.gutinhoanotaai.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutinhotech.gutinhoanotaai.api.assembler.CategoryAssembler;
import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.usecase.LoadAllCategoriesUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
@Tag(name = "Categories")
public class LoadAllCategoriesController {

    private final LoadAllCategoriesUseCase loadAllCategoriesUseCase;
    private final CategoryAssembler categoryAssembler;

    @GetMapping
    @Operation(summary = "Get registered all categories.")
    @ApiResponse(responseCode = "200", content = {
        @Content(mediaType = "application/json", 
            schema = @Schema(implementation = CategoryOutput.class))
    })
    public List<CategoryOutput> perform() {
        return categoryAssembler.toCollectionModel(
            loadAllCategoriesUseCase.perform()
        );
    }

}
