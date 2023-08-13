package com.gutinhotech.gutinhoanotaai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutinhotech.gutinhoanotaai.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
