package com.gutinhotech.gutinhoanotaai.domain.usecase;

import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import lombok.AllArgsConstructor;

@ExtendWith(MockitoExtension.class)
public class LoadCategoriesUseCaseTest {

    class Category {

    }

    interface CategoryRepository {
        
        public Collection<Category> findAll();
    
    }

    @AllArgsConstructor
    class LoadCategoriesUseCase {

        private final CategoryRepository categoryRepository;

        public void perform() {
            categoryRepository.findAll();
        }
    }

    @Mock
    private CategoryRepository categoryRepository;

    private LoadCategoriesUseCase sut;

    @BeforeAll
    public void beforeAll() {
        sut = new LoadCategoriesUseCase(categoryRepository);
    }

    @Test
    public void When_perform_Then_should_call_findAll_from_categoryRepository() {
        sut.perform();
        verify(categoryRepository, times(1))
            .findAll();
    }
    
}
