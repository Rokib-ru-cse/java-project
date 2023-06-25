package com.spring.crud.controller.category;

import com.spring.crud.model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categoryList = categoryService.categoryList();
        model.addAttribute("categories", categoryList);
        return "category/index";
    }

    @GetMapping("/categories/new")
    public String addNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/categoryform";
    }

    @PostMapping("/categories")
    public String addNewCategory(Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }


}
