package com.gutinhotech.gutinhoanotaai.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import com.gutinhotech.gutinhoanotaai.domain.usecase.LoadAllCategoriesUseCase;

import lombok.AllArgsConstructor;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LoadAllCategoriesControllerTest {

    @AllArgsConstructor
    public class LoadAllCategoriesController {

        private final LoadAllCategoriesUseCase loadAllCategoriesUseCase;

        public void perform() {
            loadAllCategoriesUseCase.perform();
        }

    }

    @Mock
    private LoadAllCategoriesUseCase loadAllCategoriesUseCase;

    private LoadAllCategoriesController sut;

    @BeforeEach
    public void beforeEach() {
        sut = new LoadAllCategoriesController(loadAllCategoriesUseCase);
    }

    @Test
    public void When_perform_Then_should_call_loadAllCategoriesUseCase_perform() {
        sut.perform();

        verify(loadAllCategoriesUseCase, times(1))
            .perform();
    }
    
}
