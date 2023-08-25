package com.gutinhotech.gutodelivery.application.usecase.category.create;

import java.util.Objects;

import com.gutinhotech.gutodelivery.application.entity.category.CategoryInput;
import com.gutinhotech.gutodelivery.application.entity.category.CategoryOutput;
import com.gutinhotech.gutodelivery.domain.contracts.repository.CategoryRepository;
import com.gutinhotech.gutodelivery.domain.entity.Category2;
import com.gutinhotech.gutodelivery.domain.validation.handler.ThrowsValidationHandler;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public DefaultCreateCategoryUseCase(final CategoryRepository aCategoryRepository) {
        this.categoryRepository = Objects.requireNonNull(aCategoryRepository);
    }

    @Override
    public CategoryOutput execute(CategoryInput anIn) {
        final var category = Category2.newCategory(anIn.getName());
        category.validate(new ThrowsValidationHandler());
        return CategoryOutput.from(this.categoryRepository.create(category));
    }

}
