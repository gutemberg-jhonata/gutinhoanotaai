package com.gutinhotech.gutinhoanotaai.domain.usecase;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gutinhotech.gutinhoanotaai.domain.entity.Category;
import com.gutinhotech.gutinhoanotaai.domain.repository.CategoryRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LoadAllCategoriesUseCaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    private LoadAllCategoriesUseCase sut;

    @BeforeEach
    public void beforeEach() {
        when(categoryRepository.findAll()).thenReturn(mockCategories());

        sut = new LoadAllCategoriesUseCase(categoryRepository);
    }
   
    @Test
    public void When_perform_Then_should_call_findAll_from_categoryRepository() {
        sut.perform();
        verify(categoryRepository, times(1))
            .findAll();
    }

    @Test
    public void When_perform_Then_should_return_a_set_of_categories() {
        Set<Category> categories = sut.perform();
        
        final var iterator = categories.iterator();
        final var category1 = iterator.next();
        final var category2 = iterator.next();
        assertEquals("any_category_name_1", category1.getName());
        assertInstanceOf(OffsetDateTime.class, category1.getCreatedAt());
        assertNull(category1.getUpdatedAt());
        assertEquals(category2.getName(), "any_category_name_2");
        assertInstanceOf(OffsetDateTime.class, category2.getCreatedAt());
        assertNull(category2.getUpdatedAt());
    }

    private Set<Category> mockCategories() {
        Category category1 = new Category("any_category_name_1");
        Category category2 = new Category("any_category_name_2");
        Set<Category> categories = new HashSet<>();
        categories.add(category1);
        categories.add(category2);
        return categories;
    }

}
