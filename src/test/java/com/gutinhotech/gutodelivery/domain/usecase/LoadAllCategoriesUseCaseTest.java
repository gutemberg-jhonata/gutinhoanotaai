package com.gutinhotech.gutodelivery.domain.usecase;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gutinhotech.gutodelivery.domain.entity.Category;
import com.gutinhotech.gutodelivery.domain.repository.CategoryRepository;

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
        List<Category> categories = sut.perform();
        
        final var category1 = categories.get(0);
        final var category2 = categories.get(1);
        assertEquals("any_category_name_1", category1.getName());
        assertInstanceOf(OffsetDateTime.class, category1.getCreatedAt());
        assertNull(category1.getUpdatedAt());
        assertEquals(category2.getName(), "any_category_name_2");
        assertInstanceOf(OffsetDateTime.class, category2.getCreatedAt());
        assertNull(category2.getUpdatedAt());
    }

    private List<Category> mockCategories() {
        Category category1 = new Category("any_category_name_1");
        Category category2 = new Category("any_category_name_2");
        return Arrays.asList(category1, category2);
    }

}
