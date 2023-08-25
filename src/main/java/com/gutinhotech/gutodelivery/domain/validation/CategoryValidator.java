package com.gutinhotech.gutodelivery.domain.validation;

import com.gutinhotech.gutodelivery.domain.entity.Category2;

public class CategoryValidator extends Validator {

    private final Category2 category;

    public CategoryValidator(final Category2 aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = category.getName();
        if (name == null) {
            this.validationHandler().append(new Error("name should not be null"));
            return;
        }
        if (name.isBlank()) {
            this.validationHandler().append(new Error("name should not be blank"));
            return;
        }
        final var length = name.trim().length();
        if (length < 3 || length > 25) {
            this.validationHandler().append(new Error("name must be between 3 and 25 characters"));
        }
    }
    
}
