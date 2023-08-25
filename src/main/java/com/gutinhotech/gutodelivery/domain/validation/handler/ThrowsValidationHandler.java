package com.gutinhotech.gutodelivery.domain.validation.handler;

import java.util.List;

import com.gutinhotech.gutodelivery.domain.validation.Error;
import com.gutinhotech.gutodelivery.domain.validation.ValidationHandler;
import com.gutinhotech.gutodelivery.domain.exception.DomainException;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception exception) {
            throw DomainException.with(new Error(exception.getMessage()));
        }
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
    
}
