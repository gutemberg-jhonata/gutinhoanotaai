package com.gutinhotech.gutodelivery.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutinhotech.gutodelivery.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
