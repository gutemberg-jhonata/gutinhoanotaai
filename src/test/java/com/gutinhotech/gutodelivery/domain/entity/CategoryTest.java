package com.gutinhotech.gutodelivery.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CategoryTest {
    
    @Test
    public void Given_valid_name_When_call_the_constructor_Then_should_instantiate() {
        var name = "any_valid_name";

        var category = new Category(name);

        assertEquals(name, category.getName());
        assertInstanceOf(OffsetDateTime.class, category.getCreatedAt());
        assertNull(category.getUpdatedAt());
    }

}
