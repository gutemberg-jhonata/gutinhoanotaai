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
        final String name = category.getName();
        if (name == null) {
            this.validationHandler().append(new Error("name should not be null"));
        }
        if (name.trim().length() == 0) {
            this.validationHandler().append(new Error("name should not be blank"));
        }
        if (name.trim().trim().length() < 3) {
            this.validationHandler().append(new Error("name must be between 3 and 25 characters"));
        }
    }
    
}
