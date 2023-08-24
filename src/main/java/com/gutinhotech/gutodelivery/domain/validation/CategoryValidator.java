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
            this.validationHandler().append(new Error("name is required"));
        }
    }
    
}
