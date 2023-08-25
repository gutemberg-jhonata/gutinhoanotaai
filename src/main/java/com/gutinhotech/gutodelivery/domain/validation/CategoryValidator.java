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
        if (category.getName() == null) {
            this.validationHandler().append(new Error("name should not be null"));
        }
        if (category.getName().trim().length() == 0) {
            this.validationHandler().append(new Error("name should not be blank"));
        }
    }
    
}
