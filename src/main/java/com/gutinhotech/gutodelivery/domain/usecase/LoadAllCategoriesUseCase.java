package com.gutinhotech.gutodelivery.domain.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gutinhotech.gutodelivery.domain.entity.Category;
import com.gutinhotech.gutodelivery.domain.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoadAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public List<Category> perform() {
        return categoryRepository.findAll();
    }
    
}
