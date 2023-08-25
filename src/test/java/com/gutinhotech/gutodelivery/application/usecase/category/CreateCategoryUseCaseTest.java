package com.gutinhotech.gutodelivery.application.usecase.category;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gutinhotech.gutodelivery.application.UseCase;
import com.gutinhotech.gutodelivery.application.entity.category.CategoryInput;
import com.gutinhotech.gutodelivery.domain.contracts.repository.CategoryRepository;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private DefaultCreateCategoryUseCase useCase;

    @Test
    public void Given_valid_input_When_execute_than_should_return_a_valid_output() {
        when(categoryRepository.create(any()))
            .thenAnswer(returnsFirstArg());
        final var expectedName = "snacks";
        final var input = CategoryInput.with(expectedName);

        final var output = useCase.execute(input);

        assertInstanceOf(UseCase.class, useCase);
        verify(categoryRepository, times(1))
            .create(Mockito.argThat(aCategory ->
                Objects.equals(expectedName, aCategory.getName())));
        assertNotNull(output);
        assertNotNull(output.id());
    }

}
