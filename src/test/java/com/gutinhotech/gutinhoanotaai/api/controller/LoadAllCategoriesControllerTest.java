package com.gutinhotech.gutinhoanotaai.api.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import com.gutinhotech.gutinhoanotaai.api.assembler.CategoryAssembler;
import com.gutinhotech.gutinhoanotaai.api.entity.output.CategoryOutput;
import com.gutinhotech.gutinhoanotaai.domain.entity.Category;
import com.gutinhotech.gutinhoanotaai.domain.usecase.LoadAllCategoriesUseCase;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LoadAllCategoriesControllerTest {

    @Mock
    private LoadAllCategoriesUseCase loadAllCategoriesUseCase;

    @Mock
    private CategoryAssembler categoryAssembler;

    private LoadAllCategoriesController sut;
    private Category category1;
    private Category category2;
    private Set<Category> categories;

    @BeforeAll
    public void beforeAll() {
        category1 = new Category("any_category_name_1");
        category2 = new Category("any_category_name_2");
        categories = new HashSet<>();
        categories.add(category1);
        categories.add(category2);
    }

    @BeforeEach
    public void beforeEach() {
        when(loadAllCategoriesUseCase.perform()).thenReturn(categories);
        when(categoryAssembler.toCollectionModel(categories))
            .thenReturn(mockCategoriesOutput());

        sut = new LoadAllCategoriesController(
            loadAllCategoriesUseCase,
            categoryAssembler
        );
    }

    @Test
    public void When_perform_Then_should_call_loadAllCategoriesUseCase_perform() {
        sut.perform();

        verify(loadAllCategoriesUseCase, times(1))
            .perform();
    }

    @Test
    public void When_perform_Then_should_return_a_set_of_category_output() {
        Set<CategoryOutput> categoriesOutput = sut.perform();
        
        var iterator = categoriesOutput.iterator();
        var categoryOutput1 = iterator.next();
        var categoryOutput2 = iterator.next();
        Assertions.assertEquals(category1.getId(), categoryOutput1.getId());
        Assertions.assertEquals(category1.getName(), categoryOutput1.getName());
        Assertions.assertEquals(category1.getCreatedAt(), categoryOutput1.getCreatedAt());
        Assertions.assertEquals(category1.getUpdatedAt(), categoryOutput1.getUpdatedAt());
        Assertions.assertEquals(category2.getId(), categoryOutput2.getId());
        Assertions.assertEquals(category2.getName(), categoryOutput2.getName());
        Assertions.assertEquals(category2.getCreatedAt(), categoryOutput2.getCreatedAt());
        Assertions.assertEquals(category2.getUpdatedAt(), categoryOutput2.getUpdatedAt());
    }

    private Set<CategoryOutput> mockCategoriesOutput() {
        var categoryOutput1 = new CategoryOutput();
        categoryOutput1.setId(category1.getId());
        categoryOutput1.setName(category1.getName());
        categoryOutput1.setCreatedAt(category1.getCreatedAt());
        categoryOutput1.setUpdatedAt(category1.getUpdatedAt());
        var categoryOutput2 = new CategoryOutput();
        categoryOutput2.setId(category2.getId());
        categoryOutput2.setName(category2.getName());
        categoryOutput2.setCreatedAt(category2.getCreatedAt());
        categoryOutput2.setUpdatedAt(category2.getUpdatedAt());
        var categoriesOutput = new HashSet<CategoryOutput>();
        categoriesOutput.add(categoryOutput1);
        categoriesOutput.add(categoryOutput2);
        return categoriesOutput;
    }

}
