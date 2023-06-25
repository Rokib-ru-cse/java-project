package com.rokibrucse.cleanarchitecture.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.ICategoryRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.ICategoryUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Category;
import com.rokibrucse.cleanarchitecture.domain.returnresponse.ReturnReponse;

import java.util.List;

@Service
public class CategoryUseCase implements ICategoryUseCase {
    @Autowired
    private ICategoryRepository categoryRepository;

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    public Category createCategory(String name) {
        Category category = Category.builder().name(name).build();
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, String name) {
        Category category = categoryRepository.findById(id).get();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public ReturnReponse<Category> categoryList() {
        return ReturnReponse.<Category>builder().message("data found successfully").succeeded(true)
                .values(categoryRepository.findAll()).build();
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}