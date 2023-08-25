package com.gutinhotech.gutodelivery.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import com.gutinhotech.gutodelivery.domain.AggregateRoot;
import com.gutinhotech.gutodelivery.domain.exception.DomainException;
import com.gutinhotech.gutodelivery.domain.validation.handler.ThrowsValidationHandler;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Category2Test {

    @Test
    public void Given_an_valid_name_When_call_new_category_Then_should_instantiate_a_category() {
        final var name = "any_valid_name";

        final var category = Category2.newCategory(name);

        assertNotNull(category);
        assertInstanceOf(AggregateRoot.class, category);
        assertNotNull(category.getId());
        assertInstanceOf(CategoryID.class, category.getId());
        assertEquals(name, category.getName());
        assertNotNull(category.getCreatedAt());
        assertInstanceOf(OffsetDateTime.class, category.getCreatedAt());
        assertNull(category.getUpdatedAt());
    }

    @Test
    public void Given_an_invalid_null_name_When_call_new_category_and_validate_Then_should_receive_error() {
        final String name = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "name should not be null";

        final var category = Category2.newCategory(name);

        final var exception = assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        assertEquals(expectedErrorCount, exception.getErrors().size());
        assertEquals(expectedErrorMessage, exception.getErrors().get(0).message());
    }

    @Test
    public void Given_an_invalid_blank_name_When_call_new_category_and_validate_Then_should_receive_error() {
        final String name = "  ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "name should not be blank";

        final var category = Category2.newCategory(name);

        final var exception = assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        assertEquals(expectedErrorCount, exception.getErrors().size());
        assertEquals(expectedErrorMessage, exception.getErrors().get(0).message());
    }

    @Test
    public void Given_an_invalid_name_with_length_less_than_3_When_call_new_category_and_validate_Then_should_receive_error() {
        final String name = "Fi ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "name must be between 3 and 25 characters";

        final var category = Category2.newCategory(name);

        final var exception = assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        assertEquals(expectedErrorCount, exception.getErrors().size());
        assertEquals(expectedErrorMessage, exception.getErrors().get(0).message());
    }

    @Test
    public void Given_an_invalid_name_with_length_more_than_25_When_call_new_category_and_validate_Then_should_receive_error() {
        final String name = "Caros amigos, a estrutura atual da organização garante a contribuição de um grupo";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "name must be between 3 and 25 characters";

        final var category = Category2.newCategory(name);

        final var exception = assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        assertEquals(expectedErrorCount, exception.getErrors().size());
        assertEquals(expectedErrorMessage, exception.getErrors().get(0).message());
    }

}
