package com.gutinhotech.gutinhoanotaai.api.assembler;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.entity.Category;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryAssembler {

    private final ModelMapper modelMapper;

    public Set<CategoryOutput> toCollectionModel(Set<Category> categories) {
        return categories.stream()
            .map((category) -> modelMapper.map(category, CategoryOutput.class))
            .collect(Collectors.toSet());
    }

}
