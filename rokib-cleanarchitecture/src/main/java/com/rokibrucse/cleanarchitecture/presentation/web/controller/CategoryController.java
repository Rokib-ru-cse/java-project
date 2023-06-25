package com.rokibrucse.cleanarchitecture.presentation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rokibrucse.cleanarchitecture.application.usecase.ICategoryUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Category;

import java.util.List;

public class CategoryController {

    @Autowired
    private ICategoryUseCase useCase;

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categoryList = useCase.categoryList().getValues();
        model.addAttribute("categories", categoryList);
        return "category/index";
    }

    @GetMapping("/categories/new")
    public String addNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/categoryform";
    }

    @PostMapping("/categories")
    public String addNewCategory(Category category) {
        useCase.save(category);
        return "redirect:/categories";
    }

}
