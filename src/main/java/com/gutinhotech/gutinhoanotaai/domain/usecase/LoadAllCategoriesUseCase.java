package com.gutinhotech.gutinhoanotaai.domain.usecase;

import java.util.Set;

import com.gutinhotech.gutinhoanotaai.domain.entity.Category;
import com.gutinhotech.gutinhoanotaai.domain.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoadAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public Set<Category> perform() {
        return categoryRepository.findAll();
    }
    
}
