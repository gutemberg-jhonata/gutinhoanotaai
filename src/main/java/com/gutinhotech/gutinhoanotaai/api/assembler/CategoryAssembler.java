package com.gutinhotech.gutinhoanotaai.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.entity.Category;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CategoryAssembler {

    private final ModelMapper modelMapper;

    public List<CategoryOutput> toCollectionModel(List<Category> categories) {
        return categories.stream()
            .map((category) -> modelMapper.map(category, CategoryOutput.class))
            .toList();
    }

}
