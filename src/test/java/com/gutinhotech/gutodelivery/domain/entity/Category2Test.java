package com.gutinhotech.gutodelivery.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Category2Test {
    @Test
    public void Given_valid_name_When_call_new_category_Then_should_instantiate_a_category() {
        final var name = "any_valid_name";

        final var category = Category2.newCategory(name);

        assertNotNull(category);
        assertNotNull(category.getId());
        assertEquals(name, category.getName());
        assertNotNull(category.getCreatedAt());
        assertNull(category.getUpdatedAt());
    }

}
