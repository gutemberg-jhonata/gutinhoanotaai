package com.gutinhotech.gutodelivery.application.entity.category;

import com.gutinhotech.gutodelivery.domain.entity.Category2;
import com.gutinhotech.gutodelivery.domain.entity.CategoryID;

public record CategoryOutput(CategoryID id) {

    public static CategoryOutput from(final Category2 aCategory) {
        return new CategoryOutput(aCategory.getId());
    }

}
