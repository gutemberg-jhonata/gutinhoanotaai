package com.gutinhotech.gutodelivery.application.entity.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryInput {

    private final String name;

    public static CategoryInput with(final String aName) {
        return new CategoryInput(aName);
    }

}
