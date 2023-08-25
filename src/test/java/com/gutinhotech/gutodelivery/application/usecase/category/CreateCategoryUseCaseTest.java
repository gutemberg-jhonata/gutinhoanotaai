package com.gutinhotech.gutodelivery.application.usecase.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gutinhotech.gutodelivery.application.UseCase;
import com.gutinhotech.gutodelivery.application.entity.category.CategoryInput;
import com.gutinhotech.gutodelivery.application.usecase.category.create.DefaultCreateCategoryUseCase;
import com.gutinhotech.gutodelivery.domain.contracts.repository.CategoryRepository;
import com.gutinhotech.gutodelivery.domain.exception.DomainException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private DefaultCreateCategoryUseCase useCase;

    @Test
    public void Given_a_valid_input_When_execute_than_should_return_a_valid_output() {
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

    @Test
    public void Given_a_valid_name_When_execute_than_should_return_a_domain_exception() {
        final String expectedName = null;
        final var expectedErrorMessage = "name should not be null";
        final var input = CategoryInput.with(expectedName);

        final Executable executable = () -> useCase.execute(input);

        final var actualException = assertThrows(DomainException.class, executable);
        assertEquals(expectedErrorMessage, actualException.getMessage());
        verify(categoryRepository, times(0))
            .create(any());
    }

    @Test
    public void Given_a_valid_input_When_gateway_throws_than_should_return_a_exception() {
        final var expectedName = "snacks";
        final var expectedErrorMessage = "Gateway error";
        final var input = CategoryInput.with(expectedName);
        when(categoryRepository.create(any()))
            .thenThrow(new IllegalStateException(expectedErrorMessage));

        final Executable executable = () -> useCase.execute(input);

        final var actualException =
            assertThrows(IllegalStateException.class, executable);
        assertEquals(expectedErrorMessage, actualException.getMessage());
        verify(categoryRepository, times(1))
            .create(Mockito.argThat(aCategory ->
                Objects.equals(expectedName, aCategory.getName())));
    }

}
