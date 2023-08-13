package com.gutinhotech.gutinhoanotaai.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutinhotech.gutinhoanotaai.api.assembler.CategoryAssembler;
import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.usecase.LoadAllCategoriesUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class LoadAllCategoriesController {

    private final LoadAllCategoriesUseCase loadAllCategoriesUseCase;
    private final CategoryAssembler categoryAssembler;

    @GetMapping
    public List<CategoryOutput> perform() {
        return categoryAssembler.toCollectionModel(
            loadAllCategoriesUseCase.perform()
        );
    }

}
