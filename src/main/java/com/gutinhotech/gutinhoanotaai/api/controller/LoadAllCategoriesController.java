package com.gutinhotech.gutinhoanotaai.api.controller;

import java.util.Set;

import com.gutinhotech.gutinhoanotaai.api.assembler.CategoryAssembler;
import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.usecase.LoadAllCategoriesUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoadAllCategoriesController {

    private final LoadAllCategoriesUseCase loadAllCategoriesUseCase;
    private final CategoryAssembler categoryAssembler;

    public Set<CategoryOutput> perform() {
        return categoryAssembler.toCollectionModel(
            loadAllCategoriesUseCase.perform()
        );
    }

}
