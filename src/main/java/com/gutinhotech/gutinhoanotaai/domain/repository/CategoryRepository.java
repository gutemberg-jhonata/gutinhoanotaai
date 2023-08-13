package com.gutinhotech.gutinhoanotaai.domain.repository;

import java.util.Set;

import com.gutinhotech.gutinhoanotaai.domain.entity.Category;

public interface CategoryRepository {
        
    public Set<Category> findAll();
    
}
