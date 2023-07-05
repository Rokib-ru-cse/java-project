package com.bitspondon.ecommerce.application.usecase.impl;

import com.bitspondon.ecommerce.application.repository.CategoryRepository;
import com.bitspondon.ecommerce.application.usecase.CategoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CategoryUseCaseImpl implements CategoryUseCase {

    private CategoryRepository repository;

    public CategoryUseCaseImpl(CategoryRepository repository) {
        this.repository = repository;
    }



}
