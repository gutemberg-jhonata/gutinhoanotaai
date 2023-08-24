package com.gutinhotech.gutodelivery.domain.validation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Validator {
    
    private final ValidationHandler handler;

    public abstract void validate();

    protected ValidationHandler validationHandler() {
        return this.handler;
    }

}
